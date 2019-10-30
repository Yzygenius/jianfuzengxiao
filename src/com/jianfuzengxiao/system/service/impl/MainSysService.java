package com.jianfuzengxiao.system.service.impl;

import static com.jianfuzengxiao.base.utils.ApiUtil.throwAppException;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.base.common.HttpHelper;
import com.jianfuzengxiao.base.common.MD5Util;
import com.jianfuzengxiao.base.common.RC;
import com.jianfuzengxiao.base.common.SessionAdmin;
import com.jianfuzengxiao.pub.dao.IAdminInfoMDAO;
import com.jianfuzengxiao.pub.entity.AdminInfoMVO;
import com.jianfuzengxiao.system.service.IMainSysService;

@Service
public class MainSysService extends BaseService implements IMainSysService {
	
	@Autowired
	private IAdminInfoMDAO adminInfoMDAO;

	@Override
	public boolean login(AdminInfoMVO adminInfo) throws SysException, AppException {
		//System.out.println(adminInfo.getPassword());
    	AdminInfoMVO admin = new AdminInfoMVO();
    	admin.setLoginName(adminInfo.getLoginName());
    	
    	List<AdminInfoMVO> adminList = adminInfoMDAO.queryList(admin);
    	throwAppException(adminList.size() < 1, RC.LOGIN_USERNAME_PASSWORD_ERROR);
    	admin = adminList.get(0);
    	//System.out.println(admin.getPassword());
    	// 校验用户名密码
    	String encrypt = MD5Util.MD5Encode(adminInfo.getPassword() + admin.getSatl());
    	
    	throwAppException(!StringUtils.equalsIgnoreCase(encrypt, admin.getPassword()), RC.LOGIN_USERNAME_PASSWORD_ERROR);
    	
    	setSession(admin);
        return true;
	}

	@Override
	public void logout() throws SysException, AppException {
		HttpHelper.getHttpSession().removeAttribute(SessionAdmin.SESSION_ADMIN);
	}

	/**
     * 设置会话属性
     */
    private void setSession(AdminInfoMVO adminInfo) {
    	
    	// 保存会话信息
    	HttpHelper.getHttpSession().setAttribute(SessionAdmin.SESSION_ADMIN, adminInfo);
    }
    
}
