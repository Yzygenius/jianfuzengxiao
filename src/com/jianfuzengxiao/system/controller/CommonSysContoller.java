package com.jianfuzengxiao.system.controller;

import static com.jianfuzengxiao.base.utils.ApiUtil.throwAppException;

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

import com.bamboo.framework.common.util.DateUtil;
import com.jianfuzengxiao.base.common.Constant;
import com.jianfuzengxiao.base.common.DataFileUtil;
import com.jianfuzengxiao.base.common.FileUtil;
import com.jianfuzengxiao.base.common.RC;
import com.jianfuzengxiao.base.common.SessionAdmin;
import com.jianfuzengxiao.base.controller.BaseController;
import com.jianfuzengxiao.base.utils.BigDouble;
import com.jianfuzengxiao.base.utils.ExcelUtil;
import com.jianfuzengxiao.base.utils.Upxml;
import com.jianfuzengxiao.pub.entity.AttachFileMVO;
import com.jianfuzengxiao.pub.entity.CommunityInfoMVO;
import com.jianfuzengxiao.pub.entity.CommunityStreetInfoMVO;
import com.jianfuzengxiao.pub.entity.HousesInfoMVO;
import com.jianfuzengxiao.pub.entity.HousesTypeMVO;
import com.jianfuzengxiao.pub.entity.LgzgMVO;
import com.jianfuzengxiao.pub.service.ICommunityInfoService;
import com.jianfuzengxiao.pub.service.ICommunityStreetInfoService;
import com.jianfuzengxiao.pub.service.IExcelImportService;
import com.jianfuzengxiao.pub.service.IHousesInfoService;
import com.jianfuzengxiao.pub.service.IHousesTypeService;
import com.jianfuzengxiao.pub.service.ILgzgService;

@Controller
@RequestMapping(value="/system/common")
public class CommonSysContoller extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(CommonSysContoller.class);
	
	@Autowired
	private IHousesTypeService housesTypeService;
	
	@Autowired
	private IHousesInfoService housesInfoService;
	
	@Autowired
	private IExcelImportService excelImportService;
	
	@Autowired
	private ICommunityInfoService communityInfoService;
	
	@Autowired
	private ICommunityStreetInfoService communityStreetInfoService;
	
	@Autowired
	private ILgzgService lgzgService;
	
	@ResponseBody
	@RequestMapping(value="/uploadExcel")
	public String uploadExcel(@RequestParam("file") CommonsMultipartFile file){
		try {
			throwAppException(file == null, RC.COMMON_IMAGE_FILE_INVALID);
			AttachFileMVO attachFile = DataFileUtil.saveDBImage(file);
		
			String fileName = request.getSession().getServletContext().getRealPath(attachFile.getSaveName());
			/*List<HousesInfoMVO> housesList = Upxml.getDataFromExcel(fileName);
			for(int i=0; i<housesList.size(); i++) {
				housesInfoService.insert(housesList.get(i));
			}*/
			excelImportService.addPersonnelExcel(fileName);
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "导入excel错误", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/downloadExcel")
	public void downloadExcel(RedirectAttributes redirectAttributes, HousesInfoMVO entity){
		String fileName = "房产信息.xls";
		String[] title = {"房产ID", "产权类型", "产权人姓名", "产权人联系电话", "产权人身份证号", "房产证号码", "社区", "小区", "户型", "楼号", "单元", "门牌号", "详细地址", "房产类型", "内/外铺", "省", "市", "区", "创建时间", "最新更新时间", "房产证照片", "户型图"};
		
		try {
			entity.setSts("A");
			List<HousesInfoMVO> list = housesInfoService.queryList(entity);
			HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(fileName, title, list, null);
			
			this.setResponseHeader(response, fileName);
			OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			logger.info("导出excel错误", e);
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
			model.setSts("A");
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
			CommunityInfoMVO communityInfoMVO = new CommunityInfoMVO();
			
			communityInfoMVO.setSts("A");
			List<CommunityInfoMVO> list = communityInfoService.queryList(communityInfoMVO);
			return apiResult(RC.SUCCESS, list);
		} catch (Exception e) {
			return exceptionResult(logger, "获取社区列表出错", e);
		}
	}
	
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
