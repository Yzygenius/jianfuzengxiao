package com.jianfuzengxiao.pub.entity;

import com.bamboo.framework.entity.Entity;

public class UserRole extends Entity {

	protected String userRoleId;

	protected String userId;

	protected String roleId;

	protected String sts;

	protected String stsTime;

	public String getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}

	public String getStsTime() {
		return stsTime;
	}

	public void setStsTime(String stsTime) {
		this.stsTime = stsTime;
	}
}
