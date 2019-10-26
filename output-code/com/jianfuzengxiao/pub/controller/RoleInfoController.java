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
import com.jianfuzengxiao.pub.entity.RoleInfoMVO;
import com.jianfuzengxiao.pub.service.IRoleInfoService;



@Controller
@RequestMapping(value="/roleinfo")
public class RoleInfoController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(RoleInfoController.class);
	@Autowired
	private IRoleInfoService roleInfoService;

	@ResponseBody
	@RequestMapping(value="/getRoleInfoDetails", method=RequestMethod.POST)
	public String getRoleInfoDetails(RoleInfoMVO model) {
	    try {
	    	model = roleInfoService.queryBean(model);
	    	return JSON.toJSONString(model);
		} catch (Exception e) {
			return callbackException(logger, "获取详情出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getRoleInfoList", method=RequestMethod.POST)
	public String getRoleInfoList(RoleInfoMVO model) {
	    try {
	    	List<RoleInfoMVO> list = new ArrayList<>();
	    	list = roleInfoService.queryList(model);
	    	return JSON.toJSONString(list);
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getRoleInfoPage", method=RequestMethod.POST)
	public String getRoleInfoPage(RoleInfoMVO model) {
	    try {
	    	PageInfo pageInfo = getPage();
	    	pageInfo = roleInfoService.queryPage(model, pageInfo);
	    	return pageInfo.toJSONString();
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/addRoleInfo", method=RequestMethod.POST)
	public String addRoleInfo(RoleInfoMVO model) {
		try {
			roleInfoService.insert(model);
			return callback(true, "新增成功");
		} catch (Exception e) {
			return callbackException(logger, "新增出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateRoleInfo", method=RequestMethod.POST)
	public String updateRoleInfo(RoleInfoMVO model) {
		try {
			roleInfoService.update(model);
			return callback(true, "修改成功");
		} catch (Exception e) {
			return callbackException(logger, "修改出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateStsRoleInfo", method=RequestMethod.POST)
	public String updateStsRoleInfo(RoleInfoMVO model) {
		try {
			model.setSts("P");
			roleInfoService.update(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/deleteRoleInfo", method=RequestMethod.POST)
	public String deleteRoleInfo(RoleInfoMVO model) {
		try {
			roleInfoService.delete(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

}

