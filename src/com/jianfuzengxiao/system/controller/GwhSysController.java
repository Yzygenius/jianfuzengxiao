package com.jianfuzengxiao.system.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.base.common.RC;
import com.jianfuzengxiao.base.controller.BaseController;
import com.jianfuzengxiao.pub.entity.CommunityInfoMVO;
import com.jianfuzengxiao.pub.entity.GwhInfoMVO;
import com.jianfuzengxiao.pub.service.IGwhInfoService;

@Controller
@RequestMapping(value="/system/gwh")
public class GwhSysController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(GwhSysController.class);
	
	@Autowired
	private IGwhInfoService gwhInfoService;
	
	@RequestMapping(value="/toGwhPage")
	public String toGwhPage(){
		return "/system/gwh-page";
	}
	
	@RequestMapping(value="/toGwhDetail")
	public String toGwhDetail(GwhInfoMVO entity, Model model){
		try {
			entity = gwhInfoService.queryBean(entity);
			model.addAttribute("gwh", entity);
		} catch (Exception e) {
			return "/system/error";
		}
		return "/system/gwh-detail";
	}
	
	@RequestMapping(value="/toAddGwh")
	public String toAddGwh(){
		return "/system/gwh-add";
	}
	
	@RequestMapping(value="/toUpdateGwh")
	public String toUpdateGwh(GwhInfoMVO entity, Model model){
		try {
			entity = gwhInfoService.queryBean(entity);
			model.addAttribute("gwh", entity);
		} catch (Exception e) {
			return "/system/error";
		}
		return "/system/gwh-update";
	}
	
	@ResponseBody
	@RequestMapping(value="/getGwhPage", method = RequestMethod.POST)
	public String getGwhPage(GwhInfoMVO entity){
		try {
			PageInfo pageInfo = getPage();
			pageInfo.setSortName("createTime");
			pageInfo.setSortOrder("desc");
			entity.setSts("A");
			pageInfo = gwhInfoService.queryPage(entity, pageInfo);
			return apiResult(RC.SUCCESS, pageInfo);
		} catch (Exception e) {
			return exceptionResult(logger, "获取管委会列表失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/addGwh", method = RequestMethod.POST)
	public String addGwh(GwhInfoMVO entity){
		try {
			
			gwhInfoService.insert(entity);
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "添加管委会列表失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/updateGwh", method = RequestMethod.POST)
	public String updateGwh(GwhInfoMVO entity){
		try {
			
			gwhInfoService.update(entity);
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "更新管委会列表失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/delGwh", method = RequestMethod.POST)
	public String delGwh(GwhInfoMVO entity){
		try {
			List<String> list = Arrays.asList(entity.getGwhId().split(","));
			for(int i=0; i<list.size(); i++){
				GwhInfoMVO gwhInfoMVO = new GwhInfoMVO();
				gwhInfoMVO.setGwhId(list.get(i));
				gwhInfoMVO.setSts("P");
				gwhInfoService.update(gwhInfoMVO);
			}
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "删除管委会列表失败", e);
		}
	}
}
