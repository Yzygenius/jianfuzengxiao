package com.jianfuzengxiao.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jianfuzengxiao.base.controller.BaseController;

@Controller
@RequestMapping(value="/system")
public class MainSysController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(MainSysController.class);
	
	@RequestMapping(value="/welcome")
	public String welcome(){
		return "/system/welcome";
	}
}
