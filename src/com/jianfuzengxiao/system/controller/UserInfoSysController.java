package com.jianfuzengxiao.system.controller;

import static com.jianfuzengxiao.base.utils.ApiUtil.throwAppException;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.base.common.RC;
import com.jianfuzengxiao.base.controller.BaseController;
import com.jianfuzengxiao.pub.entity.AdminInfoMVO;
import com.jianfuzengxiao.pub.entity.PersonnelInfoMVO;
import com.jianfuzengxiao.pub.entity.UserInfoMVO;
import com.jianfuzengxiao.pub.service.IContractFileService;
import com.jianfuzengxiao.pub.service.IUserInfoService;

@Controller
@RequestMapping(value="/system/user")
public class UserInfoSysController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(UserInfoSysController.class);
	
	@Autowired
	private IUserInfoService userInfoService;
	
	@Autowired
	private IContractFileService contractFileService;
	
	@RequestMapping(value="/toUserPage")
	public String toUserPage(){
		return "/system/user-page";
	}
	
	@RequestMapping(value="/toUserDetail")
	public String toUserDetail(UserInfoMVO entity, Model model){
		try {
			entity = userInfoService.queryBean(entity);
			model.addAttribute("user", entity);
		} catch (Exception e) {
			return "/system/error";
		}
		return "/system/user-detail";
	}
	
	@ResponseBody
	@RequestMapping(value="/getUserPage", method = RequestMethod.POST)
	public String getUserPage(UserInfoMVO entity){
		try {
			PageInfo pageInfo = getPage();
			pageInfo.setSortName("createTime");
			pageInfo.setSortOrder("desc");
			entity.setSts("A");
			pageInfo = userInfoService.queryPage(entity, pageInfo);
			return apiResult(RC.SUCCESS, pageInfo);
		} catch (Exception e) {
			return exceptionResult(logger, "获取用户列表失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/delUser", method=RequestMethod.POST)
	public String delUser(UserInfoMVO entity){
		try{
			throwAppException(StringUtils.isBlank(entity.getUserId()), RC.USER_INFO_PARAM_USERID_INVALID);
			List<String> list = Arrays.asList(entity.getUserId().split(","));
			for(int i=0; i<list.size(); i++){
				UserInfoMVO user = new UserInfoMVO();
				user.setUserId(list.get(i));
				user.setSts("P");
				userInfoService.update(user);
			}
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "删除人员失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/auditUser", method=RequestMethod.POST)
	public String auditUser(UserInfoMVO entity){
		try{
			throwAppException(StringUtils.isBlank(entity.getUserId()), RC.USER_INFO_PARAM_USERID_INVALID);
			throwAppException(StringUtils.isBlank(entity.getStatus()), RC.COMPANY_CERT_STATE_INVALID);
			
			userInfoService.updateAuditUser(entity);
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "审核人员失败", e);
		}
	}
	
}
