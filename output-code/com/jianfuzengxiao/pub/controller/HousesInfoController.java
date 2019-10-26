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
import com.jianfuzengxiao.pub.entity.HousesInfoMVO;
import com.jianfuzengxiao.pub.service.IHousesInfoService;



@Controller
@RequestMapping(value="/housesinfo")
public class HousesInfoController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(HousesInfoController.class);
	@Autowired
	private IHousesInfoService housesInfoService;

	@ResponseBody
	@RequestMapping(value="/getHousesInfoDetails", method=RequestMethod.POST)
	public String getHousesInfoDetails(HousesInfoMVO model) {
	    try {
	    	model = housesInfoService.queryBean(model);
	    	return JSON.toJSONString(model);
		} catch (Exception e) {
			return callbackException(logger, "获取详情出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getHousesInfoList", method=RequestMethod.POST)
	public String getHousesInfoList(HousesInfoMVO model) {
	    try {
	    	List<HousesInfoMVO> list = new ArrayList<>();
	    	list = housesInfoService.queryList(model);
	    	return JSON.toJSONString(list);
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getHousesInfoPage", method=RequestMethod.POST)
	public String getHousesInfoPage(HousesInfoMVO model) {
	    try {
	    	PageInfo pageInfo = getPage();
	    	pageInfo = housesInfoService.queryPage(model, pageInfo);
	    	return pageInfo.toJSONString();
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/addHousesInfo", method=RequestMethod.POST)
	public String addHousesInfo(HousesInfoMVO model) {
		try {
			housesInfoService.insert(model);
			return callback(true, "新增成功");
		} catch (Exception e) {
			return callbackException(logger, "新增出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateHousesInfo", method=RequestMethod.POST)
	public String updateHousesInfo(HousesInfoMVO model) {
		try {
			housesInfoService.update(model);
			return callback(true, "修改成功");
		} catch (Exception e) {
			return callbackException(logger, "修改出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateStsHousesInfo", method=RequestMethod.POST)
	public String updateStsHousesInfo(HousesInfoMVO model) {
		try {
			model.setSts("P");
			housesInfoService.update(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/deleteHousesInfo", method=RequestMethod.POST)
	public String deleteHousesInfo(HousesInfoMVO model) {
		try {
			housesInfoService.delete(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

}

