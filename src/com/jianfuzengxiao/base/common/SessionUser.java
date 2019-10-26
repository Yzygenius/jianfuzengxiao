package com.jianfuzengxiao.base.common;

import javax.servlet.http.HttpSession;

import com.weishangcheng.system.entity.UserInfo;

/**
 * 保存用户会话
 *
 * @author yzy
 * 2018年12月18日10:36:18
 */
public class SessionUser {
	
	public static final String SESSION_USER = "WSC_SESSION_USER"; 
	public static final String USERNAME = "WSC_SESSION_USER.USERNAME";
	public static final String USER_ID = "WSC_SESSION_USER.USER_ID";
	public static final String STAFF_NAME = "WSC_SESSION_USER.STAFF_NAME";

	public static String get(String key) {
		String val = null;

		HttpSession session = HttpHelper.getHttpSession();
		UserInfo userInfo = (UserInfo) session.getAttribute(SESSION_USER);
		switch (key) {
		case USERNAME:
			val = userInfo.getUsername();
			break;
		case USER_ID:
			val = userInfo.getUserId();
			break;
		case STAFF_NAME:
			val = userInfo.getStaffName();
			break;
		default:
			break;
		}
		return val;
	}
	
	public static boolean isLogined() {
		UserInfo userMVO = (UserInfo) HttpHelper.getHttpSession().getAttribute(SESSION_USER);
		return userMVO != null;
	}
	
}
