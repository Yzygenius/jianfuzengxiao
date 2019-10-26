package com.jianfuzengxiao.base.utils;

import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.base.common.RC;

public class ApiUtil {

	public static void throwAppException(RC rc) throws AppException {
		throwAppException(true, rc);
	}
	
	public static void throwAppException(String msg) throws AppException {
		throwAppException(true, "9999", msg);
	}
	
	public static void throwAppException(String code, String msg) throws AppException {
		throwAppException(true, code, msg);
	}
	
	public static void throwAppException(boolean result, RC rc) throws AppException {
		throwAppException(result, rc.code, rc.msg);
	}

	public static void throwAppException(boolean result, String msg) throws AppException {
		throwAppException(result, "9999", msg);
	}
	
	public static void throwAppException(boolean result, String code, String msg) throws AppException {
		if (result) 
			throw new AppException(code, msg);
	}
	
	public static void throwSysException(RC rc) throws SysException {
		throwSysException(true, rc);
	}
	
	public static void throwSysException(String code, String msg) throws SysException {
		throwSysException(true, code, msg);
	}
	
	public static void throwSysException(boolean result, RC rc) throws SysException {
		throwSysException(result, rc.code, rc.msg);
	}
	
	public static void throwSysException(boolean result, String code, String msg) throws SysException {
		if (result) 
			throw new SysException(code, msg, new Exception());
	}
	
	/**
	 * 生成token
	 * @return
	 */
	public static String generateToken() {
		return uuid();
	}

	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("\\-", "");
	}
	
	/**
	 * 生成随机短信验证码
	 * @return
	 */
	public static String generateSmsCode() {
		Random random = new Random();
		StringBuffer buf = new StringBuffer();
		buf.append(random.nextInt(9) + 1);
		for (int i = 0; i < 5; i++) {
			buf.append(random.nextInt(10));
		}
		return buf.toString();
	}
	
	/**
	 * 隐藏手机号码中间四位
	 * @param mobile
	 * @return
	 */
	public static String hideMobile(String mobile) {
		if (StringUtils.isBlank(mobile)
				|| StringUtils.length(mobile) < 11) {
    		return "";
    	}
		return mobile.substring(0, 3) + "****" + mobile.substring(7);
    }

}
