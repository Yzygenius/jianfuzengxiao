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
import com.jianfuzengxiao.pub.entity.LiveTypeMVO;
import com.jianfuzengxiao.pub.service.ILiveTypeService;

@Controller
@RequestMapping(value = "/livetype")
public class LiveTypeController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(LiveTypeController.class);
	@Autowired
	private ILiveTypeService liveTypeService;

	@ResponseBody
	@RequestMapping(value = "/getLiveTypeDetails", method = RequestMethod.POST)
	public String getLiveTypeDetails(LiveTypeMVO model) {
		try {
			model = liveTypeService.queryBean(model);
			return JSON.toJSONString(model);
		} catch (Exception e) {
			return callbackException(logger, "获取详情出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getLiveTypeList", method = RequestMethod.POST)
	public String getLiveTypeList(LiveTypeMVO model) {
		try {
			List<LiveTypeMVO> list = new ArrayList<>();
			list = liveTypeService.queryList(model);
			return JSON.toJSONString(list);
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getLiveTypePage", method = RequestMethod.POST)
	public String getLiveTypePage(LiveTypeMVO model) {
		try {
			PageInfo pageInfo = getPage();
			pageInfo = liveTypeService.queryPage(model, pageInfo);
			return pageInfo.toJSONString();
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/addLiveType", method = RequestMethod.POST)
	public String addLiveType(LiveTypeMVO model) {
		try {
			liveTypeService.insert(model);
			return callback(true, "新增成功");
		} catch (Exception e) {
			return callbackException(logger, "新增出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/updateLiveType", method = RequestMethod.POST)
	public String updateLiveType(LiveTypeMVO model) {
		try {
			liveTypeService.update(model);
			return callback(true, "修改成功");
		} catch (Exception e) {
			return callbackException(logger, "修改出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/updateStsLiveType", method = RequestMethod.POST)
	public String updateStsLiveType(LiveTypeMVO model) {
		try {
			model.setSts("P");
			liveTypeService.update(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/deleteLiveType", method = RequestMethod.POST)
	public String deleteLiveType(LiveTypeMVO model) {
		try {
			liveTypeService.delete(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

}
