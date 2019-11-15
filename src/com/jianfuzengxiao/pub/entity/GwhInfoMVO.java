package com.jianfuzengxiao.pub.entity;

import org.apache.commons.lang.StringUtils;

import com.bamboo.framework.cache.CacheManager;

public class GwhInfoMVO extends GwhInfo {

	private static final long serialVersionUID = -2418868731764480284L;
	
	private String provName;
	
	private String cityName;
	
	private String areaName;
	
	public String getProvName() {
		if (StringUtils.isNotBlank(provCode)) {
			return (String) CacheManager.getInstance().get("table.cache.idvalue.area", provCode);
		}
		return "";
	}
	
	public String getCityName() {
		if (StringUtils.isNotBlank(cityCode)) {
			return (String) CacheManager.getInstance().get("table.cache.idvalue.area", cityCode);
		}
		return "";
	}
	
	public String getAreaName() {
		if (StringUtils.isNotBlank(areaCode)) {
			return (String) CacheManager.getInstance().get("table.cache.idvalue.area", areaCode);
		}
		return "";
	}
	
}