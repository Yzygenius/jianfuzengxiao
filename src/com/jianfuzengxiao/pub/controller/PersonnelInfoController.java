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
import com.jianfuzengxiao.pub.entity.PersonnelInfoMVO;
import com.jianfuzengxiao.pub.service.IPersonnelInfoService;

@Controller
@RequestMapping(value = "/personnelinfo")
public class PersonnelInfoController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(PersonnelInfoController.class);
	@Autowired
	private IPersonnelInfoService personnelInfoService;

	@ResponseBody
	@RequestMapping(value = "/getPersonnelInfoDetails", method = RequestMethod.POST)
	public String getPersonnelInfoDetails(PersonnelInfoMVO model) {
		try {
			model = personnelInfoService.queryBean(model);
			return JSON.toJSONString(model);
		} catch (Exception e) {
			return callbackException(logger, "获取详情出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getPersonnelInfoList", method = RequestMethod.POST)
	public String getPersonnelInfoList(PersonnelInfoMVO model) {
		try {
			List<PersonnelInfoMVO> list = new ArrayList<>();
			list = personnelInfoService.queryList(model);
			return JSON.toJSONString(list);
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getPersonnelInfoPage", method = RequestMethod.POST)
	public String getPersonnelInfoPage(PersonnelInfoMVO model) {
		try {
			PageInfo pageInfo = getPage();
			pageInfo = personnelInfoService.queryPage(model, pageInfo);
			return pageInfo.toJSONString();
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/addPersonnelInfo", method = RequestMethod.POST)
	public String addPersonnelInfo(PersonnelInfoMVO model) {
		try {
			personnelInfoService.insert(model);
			return callback(true, "新增成功");
		} catch (Exception e) {
			return callbackException(logger, "新增出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/updatePersonnelInfo", method = RequestMethod.POST)
	public String updatePersonnelInfo(PersonnelInfoMVO model) {
		try {
			personnelInfoService.update(model);
			return callback(true, "修改成功");
		} catch (Exception e) {
			return callbackException(logger, "修改出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/updateStsPersonnelInfo", method = RequestMethod.POST)
	public String updateStsPersonnelInfo(PersonnelInfoMVO model) {
		try {
			model.setSts("P");
			personnelInfoService.update(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/deletePersonnelInfo", method = RequestMethod.POST)
	public String deletePersonnelInfo(PersonnelInfoMVO model) {
		try {
			personnelInfoService.delete(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

}
