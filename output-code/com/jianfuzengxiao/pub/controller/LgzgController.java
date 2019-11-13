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
import com.jianfuzengxiao.pub.entity.LgzgMVO;
import com.jianfuzengxiao.pub.service.ILgzgService;



@Controller
@RequestMapping(value="/lgzg")
public class LgzgController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(LgzgController.class);
	@Autowired
	private ILgzgService lgzgService;

	@ResponseBody
	@RequestMapping(value="/getLgzgDetails", method=RequestMethod.POST)
	public String getLgzgDetails(LgzgMVO model) {
	    try {
	    	model = lgzgService.queryBean(model);
	    	return JSON.toJSONString(model);
		} catch (Exception e) {
			return callbackException(logger, "获取详情出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getLgzgList", method=RequestMethod.POST)
	public String getLgzgList(LgzgMVO model) {
	    try {
	    	List<LgzgMVO> list = new ArrayList<>();
	    	list = lgzgService.queryList(model);
	    	return JSON.toJSONString(list);
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getLgzgPage", method=RequestMethod.POST)
	public String getLgzgPage(LgzgMVO model) {
	    try {
	    	PageInfo pageInfo = getPage();
	    	pageInfo = lgzgService.queryPage(model, pageInfo);
	    	return pageInfo.toJSONString();
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/addLgzg", method=RequestMethod.POST)
	public String addLgzg(LgzgMVO model) {
		try {
			lgzgService.insert(model);
			return callback(true, "新增成功");
		} catch (Exception e) {
			return callbackException(logger, "新增出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateLgzg", method=RequestMethod.POST)
	public String updateLgzg(LgzgMVO model) {
		try {
			lgzgService.update(model);
			return callback(true, "修改成功");
		} catch (Exception e) {
			return callbackException(logger, "修改出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateStsLgzg", method=RequestMethod.POST)
	public String updateStsLgzg(LgzgMVO model) {
		try {
			model.setSts("P");
			lgzgService.update(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/deleteLgzg", method=RequestMethod.POST)
	public String deleteLgzg(LgzgMVO model) {
		try {
			lgzgService.delete(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

}

