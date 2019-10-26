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
import com.jianfuzengxiao.pub.entity.UserRoleMVO;
import com.jianfuzengxiao.pub.service.IUserRoleService;



@Controller
@RequestMapping(value="/userrole")
public class UserRoleController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(UserRoleController.class);
	@Autowired
	private IUserRoleService userRoleService;

	@ResponseBody
	@RequestMapping(value="/getUserRoleDetails", method=RequestMethod.POST)
	public String getUserRoleDetails(UserRoleMVO model) {
	    try {
	    	model = userRoleService.queryBean(model);
	    	return JSON.toJSONString(model);
		} catch (Exception e) {
			return callbackException(logger, "获取详情出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getUserRoleList", method=RequestMethod.POST)
	public String getUserRoleList(UserRoleMVO model) {
	    try {
	    	List<UserRoleMVO> list = new ArrayList<>();
	    	list = userRoleService.queryList(model);
	    	return JSON.toJSONString(list);
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getUserRolePage", method=RequestMethod.POST)
	public String getUserRolePage(UserRoleMVO model) {
	    try {
	    	PageInfo pageInfo = getPage();
	    	pageInfo = userRoleService.queryPage(model, pageInfo);
	    	return pageInfo.toJSONString();
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/addUserRole", method=RequestMethod.POST)
	public String addUserRole(UserRoleMVO model) {
		try {
			userRoleService.insert(model);
			return callback(true, "新增成功");
		} catch (Exception e) {
			return callbackException(logger, "新增出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateUserRole", method=RequestMethod.POST)
	public String updateUserRole(UserRoleMVO model) {
		try {
			userRoleService.update(model);
			return callback(true, "修改成功");
		} catch (Exception e) {
			return callbackException(logger, "修改出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateStsUserRole", method=RequestMethod.POST)
	public String updateStsUserRole(UserRoleMVO model) {
		try {
			model.setSts("P");
			userRoleService.update(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/deleteUserRole", method=RequestMethod.POST)
	public String deleteUserRole(UserRoleMVO model) {
		try {
			userRoleService.delete(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

}

