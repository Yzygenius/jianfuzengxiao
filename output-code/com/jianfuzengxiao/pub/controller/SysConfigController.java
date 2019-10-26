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
import com.jianfuzengxiao.pub.entity.SysConfigMVO;
import com.jianfuzengxiao.pub.service.ISysConfigService;



@Controller
@RequestMapping(value="/sysconfig")
public class SysConfigController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(SysConfigController.class);
	@Autowired
	private ISysConfigService sysConfigService;

	@ResponseBody
	@RequestMapping(value="/getSysConfigDetails", method=RequestMethod.POST)
	public String getSysConfigDetails(SysConfigMVO model) {
	    try {
	    	model = sysConfigService.queryBean(model);
	    	return JSON.toJSONString(model);
		} catch (Exception e) {
			return callbackException(logger, "获取详情出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getSysConfigList", method=RequestMethod.POST)
	public String getSysConfigList(SysConfigMVO model) {
	    try {
	    	List<SysConfigMVO> list = new ArrayList<>();
	    	list = sysConfigService.queryList(model);
	    	return JSON.toJSONString(list);
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getSysConfigPage", method=RequestMethod.POST)
	public String getSysConfigPage(SysConfigMVO model) {
	    try {
	    	PageInfo pageInfo = getPage();
	    	pageInfo = sysConfigService.queryPage(model, pageInfo);
	    	return pageInfo.toJSONString();
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/addSysConfig", method=RequestMethod.POST)
	public String addSysConfig(SysConfigMVO model) {
		try {
			sysConfigService.insert(model);
			return callback(true, "新增成功");
		} catch (Exception e) {
			return callbackException(logger, "新增出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateSysConfig", method=RequestMethod.POST)
	public String updateSysConfig(SysConfigMVO model) {
		try {
			sysConfigService.update(model);
			return callback(true, "修改成功");
		} catch (Exception e) {
			return callbackException(logger, "修改出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateStsSysConfig", method=RequestMethod.POST)
	public String updateStsSysConfig(SysConfigMVO model) {
		try {
			model.setSts("P");
			sysConfigService.update(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/deleteSysConfig", method=RequestMethod.POST)
	public String deleteSysConfig(SysConfigMVO model) {
		try {
			sysConfigService.delete(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

}

