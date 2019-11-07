package com.jianfuzengxiao.system.controller;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.base.common.RC;
import com.jianfuzengxiao.base.common.SessionAdmin;
import com.jianfuzengxiao.base.controller.BaseController;
import com.jianfuzengxiao.pub.entity.AdminInfoMVO;
import com.jianfuzengxiao.pub.service.IAdminInfoService;
import com.jianfuzengxiao.system.service.IMainSysService;

import static com.jianfuzengxiao.base.utils.ApiUtil.throwAppException;

@Controller
@RequestMapping(value="/system")
public class IndexSysController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(IndexSysController.class);

	@Autowired
	private IMainSysService mainSysService;
	
	@Autowired
	private IAdminInfoService adminInfoService;
	
	@RequestMapping
    public String index(Model model) {
    	try {
    		if (!SessionAdmin.isLogined()) {
    			return "/system/login";
    		}
        	AdminInfoMVO admin = new AdminInfoMVO();
        	admin.setAdminId(SessionAdmin.get(SessionAdmin.ADMIN_ID));
        	admin = adminInfoService.queryBean(admin);
        	model.addAttribute("admin", admin);
            return "/system/index"; 
		} catch (Exception e) {
			return "/system/error";
		}
    }
	
	@ResponseBody
	@RequestMapping("/login")
	public String login(AdminInfoMVO adminInfo) {
	    try {
	    	throwAppException(StringUtils.isBlank(adminInfo.getLoginName()) || StringUtils.isBlank(adminInfo.getPassword()), RC.LOGIN_USERNAME_PASSWORD_CANNOT_NULL);
	    	
	    	mainSysService.login(adminInfo);
		} catch (Exception e) {
			return exceptionResult(logger, "用户登录出错", e);
		}
	    return apiResult(RC.SUCCESS);
	}
	
	@RequestMapping("/logout")
	public String logout(AdminInfoMVO adminInfo) throws SysException, AppException {
		mainSysService.logout();
	    return "/system/login";
	}
}
