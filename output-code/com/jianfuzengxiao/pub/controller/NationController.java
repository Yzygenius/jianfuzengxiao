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
import com.jianfuzengxiao.pub.entity.NationMVO;
import com.jianfuzengxiao.pub.service.INationService;



@Controller
@RequestMapping(value="/nation")
public class NationController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(NationController.class);
	@Autowired
	private INationService nationService;

	@ResponseBody
	@RequestMapping(value="/getNationDetails", method=RequestMethod.POST)
	public String getNationDetails(NationMVO model) {
	    try {
	    	model = nationService.queryBean(model);
	    	return JSON.toJSONString(model);
		} catch (Exception e) {
			return callbackException(logger, "获取详情出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getNationList", method=RequestMethod.POST)
	public String getNationList(NationMVO model) {
	    try {
	    	List<NationMVO> list = new ArrayList<>();
	    	list = nationService.queryList(model);
	    	return JSON.toJSONString(list);
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getNationPage", method=RequestMethod.POST)
	public String getNationPage(NationMVO model) {
	    try {
	    	PageInfo pageInfo = getPage();
	    	pageInfo = nationService.queryPage(model, pageInfo);
	    	return pageInfo.toJSONString();
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/addNation", method=RequestMethod.POST)
	public String addNation(NationMVO model) {
		try {
			nationService.insert(model);
			return callback(true, "新增成功");
		} catch (Exception e) {
			return callbackException(logger, "新增出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateNation", method=RequestMethod.POST)
	public String updateNation(NationMVO model) {
		try {
			nationService.update(model);
			return callback(true, "修改成功");
		} catch (Exception e) {
			return callbackException(logger, "修改出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateStsNation", method=RequestMethod.POST)
	public String updateStsNation(NationMVO model) {
		try {
			model.setSts("P");
			nationService.update(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/deleteNation", method=RequestMethod.POST)
	public String deleteNation(NationMVO model) {
		try {
			nationService.delete(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

}

