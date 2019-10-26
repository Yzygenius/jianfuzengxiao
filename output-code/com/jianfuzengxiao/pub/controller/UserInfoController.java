package com.jianfuzengxiao.pub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jianfuzengxiao.base.controller.BaseController;
import com.alibaba.fastjson.JSON;
import java.util.List;
import java.util.ArrayList;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.entity.UserInfoMVO;
import com.jianfuzengxiao.pub.service.IUserInfoService;



@Controller
@RequestMapping(value="/userinfo")
public class UserInfoController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(UserInfoController.class);
	@Autowired
	private IUserInfoService userInfoService;

	@ResponseBody
	@RequestMapping(value="/getUserInfoDetails", method=RequestMethod.POST)
	public String getUserInfoDetails(UserInfoMVO model) {
	    try {
	    	model = userInfoService.queryBean(model);
	    	return JSON.toJSONString(model);
		} catch (Exception e) {
			return callbackException(logger, "获取详情出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getUserInfoList", method=RequestMethod.POST)
	public String getUserInfoList(UserInfoMVO model) {
	    try {
	    	List<UserInfoMVO> list = new ArrayList<>();
	    	list = userInfoService.queryList(model);
	    	return JSON.toJSONString(list);
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getUserInfoPage", method=RequestMethod.POST)
	public String getUserInfoPage(UserInfoMVO model) {
	    try {
	    	PageInfo pageInfo = getPage();
	    	pageInfo = userInfoService.queryPage(model, pageInfo);
	    	return pageInfo.toJSONString();
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/addUserInfo", method=RequestMethod.POST)
	public String addUserInfo(UserInfoMVO model) {
		try {
			userInfoService.insert(model);
			return callback(true, "新增成功");
		} catch (Exception e) {
			return callbackException(logger, "新增出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateUserInfo", method=RequestMethod.POST)
	public String updateUserInfo(UserInfoMVO model) {
		try {
			userInfoService.update(model);
			return callback(true, "修改成功");
		} catch (Exception e) {
			return callbackException(logger, "修改出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateStsUserInfo", method=RequestMethod.POST)
	public String updateStsUserInfo(UserInfoMVO model) {
		try {
			model.setSts("P");
			userInfoService.update(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/deleteUserInfo", method=RequestMethod.POST)
	public String deleteUserInfo(UserInfoMVO model) {
		try {
			userInfoService.delete(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

}

