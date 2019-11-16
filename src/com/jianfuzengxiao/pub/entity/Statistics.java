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
	protected String startTime2;
	protected String stopTime2;

	protected String communityId;
	protected String communityStreetId;
	protected String housesTypeId;
	protected String liveTypeId;
	
	//房屋
	protected String housesId;
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
	
	//上报信息
	protected String totalPass;
	protected String totalWait;
	protected String totalPassRatio;
	protected String totalWaitRatio;
	protected String fangzhuPass;
	protected String fangzhuWait;
	protected String fangzhuPassRatio;
	protected String fangzhuWaitRatio;
	protected String zuhuPass;
	protected String zuhuWait;
	protected String zuhuPassRatio;
	protected String zuhuWaitRatio;
	protected String dianzhuPass;
	protected String dianzhuWait;
	protected String dianzhuPassRatio;
	protected String dianzhuWaitRatio;
	protected String yuangongPass;
	protected String yuangongWait;
	protected String yuangongPassRatio;
	protected String yuangongWaitRatio;
	protected String jiashuPass;
	protected String jiashuWait;
	protected String jiashuPassRatio;
	protected String jiashuWaitRatio;
	protected String fangzhuRatio;
	protected String dianzhuRatio;
	protected String zuhuRatio;
	protected String jiashuRatio;
	protected String yuangongRatio;
	protected String year;
	protected String month;
	protected String day;
	
	protected String thisWeekRatio;
	protected String lastWeekRatio;
	protected String bianhualv;
	
	
	
	
	public String getBianhualv() {
		return bianhualv;
	}
	public void setBianhualv(String bianhualv) {
		this.bianhualv = bianhualv;
	}
	public String getStartTime2() {
		return startTime2;
	}
	public void setStartTime2(String startTime2) {
		this.startTime2 = startTime2;
	}
	public String getStopTime2() {
		return stopTime2;
	}
	public void setStopTime2(String stopTime2) {
		this.stopTime2 = stopTime2;
	}
	public String getThisWeekRatio() {
		return thisWeekRatio;
	}
	public void setThisWeekRatio(String thisWeekRatio) {
		this.thisWeekRatio = thisWeekRatio;
	}
	public String getLastWeekRatio() {
		return lastWeekRatio;
	}
	public void setLastWeekRatio(String lastWeekRatio) {
		this.lastWeekRatio = lastWeekRatio;
	}
	public String getHousesId() {
		return housesId;
	}
	public void setHousesId(String housesId) {
		this.housesId = housesId;
	}
	public String getTotalWaitRatio() {
		return totalWaitRatio;
	}
	public void setTotalWaitRatio(String totalWaitRatio) {
		this.totalWaitRatio = totalWaitRatio;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getFangzhuRatio() {
		return fangzhuRatio;
	}
	public void setFangzhuRatio(String fangzhuRatio) {
		this.fangzhuRatio = fangzhuRatio;
	}
	public String getDianzhuRatio() {
		return dianzhuRatio;
	}
	public void setDianzhuRatio(String dianzhuRatio) {
		this.dianzhuRatio = dianzhuRatio;
	}
	public String getZuhuRatio() {
		return zuhuRatio;
	}
	public void setZuhuRatio(String zuhuRatio) {
		this.zuhuRatio = zuhuRatio;
	}
	public String getJiashuRatio() {
		return jiashuRatio;
	}
	public void setJiashuRatio(String jiashuRatio) {
		this.jiashuRatio = jiashuRatio;
	}
	public String getYuangongRatio() {
		return yuangongRatio;
	}
	public void setYuangongRatio(String yuangongRatio) {
		this.yuangongRatio = yuangongRatio;
	}
	public String getTotalPass() {
		return totalPass;
	}
	public void setTotalPass(String totalPass) {
		this.totalPass = totalPass;
	}
	public String getTotalWait() {
		return totalWait;
	}
	public void setTotalWait(String totalWait) {
		this.totalWait = totalWait;
	}
	public String getTotalPassRatio() {
		return totalPassRatio;
	}
	public void setTotalPassRatio(String totalPassRatio) {
		this.totalPassRatio = totalPassRatio;
	}
	public String getFangzhuPass() {
		return fangzhuPass;
	}
	public void setFangzhuPass(String fangzhuPass) {
		this.fangzhuPass = fangzhuPass;
	}
	public String getFangzhuWait() {
		return fangzhuWait;
	}
	public void setFangzhuWait(String fangzhuWait) {
		this.fangzhuWait = fangzhuWait;
	}
	public String getFangzhuPassRatio() {
		return fangzhuPassRatio;
	}
	public void setFangzhuPassRatio(String fangzhuPassRatio) {
		this.fangzhuPassRatio = fangzhuPassRatio;
	}
	public String getFangzhuWaitRatio() {
		return fangzhuWaitRatio;
	}
	public void setFangzhuWaitRatio(String fangzhuWaitRatio) {
		this.fangzhuWaitRatio = fangzhuWaitRatio;
	}
	public String getZuhuPass() {
		return zuhuPass;
	}
	public void setZuhuPass(String zuhuPass) {
		this.zuhuPass = zuhuPass;
	}
	public String getZuhuWait() {
		return zuhuWait;
	}
	public void setZuhuWait(String zuhuWait) {
		this.zuhuWait = zuhuWait;
	}
	public String getZuhuPassRatio() {
		return zuhuPassRatio;
	}
	public void setZuhuPassRatio(String zuhuPassRatio) {
		this.zuhuPassRatio = zuhuPassRatio;
	}
	public String getZuhuWaitRatio() {
		return zuhuWaitRatio;
	}
	public void setZuhuWaitRatio(String zuhuWaitRatio) {
		this.zuhuWaitRatio = zuhuWaitRatio;
	}
	public String getDianzhuPass() {
		return dianzhuPass;
	}
	public void setDianzhuPass(String dianzhuPass) {
		this.dianzhuPass = dianzhuPass;
	}
	public String getDianzhuWait() {
		return dianzhuWait;
	}
	public void setDianzhuWait(String dianzhuWait) {
		this.dianzhuWait = dianzhuWait;
	}
	public String getDianzhuPassRatio() {
		return dianzhuPassRatio;
	}
	public void setDianzhuPassRatio(String dianzhuPassRatio) {
		this.dianzhuPassRatio = dianzhuPassRatio;
	}
	public String getDianzhuWaitRatio() {
		return dianzhuWaitRatio;
	}
	public void setDianzhuWaitRatio(String dianzhuWaitRatio) {
		this.dianzhuWaitRatio = dianzhuWaitRatio;
	}
	public String getYuangongPass() {
		return yuangongPass;
	}
	public void setYuangongPass(String yuangongPass) {
		this.yuangongPass = yuangongPass;
	}
	public String getYuangongWait() {
		return yuangongWait;
	}
	public void setYuangongWait(String yuangongWait) {
		this.yuangongWait = yuangongWait;
	}
	public String getYuangongPassRatio() {
		return yuangongPassRatio;
	}
	public void setYuangongPassRatio(String yuangongPassRatio) {
		this.yuangongPassRatio = yuangongPassRatio;
	}
	public String getYuangongWaitRatio() {
		return yuangongWaitRatio;
	}
	public void setYuangongWaitRatio(String yuangongWaitRatio) {
		this.yuangongWaitRatio = yuangongWaitRatio;
	}
	public String getJiashuPass() {
		return jiashuPass;
	}
	public void setJiashuPass(String jiashuPass) {
		this.jiashuPass = jiashuPass;
	}
	public String getJiashuWait() {
		return jiashuWait;
	}
	public void setJiashuWait(String jiashuWait) {
		this.jiashuWait = jiashuWait;
	}
	public String getJiashuPassRatio() {
		return jiashuPassRatio;
	}
	public void setJiashuPassRatio(String jiashuPassRatio) {
		this.jiashuPassRatio = jiashuPassRatio;
	}
	public String getJiashuWaitRatio() {
		return jiashuWaitRatio;
	}
	public void setJiashuWaitRatio(String jiashuWaitRatio) {
		this.jiashuWaitRatio = jiashuWaitRatio;
	}
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
