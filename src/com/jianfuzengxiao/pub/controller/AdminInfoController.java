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
import com.jianfuzengxiao.pub.entity.AdminInfoMVO;
import com.jianfuzengxiao.pub.service.IAdminInfoService;

@Controller
@RequestMapping(value = "/admininfo")
public class AdminInfoController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(AdminInfoController.class);
	@Autowired
	private IAdminInfoService adminInfoService;

	@ResponseBody
	@RequestMapping(value = "/getAdminInfoDetails", method = RequestMethod.POST)
	public String getAdminInfoDetails(AdminInfoMVO model) {
		try {
			model = adminInfoService.queryBean(model);
			return JSON.toJSONString(model);
		} catch (Exception e) {
			return callbackException(logger, "获取详情出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getAdminInfoList", method = RequestMethod.POST)
	public String getAdminInfoList(AdminInfoMVO model) {
		try {
			List<AdminInfoMVO> list = new ArrayList<>();
			list = adminInfoService.queryList(model);
			return JSON.toJSONString(list);
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getAdminInfoPage", method = RequestMethod.POST)
	public String getAdminInfoPage(AdminInfoMVO model) {
		try {
			PageInfo pageInfo = getPage();
			pageInfo = adminInfoService.queryPage(model, pageInfo);
			return pageInfo.toJSONString();
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/addAdminInfo", method = RequestMethod.POST)
	public String addAdminInfo(AdminInfoMVO model) {
		try {
			adminInfoService.insert(model);
			return callback(true, "新增成功");
		} catch (Exception e) {
			return callbackException(logger, "新增出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/updateAdminInfo", method = RequestMethod.POST)
	public String updateAdminInfo(AdminInfoMVO model) {
		try {
			adminInfoService.update(model);
			return callback(true, "修改成功");
		} catch (Exception e) {
			return callbackException(logger, "修改出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/updateStsAdminInfo", method = RequestMethod.POST)
	public String updateStsAdminInfo(AdminInfoMVO model) {
		try {
			model.setSts("P");
			adminInfoService.update(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/deleteAdminInfo", method = RequestMethod.POST)
	public String deleteAdminInfo(AdminInfoMVO model) {
		try {
			adminInfoService.delete(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

}
