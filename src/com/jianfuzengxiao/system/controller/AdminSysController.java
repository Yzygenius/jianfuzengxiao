package com.jianfuzengxiao.system.controller;

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
import com.jianfuzengxiao.base.common.MD5Util;
import com.jianfuzengxiao.base.common.RC;
import com.jianfuzengxiao.base.common.RandomUtil;
import com.jianfuzengxiao.base.common.SessionAdmin;
import com.jianfuzengxiao.base.controller.BaseController;
import com.jianfuzengxiao.pub.entity.AdminInfo;
import com.jianfuzengxiao.pub.entity.AdminInfoMVO;
import com.jianfuzengxiao.pub.entity.AduitDistributionMVO;
import com.jianfuzengxiao.pub.entity.LgzgMVO;
import com.jianfuzengxiao.pub.entity.RoleInfoMVO;
import com.jianfuzengxiao.pub.service.IAdminInfoService;
import com.jianfuzengxiao.pub.service.IAduitDistributionService;
import com.jianfuzengxiao.pub.service.ILgzgService;
import com.jianfuzengxiao.pub.service.IRoleInfoService;

import static com.jianfuzengxiao.base.utils.ApiUtil.throwAppException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value="/system/admin")
public class AdminSysController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(AdminSysController.class);
	
	@Autowired
	private IAdminInfoService adminInfoService;
	
	@Autowired
	private IRoleInfoService roleInfoService;
	
	@Autowired
	private ILgzgService lgzgService;
	
	@Autowired
	private IAduitDistributionService aduitDistributionService;
	
	@RequestMapping(value="/toAdminPage")
	public String toAdminPage(){
		return "/system/admin-page";
	}
	
	@RequestMapping(value="/toAdminDetail")
	public String toAdminDetail(AdminInfoMVO entity, Model model){
		try {
			entity = adminInfoService.queryBean(entity);
			model.addAttribute("admin", entity);
		} catch (Exception e) {
			return "/system/error";
		}
		return "/system/admin-detail";
	}
	
	@RequestMapping(value="/toAddAdmin")
	public String toAddAdmin(){
		return "/system/admin-addBhgb";
	}
	
	@RequestMapping(value="/toUpdateAdmin")
	public String toUpdateAdmin(AdminInfoMVO entity, Model model){
		try {
			entity = adminInfoService.queryBean(entity);
			model.addAttribute("admin", entity);
		} catch (Exception e) {
			return "/system/error";
		}
		return "/system/admin-update";
	}
	
	@RequestMapping(value="/toAddLgzg")
	public String toAddLgzg(){
		return "/system/admin-addLgzg";
	}
	
	@RequestMapping(value="/toResetPwd")
	public String toResetPwd(){
		return "/system/admin-resetPwd";
	}
	
	//流动专干
	@RequestMapping(value="/toLgzgManagePage")
	public String toLgzgManagePage(){
		return "/system/admin-lgzgPage";
	}

	
	@ResponseBody
	@RequestMapping(value="/getAdminPage", method = RequestMethod.POST)
	public String getAdminPage(AdminInfoMVO entity){
		try {
			if (SessionAdmin.get(SessionAdmin.ROLE_ID).equals("3")) {
				LgzgMVO lgzg = new LgzgMVO();
				lgzg.setAdminId(SessionAdmin.get(SessionAdmin.ADMIN_ID));
				lgzg.setSts("A");
				String communityInfo = "0";
				String adminId = "0";
				List<LgzgMVO> lgzgList = lgzgService.queryList(lgzg);
				if (lgzgList.size() > 0) {
					List<String> list = new ArrayList<String>();
					for(LgzgMVO lg : lgzgList){
						list.add(lg.getCommunityId());
					}
					communityInfo = StringUtils.join(list.toArray(),",");
					
					AduitDistributionMVO aduitDistribution = new AduitDistributionMVO();
					aduitDistribution.setCommunityId(communityInfo);
					aduitDistribution.setSts("A");
					List<AduitDistributionMVO> list2 = aduitDistributionService.queryList(aduitDistribution);
					List<String> list3 = new ArrayList<>();
					if(list2.size() > 0){
						for(AduitDistributionMVO ad: list2){
							list3.add(ad.getAdminId());
						}
						adminId = StringUtils.join(list3.toArray(),",");
					}
				}
				
				entity.setAdminId(adminId);
			}
			
			PageInfo pageInfo = getPage();
			entity.setSts("A");
			pageInfo = adminInfoService.queryPage(entity, pageInfo);
			return apiResult(RC.SUCCESS, pageInfo);
		} catch (Exception e) {
			return exceptionResult(logger, "获取管理员列表失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/getAdminDetail", method = RequestMethod.POST)
	public String getAdminDetail(AdminInfoMVO entity){
		try {
			throwAppException(StringUtils.isBlank(entity.getAdminId()), RC.ADMIN_INFO_PARAM_ADMIN_ID_INVALID);
			entity = adminInfoService.queryBean(entity);
			return apiResult(RC.SUCCESS, entity);
		} catch (Exception e) {
			return exceptionResult(logger, "获取管理员详情失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 添加包户干部
	 * </p>
	 * @param entity
	 * @return    
	 * String    返回类型 
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年11月2日 下午5:32:40
	 */
	@ResponseBody
	@RequestMapping(value="/addAdmin", method = RequestMethod.POST)
	public String addAdmin(AdminInfoMVO entity){
		try {
			throwAppException(StringUtils.isBlank(entity.getLoginName()), RC.LOGIN_USERNAME_PASSWORD_CANNOT_NULL);
			throwAppException(StringUtils.isBlank(entity.getPassword()), RC.LOGIN_USERNAME_PASSWORD_CANNOT_NULL);
			AdminInfoMVO admin = new AdminInfoMVO();
			admin.setLoginName(entity.getLoginName());
			admin.setSts("A");
			List<AdminInfoMVO> list = adminInfoService.queryList(admin);
			throwAppException(list.size() > 0, RC.REGIST_PARAM_TYPE_EXIST);
			
			RoleInfoMVO roleInfo = new RoleInfoMVO();
			roleInfo.setRoleId(entity.getRoleId());
			roleInfo = roleInfoService.queryBean(roleInfo);
			
			String random = RandomUtil.randomStr(6);
			String password = entity.getPassword();
			entity.setSatl(random);
			entity.setPassword(MD5Util.MD5Encode(password + random));
			entity.setIsWx(AdminInfo.is_wx_no);
			entity.setRoleId(roleInfo.getRoleId());
			entity.setRoleName(roleInfo.getRoleName());
			adminInfoService.insert(entity);
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "添加管理员失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/updateAdmin", method = RequestMethod.POST)
	public String updateAdmin(AdminInfoMVO entity){
		try {
			throwAppException(StringUtils.isBlank(entity.getAdminId()), RC.ADMIN_INFO_PARAM_ADMIN_ID_INVALID);
			
			adminInfoService.update(entity);
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "更新管理员失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/delAdmin", method = RequestMethod.POST)
	public String delAdmin(AdminInfoMVO entity){
		try {
			throwAppException(StringUtils.isBlank(entity.getAdminId()), RC.ADMIN_INFO_PARAM_ADMIN_ID_INVALID);
			List<String> list = Arrays.asList(entity.getAdminId().split(","));
			for(int i=0; i<list.size(); i++){
				AdminInfoMVO adminInfo = new AdminInfoMVO();
				adminInfo.setAdminId(list.get(i));
				adminInfo.setSts("P");
				adminInfoService.update(adminInfo);
			}
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "删除管理员失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/resetPwd", method = RequestMethod.POST)
	public String resetPwd(AdminInfoMVO entity){
		try {
			throwAppException(StringUtils.isBlank(entity.getAdminId()), RC.ADMIN_INFO_PARAM_ADMIN_ID_INVALID);
			String password = entity.getPassword();
			entity = adminInfoService.queryBean(entity);
			
			AdminInfoMVO adminInfo = new AdminInfoMVO();
			adminInfo.setAdminId(entity.getAdminId());
			adminInfo.setPassword(MD5Util.MD5Encode(password + entity.getSatl()));
			adminInfoService.update(adminInfo);
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "重置密码失败", e);
		}
	}
	
}
