package com.jianfuzengxiao.pub.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bamboo.framework.common.util.DateUtil;
import com.jianfuzengxiao.base.common.Constant;
import com.jianfuzengxiao.base.common.FileUtil;
import com.jianfuzengxiao.base.common.RC;
import com.jianfuzengxiao.base.common.RandomUtil;
import com.jianfuzengxiao.base.controller.BaseController;
import com.jianfuzengxiao.base.utils.BigDouble;
import com.jianfuzengxiao.pub.entity.AreaInfoMVO;
import com.jianfuzengxiao.pub.entity.NationMVO;
import com.jianfuzengxiao.pub.service.IAreaInfoService;
import com.jianfuzengxiao.pub.service.INationService;

/**
 * 公共接口
 */
@Controller
@RequestMapping(value="/common")
public class CommonController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private IAreaInfoService areaInfoService;
	
	@Autowired
	private INationService nationService;
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 获取民族列表
	 * </p>
	 * @return    
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月28日 上午10:55:07
	 */
	@ResponseBody
	@RequestMapping(value="/getNationList")
	public String getNationList(){
		try {
			List<NationMVO> list = nationService.queryList(new NationMVO());
			return apiResult(RC.SUCCESS, list);
		} catch (Exception e) {
			return exceptionResult(logger, "获取民族列表出错", e);
		}
	}
	
	/**
	 * 获取地址省市区
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAreaList")
	public String getAreaList() {
	    try {
	    	JSONArray jsonArr = new JSONArray();
	    	List<AreaInfoMVO> areaList = areaInfoService.queryList(new AreaInfoMVO());
	    	
	    	// 取出一、二级列表
	    	List<AreaInfoMVO> areaLv1List = new ArrayList<AreaInfoMVO>();
	    	List<AreaInfoMVO> areaLv2List = new ArrayList<AreaInfoMVO>();
	    	List<AreaInfoMVO> areaLv3List = new ArrayList<AreaInfoMVO>();
	    	for (AreaInfoMVO area : areaList) {
	    		switch (area.getAreaLevel()) {
				case "1":
					areaLv1List.add(area);
					break;
				case "2":
					areaLv2List.add(area);
					break;
				case "3":
					areaLv3List.add(area);
					break;
				}
			}
	    	
	    	// 整理二三级上下级关系
	    	HashMap<String, JSONObject> map = new HashMap<>();
	    	for (AreaInfoMVO area2 : areaLv2List) {
				JSONObject jsonObj2 = new JSONObject();
				jsonObj2.put("code", area2.getAreaCode());
				jsonObj2.put("name", area2.getAreaName());
	    		
				JSONArray jsonArr3 = new JSONArray();
	    		for (AreaInfoMVO area3 : areaLv3List) {
					if (StringUtils.equals(area3.getParentCode(), area2.getAreaCode())) {
						JSONObject jsonObj3 = new JSONObject();
						jsonObj3.put("code", area3.getAreaCode());
						jsonObj3.put("name", area3.getAreaName());
						jsonArr3.add(jsonObj3);
					}
				}
	    		jsonObj2.put("childList", jsonArr3);
	    		map.put(area2.getAreaCode(), jsonObj2);
			}
	    	
	    	// 整理一二级上下级关系
	    	for (AreaInfoMVO area1 : areaLv1List) {
				JSONObject jsonObj1 = new JSONObject();
				jsonObj1.put("code", area1.getAreaCode());
				jsonObj1.put("name", area1.getAreaName());
	    		
				JSONArray jsonArr2 = new JSONArray();
	    		for (AreaInfoMVO area2 : areaLv2List) {
					if (StringUtils.equals(area2.getParentCode(), area1.getAreaCode())) {
						jsonArr2.add(map.get(area2.getAreaCode()));
					}
				}
	    		jsonObj1.put("childList", jsonArr2);
	    		jsonArr.add(jsonObj1);
			}
	    	return apiResult(RC.SUCCESS_CODE, "获取地区列表成功", jsonArr);
		} catch (Exception e) {
			return exceptionResult(logger, "获取地区列表出错", e);
		}
	}
	
	/**
	 * 上传文件
	 * picType A人脸照片、B证件照片、C其他照片
	 */
	@ResponseBody
	@RequestMapping(value="/uploadFile", method=RequestMethod.POST)
	public String uploadpic(@RequestParam(value="file") MultipartFile file, String picType) {
		String uploadImgDir = "";
		if (StringUtils.isBlank(picType)) {
			return apiResult(RC.OTHER_CZ_ERROR);
		}
		switch (picType) {
		case "A":
			uploadImgDir = Constant.UPLOAD_FACE_IMAGE_DIR;
			break;
		case "B":
			uploadImgDir = Constant.UPLOAD_CERT_IMAGE_DIR;
			break;
		case "C":
			uploadImgDir = Constant.UPLOAD_OTHER_IMAGE_DIR;
			break;
		default:
			return apiResult(RC.OTHER_CZ_ERROR);
		}
		// 创建日期目录
		String imageDir = request.getSession().getServletContext().getRealPath(uploadImgDir);
		String day = DateUtil.now("yyyyMMdd");
		String filepath = imageDir + "/" + day;
		File dir = new File(filepath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		// 保存到目标文件
		String extname = FileUtil.getExtName(file.getOriginalFilename());
		//String filename = DateUtil.now("yyyyMMddHHmmssS") + RandomUtil.randomStr(6) + "." + extname;
		String filename = BigDouble.getUUID() + "." + extname;
		File targetFile = new File(dir, filename);
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            logger.error("上传文件出错", e);
            return apiResult(RC.OTHER_CW_ERROR);
        }
        
        // 返回文件路径
        Map<String, String> result = new HashMap<String, String>();
		String relativePath = uploadImgDir + day + "/" + filename;
		result.put("relativePath", relativePath);
		result.put("absolutePath", request.getContextPath() + "/" + relativePath);
        return apiResult(RC.SUCCESS, result);
	}
	
}
