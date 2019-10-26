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
import com.jianfuzengxiao.pub.entity.AttachFileMVO;
import com.jianfuzengxiao.pub.service.IAttachFileService;



@Controller
@RequestMapping(value="/attachfile")
public class AttachFileController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(AttachFileController.class);
	@Autowired
	private IAttachFileService attachFileService;

	@ResponseBody
	@RequestMapping(value="/getAttachFileDetails", method=RequestMethod.POST)
	public String getAttachFileDetails(AttachFileMVO model) {
	    try {
	    	model = attachFileService.queryBean(model);
	    	return JSON.toJSONString(model);
		} catch (Exception e) {
			return callbackException(logger, "获取详情出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getAttachFileList", method=RequestMethod.POST)
	public String getAttachFileList(AttachFileMVO model) {
	    try {
	    	List<AttachFileMVO> list = new ArrayList<>();
	    	list = attachFileService.queryList(model);
	    	return JSON.toJSONString(list);
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getAttachFilePage", method=RequestMethod.POST)
	public String getAttachFilePage(AttachFileMVO model) {
	    try {
	    	PageInfo pageInfo = getPage();
	    	pageInfo = attachFileService.queryPage(model, pageInfo);
	    	return pageInfo.toJSONString();
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/addAttachFile", method=RequestMethod.POST)
	public String addAttachFile(AttachFileMVO model) {
		try {
			attachFileService.insert(model);
			return callback(true, "新增成功");
		} catch (Exception e) {
			return callbackException(logger, "新增出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateAttachFile", method=RequestMethod.POST)
	public String updateAttachFile(AttachFileMVO model) {
		try {
			attachFileService.update(model);
			return callback(true, "修改成功");
		} catch (Exception e) {
			return callbackException(logger, "修改出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateStsAttachFile", method=RequestMethod.POST)
	public String updateStsAttachFile(AttachFileMVO model) {
		try {
			model.setSts("P");
			attachFileService.update(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/deleteAttachFile", method=RequestMethod.POST)
	public String deleteAttachFile(AttachFileMVO model) {
		try {
			attachFileService.delete(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

}

