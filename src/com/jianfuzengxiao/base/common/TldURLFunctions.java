package com.jianfuzengxiao.base.common;

import org.apache.commons.lang.StringUtils;

/**
 * 自定义标签
 *
 * @author Z.jh
 * 2017年3月19日
 */
public class TldURLFunctions {

	private static final String ADMIN_URI = "system";
	private static final String MANAGER_URI = "manager";
	private static final String MOBILE_URI = "mobile";
	private static final String API_URI = "api";
	
	private static final String SUFFIX = ".html";
	private static final String SEPARATOR = "/";

    /**
     * 获取后台管理请求路径
     * @param uri
     * @return
     */
    public static String getAdminURL(String uri) {
    	String contextPath = getContextPath();
    	if (StringUtils.isBlank(uri)) {
    		return contextPath + SEPARATOR + ADMIN_URI + SUFFIX;
    	}
    	return contextPath + SEPARATOR + ADMIN_URI + SEPARATOR + uri + SUFFIX;
    }
    
    /**
     * 用户网页版请求路径
     * @param uri
     * @return
     */
    /*public static String getManagerURL(String uri){
    	String contextPath = getContextPath();
    	if (StringUtils.isBlank(uri)) {
    		return contextPath + SEPARATOR + MANAGER_URI + SUFFIX;
    	}
    	return contextPath + SEPARATOR + MANAGER_URI + SEPARATOR + uri + SUFFIX;
    }*/
    
    /**
     * 获取手机端Web请求路径
     * @param uri
     * @return
     */
    public static String getMobileURL(String uri) {
    	String contextPath = getContextPath();
    	if (StringUtils.isBlank(uri)) {
    		return contextPath + SEPARATOR + MOBILE_URI + SUFFIX;
    	}
    	return contextPath + SEPARATOR + MOBILE_URI + SEPARATOR + uri + SUFFIX;
    }
    
    /**
     * 获取Web请求路径
     * @param uri
     * @return
     */
    public static String getSiteURL(String uri) {
    	String contextPath = getContextPath();
    	if (StringUtils.isBlank(uri)) {
    		return contextPath + SEPARATOR + API_URI + SUFFIX;
    	}
    	return contextPath + SEPARATOR  + API_URI + SEPARATOR + uri + SUFFIX;
    }
    
    /**
     * 排序方式转换
     * @param cur 当前排序方式代码
     * @param clickAsc 点击的排序类型，递增方式排序代码
     * @return
     */
    public static int nextSort(int cur, int clickAsc) {
    	/**
    	 * 排序规则：
    	 *   两位数字表示，第一位数字为排序类型，第二位数字为排序方式
    	 *   排序类型：如按价格、按人气
    	 *   排序方式：0=默认排序，1=升序，2=降序
    	 *   -------------------------------------
    	 * 	  如：按价格排序为10+x，按人气排序为20+x
    	 *      价格升序：11，价格降序：12
    	 *      人气升序：21，人气降序：22
    	 */
    	// 排序类型不同，则取点击的排序类型升序值
    	if (cur/10 != clickAsc/10) {
    		return clickAsc;
		}
    	
    	// 排序类型相同
    	int digit = cur%10;
    	switch (digit) {
		case 0:
		case 1: return cur + 1;
		default: return cur - cur % 10 + 1;
		}
    }
    
    private static String getContextPath() {
    	return HttpHelper.getHttpServletRequest().getContextPath();
    }
    
    public static void main(String[] args) {
		System.out.println(getSiteURL("order/new"));
	}

}
