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
import com.jianfuzengxiao.pub.entity.HousesTypeMVO;
import com.jianfuzengxiao.pub.service.IHousesTypeService;

@Controller
@RequestMapping(value = "/housestype")
public class HousesTypeController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(HousesTypeController.class);
	@Autowired
	private IHousesTypeService housesTypeService;

	@ResponseBody
	@RequestMapping(value = "/getHousesTypeDetails", method = RequestMethod.POST)
	public String getHousesTypeDetails(HousesTypeMVO model) {
		try {
			model = housesTypeService.queryBean(model);
			return JSON.toJSONString(model);
		} catch (Exception e) {
			return callbackException(logger, "获取详情出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getHousesTypeList", method = RequestMethod.POST)
	public String getHousesTypeList(HousesTypeMVO model) {
		try {
			List<HousesTypeMVO> list = new ArrayList<>();
			list = housesTypeService.queryList(model);
			return JSON.toJSONString(list);
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getHousesTypePage", method = RequestMethod.POST)
	public String getHousesTypePage(HousesTypeMVO model) {
		try {
			PageInfo pageInfo = getPage();
			pageInfo = housesTypeService.queryPage(model, pageInfo);
			return pageInfo.toJSONString();
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/addHousesType", method = RequestMethod.POST)
	public String addHousesType(HousesTypeMVO model) {
		try {
			housesTypeService.insert(model);
			return callback(true, "新增成功");
		} catch (Exception e) {
			return callbackException(logger, "新增出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/updateHousesType", method = RequestMethod.POST)
	public String updateHousesType(HousesTypeMVO model) {
		try {
			housesTypeService.update(model);
			return callback(true, "修改成功");
		} catch (Exception e) {
			return callbackException(logger, "修改出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/updateStsHousesType", method = RequestMethod.POST)
	public String updateStsHousesType(HousesTypeMVO model) {
		try {
			model.setSts("P");
			housesTypeService.update(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/deleteHousesType", method = RequestMethod.POST)
	public String deleteHousesType(HousesTypeMVO model) {
		try {
			housesTypeService.delete(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

}
