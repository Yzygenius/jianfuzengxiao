package com.jianfuzengxiao.pub.entity;

import com.bamboo.framework.entity.Entity;

public class UserInfo extends Entity {
	
	/** 待审核 */
	public final static String status_waiting = "1";
	/** 已通过 */
	public final static String status_passed = "2";
	/** 驳回 */
	public final static String status_reject = "3";

	protected String userId;
	
	protected String opId;

	protected String username;

	protected String gender;

	protected String facePhoto;

	protected String faceFile;

	protected String birthDate;

	protected String nationId;

	protected String nationName;

	protected String telephone;

	protected String certificatesTypeId;

	protected String certificatesTypeName;

	protected String certificatesPositivePhoto;

	protected String certificatesNegativePhoto;

	protected String certificatesNumber;

	protected String certificatesStartTime;

	protected String certificatesStopTime;

	protected String certificatesAddress;

	protected String certificatesOffice;

	protected String status;

	protected String auditRemark;

	protected String createTime;

	protected String updateTime;

	protected String sts;

	protected String leaseStartTime;

	
	public String getOpId() {
		return opId;
	}

	public void setOpId(String opId) {
		this.opId = opId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFacePhoto() {
		return facePhoto;
	}

	public void setFacePhoto(String facePhoto) {
		this.facePhoto = facePhoto;
	}

	public String getFaceFile() {
		return faceFile;
	}

	public void setFaceFile(String faceFile) {
		this.faceFile = faceFile;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getNationId() {
		return nationId;
	}

	public void setNationId(String nationId) {
		this.nationId = nationId;
	}

	public String getNationName() {
		return nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

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

	public String getCertificatesPositivePhoto() {
		return certificatesPositivePhoto;
	}

	public void setCertificatesPositivePhoto(String certificatesPositivePhoto) {
		this.certificatesPositivePhoto = certificatesPositivePhoto;
	}

	public String getCertificatesNegativePhoto() {
		return certificatesNegativePhoto;
	}

	public void setCertificatesNegativePhoto(String certificatesNegativePhoto) {
		this.certificatesNegativePhoto = certificatesNegativePhoto;
	}

	public String getCertificatesNumber() {
		return certificatesNumber;
	}

	public void setCertificatesNumber(String certificatesNumber) {
		this.certificatesNumber = certificatesNumber;
	}

	public String getCertificatesStartTime() {
		return certificatesStartTime;
	}

	public void setCertificatesStartTime(String certificatesStartTime) {
		this.certificatesStartTime = certificatesStartTime;
	}

	public String getCertificatesStopTime() {
		return certificatesStopTime;
	}

	public void setCertificatesStopTime(String certificatesStopTime) {
		this.certificatesStopTime = certificatesStopTime;
	}

	public String getCertificatesAddress() {
		return certificatesAddress;
	}

	public void setCertificatesAddress(String certificatesAddress) {
		this.certificatesAddress = certificatesAddress;
	}

	public String getCertificatesOffice() {
		return certificatesOffice;
	}

	public void setCertificatesOffice(String certificatesOffice) {
		this.certificatesOffice = certificatesOffice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAuditRemark() {
		return auditRemark;
	}

	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
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

	public String getLeaseStartTime() {
		return leaseStartTime;
	}

	public void setLeaseStartTime(String leaseStartTime) {
		this.leaseStartTime = leaseStartTime;
	}
}
