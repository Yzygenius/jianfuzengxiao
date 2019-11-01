package com.jianfuzengxiao.system.controller;

import java.io.File;
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

import com.bamboo.framework.common.util.DateUtil;
import com.jianfuzengxiao.base.common.Constant;
import com.jianfuzengxiao.base.common.FileUtil;
import com.jianfuzengxiao.base.common.RC;
import com.jianfuzengxiao.base.controller.BaseController;
import com.jianfuzengxiao.base.utils.BigDouble;
import com.jianfuzengxiao.pub.entity.HousesTypeMVO;
import com.jianfuzengxiao.pub.service.IHousesTypeService;

@Controller
@RequestMapping(value="/system/common")
public class CommonSysContoller extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(CommonSysContoller.class);
	
	@Autowired
	private IHousesTypeService housesTypeService;
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 获取房屋类型列表
	 * </p>
	 * @return    
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年11月1日 上午10:25:43
	 */
	@ResponseBody
	@RequestMapping(value="/getHousesTypeList")
	public String getHousesTypeList(HousesTypeMVO entity){
		try {
			entity.setSts("A");
			List<HousesTypeMVO> list = housesTypeService.queryList(entity);
			return apiResult(RC.SUCCESS, list);
		} catch (Exception e) {
			return exceptionResult(logger, "获取房屋类型列表失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 上传文件
	 * </p>
	 * @param file 文件, picType A人脸照片、B证件照片、 C租赁合同、 D房产证 、 E户型图、Z其他照片
	 * @return    
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月29日 下午3:42:01
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
			uploadImgDir = Constant.UPLOAD_LEASE_CONTRACT_IMAGE_DIR;
			break;
		case "D":
			uploadImgDir = Constant.UPLOAD_PROPERTY_CERTIFICATES_IMAGE_DIR;
			break;
		case "E":
			uploadImgDir = Constant.UPLOAD_HOUSE_TYPE_IMAGE_DIR;
			break;
		case "Z":
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
