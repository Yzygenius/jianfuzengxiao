package com.jianfuzengxiao.base.entity;

public class ApiResult {

	protected String code;

	protected String msg;

	protected Object data;
	
	public ApiResult() {
	}
	
	public ApiResult(String code, String msg) {
		this(code, msg, null);
	}

	public ApiResult(String code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
