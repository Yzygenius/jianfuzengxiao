package com.jianfuzengxiao.base.common;

import javax.servlet.http.HttpSession;

import com.jianfuzengxiao.pub.entity.AdminInfoMVO;

/**
 * 保存用户会话
 *
 * @author yzy
 * 2018年12月18日10:36:18
 */
public class SessionAdmin {
	
	public static final String SESSION_ADMIN = "SESSION_ADMIN"; 
	public static final String ADMIN_ID = "SESSION_USER.ADMIN_ID";
	public static final String LOGIN_NAME = "SESSION_USER.LOGIN_NAME";
	public static final String USERNAME = "SESSION_USER.USERNAME";
	public static final String GENDER = "SESSION_USER.GENDER";
	public static final String TELEPHONE = "SESSION_USER.TELEPHONE";
	public static final String ROLE_ID = "SESSION_USER.ROLE_ID";
	public static final String ROLE_NAME = "SESSION_USER.ROLE_NAME";

	public static String get(String key) {
		String val = null;

		HttpSession session = HttpHelper.getHttpSession();
		AdminInfoMVO adminInfo = (AdminInfoMVO) session.getAttribute(SESSION_ADMIN);
		switch (key) {
		case ADMIN_ID:
			val = adminInfo.getAdminId();
			break;
		case LOGIN_NAME:
			val = adminInfo.getLoginName();
			break;
		case USERNAME:
			val = adminInfo.getUsername();
			break;
		case GENDER:
			val = adminInfo.getGender();
			break;
		case TELEPHONE:
			val = adminInfo.getTelephone();
			break;
		case ROLE_ID:
			val = adminInfo.getRoleId();
			break;
		case ROLE_NAME:
			val = adminInfo.getRoleName();
			break;
		default:
			break;
		}
		return val;
	}
	
	public static boolean isLogined() {
		AdminInfoMVO adminInfo = (AdminInfoMVO) HttpHelper.getHttpSession().getAttribute(SESSION_ADMIN);
		return adminInfo != null;
	}
	
}
