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
import com.jianfuzengxiao.pub.entity.AreaInfoMVO;
import com.jianfuzengxiao.pub.service.IAreaInfoService;



@Controller
@RequestMapping(value="/areainfo")
public class AreaInfoController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(AreaInfoController.class);
	@Autowired
	private IAreaInfoService areaInfoService;

	@ResponseBody
	@RequestMapping(value="/getAreaInfoDetails", method=RequestMethod.POST)
	public String getAreaInfoDetails(AreaInfoMVO model) {
	    try {
	    	model = areaInfoService.queryBean(model);
	    	return JSON.toJSONString(model);
		} catch (Exception e) {
			return callbackException(logger, "获取详情出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getAreaInfoList", method=RequestMethod.POST)
	public String getAreaInfoList(AreaInfoMVO model) {
	    try {
	    	List<AreaInfoMVO> list = new ArrayList<>();
	    	list = areaInfoService.queryList(model);
	    	return JSON.toJSONString(list);
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getAreaInfoPage", method=RequestMethod.POST)
	public String getAreaInfoPage(AreaInfoMVO model) {
	    try {
	    	PageInfo pageInfo = getPage();
	    	pageInfo = areaInfoService.queryPage(model, pageInfo);
	    	return pageInfo.toJSONString();
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/addAreaInfo", method=RequestMethod.POST)
	public String addAreaInfo(AreaInfoMVO model) {
		try {
			areaInfoService.insert(model);
			return callback(true, "新增成功");
		} catch (Exception e) {
			return callbackException(logger, "新增出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateAreaInfo", method=RequestMethod.POST)
	public String updateAreaInfo(AreaInfoMVO model) {
		try {
			areaInfoService.update(model);
			return callback(true, "修改成功");
		} catch (Exception e) {
			return callbackException(logger, "修改出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateStsAreaInfo", method=RequestMethod.POST)
	public String updateStsAreaInfo(AreaInfoMVO model) {
		try {
			model.setSts("P");
			areaInfoService.update(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/deleteAreaInfo", method=RequestMethod.POST)
	public String deleteAreaInfo(AreaInfoMVO model) {
		try {
			areaInfoService.delete(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

}

