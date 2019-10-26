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
import com.jianfuzengxiao.pub.entity.RoleFuncMVO;
import com.jianfuzengxiao.pub.service.IRoleFuncService;



@Controller
@RequestMapping(value="/rolefunc")
public class RoleFuncController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(RoleFuncController.class);
	@Autowired
	private IRoleFuncService roleFuncService;

	@ResponseBody
	@RequestMapping(value="/getRoleFuncDetails", method=RequestMethod.POST)
	public String getRoleFuncDetails(RoleFuncMVO model) {
	    try {
	    	model = roleFuncService.queryBean(model);
	    	return JSON.toJSONString(model);
		} catch (Exception e) {
			return callbackException(logger, "获取详情出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getRoleFuncList", method=RequestMethod.POST)
	public String getRoleFuncList(RoleFuncMVO model) {
	    try {
	    	List<RoleFuncMVO> list = new ArrayList<>();
	    	list = roleFuncService.queryList(model);
	    	return JSON.toJSONString(list);
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getRoleFuncPage", method=RequestMethod.POST)
	public String getRoleFuncPage(RoleFuncMVO model) {
	    try {
	    	PageInfo pageInfo = getPage();
	    	pageInfo = roleFuncService.queryPage(model, pageInfo);
	    	return pageInfo.toJSONString();
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/addRoleFunc", method=RequestMethod.POST)
	public String addRoleFunc(RoleFuncMVO model) {
		try {
			roleFuncService.insert(model);
			return callback(true, "新增成功");
		} catch (Exception e) {
			return callbackException(logger, "新增出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateRoleFunc", method=RequestMethod.POST)
	public String updateRoleFunc(RoleFuncMVO model) {
		try {
			roleFuncService.update(model);
			return callback(true, "修改成功");
		} catch (Exception e) {
			return callbackException(logger, "修改出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateStsRoleFunc", method=RequestMethod.POST)
	public String updateStsRoleFunc(RoleFuncMVO model) {
		try {
			model.setSts("P");
			roleFuncService.update(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/deleteRoleFunc", method=RequestMethod.POST)
	public String deleteRoleFunc(RoleFuncMVO model) {
		try {
			roleFuncService.delete(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

}

