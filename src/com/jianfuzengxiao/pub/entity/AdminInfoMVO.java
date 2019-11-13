package com.jianfuzengxiao.pub.entity;

public class AdminInfoMVO extends AdminInfo {
	
	private String manageHousesCount;
	private String manageCommunityCount;
	
	private String jsCode;
	
	private String keyword;

	
	public String getManageCommunityCount() {
		return manageCommunityCount;
	}

	public void setManageCommunityCount(String manageCommunityCount) {
		this.manageCommunityCount = manageCommunityCount;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getManageHousesCount() {
		return manageHousesCount;
	}

	public void setManageHousesCount(String manageHousesCount) {
		this.manageHousesCount = manageHousesCount;
	}

	public String getJsCode() {
		return jsCode;
	}

	public void setJsCode(String jsCode) {
		this.jsCode = jsCode;
	}
	
	
}