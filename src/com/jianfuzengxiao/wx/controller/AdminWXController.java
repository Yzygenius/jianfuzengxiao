package com.jianfuzengxiao.wx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.jianfuzengxiao.base.controller.BaseController;

@Controller
@RequestMapping(value="/wx/admin")
public class AdminWXController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(AdminWXController.class);
	
	@ResponseBody
	@RequestMapping(value="/verifyLogin")
	public String verifyLogin(){
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
