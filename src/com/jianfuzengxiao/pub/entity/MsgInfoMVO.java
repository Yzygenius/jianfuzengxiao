package com.jianfuzengxiao.pub.entity;

public class MsgInfoMVO extends MsgInfo {
	
	private String perCreateTime;
	private String auditRemark;
	
	private String unreadCount;
	
	public String getPerCreateTime() {
		return perCreateTime;
	}
	public void setPerCreateTime(String perCreateTime) {
		this.perCreateTime = perCreateTime;
	}
	public String getAuditRemark() {
		return auditRemark;
	}
	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}
	public String getUnreadCount() {
		return unreadCount;
	}
	public void setUnreadCount(String unreadCount) {
		this.unreadCount = unreadCount;
	}
	
	
}