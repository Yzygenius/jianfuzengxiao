package com.jianfuzengxiao.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jianfuzengxiao.base.common.RC;
import com.jianfuzengxiao.base.controller.BaseController;
import com.jianfuzengxiao.pub.entity.CertificatesTypeMVO;
import com.jianfuzengxiao.pub.service.ICertificatesTypeService;

/**
 * 证件类型
 */
@Controller
@RequestMapping(value="/api/certificatesType")
public class CertificatesTypeAPIController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(CertificatesTypeAPIController.class);
	
	@Autowired
	private ICertificatesTypeService certificatesTypeService;
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 证件类型列表
	 * </p>
	 * @return    
	   certificatesTypeId , certificatesTypeName 名称
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月28日 上午10:49:06
	 */
	@ResponseBody
	@RequestMapping(value="/getCertificatesTypeList")
	public String getCertificatesTypeList(){
		try {
			List<CertificatesTypeMVO> list = certificatesTypeService.queryList(new CertificatesTypeMVO());
			return apiResult(RC.SUCCESS, list);
		} catch (Exception e) {
			return exceptionResult(logger, "查询证件类型失败", e);
		}
	}
	
}
