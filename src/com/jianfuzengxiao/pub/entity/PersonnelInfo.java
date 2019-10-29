package com.jianfuzengxiao.pub.entity;

import com.bamboo.framework.entity.Entity;

public class PersonnelInfo extends Entity {
	
	/** 长期 */
	public final static String lease_mode_changqi = "1";
	/** 非长期 */
	public final static String lease_mode_youxiaoqi = "2";
	
	/** 1 app用户 */
	public final static String per_sort_app = "1";
	/** 2 通过app添加的用户 */
	public final static String per_sort_not_app = "2";
	
	/** 1 未审核 */
	public final static String status_waiting = "1";
	/** 2 审核通过 */
	public final static String status_passed = "2";
	/** 3审核失败 */
	public final static String status_reject = "3";
	/** 4 过期 */
	public final static String status_guoqi = "4";
	/** 5 注销 */
	public final static String status_zhuxiao = "5";
	/** 6 撤销 */
	public final static String status_cexiao = "6";
	
	protected String personnelId;

	protected String housesId;

	protected String userId;

	protected String perSort;

	protected String liveTypeId;

	protected String liveTypeName;

	protected String leaseMode;

	protected String leaseStartTime;

	protected String leaseStopTime;

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

	protected String certificatesPositiveFile;

	protected String certificatesNegativePhoto;

	protected String certificatesNegativeFile;

	protected String certificatesNumber;

	protected String certificatesStartTime;

	protected String certificatesStopTime;

	protected String certificatesAddress;

	protected String certificatesOffice;

	protected String enterpriseName;

	protected String status;

	protected String auditRemark;

	protected String createTime;

	protected String updateTime;

	protected String sts;

	public String getPersonnelId() {
		return personnelId;
	}

	public void setPersonnelId(String personnelId) {
		this.personnelId = personnelId;
	}

	public String getHousesId() {
		return housesId;
	}

	public void setHousesId(String housesId) {
		this.housesId = housesId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPerSort() {
		return perSort;
	}

	public void setPerSort(String perSort) {
		this.perSort = perSort;
	}

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

	public String getLeaseMode() {
		return leaseMode;
	}

	public void setLeaseMode(String leaseMode) {
		this.leaseMode = leaseMode;
	}

	public String getLeaseStartTime() {
		return leaseStartTime;
	}

	public void setLeaseStartTime(String leaseStartTime) {
		this.leaseStartTime = leaseStartTime;
	}

	public String getLeaseStopTime() {
		return leaseStopTime;
	}

	public void setLeaseStopTime(String leaseStopTime) {
		this.leaseStopTime = leaseStopTime;
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

	public String getCertificatesPositiveFile() {
		return certificatesPositiveFile;
	}

	public void setCertificatesPositiveFile(String certificatesPositiveFile) {
		this.certificatesPositiveFile = certificatesPositiveFile;
	}

	public String getCertificatesNegativePhoto() {
		return certificatesNegativePhoto;
	}

	public void setCertificatesNegativePhoto(String certificatesNegativePhoto) {
		this.certificatesNegativePhoto = certificatesNegativePhoto;
	}

	public String getCertificatesNegativeFile() {
		return certificatesNegativeFile;
	}

	public void setCertificatesNegativeFile(String certificatesNegativeFile) {
		this.certificatesNegativeFile = certificatesNegativeFile;
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

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
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
}
