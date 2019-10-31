package com.jianfuzengxiao.pub.entity;

public class HousesInfoMVO extends HousesInfo {
	
	private String username;
	
	private String adminTelephone;
	
	private String leaseCount;

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