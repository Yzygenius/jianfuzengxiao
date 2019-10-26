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
import com.jianfuzengxiao.pub.entity.CommunityStreetInfoMVO;
import com.jianfuzengxiao.pub.service.ICommunityStreetInfoService;

@Controller
@RequestMapping(value = "/communitystreetinfo")
public class CommunityStreetInfoController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(CommunityStreetInfoController.class);
	@Autowired
	private ICommunityStreetInfoService communityStreetInfoService;

	@ResponseBody
	@RequestMapping(value = "/getCommunityStreetInfoDetails", method = RequestMethod.POST)
	public String getCommunityStreetInfoDetails(CommunityStreetInfoMVO model) {
		try {
			model = communityStreetInfoService.queryBean(model);
			return JSON.toJSONString(model);
		} catch (Exception e) {
			return callbackException(logger, "获取详情出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getCommunityStreetInfoList", method = RequestMethod.POST)
	public String getCommunityStreetInfoList(CommunityStreetInfoMVO model) {
		try {
			List<CommunityStreetInfoMVO> list = new ArrayList<>();
			list = communityStreetInfoService.queryList(model);
			return JSON.toJSONString(list);
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getCommunityStreetInfoPage", method = RequestMethod.POST)
	public String getCommunityStreetInfoPage(CommunityStreetInfoMVO model) {
		try {
			PageInfo pageInfo = getPage();
			pageInfo = communityStreetInfoService.queryPage(model, pageInfo);
			return pageInfo.toJSONString();
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/addCommunityStreetInfo", method = RequestMethod.POST)
	public String addCommunityStreetInfo(CommunityStreetInfoMVO model) {
		try {
			communityStreetInfoService.insert(model);
			return callback(true, "新增成功");
		} catch (Exception e) {
			return callbackException(logger, "新增出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/updateCommunityStreetInfo", method = RequestMethod.POST)
	public String updateCommunityStreetInfo(CommunityStreetInfoMVO model) {
		try {
			communityStreetInfoService.update(model);
			return callback(true, "修改成功");
		} catch (Exception e) {
			return callbackException(logger, "修改出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/updateStsCommunityStreetInfo", method = RequestMethod.POST)
	public String updateStsCommunityStreetInfo(CommunityStreetInfoMVO model) {
		try {
			model.setSts("P");
			communityStreetInfoService.update(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/deleteCommunityStreetInfo", method = RequestMethod.POST)
	public String deleteCommunityStreetInfo(CommunityStreetInfoMVO model) {
		try {
			communityStreetInfoService.delete(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

}
