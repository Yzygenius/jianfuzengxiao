package com.jianfuzengxiao.pub.entity;

import com.bamboo.framework.entity.Entity;

public class WxConfig extends Entity {

	
	private static final long serialVersionUID = 5285210786161182054L;
	
	public final static String ACCESS_TOKEN_TIME = "ACCESS_TOKEN_TIME";
	
	protected String configId;
	protected String configName;
	protected String configKey;
	protected String configValue;
	protected String type;
	protected String remark;
	protected String updateTime;
	
	public String getConfigId() {
		return configId;
	}
	public void setConfigId(String configId) {
		this.configId = configId;
	}
	public String getConfigName() {
		return configName;
	}
	public void setConfigName(String configName) {
		this.configName = configName;
	}
	public String getConfigValue() {
		return configValue;
	}
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getConfigKey() {
		return configKey;
	}
	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}
	
	
}
