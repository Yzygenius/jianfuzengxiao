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
import com.jianfuzengxiao.pub.entity.MsgTypeMVO;
import com.jianfuzengxiao.pub.service.IMsgTypeService;

@Controller
@RequestMapping(value = "/msgtype")
public class MsgTypeController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(MsgTypeController.class);
	@Autowired
	private IMsgTypeService msgTypeService;

	@ResponseBody
	@RequestMapping(value = "/getMsgTypeDetails", method = RequestMethod.POST)
	public String getMsgTypeDetails(MsgTypeMVO model) {
		try {
			model = msgTypeService.queryBean(model);
			return JSON.toJSONString(model);
		} catch (Exception e) {
			return callbackException(logger, "获取详情出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getMsgTypeList", method = RequestMethod.POST)
	public String getMsgTypeList(MsgTypeMVO model) {
		try {
			List<MsgTypeMVO> list = new ArrayList<>();
			list = msgTypeService.queryList(model);
			return JSON.toJSONString(list);
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getMsgTypePage", method = RequestMethod.POST)
	public String getMsgTypePage(MsgTypeMVO model) {
		try {
			PageInfo pageInfo = getPage();
			pageInfo = msgTypeService.queryPage(model, pageInfo);
			return pageInfo.toJSONString();
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/addMsgType", method = RequestMethod.POST)
	public String addMsgType(MsgTypeMVO model) {
		try {
			msgTypeService.insert(model);
			return callback(true, "新增成功");
		} catch (Exception e) {
			return callbackException(logger, "新增出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/updateMsgType", method = RequestMethod.POST)
	public String updateMsgType(MsgTypeMVO model) {
		try {
			msgTypeService.update(model);
			return callback(true, "修改成功");
		} catch (Exception e) {
			return callbackException(logger, "修改出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/updateStsMsgType", method = RequestMethod.POST)
	public String updateStsMsgType(MsgTypeMVO model) {
		try {
			model.setSts("P");
			msgTypeService.update(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/deleteMsgType", method = RequestMethod.POST)
	public String deleteMsgType(MsgTypeMVO model) {
		try {
			msgTypeService.delete(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

}
