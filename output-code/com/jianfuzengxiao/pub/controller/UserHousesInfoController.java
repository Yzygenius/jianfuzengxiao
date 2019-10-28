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
import com.jianfuzengxiao.pub.entity.UserHousesInfoMVO;
import com.jianfuzengxiao.pub.service.IUserHousesInfoService;



@Controller
@RequestMapping(value="/userhousesinfo")
public class UserHousesInfoController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(UserHousesInfoController.class);
	@Autowired
	private IUserHousesInfoService userHousesInfoService;

	@ResponseBody
	@RequestMapping(value="/getUserHousesInfoDetails", method=RequestMethod.POST)
	public String getUserHousesInfoDetails(UserHousesInfoMVO model) {
	    try {
	    	model = userHousesInfoService.queryBean(model);
	    	return JSON.toJSONString(model);
		} catch (Exception e) {
			return callbackException(logger, "获取详情出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getUserHousesInfoList", method=RequestMethod.POST)
	public String getUserHousesInfoList(UserHousesInfoMVO model) {
	    try {
	    	List<UserHousesInfoMVO> list = new ArrayList<>();
	    	list = userHousesInfoService.queryList(model);
	    	return JSON.toJSONString(list);
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getUserHousesInfoPage", method=RequestMethod.POST)
	public String getUserHousesInfoPage(UserHousesInfoMVO model) {
	    try {
	    	PageInfo pageInfo = getPage();
	    	pageInfo = userHousesInfoService.queryPage(model, pageInfo);
	    	return pageInfo.toJSONString();
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/addUserHousesInfo", method=RequestMethod.POST)
	public String addUserHousesInfo(UserHousesInfoMVO model) {
		try {
			userHousesInfoService.insert(model);
			return callback(true, "新增成功");
		} catch (Exception e) {
			return callbackException(logger, "新增出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateUserHousesInfo", method=RequestMethod.POST)
	public String updateUserHousesInfo(UserHousesInfoMVO model) {
		try {
			userHousesInfoService.update(model);
			return callback(true, "修改成功");
		} catch (Exception e) {
			return callbackException(logger, "修改出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateStsUserHousesInfo", method=RequestMethod.POST)
	public String updateStsUserHousesInfo(UserHousesInfoMVO model) {
		try {
			model.setSts("P");
			userHousesInfoService.update(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/deleteUserHousesInfo", method=RequestMethod.POST)
	public String deleteUserHousesInfo(UserHousesInfoMVO model) {
		try {
			userHousesInfoService.delete(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

}

