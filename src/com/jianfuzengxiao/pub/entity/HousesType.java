package com.jianfuzengxiao.pub.entity;

import com.bamboo.framework.entity.Entity;

public class HousesType extends Entity {

	protected String housesTypeId;

	protected String housesTypeName;

	protected String listOrder;

	protected String createTime;

	protected String updateTime;

	protected String sts;

	public String getHousesTypeId() {
		return housesTypeId;
	}

	public void setHousesTypeId(String housesTypeId) {
		this.housesTypeId = housesTypeId;
	}

	public String getHousesTypeName() {
		return housesTypeName;
	}

	public void setHousesTypeName(String housesTypeName) {
		this.housesTypeName = housesTypeName;
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
