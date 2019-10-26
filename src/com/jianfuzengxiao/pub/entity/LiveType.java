package com.jianfuzengxiao.pub.entity;

import com.bamboo.framework.entity.Entity;

public class LiveType extends Entity {

	protected String liveTypeId;

	protected String liveTypeName;

	protected String listOrder;

	protected String createTime;

	protected String updateTime;

	protected String sts;

	public String getLiveTypeId() {
		return liveTypeId;
	}

	public void setLiveTypeId(String liveTypeId) {
		this.liveTypeId = liveTypeId;
	}

	public String getLiveTypeName() {
		return liveTypeName;
	}

	public void setLiveTypeName(String liveTypeName) {
		this.liveTypeName = liveTypeName;
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
