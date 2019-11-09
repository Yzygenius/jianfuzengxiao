package com.jianfuzengxiao.pub.entity;

import com.bamboo.framework.entity.Entity;

public class Statistics extends Entity {

	/** 
	  *  
	  */
	private static final long serialVersionUID = 2795120938829256560L;
	
	//首页
	protected String audit;
	protected String waitaudit;
	protected String auditratio;
	protected String housescount;
	protected String used; //已用
	protected String idle;  //闲置
	protected String percount;
	
	protected String startTime;
	protected String stopTime;
	

	protected String communityId;
	protected String communityStreetId;
	protected String housesTypeId;
	protected String liveTypeId;
	
	//房屋
	protected String total;
	protected String zjf;
	protected String zjfratio;
	protected String szf;
	protected String szfratio;
	protected String sp;
	protected String spratio;
	protected String rent;
	protected String rentratio;
	protected String waitrent;
	protected String waitrentratio;
	protected String houseType;
	
	//人员
	protected String fangzhunum;
	protected String fangzhuratio;
	protected String dianzhunum;
	protected String dianzhuratio;
	protected String zuhunum;
	protected String zuhuratio;
	protected String yuangongnum;
	protected String yuangongratio;
	protected String jiashunum;
	protected String jiashuratio;
	protected String nannum;
	protected String nanratio;
	protected String nvnum;
	protected String nvratio;
	protected String agerange;
	protected String count;
	protected String ratio;
	protected String nationName;
	
	
	
	public String getHouseType() {
		return houseType;
	}
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	public String getNationName() {
		return nationName;
	}
	public void setNationName(String nationName) {
		this.nationName = nationName;
	}
	public String getRatio() {
		return ratio;
	}
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	public String getHousescount() {
		return housescount;
	}
	public void setHousescount(String housescount) {
		this.housescount = housescount;
	}
	public String getUsed() {
		return used;
	}
	public void setUsed(String used) {
		this.used = used;
	}
	public String getIdle() {
		return idle;
	}
	public void setIdle(String idle) {
		this.idle = idle;
	}
	public String getPercount() {
		return percount;
	}
	public void setPercount(String percount) {
		this.percount = percount;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getStopTime() {
		return stopTime;
	}
	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}
	public String getAudit() {
		return audit;
	}
	public void setAudit(String audit) {
		this.audit = audit;
	}
	public String getWaitaudit() {
		return waitaudit;
	}
	public void setWaitaudit(String waitaudit) {
		this.waitaudit = waitaudit;
	}
	public String getAuditratio() {
		return auditratio;
	}
	public void setAuditratio(String auditratio) {
		this.auditratio = auditratio;
	}
	public String getRentratio() {
		return rentratio;
	}
	public void setRentratio(String rentratio) {
		this.rentratio = rentratio;
	}
	public String getWaitrent() {
		return waitrent;
	}
	public void setWaitrent(String waitrent) {
		this.waitrent = waitrent;
	}
	public String getWaitrentratio() {
		return waitrentratio;
	}
	public void setWaitrentratio(String waitrentratio) {
		this.waitrentratio = waitrentratio;
	}
	public String getRent() {
		return rent;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}
	public String getAgerange() {
		return agerange;
	}
	public void setAgerange(String agerange) {
		this.agerange = agerange;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getNannum() {
		return nannum;
	}
	public void setNannum(String nannum) {
		this.nannum = nannum;
	}
	public String getNanratio() {
		return nanratio;
	}
	public void setNanratio(String nanratio) {
		this.nanratio = nanratio;
	}
	public String getNvnum() {
		return nvnum;
	}
	public void setNvnum(String nvnum) {
		this.nvnum = nvnum;
	}
	public String getNvratio() {
		return nvratio;
	}
	public void setNvratio(String nvratio) {
		this.nvratio = nvratio;
	}
	public String getLiveTypeId() {
		return liveTypeId;
	}
	public void setLiveTypeId(String liveTypeId) {
		this.liveTypeId = liveTypeId;
	}
	public String getFangzhunum() {
		return fangzhunum;
	}
	public void setFangzhunum(String fangzhunum) {
		this.fangzhunum = fangzhunum;
	}
	public String getFangzhuratio() {
		return fangzhuratio;
	}
	public void setFangzhuratio(String fangzhuratio) {
		this.fangzhuratio = fangzhuratio;
	}
	public String getDianzhunum() {
		return dianzhunum;
	}
	public void setDianzhunum(String dianzhunum) {
		this.dianzhunum = dianzhunum;
	}
	public String getDianzhuratio() {
		return dianzhuratio;
	}
	public void setDianzhuratio(String dianzhuratio) {
		this.dianzhuratio = dianzhuratio;
	}
	public String getZuhunum() {
		return zuhunum;
	}
	public void setZuhunum(String zuhunum) {
		this.zuhunum = zuhunum;
	}
	public String getZuhuratio() {
		return zuhuratio;
	}
	public void setZuhuratio(String zuhuratio) {
		this.zuhuratio = zuhuratio;
	}
	public String getYuangongnum() {
		return yuangongnum;
	}
	public void setYuangongnum(String yuangongnum) {
		this.yuangongnum = yuangongnum;
	}
	public String getYuangongratio() {
		return yuangongratio;
	}
	public void setYuangongratio(String yuangongratio) {
		this.yuangongratio = yuangongratio;
	}
	public String getJiashunum() {
		return jiashunum;
	}
	public void setJiashunum(String jiashunum) {
		this.jiashunum = jiashunum;
	}
	public String getJiashuratio() {
		return jiashuratio;
	}
	public void setJiashuratio(String jiashuratio) {
		this.jiashuratio = jiashuratio;
	}
	public String getHousesTypeId() {
		return housesTypeId;
	}
	public void setHousesTypeId(String housesTypeId) {
		this.housesTypeId = housesTypeId;
	}
	public String getCommunityId() {
		return communityId;
	}
	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}
	public String getCommunityStreetId() {
		return communityStreetId;
	}
	public void setCommunityStreetId(String communityStreetId) {
		this.communityStreetId = communityStreetId;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getZjf() {
		return zjf;
	}
	public void setZjf(String zjf) {
		this.zjf = zjf;
	}
	public String getZjfratio() {
		return zjfratio;
	}
	public void setZjfratio(String zjfratio) {
		this.zjfratio = zjfratio;
	}
	public String getSzf() {
		return szf;
	}
	public void setSzf(String szf) {
		this.szf = szf;
	}
	public String getSzfratio() {
		return szfratio;
	}
	public void setSzfratio(String szfratio) {
		this.szfratio = szfratio;
	}
	public String getSp() {
		return sp;
	}
	public void setSp(String sp) {
		this.sp = sp;
	}
	public String getSpratio() {
		return spratio;
	}
	public void setSpratio(String spratio) {
		this.spratio = spratio;
	}
	
	
}
