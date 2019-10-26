package com.jianfuzengxiao.base.entity;

public class CallBack {

	protected boolean result;

	protected String msg;

	protected Object data;

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
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

	public CallBack() {
	}

	public CallBack(boolean result, String msg, Object data) {
		this.result = result;
		this.msg = msg;
		this.data = data;
	}
	
	
}
