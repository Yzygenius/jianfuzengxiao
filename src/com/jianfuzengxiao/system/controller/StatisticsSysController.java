package com.jianfuzengxiao.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/system/statistics")
public class StatisticsSysController {
	private static Logger logger = LoggerFactory.getLogger(StatisticsSysController.class);
	
	@RequestMapping(value="/toIndex")
	public String toIndex(){
		return "/system/statistics-index";
	}
	
	@RequestMapping(value="/toHouses")
	public String toHouses(){
		return "/system/statistics-houses";
	}
	
	@RequestMapping(value="/toPersonnel")
	public String toPersonnel(){
		return "/system/statistics-personnel";
	}
	
}
