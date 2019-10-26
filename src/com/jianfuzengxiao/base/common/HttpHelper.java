package com.jianfuzengxiao.base.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class HttpHelper {

	/**
	 * 获取 HttpServletRequest
	 */
	public static HttpServletRequest getHttpServletRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	/**
	 * 获取HttpSession
	 */
	public static HttpSession getHttpSession() {
		return getHttpServletRequest().getSession();
	}
	
	/**
	 * 获取请求IP地址
	 * @return
	 */
	public static String getIpAddr() {
		return getIpAddr(getHttpServletRequest());
	}
	
	/**
	 * 获取请求IP地址
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		return request.getRemoteAddr();
	}

}
