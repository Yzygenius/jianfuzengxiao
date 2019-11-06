package com.jianfuzengxiao.pub.controller;

import java.io.File;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bamboo.framework.common.util.DateUtil;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.base.common.Constant;
import com.jianfuzengxiao.base.common.DataFileUtil;
import com.jianfuzengxiao.base.common.FileUtil;
import com.jianfuzengxiao.base.common.RC;
import com.jianfuzengxiao.base.common.RandomUtil;
import com.jianfuzengxiao.base.controller.BaseController;
import com.jianfuzengxiao.base.utils.BigDouble;
import com.jianfuzengxiao.base.utils.ExcelUtil;
import com.jianfuzengxiao.base.utils.Upxml;
import com.jianfuzengxiao.pub.entity.AreaInfoMVO;
import com.jianfuzengxiao.pub.entity.AttachFileMVO;
import com.jianfuzengxiao.pub.entity.CertificatesTypeMVO;
import com.jianfuzengxiao.pub.entity.CommunityInfoMVO;
import com.jianfuzengxiao.pub.entity.CommunityStreetInfoMVO;
import com.jianfuzengxiao.pub.entity.HousesInfoMVO;
import com.jianfuzengxiao.pub.entity.LiveTypeMVO;
import com.jianfuzengxiao.pub.entity.NationMVO;
import com.jianfuzengxiao.pub.service.IAreaInfoService;
import com.jianfuzengxiao.pub.service.ICertificatesTypeService;
import com.jianfuzengxiao.pub.service.ICommunityInfoService;
import com.jianfuzengxiao.pub.service.ICommunityStreetInfoService;
import com.jianfuzengxiao.pub.service.IHousesInfoService;
import com.jianfuzengxiao.pub.service.ILiveTypeService;
import com.jianfuzengxiao.pub.service.INationService;
import static com.jianfuzengxiao.base.utils.ApiUtil.throwAppException;


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
	
	@Autowired
	private ICertificatesTypeService certTypeService;
	
	@Autowired
	private ICommunityInfoService communityInfoService;
	
	@Autowired
	private ICommunityStreetInfoService communityStreetInfoService;
	
	@Autowired
	private IHousesInfoService housesInfoService;
	
	@Autowired
	private ILiveTypeService liveTypeService;
	
	@ResponseBody
	@RequestMapping(value="/uploadEx")
	public String uploadEx(@RequestParam("file") CommonsMultipartFile file){
		try {
			throwAppException(file == null, RC.COMMON_IMAGE_FILE_INVALID);
			AttachFileMVO attachFile = DataFileUtil.saveDBImage(file);
		
			String qrcode = request.getSession().getServletContext().getRealPath(attachFile.getSaveName());
			List<HousesInfoMVO> housesList = Upxml.getDataFromExcel(qrcode);
			for(int i=0; i<housesList.size(); i++) {
				housesInfoService.insert(housesList.get(i));
			}
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "导入excel错误", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/ex")
	public String ex(RedirectAttributes redirectAttributes){
		String fileName = "房产信息.xls";
		String[] title = {"房产ID", "产权类型", "产权人姓名", "产权人联系电话", "产权人身份证号", "房产证号码", "社区", "小区", "户型", "楼号", "单元", "门牌号", "详细地址", "房产类型", "内/外铺", "省", "市", "区", "创建时间", "最新更新时间", "房产证照片", "户型图"};
		
		try {
			HousesInfoMVO housesInfo = new HousesInfoMVO();
			housesInfo.setSts("A");
			List<HousesInfoMVO> list = housesInfoService.queryList(housesInfo);
			HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(fileName, title, list, null);
			
			this.setResponseHeader(response, fileName);
			OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "导出excel错误", e);
		}
	}
	
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception e) {
        	logger.info("导出excel错误：", e);
        }

    }
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 获取小区或街道列表
	 * </p>
	 * @param communityId 社区ID, communityStreetId 小区/街道ID, housesStatus 1 房屋、2 店铺, storiedBuildingNumber 楼号, unit 单元号, storeLocation 1内/2外铺
	 * @return  storiedBuildingNumber 楼号, unit 单元号, houseNumber 门牌号(如果是房屋为门牌号、如果是店铺为店铺号), storeLocation 1内/2外铺
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月29日 上午9:05:27
	 */
	@ResponseBody
	@RequestMapping(value="/getHousesList")
	public String getHousesList(HousesInfoMVO model){
		try {
			List<HousesInfoMVO> list = housesInfoService.queryBuildingUnitNumList(model);
			return apiResult(RC.SUCCESS, list);
		} catch (Exception e) {
			return exceptionResult(logger, "获取房产列表出错", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 获取小区或街道列表
	 * </p>
	 * @param status 1小区2街道(如果是房屋，参数传1、如果是店铺参数传空或不用此参数), communityId 社区ID 
	 * @return    
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月29日 上午9:05:27
	 */
	@ResponseBody
	@RequestMapping(value="/getCommunityStreetList")
	public String getCommunityStreetList(CommunityStreetInfoMVO model){
		try {
			List<CommunityStreetInfoMVO> list = communityStreetInfoService.queryList(model);
			return apiResult(RC.SUCCESS, list);
		} catch (Exception e) {
			return exceptionResult(logger, "获取小区/街道列表出错", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 获取社区列表
	 * </p>
	 * @return    
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月29日 上午9:05:27
	 */
	@ResponseBody
	@RequestMapping(value="/getCommunityList")
	public String getCommunityList(){
		try {
			List<CommunityInfoMVO> list = communityInfoService.queryList(new CommunityInfoMVO());
			return apiResult(RC.SUCCESS, list);
		} catch (Exception e) {
			return exceptionResult(logger, "获取社区列表出错", e);
		}
	}	
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 获取证件类型
	 * </p>
	 * @return    
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月29日 上午8:56:22
	 */
	@ResponseBody
	@RequestMapping(value="/getCertTypeList")
	public String getCertTypeList(){
		try {
			List<CertificatesTypeMVO> list = certTypeService.queryList(new CertificatesTypeMVO());
			return apiResult(RC.SUCCESS, list);
		} catch (Exception e) {
			return exceptionResult(logger, "获取证件类型列表出错", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 居住类型
	 * </p>
	 * @return    
	 * String    返回类型 
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年11月4日 下午7:22:53
	 */
	@ResponseBody
	@RequestMapping(value="/getLiveTypeList")
	public String getLiveTypeList(){
		try {
			List<LiveTypeMVO> list = liveTypeService.queryList(new LiveTypeMVO());
			return apiResult(RC.SUCCESS, list);
		} catch (Exception e) {
			return exceptionResult(logger, "获取居住类型列表出错", e);
		}
	}
	
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
