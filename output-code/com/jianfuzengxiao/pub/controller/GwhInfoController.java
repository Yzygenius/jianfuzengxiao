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
import com.jianfuzengxiao.pub.entity.GwhInfoMVO;
import com.jianfuzengxiao.pub.service.IGwhInfoService;



@Controller
@RequestMapping(value="/gwhinfo")
public class GwhInfoController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(GwhInfoController.class);
	@Autowired
	private IGwhInfoService gwhInfoService;

	@ResponseBody
	@RequestMapping(value="/getGwhInfoDetails", method=RequestMethod.POST)
	public String getGwhInfoDetails(GwhInfoMVO model) {
	    try {
	    	model = gwhInfoService.queryBean(model);
	    	return JSON.toJSONString(model);
		} catch (Exception e) {
			return callbackException(logger, "获取详情出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getGwhInfoList", method=RequestMethod.POST)
	public String getGwhInfoList(GwhInfoMVO model) {
	    try {
	    	List<GwhInfoMVO> list = new ArrayList<>();
	    	list = gwhInfoService.queryList(model);
	    	return JSON.toJSONString(list);
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getGwhInfoPage", method=RequestMethod.POST)
	public String getGwhInfoPage(GwhInfoMVO model) {
	    try {
	    	PageInfo pageInfo = getPage();
	    	pageInfo = gwhInfoService.queryPage(model, pageInfo);
	    	return pageInfo.toJSONString();
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/addGwhInfo", method=RequestMethod.POST)
	public String addGwhInfo(GwhInfoMVO model) {
		try {
			gwhInfoService.insert(model);
			return callback(true, "新增成功");
		} catch (Exception e) {
			return callbackException(logger, "新增出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateGwhInfo", method=RequestMethod.POST)
	public String updateGwhInfo(GwhInfoMVO model) {
		try {
			gwhInfoService.update(model);
			return callback(true, "修改成功");
		} catch (Exception e) {
			return callbackException(logger, "修改出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateStsGwhInfo", method=RequestMethod.POST)
	public String updateStsGwhInfo(GwhInfoMVO model) {
		try {
			model.setSts("P");
			gwhInfoService.update(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/deleteGwhInfo", method=RequestMethod.POST)
	public String deleteGwhInfo(GwhInfoMVO model) {
		try {
			gwhInfoService.delete(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

}

