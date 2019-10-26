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
import com.jianfuzengxiao.pub.entity.AduitDistributionMVO;
import com.jianfuzengxiao.pub.service.IAduitDistributionService;

@Controller
@RequestMapping(value = "/aduitdistribution")
public class AduitDistributionController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(AduitDistributionController.class);
	@Autowired
	private IAduitDistributionService aduitDistributionService;

	@ResponseBody
	@RequestMapping(value = "/getAduitDistributionDetails", method = RequestMethod.POST)
	public String getAduitDistributionDetails(AduitDistributionMVO model) {
		try {
			model = aduitDistributionService.queryBean(model);
			return JSON.toJSONString(model);
		} catch (Exception e) {
			return callbackException(logger, "获取详情出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getAduitDistributionList", method = RequestMethod.POST)
	public String getAduitDistributionList(AduitDistributionMVO model) {
		try {
			List<AduitDistributionMVO> list = new ArrayList<>();
			list = aduitDistributionService.queryList(model);
			return JSON.toJSONString(list);
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getAduitDistributionPage", method = RequestMethod.POST)
	public String getAduitDistributionPage(AduitDistributionMVO model) {
		try {
			PageInfo pageInfo = getPage();
			pageInfo = aduitDistributionService.queryPage(model, pageInfo);
			return pageInfo.toJSONString();
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/addAduitDistribution", method = RequestMethod.POST)
	public String addAduitDistribution(AduitDistributionMVO model) {
		try {
			aduitDistributionService.insert(model);
			return callback(true, "新增成功");
		} catch (Exception e) {
			return callbackException(logger, "新增出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/updateAduitDistribution", method = RequestMethod.POST)
	public String updateAduitDistribution(AduitDistributionMVO model) {
		try {
			aduitDistributionService.update(model);
			return callback(true, "修改成功");
		} catch (Exception e) {
			return callbackException(logger, "修改出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/updateStsAduitDistribution", method = RequestMethod.POST)
	public String updateStsAduitDistribution(AduitDistributionMVO model) {
		try {
			model.setSts("P");
			aduitDistributionService.update(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/deleteAduitDistribution", method = RequestMethod.POST)
	public String deleteAduitDistribution(AduitDistributionMVO model) {
		try {
			aduitDistributionService.delete(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

}
