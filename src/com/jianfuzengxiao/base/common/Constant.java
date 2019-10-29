package com.jianfuzengxiao.base.common;

public class Constant {
	
	public final static String RETURN_MESSAGE_SERVER_ERROR = "服务器开了小差，请联系管理员";
	public final static String RETURN_WEB_SERVER_ERROR = "系统忙，请稍后重试";
	
	public final static String AES_KEY = "LdfbAo1S8Dggjj==";
	public final static String ACCOUNT_KEY = "nXnbh333Cv0APo==";

	// token key
	public final static String KEY_TOKEN_LOGIN = "WSC_TOKEN_LOGIN";
	public final static String KEY_TOKEN_LOGIN_ID = "WSC_TOKEN_LOGIN_ID";
	public final static String KEY_TOKEN_RETRIEVE = "TOKEN_RETRIEVE";
	public final static String KEY_TOKEN_CHANGE_MOBILE = "TOKEN_CHANGE_MOBILE";
	public final static String KEY_SMS = "weishangcheng_SMS";
	
	// regex
	public final static String REGEX_ACCOUNT_TYPE = "^[HCVIhcvi]$";
	public final static String REGEX_SMSCODE_TYPE = "^[ABab]$";
	public final static String REGEX_CERT_TYPE = "^[PEpe]$";
	public final static String REGEX_CHANGE_MOBILE_TYPE = "^[ABab]$";
	public final static String REGEX_MOBILE = "^1(3|4|5|7|8|9)\\d{9}$";
	public final static String REGEX_SMSCODE = "^\\d{6}$";
	public final static String REGEX_PASSWORD = "^[a-zA-Z\\d_]{6,16}$";
	public final static String REGEX_TOKEN = "^[a-zA-Z\\d]{32}$";
	public final static String REGEX_PLATE = "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$";
	public final static String REGEX_TELEPHONE = "^\\d{3,4}\\-?\\d{7,8}$";
	public final static String REGEX_BANKCARD = "^[1-9]\\d{15,18}$";
	public final static String REGEX_FLOAT = "^([1-9]\\d*|0)+(\\.?\\d{0,2})?$";
	public final static String REGEX_INT = "^\\d+$";
	public final static String REGEX_POSITIVE_INT = "^[1-9]\\d*$";
	public final static String REGEX_DEMIND_WEIGHT = "^[1-9]\\d*(\\.\\d{1,2})?$";
	public final static String REGEX_DEMIND_FREIGHT = "^[1-9]\\d+(\\.\\d{1,2})?$";
	public final static String REGEX_DEMIND_BRINGBILL = "^[01]$";
	public final static String REGEX_DATE_YYYYMMDD = "^20(18|19|2\\d)\\d{4}$";
	
	// 序列
	public final static String SEQ_MEMBER_ACCOUNT = "MEMBER_ACCOUNT";

	// session key
	public final static String SKEY_SYSTEM_LOGIN = "WSC_SKEY_SYSTEM_LOGIN";
	
	/******************************** 文件路径 *******************************/
	// 上传文件根目录
	public final static String UPLOAD_ROOT_DIR = "data/attach/";
	// 上传人脸图片文件目录
	public final static String UPLOAD_FACE_IMAGE_DIR = "data/attach/image/face/";
	// 上传证件图片文件目录
	public final static String UPLOAD_CERT_IMAGE_DIR = "data/attach/image/cert/";
	// 上传租赁合同图片文件目录
	public final static String UPLOAD_LEASE_CONTRACT_IMAGE_DIR = "data/attach/image/contract/";
	// 上传其他图片文件目录
	public final static String UPLOAD_OTHER_IMAGE_DIR = "data/attach/image/other/";
	
	// 允许的图片文件扩展名
	public final static String[] ALLOWED_IMAGE_FILE_TYPES = new String[]{"gif", "jpg", "jpeg", "png", "bmp"};
	
	// 订单过期时长：单位秒（30分钟）
	public final static long ORDER_EXPIRE_SECONDS = 30 * 60;
	
}
