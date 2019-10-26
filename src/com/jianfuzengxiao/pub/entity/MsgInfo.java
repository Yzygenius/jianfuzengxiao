package com.jianfuzengxiao.pub.entity;

import com.bamboo.framework.entity.Entity;

public class MsgInfo extends Entity {

	protected String msgId;

	protected String userid;

	protected String msgTypeId;

	protected String msgTypeName;

	protected String title;

	protected String content;

	protected String status;

	protected String createTime;

	protected String updateTime;

	protected String sts;

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getMsgTypeId() {
		return msgTypeId;
	}

	public void setMsgTypeId(String msgTypeId) {
		this.msgTypeId = msgTypeId;
	}

	public String getMsgTypeName() {
		return msgTypeName;
	}

	public void setMsgTypeName(String msgTypeName) {
		this.msgTypeName = msgTypeName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}
}
