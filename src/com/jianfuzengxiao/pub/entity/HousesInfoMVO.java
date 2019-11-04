package com.jianfuzengxiao.pub.entity;

public class HousesInfoMVO extends HousesInfo {
	
	private String username;
	
	private String adminTelephone;
	
	private String leaseCount;
	
	private String keyword;
	
	private String communityStreetStatus;

	
	public String getCommunityStreetStatus() {
		return communityStreetStatus;
	}

	public void setCommunityStreetStatus(String communityStreetStatus) {
		this.communityStreetStatus = communityStreetStatus;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getAdminTelephone() {
		return adminTelephone;
	}

	public void setAdminTelephone(String adminTelephone) {
		this.adminTelephone = adminTelephone;
	}

	public String getLeaseCount() {
		return leaseCount;
	}

	public void setLeaseCount(String leaseCount) {
		this.leaseCount = leaseCount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}