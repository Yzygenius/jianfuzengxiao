package com.jianfuzengxiao.pub.entity;

import com.bamboo.framework.entity.Entity;

public class LiveType extends Entity {
	
	/** 房主产权人 */
	public static final String fangzhu_chanquanren = "1";
	/** 店主产权人 */
	public static final String dianzhu_chanquanren = "2";
	/** 房主租赁 */
	public static final String fangzhu_zulin = "3";
	/** 店主租赁 */
	public static final String dianzhu_zulin = "4";
	/** 租户 */
	public static final String zuhu = "5";
	/** 员工 */
	public static final String yuangong = "6";
	/** 家属 */
	public static final String jiashu = "7";

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
