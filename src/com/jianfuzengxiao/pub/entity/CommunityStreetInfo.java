package com.jianfuzengxiao.pub.entity;

import com.bamboo.framework.entity.Entity;

public class CommunityStreetInfo extends Entity {

	protected String communityStreetId;

	protected String communityStreetName;

	protected String status;

	protected String communityId;

	protected String listOrder;

	protected String createTime;

	protected String updateTime;

	protected String sts;

	public String getCommunityStreetId() {
		return communityStreetId;
	}

	public void setCommunityStreetId(String communityStreetId) {
		this.communityStreetId = communityStreetId;
	}

	public String getCommunityStreetName() {
		return communityStreetName;
	}

	public void setCommunityStreetName(String communityStreetName) {
		this.communityStreetName = communityStreetName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCommunityId() {
		return communityId;
	}

	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}

	public String getListOrder() {
		return listOrder;
	}

	public void setListOrder(String listOrder) {
		this.listOrder = listOrder;
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
