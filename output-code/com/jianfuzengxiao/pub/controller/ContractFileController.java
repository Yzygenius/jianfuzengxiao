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
import com.jianfuzengxiao.pub.entity.ContractFileMVO;
import com.jianfuzengxiao.pub.service.IContractFileService;



@Controller
@RequestMapping(value="/contractfile")
public class ContractFileController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(ContractFileController.class);
	@Autowired
	private IContractFileService contractFileService;

	@ResponseBody
	@RequestMapping(value="/getContractFileDetails", method=RequestMethod.POST)
	public String getContractFileDetails(ContractFileMVO model) {
	    try {
	    	model = contractFileService.queryBean(model);
	    	return JSON.toJSONString(model);
		} catch (Exception e) {
			return callbackException(logger, "获取详情出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getContractFileList", method=RequestMethod.POST)
	public String getContractFileList(ContractFileMVO model) {
	    try {
	    	List<ContractFileMVO> list = new ArrayList<>();
	    	list = contractFileService.queryList(model);
	    	return JSON.toJSONString(list);
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getContractFilePage", method=RequestMethod.POST)
	public String getContractFilePage(ContractFileMVO model) {
	    try {
	    	PageInfo pageInfo = getPage();
	    	pageInfo = contractFileService.queryPage(model, pageInfo);
	    	return pageInfo.toJSONString();
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/addContractFile", method=RequestMethod.POST)
	public String addContractFile(ContractFileMVO model) {
		try {
			contractFileService.insert(model);
			return callback(true, "新增成功");
		} catch (Exception e) {
			return callbackException(logger, "新增出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateContractFile", method=RequestMethod.POST)
	public String updateContractFile(ContractFileMVO model) {
		try {
			contractFileService.update(model);
			return callback(true, "修改成功");
		} catch (Exception e) {
			return callbackException(logger, "修改出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateStsContractFile", method=RequestMethod.POST)
	public String updateStsContractFile(ContractFileMVO model) {
		try {
			model.setSts("P");
			contractFileService.update(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/deleteContractFile", method=RequestMethod.POST)
	public String deleteContractFile(ContractFileMVO model) {
		try {
			contractFileService.delete(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

}

