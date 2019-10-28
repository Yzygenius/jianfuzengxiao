package com.jianfuzengxiao.api.controller;

import static com.jianfuzengxiao.base.utils.ApiUtil.throwAppException;

import java.util.List;

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
import com.jianfuzengxiao.pub.entity.UserInfo;
import com.jianfuzengxiao.pub.entity.UserInfoMVO;
import com.jianfuzengxiao.pub.service.IUserInfoService;

@Controller
@RequestMapping(value="/api/userInfo")
public class UserInfoAPIController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(UserInfoAPIController.class);
	
	@Autowired
	private IUserInfoService userInfoService;
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 身份信息认证上报
	 * </p>
	 * @param userId 用户id, facePhoto 人脸照片地址, certificatesPositivePhoto 证件正面照片, certificatesNegativePhoto 证件反面照片, certificatesTypeId 证件类型id, certificatesTypeName 证件类型名称</br>
	   username 姓名, gender 性别(1男2女), birthDate 生日, nationId 民族id, nationName 民族名称, certificatesNumber 证件号码, certificatesStartTime certificatesStopTime 证件时效, certificatesOffice 办证机关<br>
	   certificatesAddress 办证地址 , telephone 联系电话 , leaseStartTime 居住开始时间
	 * @return    
	 * String    返回类型 
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月28日 上午10:20:28
	 */
	@ResponseBody
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String addUser(UserInfoMVO model){
		try {
			throwAppException(StringUtils.isBlank(model.getUserId()), RC.USER_INFO_PARAM_USERID_INVALID);
			UserInfoMVO userInfoMVO = new UserInfoMVO();
			userInfoMVO.setUserId(model.getUserId());
			List<UserInfoMVO> uList = userInfoService.queryList(userInfoMVO);
			throwAppException(uList.size() > 0, RC.USER_INFO_EXIST);
			model.setStatus(UserInfo.status_waiting);
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
			List<UserInfoMVO> list = userInfoService.queryList(userInfoMVO);
			throwAppException(list.size() < 1, RC.USER_INFO_NOT_EXIST);
			model = list.get(0);
			return apiResult(RC.SUCCESS, model);
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
			userInfoService.update(model);
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "更新身份信息失败", e);
		}
	}
	
}
