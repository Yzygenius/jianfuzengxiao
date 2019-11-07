package com.jianfuzengxiao.pub.entity;

import java.util.List;

public class UserInfoMVO extends UserInfo {
	private String age;
	
	private String housesId;
	private String enterpriseName;
	private String leaseStartTime;
	private String leaseStopTime;
	private String leaseContract;
	private String liveTypeId;
	private String personnelId;
	private List<ContractFileMVO> contractList;

	private String housesStatus;
	private String communityId;
	private String communityName;
	private String communityStreetId;
	private String communityStreetName;
	private String storiedBuildingNumber;
	private String unit;
	private String houseNumber;
	private String housesAddress;
	private String storeLocation;
	
	
	public String getHousesStatus() {
		return housesStatus;
	}

	public void setHousesStatus(String housesStatus) {
		this.housesStatus = housesStatus;
	}

	public List<ContractFileMVO> getContractList() {
		return contractList;
	}

	public void setContractList(List<ContractFileMVO> contractList) {
		this.contractList = contractList;
	}

	public String getPersonnelId() {
		return personnelId;
	}

	public void setPersonnelId(String personnelId) {
		this.personnelId = personnelId;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCommunityId() {
		return communityId;
	}

	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

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

	public String getStoriedBuildingNumber() {
		return storiedBuildingNumber;
	}

	public void setStoriedBuildingNumber(String storiedBuildingNumber) {
		this.storiedBuildingNumber = storiedBuildingNumber;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getHousesAddress() {
		return housesAddress;
	}

	public void setHousesAddress(String housesAddress) {
		this.housesAddress = housesAddress;
	}

	public String getStoreLocation() {
		return storeLocation;
	}

	public void setStoreLocation(String storeLocation) {
		this.storeLocation = storeLocation;
	}

	public String getLiveTypeId() {
		return liveTypeId;
	}

	public void setLiveTypeId(String liveTypeId) {
		this.liveTypeId = liveTypeId;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getHousesId() {
		return housesId;
	}

	public void setHousesId(String housesId) {
		this.housesId = housesId;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
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

	public String getLeaseContract() {
		return leaseContract;
	}

	public void setLeaseContract(String leaseContract) {
		this.leaseContract = leaseContract;
	}
	
}