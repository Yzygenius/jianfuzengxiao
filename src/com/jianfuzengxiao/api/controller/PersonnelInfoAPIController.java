package com.jianfuzengxiao.api.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bamboo.framework.common.util.DateUtil;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.base.common.RC;
import com.jianfuzengxiao.base.controller.BaseController;
import com.jianfuzengxiao.base.utils.Base64ToFile;
import com.jianfuzengxiao.pub.entity.HousesInfo;
import com.jianfuzengxiao.pub.entity.HousesInfoMVO;
import com.jianfuzengxiao.pub.entity.MsgInfo;
import com.jianfuzengxiao.pub.entity.MsgInfoMVO;
import com.jianfuzengxiao.pub.entity.MsgTypeMVO;
import com.jianfuzengxiao.pub.entity.PersonnelInfo;
import com.jianfuzengxiao.pub.entity.PersonnelInfoMVO;
import com.jianfuzengxiao.pub.entity.UserInfoMVO;
import com.jianfuzengxiao.pub.service.IHousesInfoService;
import com.jianfuzengxiao.pub.service.IMsgInfoService;
import com.jianfuzengxiao.pub.service.IMsgTypeService;
import com.jianfuzengxiao.pub.service.IPersonnelInfoService;
import com.jianfuzengxiao.pub.service.IUserInfoService;
import com.jianfuzengxiao.pub.service.impl.PersonnelInfoService;

import sun.misc.BASE64Decoder;

import static com.jianfuzengxiao.base.utils.ApiUtil.throwAppException;

/**
 * 房产、人员 接口
 */
@Controller
@RequestMapping(value="/api/personnel")
public class PersonnelInfoAPIController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(PersonnelInfoAPIController.class);
	
	@Autowired
	private IPersonnelInfoService personnelInfoService;
	
	@Autowired
	private IHousesInfoService housesInfoService;
	
	@Autowired
	private IMsgInfoService magInfoService;
	
	@Autowired
	private IMsgTypeService msgTypeService;
	
	@Autowired
	private IUserInfoService userInfoService;
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 选择房产
	 * </p>
	 * @param housesId, userId
	 * @return    
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年11月4日 上午11:09:20
	 */
	@ResponseBody
	@RequestMapping(value="/getVerifyHouses")
	public String getVerifyHouses(HousesInfoMVO entity){
		try {
			throwAppException(StringUtils.isBlank(entity.getUserId()), RC.USER_INFO_PARAM_USERID_INVALID);
			throwAppException(StringUtils.isBlank(entity.getHousesId()), RC.HOUSES_INFO_PARAM_HOUSES_ID_INVALID);
			String userId = entity.getUserId();
			
			entity = housesInfoService.queryBean(entity);
			
			UserInfoMVO userInfo = new UserInfoMVO();
			userInfo.setUserId(userId);
			userInfo = userInfoService.queryBean(userInfo);
			
			PersonnelInfoMVO per = new PersonnelInfoMVO();
			per.setHousesId(entity.getHousesId());
			per.setSts("A");
//			per.setStatus("");
			per.setLiveTypeId("1,2,3,4");
			List<PersonnelInfoMVO> perList = personnelInfoService.queryPerList(per);
			throwAppException(perList.size() > 0, RC.HOUSES_INFO_CERT_EXIST); 
			
			if (StringUtils.equals(entity.getPropertyOwnerIdcard(), userInfo.getCertificatesNumber())) {
				entity.setHousesMode(HousesInfo.houses_mode_zichi);
			}else {
				entity.setHousesMode(HousesInfo.houses_mode_zulin);
			}
			return apiResult(RC.SUCCESS, entity);
		} catch (Exception e) {
			return exceptionResult(logger, "获取房产信息失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 上传房产信息
	 * </p>
	 * @param  userId 用户ID, housesId 房产ID , enterpriseName 即app店铺租户所填的企业名称 ,leaseStartTime  leaseStopTime 居住失效 , leaseContract 租赁合同（如果多张转为用逗号隔开的字符串）
	 * @return    
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月28日 上午10:40:35
	 */
	@ResponseBody
	@RequestMapping(value="/addUserPersonnel", method=RequestMethod.POST)
	public String addUserPersonnel(PersonnelInfoMVO model){
		try {
			throwAppException(StringUtils.isBlank(model.getUserId()), RC.USER_INFO_PARAM_USERID_INVALID);
			throwAppException(StringUtils.isBlank(model.getHousesId()), RC.HOUSES_INFO_PARAM_HOUSES_ID_INVALID);
			
			personnelInfoService.addUserPersonnel(model);
			
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "身份证信息认证上报失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 更新房产信息
	 * </p>
	 * @param  userId 用户ID, housesId 房产ID , enterpriseName 即app店铺租户所填的企业名称 ,leaseStartTime  leaseStopTime 居住失效 , leaseContract 租赁合同（如果多张转为用逗号隔开的字符串）
	 * @return    
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月28日 上午10:40:35
	 */
	@ResponseBody
	@RequestMapping(value="/updateUserPersonnel", method=RequestMethod.POST)
	public String updateUserPersonnel(PersonnelInfoMVO model){
		try {
			throwAppException(StringUtils.isBlank(model.getUserId()), RC.USER_INFO_PARAM_USERID_INVALID);
			throwAppException(StringUtils.isBlank(model.getHousesId()), RC.HOUSES_INFO_PARAM_HOUSES_ID_INVALID);
			
			personnelInfoService.updatePersonnel(model);
			
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "身份证信息认证上报失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 身份证信息认证上报(人员上报)
	 * </p>
	 * @param leaseMode 居住是否为长期（1长期、2有时长）, facePhoto 人脸照片地址, certificatesPositivePhoto 证件正面照片, certificatesNegativePhoto 证件反面照片, certificatesTypeId 证件类型id, certificatesTypeName 证件类型名称</br>
	   username 姓名, gender 性别(1男2女), birthDate 生日, nationId 民族id, nationName 民族名称, certificatesNumber 证件号码, certificatesStartTime certificatesStopTime 证件时效, certificatesOffice 办证机关<br>
	   certificatesAddress 办证地址 , telephone 联系电话 , enterpriseName 即app店铺租户所填的企业名称, liveTypeId , liveTypeName 居住类型, userId 用户ID, housesId 房产ID
	 * @return    
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月28日 上午10:40:35
	 */
	@ResponseBody
	@RequestMapping(value="/addPersonnel", method=RequestMethod.POST)
	public String addPersonnel(PersonnelInfoMVO model){
		try {
			throwAppException(StringUtils.isBlank(model.getUserId()), RC.USER_INFO_PARAM_USERID_INVALID);
			throwAppException(StringUtils.isBlank(model.getHousesId()), RC.HOUSES_INFO_PARAM_HOUSES_ID_INVALID);
			//不能重复上传人员信息
			PersonnelInfoMVO personnelInfo = new PersonnelInfoMVO();
			personnelInfo.setCertificatesNumber(model.getCertificatesNumber());
			personnelInfo.setHousesId(model.getHousesId());
			personnelInfo.setSts("A");
			List<PersonnelInfoMVO> list = personnelInfoService.queryPerList(personnelInfo);
			throwAppException(list.size() > 0, RC.PERSONNEL_INFO_REPORT_EXIST);
			
			Map<String, String> positivePhoto = Base64ToFile.base64ToFile(model.getCertificatesPositivePhoto(), "B");
			Map<String, String> negativePhoto = Base64ToFile.base64ToFile(model.getCertificatesNegativePhoto(), "B");
			Map<String, String> facePhoto = Base64ToFile.base64ToFile(model.getFacePhoto(), "A");
			model.setCertificatesPositivePhoto(request.getContextPath() + "/" + positivePhoto.get("relativePath"));
			model.setCertificatesNegativePhoto(request.getContextPath() + "/" + negativePhoto.get("relativePath"));
			model.setFacePhoto(request.getContextPath() + "/" + facePhoto.get("relativePath"));
			personnelInfoService.addPersonnel(model);
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "身份证信息认证上报失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 更新，身份证信息认证上报(人员上报)
	 * </p>
	 * @param personnelId 人员ID,leaseMode 居住是否为长期（1长期、2有时长）, facePhoto 人脸照片地址, certificatesPositivePhoto 证件正面照片, certificatesNegativePhoto 证件反面照片, certificatesTypeId 证件类型id, certificatesTypeName 证件类型名称</br>
	   username 姓名, gender 性别(1男2女), birthDate 生日, nationId 民族id, nationName 民族名称, certificatesNumber 证件号码, certificatesStartTime certificatesStopTime 证件时效, certificatesOffice 办证机关<br>
	   certificatesAddress 办证地址 , telephone 联系电话 , enterpriseName 即app店铺租户所填的企业名称, liveTypeId , liveTypeName 居住类型
	 * @return    
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月28日 上午10:40:35
	 */
	@ResponseBody
	@RequestMapping(value="/updatePersonnel", method=RequestMethod.POST)
	public String updatePersonnel(PersonnelInfoMVO model){
		try {
			PersonnelInfoMVO personnelInfo = new PersonnelInfoMVO();
			personnelInfo.setCertificatesNumber(model.getCertificatesNumber());
			personnelInfo.setHousesId(model.getHousesId());
			personnelInfo.setSts("A");
			List<PersonnelInfoMVO> list = personnelInfoService.queryPerList(personnelInfo);
		//	System.out.println(list.size());
		//	System.out.println(model.getHousesId());
		//	throwAppException(list.size() > 1, RC.PERSONNEL_INFO_REPORT_EXIST);
			
			
			if (StringUtils.isNotBlank(model.getCertificatesPositivePhoto()) && StringUtils.substringBefore(model.getCertificatesPositivePhoto(), ",").equals("data:image/jpeg;base64")) {
				Map<String, String> positivePhoto = Base64ToFile.base64ToFile(model.getCertificatesPositivePhoto(), "B");
				model.setCertificatesPositivePhoto(request.getContextPath() + "/" + positivePhoto.get("relativePath"));
			}
			if (StringUtils.isNotBlank(model.getCertificatesNegativePhoto()) && StringUtils.substringBefore(model.getCertificatesNegativePhoto(), ",").equals("data:image/jpeg;base64")) {
				Map<String, String> negativePhoto = Base64ToFile.base64ToFile(model.getCertificatesNegativePhoto(), "B");
				model.setCertificatesNegativePhoto(request.getContextPath() + "/" + negativePhoto.get("relativePath"));
			}
			if (StringUtils.isNotBlank(model.getFacePhoto()) && StringUtils.substringBefore(model.getFacePhoto(), ",").equals("data:image/jpeg;base64")) {
				Map<String, String> negativePhoto = Base64ToFile.base64ToFile(model.getFacePhoto(), "A");
				model.setFacePhoto(request.getContextPath() + "/" + negativePhoto.get("relativePath"));
			}
			
			personnelInfoService.updatePersonnel(model);
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "身份证信息认证上报失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 移出人员
	 * </p>
	 * @param personnelId 人员ID
	 * @return    
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月28日 下午6:15:06
	 */
	@ResponseBody
	@RequestMapping(value="/delPersonnel", method=RequestMethod.POST)
	public String delPersonnel(PersonnelInfoMVO model){
		try {
			PersonnelInfoMVO personnelInfo = new PersonnelInfoMVO();
			personnelInfo.setPersonnelId(model.getPersonnelId());
			//居住截止时间
			personnelInfo.setLeaseStopTime(DateUtil.nowTime());
			personnelInfo.setSts("P");
			personnelInfoService.update(personnelInfo);
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "身份证信息认证上报失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 查询房产列表，分页
	 * </p>
	 * @param userId 用户ID
	 * @return  housesId, housesStatus 类型(1房屋、2门店), propertyOwnerName 房屋（门店）产权人姓名, propertyOwnerTel 房屋（门店）产权人联系电话, propertyOwnerIdcard 房屋（门店）产权人身份证号<br>
	 	propertyCertificatesNumber 房屋（门店）产权证号, propertyCertificatesPhoto 房屋（门店）房产证照片, communityId 社区类型id, communityName 社区类型名称<br>
	 	communityStreetId 小区或街道id, communityStreetName 小区或街道名称, houseType 房屋（门店）户型 , houseTypePhoto 房屋（门店）户型图, storiedBuildingNumber 房屋楼号<br>
	 	unit 房屋单元, houseNumber 门牌号, housesAddress 房屋（门店）详细地址, housesTypeId 房屋类型id, housesTypeName 房屋类型名称, storeLocation 门店0无1内/2外铺<br>
	 	provName provCode 省, cityName cityCode 市, areaName areaCode 区/县 ,
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月28日 下午4:46:02
	 */
	@ResponseBody
	@RequestMapping(value="/getHousesPage", method=RequestMethod.POST)
	public String getHousesPage(PersonnelInfoMVO model){
		try {
			throwAppException(StringUtils.isBlank(model.getUserId()), RC.USER_INFO_PARAM_USERID_INVALID);
			PageInfo pageInfo = getPage();
			pageInfo.setSortName("createTime");
			pageInfo.setSortOrder("desc");
			model.setSts("A");
			pageInfo = personnelInfoService.queryHousesPage(model, pageInfo);
			return apiResult(RC.SUCCESS, pageInfo);
		} catch (Exception e) {
			return exceptionResult(logger, "查询房产列表失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 查询房产列表
	 * </p>
	 * @param userId 用户ID
	 * @return  housesId, housesStatus 类型(1房屋、2门店), propertyOwnerName 房屋（门店）产权人姓名, propertyOwnerTel 房屋（门店）产权人联系电话, propertyOwnerIdcard 房屋（门店）产权人身份证号<br>
	 	propertyCertificatesNumber 房屋（门店）产权证号, propertyCertificatesPhoto 房屋（门店）房产证照片, communityId 社区类型id, communityName 社区类型名称<br>
	 	communityStreetId 小区或街道id, communityStreetName 小区或街道名称, houseType 房屋（门店）户型 , houseTypePhoto 房屋（门店）户型图, storiedBuildingNumber 房屋楼号<br>
	 	unit 房屋单元, houseNumber 门牌号, housesAddress 房屋（门店）详细地址, housesTypeId 房屋类型id, housesTypeName 房屋类型名称, storeLocation 门店0无1内/2外铺<br>
	 	provName provCode 省, cityName cityCode 市, areaName areaCode 区/县 ,    
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月28日 下午4:46:02
	 */
	@ResponseBody
	@RequestMapping(value="/getHousesList", method=RequestMethod.POST)
	public String getHousesList(PersonnelInfoMVO model){
		try {
			throwAppException(StringUtils.isBlank(model.getUserId()), RC.USER_INFO_PARAM_USERID_INVALID);
			model.setSts("A");
			List<PersonnelInfoMVO> list = personnelInfoService.queryHousesList(model);
			return apiResult(RC.SUCCESS, list);
		} catch (Exception e) {
			return exceptionResult(logger, "查询房产列表失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 查询房产详情
	 * </p>
	 * @param housesId 房产ID
	 * @return    houses 房产信息, per 人员列表
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月28日 下午5:07:50
	 */
	@ResponseBody
	@RequestMapping(value="/getHousesDetail", method=RequestMethod.POST)
	public String getHousesDetail(PersonnelInfoMVO model){
		try {
			throwAppException(StringUtils.isBlank(model.getHousesId()), RC.HOUSES_INFO_PARAM_HOUSES_ID_INVALID);
			HousesInfoMVO housesInfo = new HousesInfoMVO();
			housesInfo.setHousesId(model.getHousesId());
			housesInfo = housesInfoService.queryBean(housesInfo);
			
			PersonnelInfoMVO personnelInfo = new PersonnelInfoMVO();
			personnelInfo.setHousesId(model.getHousesId());
			personnelInfo.setSts("A");
			List<PersonnelInfoMVO> list = personnelInfoService.queryPerList(personnelInfo);
			Map<String, Object> map = new HashMap<String, Object>();
			if (list.size() > 0) {
				housesInfo.setEnterpriseName(list.get(0).getEnterpriseName());
				housesInfo.sethStatus(list.get(0).getStatus());
			}else {
				housesInfo.setEnterpriseName("");
				housesInfo.sethStatus(PersonnelInfo.status_waiting);
			}
			
			map.put("houses", housesInfo);
			map.put("per", list);
			return apiResult(RC.SUCCESS, map);
		} catch (Exception e) {
			return exceptionResult(logger, "查询房产列表失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 查询人员详情
	 * </p>
	 * @param personnelId 人员ID
	 * @return    
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月28日 下午5:44:36
	 */
	@ResponseBody
	@RequestMapping(value="/getPerDetail", method=RequestMethod.POST)
	public String getPerDetail(PersonnelInfoMVO model){
		try {
			throwAppException(StringUtils.isBlank(model.getPersonnelId()), RC.PERSONNEL_PARAM_PERSONNEL_ID_INVALID);
			model = personnelInfoService.queryPersonnelBean(model);
			return apiResult(RC.SUCCESS, model);
		} catch (Exception e) {
			return exceptionResult(logger, "查询房产列表失败", e);
		}
	}
}
