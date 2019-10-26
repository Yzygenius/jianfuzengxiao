package com.jianfuzengxiao.base.common;

public enum RC {
	
	SUCCESS("1", "success"),
	
	// 账号操作类
	//   登录 11
	LOGIN_USERNAME_PASSWORD_CANNOT_NULL("1101", "用户名或密码不能为空"),
	LOGIN_USERNAME_PASSWORD_ERROR("1102", "用户名或密码错误"),
	LOGIN_USERNAME_ACCOUNT_TYPE("1103", "用户没有权限登录该APP"),
	LOGIN_USERNAME_LOCKED("1104", "您的账号已被锁定，请联系客服"),
	LOGIN_USERNAME_INVALID("1105", "您的账号已失效，请联系客服"),
	LOGIN_MANAGER_USERNAME_ACCOUNT_TYPE("1106", "用户没有权限登录该平台"),
	
	//   注册 12
	REGIST_PARAM_TYPE_INVALID("1201", "账号类型无效"),
	REGIST_PARAM_MOBILE_INVALID("1202", "手机号码无效"),
	REGIST_PARAM_SMSCODE_INVALID("1203", "短信验证码无效"),
	REGIST_PARAM_PASSWORD_INVALID("1204", "密码格式无效（必须为6-16位字母+数字）"),
	REGIST_PARAM_MOBILE_OCCUPIED("1205", "该手机号码已注册，请直接登录"),
	REGIST_PARAM_SMSCODE_TYPE_INVALID("1206", "短信验证码类型无效"),
	
	// 找回密码 13
	RETRIEVE_PARAM_MOBILE_INVALID("1301", "手机号码无效"),
	RETRIEVE_PARAM_SMSCODE_INVALID("1302", "短信验证码无效"),
	RETRIEVE_MOBILE_NOT_EXIST("1303", "手机号码不存在"),
	
	RETRIEVE_TOKEN_INVALID("1304", "令牌无效"),
	RETRIEVE_PARAM_PASSWORD_INVALID("1305", "密码格式无效（必须为6-16位字母+数字）"),
	PHONE_NOT_REGISTERED("1306", "该手机号尚未注册，请输入正确的手机号！！"),
	
	//账号管理
	COMPANY_CERT_STATE_INVALID("1401", "审核状态无效"),
	COMPANY_ID_INVALID("1402", "会员无效"),
	COMPANY_PASSWORD_RESET_INVALID("1403", "重置密码失败"),
	COMPANY_CONTACT_TEL_INVALID("1404", "联系电话无效"),
	COMPANY_USERNAME_INVALID("1405", "用户名无效"),
	COMPANY_CERT_STATE_AUDITING_INVALID("1406", "该账号正在审核中，无法使用该功能"),
	
	
	// 个人中心操作类
	// 交易信息
	TRANSACTION_INFO_INVALID("1501", "交易信息令牌无效"),
	
	//    更换手机号码 24
	CHANGE_PARAM_TYPE_INVALID("2401", "验证码类型无效"),
	CHANGE_PARAM_MOBILE_INVALID("2402", "手机号码无效"),
	CHANGE_PARAM_SMSCODE_INVALID("2403", "短信验证码错误"),
	CHANGE_PARAM_TOKEN_INVALID("2404", "更换手机号码令牌无效"),
	CHANGE_PARAM_SAME_MOBILE("2405", "新手机号码不能与原手机号码相同"),
	CHANGE_PARAM_EXIST_MOBILE("2406", "新手机号码已被占用"),


	//    修改密码 26
	UPDATEPWD_PARAM_OLDPASSWORD_ERROR("2601", "原密码输入错误"),
	UPDATEPWD_PARAM_PASSWORD_INVALID("2602", "新密码格式无效（必须为6-16位字母+数字）"),
	UPDATEPWD_PARAM_PAY_PASSWORD_NULL("2603", "请设置支付密码"),
	UPDATEPWD_PARAM_PAY_PASSWORD("", "您已设置支付密码，请勿重复操作"),
	UPDATEPWD_PARAM_PAY_PASSWORD_MODILE_NOT("", "该手机号与登录账号不匹配"),
	
	//    银行卡 27
	BANKCARD_PARAM_BANKNO_INVALID("2701", "银行卡号无效"),
	BANKCARD_PARAM_CUSTNAME_NULL("2702", "请填写持卡人姓名"),
	BANKCARD_PARAM_BANKTYPE_INVALID("2703", "找不到卡号对应的银行"),
	BANKCARD_PARAM_CARDID_INVALID("2704", "银行卡编码无效"),
	BANKCARD_REPEAT_BIND_CARD("2705", "您已绑定过该银行卡，请勿重复绑定"),

	//    个人信息 28
	BASEINFO_PARAM_CITY_CODE_INVALID("2801", "归属区域无效"),

	//    钱包 29
	DRAW_PARAM_AMOUNT_INVALID("2901", "提现金额无效"),
	DRAW_PARAM_CARD_ID_INVALID("2902", "提现银行卡无效"),
	DRAW_AMOUNT_NOT_ENOUGH("2903", "可提现余额不足"),
	DRAW_DEPOSIT_NOT_ENOUGH("2904", "可退押金余额为0"),
	DRAW_RECHARGE_NULL("2905", "充值金额不能为空"),
	MEMBER_BILL_ID_NULL("2906", "账目明细参数错误"),
	
	// API业务操作类
	//    货主需求单 31
	
	
	// 订单类
	ORDER_PARAM_PAY_MODE_INVALID("5101", "请选择支付方式"),
	ORDER_PARAM_ORDER_CODE_INVALID("5102", "订单号无效"),
	ORDER_PAY_MODE_NONSUPPORT("5103", "支付方式不支持"),
	ORDER_BALANCE_NOT_ENOUGH("5104", "账户余额不足"),
	ORDER_PAY_PASSWORD_ERROR("5105", "支付密码错误"),
	DEMIND_VEHICLE_STATE_T("5106", "已经有运输中的订单"),
	RECHARGE_PARAM_PAY_MODE_INVALID("5107", "请选择充值方式"),
	RECHARGE_PARAM_AMOUNT_NULL("5108", "请输入充值金额"),
	
	
	
	// 通用类
	COMMON_IMAGE_FILE_INVALID("7101", "图片文件无效"),

	OTHER_TOKEN_TIMEOUT("9000", "登录会话过期，请重新登录"),
	OTHER_UNAUTHORIZED("9001", "无权操作"),
	OTHER_APP_VERSION_NOTFOUND("9002", "暂未找到最新版本信息"),
	OTHER_WAIT_REALNAME("9003", "请先完成实名认证"),
	OTHER_SMSCODE_ERROR("9004", "短信发送失败，请稍后再试"),
	OTHER_ERROR("9999", "操作有误,请和管理员联系");
//	OTHER_ERROR("9999", "服务器内部错误");
	
	public final static String RECEIPT_NOT_AUDIT_SUCCESS = "-1";
	public final static String NO_TRANSPORT_COMPLETE = "0";
	public final static String SUCCESS_CODE = "1";
	public final static String OTHER_ERROR_CODE = "9999";

	public String code;
	public String msg;
	
	private RC(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

}
