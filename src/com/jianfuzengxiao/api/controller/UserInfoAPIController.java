package com.jianfuzengxiao.api.controller;

import static com.jianfuzengxiao.base.utils.ApiUtil.throwAppException;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jianfuzengxiao.base.common.RC;
import com.jianfuzengxiao.base.controller.BaseController;
import com.jianfuzengxiao.base.utils.Base64ToFile;
import com.jianfuzengxiao.pub.entity.ContractFileMVO;
import com.jianfuzengxiao.pub.entity.HousesInfo;
import com.jianfuzengxiao.pub.entity.HousesInfoMVO;
import com.jianfuzengxiao.pub.entity.PersonnelInfo;
import com.jianfuzengxiao.pub.entity.PersonnelInfoMVO;
import com.jianfuzengxiao.pub.entity.UserInfo;
import com.jianfuzengxiao.pub.entity.UserInfoMVO;
import com.jianfuzengxiao.pub.service.IContractFileService;
import com.jianfuzengxiao.pub.service.IHousesInfoService;
import com.jianfuzengxiao.pub.service.IPersonnelInfoService;
import com.jianfuzengxiao.pub.service.IUserInfoService;

/**
 * 用户
 */
@Controller
@RequestMapping(value="/api/userInfo")
public class UserInfoAPIController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(UserInfoAPIController.class);
	
	@Autowired
	private IUserInfoService userInfoService;
	
	@Autowired
	private IPersonnelInfoService personnelInfoService;
	
	@Autowired
	private IHousesInfoService housesInfoService;
	
	@Autowired
	private IContractFileService contractFileService;
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 首页校验，是否已经上报信息<br>
	 * 如果已经上报信息，code 1 ，否 code 3002
	 * </p>
	 * @param userId
	 * @return    
	 * String    返回类型 
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月29日 下午3:37:07
	 */
	@ResponseBody
	@RequestMapping(value="/verify", method=RequestMethod.POST)
	public String verify(UserInfoMVO model){
		try{
			logger.info("userId---"+model.getUserId());
			logger.info("opId---"+model.getOpId());
			throwAppException(StringUtils.isBlank(model.getUserId()), RC.USER_INFO_PARAM_USERID_INVALID);
			UserInfoMVO userInfoMVO = new UserInfoMVO();
			userInfoMVO.setUserId(model.getUserId());
			userInfoMVO.setSts("A");
			List<UserInfoMVO> uList = userInfoService.queryList(userInfoMVO);
			//System.out.println(uList.size());
			throwAppException(uList.size() < 1, RC.USER_INFO_NOT_EXIST);
			userInfoMVO = uList.get(0);
			return apiResult(RC.SUCCESS, userInfoMVO);
		} catch (Exception e) {
			return exceptionResult(logger, "校验错误", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 身份信息认证上报
	 * </p>
	 * @param userId 用户id, facePhoto 人脸照片地址, certificatesPositivePhoto 证件正面照片, certificatesNegativePhoto 证件反面照片, certificatesTypeId 证件类型id, certificatesTypeName 证件类型名称</br>
	   username 姓名, gender 性别(1男2女), birthDate 生日, nationId 民族id, nationName 民族名称, certificatesNumber 证件号码, certificatesStartTime certificatesStopTime 证件时效, certificatesOffice 办证机关<br>
	   certificatesAddress 办证地址 , telephone 联系电话 , leaseStartTime 居住开始时间
	 * @return    
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月28日 上午10:20:28
	 */
	@ResponseBody
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String addUser(UserInfoMVO model){
		try {
			System.out.println("userId---"+model.getUserId());
			System.out.println("opId---"+model.getOpId());
			System.out.println(model.toString());
			throwAppException(StringUtils.isBlank(model.getUserId()), RC.USER_INFO_PARAM_USERID_INVALID);
			UserInfoMVO userInfoMVO = new UserInfoMVO();
			userInfoMVO.setUserId(model.getUserId());
			userInfoMVO.setOpId(model.getOpId());
			userInfoMVO.setSts("A");
			List<UserInfoMVO> uList = userInfoService.queryList(userInfoMVO);
			throwAppException(uList.size() > 0, RC.USER_INFO_EXIST);
			//model.setStatus(UserInfo.status_waiting);
			model.setStatus(UserInfo.status_passed);
			//base64转file
			Map<String, String> positivePhoto = Base64ToFile.base64ToFile(model.getCertificatesPositivePhoto(), "B");
			Map<String, String> negativePhoto = Base64ToFile.base64ToFile(model.getCertificatesNegativePhoto(), "B");
			Map<String, String> facePhoto = Base64ToFile.base64ToFile(model.getFacePhoto(), "A");
			model.setCertificatesPositivePhoto(request.getContextPath() + "/" + positivePhoto.get("relativePath"));
			model.setCertificatesNegativePhoto(request.getContextPath() + "/" + negativePhoto.get("relativePath"));
			model.setFacePhoto(request.getContextPath() + "/" + facePhoto.get("relativePath"));
			userInfoService.insert(model);
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "身份信息认证上报失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 查询身份信息认证详情
	 * </p>
	 * @param userId 用户id
	 * @return  userid 用户id, facePhoto 人脸照片地址, certificatesPositivePhoto 证件正面照片, certificatesNegativePhoto 证件反面照片, certificatesTypeId 证件类型id, certificatesTypeName 证件类型名称</br>
	   username 姓名, gender 性别(1男2女), birthDate 生日, nationId 民族id, nationName 民族名称, certificatesNumber 证件号码, certificatesStartTime certificatesStopTime 证件时效, certificatesOffice 办证机关<br>
	   certificatesAddress 办证地址 , telephone 联系电话 , leaseStartTime 居住开始时间
	   
	    userId 用户ID, housesId 房产ID , enterpriseName 即app店铺租户所填的企业名称 ,leaseStartTime  leaseStopTime 居住失效 , leaseContract 租赁合同（如果多张转为用逗号隔开的字符串）
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月28日 下午1:08:38
	 */
	@ResponseBody
	@RequestMapping(value="/getUserDetail", method=RequestMethod.POST)
	public String getUserDetail(UserInfoMVO model){
		try {
			throwAppException(StringUtils.isBlank(model.getUserId()), RC.USER_INFO_PARAM_USERID_INVALID);
			UserInfoMVO userInfoMVO = new UserInfoMVO();
			userInfoMVO.setUserId(model.getUserId());
			userInfoMVO.setSts("A");
			List<UserInfoMVO> list = userInfoService.queryList(userInfoMVO);
			throwAppException(list.size() < 1, RC.USER_INFO_NOT_EXIST);
			userInfoMVO = list.get(0);
			userInfoMVO.setLiveTypeId("1");
			
			if (StringUtils.isNotBlank(model.getHousesId())) {
				
				PersonnelInfoMVO personnelInfo = new PersonnelInfoMVO();
				personnelInfo.setUserId(userInfoMVO.getUserId());
				personnelInfo.setPerSort(PersonnelInfo.per_sort_app);
				personnelInfo.setHousesId(model.getHousesId());
				personnelInfo.setSts("A");
				List<PersonnelInfoMVO> list2 = personnelInfoService.queryPerList(personnelInfo);
				if (list2.size() > 0) {
					personnelInfo = list2.get(0);
					
					HousesInfoMVO housesInfo = new HousesInfoMVO();
					housesInfo.setHousesId(model.getHousesId());
					housesInfo = housesInfoService.queryBean(housesInfo);
				
					userInfoMVO.setHousesId(housesInfo.getHousesId());
					userInfoMVO.setCommunityId(housesInfo.getCommunityId());
					userInfoMVO.setCommunityName(housesInfo.getCommunityName());
					userInfoMVO.setCommunityStreetId(housesInfo.getCommunityStreetId());
					userInfoMVO.setCommunityStreetName(housesInfo.getCommunityStreetName());
					userInfoMVO.setStoriedBuildingNumber(housesInfo.getStoriedBuildingNumber());
					userInfoMVO.setUnit(housesInfo.getUnit());
					userInfoMVO.setHouseNumber(housesInfo.getHouseNumber());
					userInfoMVO.setStoreLocation(housesInfo.getStoreLocation());
					userInfoMVO.setHousesAddress(housesInfo.getHousesAddress());
					userInfoMVO.setEnterpriseName(personnelInfo.getEnterpriseName());
					userInfoMVO.setPersonnelId(personnelInfo.getPersonnelId());
					userInfoMVO.setHousesStatus(housesInfo.getHousesStatus());
					userInfoMVO.setLeaseStartTime(personnelInfo.getLeaseStartTime());
					userInfoMVO.setLeaseStopTime(personnelInfo.getLeaseStopTime());
					ContractFileMVO contract = new ContractFileMVO();
					contract.setPersonnelId(personnelInfo.getPersonnelId());
					contract.setHousesId(personnelInfo.getHousesId());
					contract.setSts("A");
					List<ContractFileMVO> contractList = contractFileService.queryList(contract);
					userInfoMVO.setContractList(contractList);
					
					if (StringUtils.equals(housesInfo.getPropertyOwnerIdcard(), personnelInfo.getCertificatesNumber())) {
						userInfoMVO.setHousesMode(HousesInfo.houses_mode_zichi);
					}else {
						userInfoMVO.setHousesMode(HousesInfo.houses_mode_zulin);
					}
				}
			}
			return apiResult(RC.SUCCESS, userInfoMVO);
		} catch (Exception e) {
			return exceptionResult(logger, "查询身份信息失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 修改身份信息认证
	 * </p>
	 * @param userId 用户id, facePhoto 人脸照片地址, certificatesPositivePhoto 证件正面照片, certificatesNegativePhoto 证件反面照片, certificatesTypeId 证件类型id, certificatesTypeName 证件类型名称</br>
	   username 姓名, gender 性别(1男2女), birthDate 生日, nationId 民族id, nationName 民族名称, certificatesNumber 证件号码, certificatesStartTime certificatesStopTime 证件时效, certificatesOffice 办证机关<br>
	   certificatesAddress 办证地址 , telephone 联系电话 , leaseStartTime 居住开始时间
	 * @return    
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月28日 下午1:47:31
	 */
	@ResponseBody
	@RequestMapping(value="updateUser", method=RequestMethod.POST)
	public String updateUser(UserInfoMVO model){
		try {
			throwAppException(StringUtils.isBlank(model.getUserId()), RC.USER_INFO_PARAM_USERID_INVALID);
			//model.setStatus(UserInfo.status_waiting);
			//base64转file
			if (StringUtils.substringBefore(model.getCertificatesPositivePhoto(), ",").equals("data:image/jpeg;base64")) {
				Map<String, String> positivePhoto = Base64ToFile.base64ToFile(model.getCertificatesPositivePhoto(), "B");
				model.setCertificatesPositivePhoto(request.getContextPath() + "/" + positivePhoto.get("relativePath"));
			}
			if (StringUtils.substringBefore(model.getCertificatesNegativePhoto(), ",").equals("data:image/jpeg;base64")) {
				Map<String, String> negativePhoto = Base64ToFile.base64ToFile(model.getCertificatesNegativePhoto(), "B");
				model.setCertificatesNegativePhoto(request.getContextPath() + "/" + negativePhoto.get("relativePath"));
			}
			if (StringUtils.substringBefore(model.getFacePhoto(), ",").equals("data:image/jpeg;base64")) {
				Map<String, String> negativePhoto = Base64ToFile.base64ToFile(model.getFacePhoto(), "A");
				model.setFacePhoto(request.getContextPath() + "/" + negativePhoto.get("relativePath"));
			}
			userInfoService.updateUserPer(model);
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "更新身份信息失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 添加房产后更新上报
	 * </p>
	 * @param userId, personnelId
	 * @return    
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年11月7日 下午6:57:08
	 */
	@ResponseBody
	@RequestMapping(value="updateUserPer", method=RequestMethod.POST)
	public String updateUserPer(UserInfoMVO model){
		try {
			throwAppException(StringUtils.isBlank(model.getUserId()), RC.USER_INFO_PARAM_USERID_INVALID);
			//model.setStatus(UserInfo.status_waiting);
			//base64转file
			if (StringUtils.substringBefore(model.getCertificatesPositivePhoto(), ",").equals("data:image/jpeg;base64")) {
				Map<String, String> positivePhoto = Base64ToFile.base64ToFile(model.getCertificatesPositivePhoto(), "B");
				model.setCertificatesPositivePhoto(request.getContextPath() + "/" + positivePhoto.get("relativePath"));
			}
			if (StringUtils.substringBefore(model.getCertificatesNegativePhoto(), ",").equals("data:image/jpeg;base64")) {
				Map<String, String> negativePhoto = Base64ToFile.base64ToFile(model.getCertificatesNegativePhoto(), "B");
				model.setCertificatesNegativePhoto(request.getContextPath() + "/" + negativePhoto.get("relativePath"));
			}
			if (StringUtils.substringBefore(model.getFacePhoto(), ",").equals("data:image/jpeg;base64")) {
				Map<String, String> negativePhoto = Base64ToFile.base64ToFile(model.getFacePhoto(), "A");
				model.setFacePhoto(request.getContextPath() + "/" + negativePhoto.get("relativePath"));
			}
			userInfoService.updateUserPer(model);
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "更新身份信息失败", e);
		}
	}
	
}
