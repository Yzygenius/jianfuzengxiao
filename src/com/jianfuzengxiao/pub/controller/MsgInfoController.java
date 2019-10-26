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
import com.jianfuzengxiao.pub.entity.MsgInfoMVO;
import com.jianfuzengxiao.pub.service.IMsgInfoService;

@Controller
@RequestMapping(value = "/msginfo")
public class MsgInfoController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(MsgInfoController.class);
	@Autowired
	private IMsgInfoService msgInfoService;

	@ResponseBody
	@RequestMapping(value = "/getMsgInfoDetails", method = RequestMethod.POST)
	public String getMsgInfoDetails(MsgInfoMVO model) {
		try {
			model = msgInfoService.queryBean(model);
			return JSON.toJSONString(model);
		} catch (Exception e) {
			return callbackException(logger, "获取详情出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getMsgInfoList", method = RequestMethod.POST)
	public String getMsgInfoList(MsgInfoMVO model) {
		try {
			List<MsgInfoMVO> list = new ArrayList<>();
			list = msgInfoService.queryList(model);
			return JSON.toJSONString(list);
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getMsgInfoPage", method = RequestMethod.POST)
	public String getMsgInfoPage(MsgInfoMVO model) {
		try {
			PageInfo pageInfo = getPage();
			pageInfo = msgInfoService.queryPage(model, pageInfo);
			return pageInfo.toJSONString();
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/addMsgInfo", method = RequestMethod.POST)
	public String addMsgInfo(MsgInfoMVO model) {
		try {
			msgInfoService.insert(model);
			return callback(true, "新增成功");
		} catch (Exception e) {
			return callbackException(logger, "新增出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/updateMsgInfo", method = RequestMethod.POST)
	public String updateMsgInfo(MsgInfoMVO model) {
		try {
			msgInfoService.update(model);
			return callback(true, "修改成功");
		} catch (Exception e) {
			return callbackException(logger, "修改出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/updateStsMsgInfo", method = RequestMethod.POST)
	public String updateStsMsgInfo(MsgInfoMVO model) {
		try {
			model.setSts("P");
			msgInfoService.update(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/deleteMsgInfo", method = RequestMethod.POST)
	public String deleteMsgInfo(MsgInfoMVO model) {
		try {
			msgInfoService.delete(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

}
