package com.jianfuzengxiao.api.controller;

import static com.jianfuzengxiao.base.utils.ApiUtil.throwAppException;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.base.common.RC;
import com.jianfuzengxiao.base.controller.BaseController;
import com.jianfuzengxiao.pub.entity.MsgInfo;
import com.jianfuzengxiao.pub.entity.MsgInfoMVO;
import com.jianfuzengxiao.pub.service.IMsgInfoService;
import static com.jianfuzengxiao.base.utils.ApiUtil.throwAppException;

@Controller
@RequestMapping(value="/api/msgInfo")
public class MsgInfoAPIController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(MsgInfoAPIController.class);
	
	@Autowired
	private IMsgInfoService msgInfoService;
	
	@ResponseBody
	@RequestMapping(value="/getMsgInfoPage")
	public String getMsgInfoPage(MsgInfoMVO entity){
		try {
			PageInfo pageInfo = getPage();
			pageInfo.setSortName("createTime");
			pageInfo.setSortOrder("desc");
			entity.setSts("A");
			pageInfo = msgInfoService.queryPage(entity, pageInfo);
			return apiResult(RC.SUCCESS, pageInfo);
		} catch (Exception e) {
			return exceptionResult(logger, "获取消息列表错误", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/getMsgDetail")
	public String getMsgDetail(MsgInfoMVO entity){
		try {
			entity = msgInfoService.queryBean(entity);
			
			MsgInfoMVO msgInfo = new MsgInfoMVO();
			msgInfo.setMsgId(entity.getMsgId());
			msgInfo.setStatus(MsgInfo.status_readed);
			msgInfoService.update(msgInfo);
			return apiResult(RC.SUCCESS, entity);
		} catch (Exception e) {
			return exceptionResult(logger, "获取消息详情错误", e);
		}
	}
	
}
