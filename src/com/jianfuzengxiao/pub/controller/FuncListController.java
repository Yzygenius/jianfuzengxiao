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
import com.jianfuzengxiao.pub.entity.FuncListMVO;
import com.jianfuzengxiao.pub.service.IFuncListService;

@Controller
@RequestMapping(value = "/funclist")
public class FuncListController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(FuncListController.class);
	@Autowired
	private IFuncListService funcListService;

	@ResponseBody
	@RequestMapping(value = "/getFuncListDetails", method = RequestMethod.POST)
	public String getFuncListDetails(FuncListMVO model) {
		try {
			model = funcListService.queryBean(model);
			return JSON.toJSONString(model);
		} catch (Exception e) {
			return callbackException(logger, "获取详情出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getFuncListList", method = RequestMethod.POST)
	public String getFuncListList(FuncListMVO model) {
		try {
			List<FuncListMVO> list = new ArrayList<>();
			list = funcListService.queryList(model);
			return JSON.toJSONString(list);
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getFuncListPage", method = RequestMethod.POST)
	public String getFuncListPage(FuncListMVO model) {
		try {
			PageInfo pageInfo = getPage();
			pageInfo = funcListService.queryPage(model, pageInfo);
			return pageInfo.toJSONString();
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/addFuncList", method = RequestMethod.POST)
	public String addFuncList(FuncListMVO model) {
		try {
			funcListService.insert(model);
			return callback(true, "新增成功");
		} catch (Exception e) {
			return callbackException(logger, "新增出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/updateFuncList", method = RequestMethod.POST)
	public String updateFuncList(FuncListMVO model) {
		try {
			funcListService.update(model);
			return callback(true, "修改成功");
		} catch (Exception e) {
			return callbackException(logger, "修改出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/updateStsFuncList", method = RequestMethod.POST)
	public String updateStsFuncList(FuncListMVO model) {
		try {
			model.setSts("P");
			funcListService.update(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/deleteFuncList", method = RequestMethod.POST)
	public String deleteFuncList(FuncListMVO model) {
		try {
			funcListService.delete(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

}
