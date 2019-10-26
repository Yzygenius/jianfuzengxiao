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
import com.jianfuzengxiao.pub.entity.CommunityInfoMVO;
import com.jianfuzengxiao.pub.service.ICommunityInfoService;



@Controller
@RequestMapping(value="/communityinfo")
public class CommunityInfoController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(CommunityInfoController.class);
	@Autowired
	private ICommunityInfoService communityInfoService;

	@ResponseBody
	@RequestMapping(value="/getCommunityInfoDetails", method=RequestMethod.POST)
	public String getCommunityInfoDetails(CommunityInfoMVO model) {
	    try {
	    	model = communityInfoService.queryBean(model);
	    	return JSON.toJSONString(model);
		} catch (Exception e) {
			return callbackException(logger, "获取详情出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getCommunityInfoList", method=RequestMethod.POST)
	public String getCommunityInfoList(CommunityInfoMVO model) {
	    try {
	    	List<CommunityInfoMVO> list = new ArrayList<>();
	    	list = communityInfoService.queryList(model);
	    	return JSON.toJSONString(list);
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getCommunityInfoPage", method=RequestMethod.POST)
	public String getCommunityInfoPage(CommunityInfoMVO model) {
	    try {
	    	PageInfo pageInfo = getPage();
	    	pageInfo = communityInfoService.queryPage(model, pageInfo);
	    	return pageInfo.toJSONString();
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/addCommunityInfo", method=RequestMethod.POST)
	public String addCommunityInfo(CommunityInfoMVO model) {
		try {
			communityInfoService.insert(model);
			return callback(true, "新增成功");
		} catch (Exception e) {
			return callbackException(logger, "新增出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateCommunityInfo", method=RequestMethod.POST)
	public String updateCommunityInfo(CommunityInfoMVO model) {
		try {
			communityInfoService.update(model);
			return callback(true, "修改成功");
		} catch (Exception e) {
			return callbackException(logger, "修改出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateStsCommunityInfo", method=RequestMethod.POST)
	public String updateStsCommunityInfo(CommunityInfoMVO model) {
		try {
			model.setSts("P");
			communityInfoService.update(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/deleteCommunityInfo", method=RequestMethod.POST)
	public String deleteCommunityInfo(CommunityInfoMVO model) {
		try {
			communityInfoService.delete(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

}

