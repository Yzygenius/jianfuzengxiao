package com.jianfuzengxiao.pub.entity;

import com.bamboo.framework.entity.Entity;

public class CertificatesType extends Entity {

	protected String certificatesTypeId;

	protected String certificatesTypeName;

	protected String listOrder;

	protected String createTime;

	protected String updateTime;

	protected String sts;

	public String getCertificatesTypeId() {
		return certificatesTypeId;
	}

	public void setCertificatesTypeId(String certificatesTypeId) {
		this.certificatesTypeId = certificatesTypeId;
	}

	public String getCertificatesTypeName() {
		return certificatesTypeName;
	}

	public void setCertificatesTypeName(String certificatesTypeName) {
		this.certificatesTypeName = certificatesTypeName;
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
