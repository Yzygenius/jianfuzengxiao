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
import com.jianfuzengxiao.pub.entity.CertificatesTypeMVO;
import com.jianfuzengxiao.pub.service.ICertificatesTypeService;



@Controller
@RequestMapping(value="/certificatestype")
public class CertificatesTypeController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(CertificatesTypeController.class);
	@Autowired
	private ICertificatesTypeService certificatesTypeService;

	@ResponseBody
	@RequestMapping(value="/getCertificatesTypeDetails", method=RequestMethod.POST)
	public String getCertificatesTypeDetails(CertificatesTypeMVO model) {
	    try {
	    	model = certificatesTypeService.queryBean(model);
	    	return JSON.toJSONString(model);
		} catch (Exception e) {
			return callbackException(logger, "获取详情出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getCertificatesTypeList", method=RequestMethod.POST)
	public String getCertificatesTypeList(CertificatesTypeMVO model) {
	    try {
	    	List<CertificatesTypeMVO> list = new ArrayList<>();
	    	list = certificatesTypeService.queryList(model);
	    	return JSON.toJSONString(list);
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/getCertificatesTypePage", method=RequestMethod.POST)
	public String getCertificatesTypePage(CertificatesTypeMVO model) {
	    try {
	    	PageInfo pageInfo = getPage();
	    	pageInfo = certificatesTypeService.queryPage(model, pageInfo);
	    	return pageInfo.toJSONString();
		} catch (Exception e) {
			return callbackException(logger, "获取列表出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/addCertificatesType", method=RequestMethod.POST)
	public String addCertificatesType(CertificatesTypeMVO model) {
		try {
			certificatesTypeService.insert(model);
			return callback(true, "新增成功");
		} catch (Exception e) {
			return callbackException(logger, "新增出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateCertificatesType", method=RequestMethod.POST)
	public String updateCertificatesType(CertificatesTypeMVO model) {
		try {
			certificatesTypeService.update(model);
			return callback(true, "修改成功");
		} catch (Exception e) {
			return callbackException(logger, "修改出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/updateStsCertificatesType", method=RequestMethod.POST)
	public String updateStsCertificatesType(CertificatesTypeMVO model) {
		try {
			model.setSts("P");
			certificatesTypeService.update(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

	@ResponseBody
	@RequestMapping(value="/deleteCertificatesType", method=RequestMethod.POST)
	public String deleteCertificatesType(CertificatesTypeMVO model) {
		try {
			certificatesTypeService.delete(model);
			return callback(true, "删除成功");
		} catch (Exception e) {
			return callbackException(logger, "删除出错", e);
		}
	}

}

