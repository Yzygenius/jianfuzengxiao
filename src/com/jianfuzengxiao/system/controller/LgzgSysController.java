package com.jianfuzengxiao.system.controller;

import static com.jianfuzengxiao.base.utils.ApiUtil.throwAppException;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.base.common.RC;
import com.jianfuzengxiao.base.controller.BaseController;
import com.jianfuzengxiao.pub.entity.AduitDistributionMVO;
import com.jianfuzengxiao.pub.entity.CommunityInfoMVO;
import com.jianfuzengxiao.pub.entity.LgzgMVO;
import com.jianfuzengxiao.pub.service.ICommunityInfoService;
import com.jianfuzengxiao.pub.service.ILgzgService;

@Controller
@RequestMapping(value="/system/lgzg")
public class LgzgSysController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(LgzgSysController.class);
	
	@Autowired
	private ILgzgService lgzgService;
	
	@Autowired
	private ICommunityInfoService communityInfoService;
	
	@RequestMapping(value="/toManagePage")
	public String toManagePage(){
		return "/system/admin-manageCommunityPage";
	}
	
	@RequestMapping(value="/toChoosePage")
	public String toChoosePage(){
		return "/system/admin-chooseCommunityPage";
	}
	
	@ResponseBody
	@RequestMapping(value="/getManageCommunityPage", method = RequestMethod.POST)
	public String getManageCommunityPage(LgzgMVO entity){
		try {
			PageInfo pageInfo = getPage();
			entity.setSts("A");
			pageInfo = lgzgService.queryManageCommunityPage(entity, pageInfo);
			return apiResult(RC.SUCCESS, pageInfo);
		} catch (Exception e) {
			return exceptionResult(logger, "获取管理列表失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/getCommunityPage", method = RequestMethod.POST)
	public String getCommunityPage(CommunityInfoMVO entity){
		try {
			PageInfo pageInfo = getPage();
			entity.setSts("A");
			pageInfo = lgzgService.queryPageNotAdminCommuntiy(entity, pageInfo);
			return apiResult(RC.SUCCESS, pageInfo);
		} catch (Exception e) {
			return exceptionResult(logger, "获取社区列表失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/addCommunity", method = RequestMethod.POST)
	public String addCommunity(LgzgMVO entity){
		try {
			throwAppException(StringUtils.isBlank(entity.getCommunityId()), RC.COMMUNITY_INFO_PARAM_COMMUNITY_ID_INVALID);
			throwAppException(StringUtils.isBlank(entity.getAdminId()), RC.ADMIN_INFO_PARAM_ADMIN_ID_INVALID);
			List<String> list = Arrays.asList(entity.getCommunityId().split(","));
			for(int i=0; i<list.size(); i++){
				LgzgMVO lgzg = new LgzgMVO();
				lgzg.setAdminId(entity.getAdminId());
				lgzg.setCommunityId(list.get(i));
				CommunityInfoMVO communityInfo = new CommunityInfoMVO();
				communityInfo.setCommunityId(list.get(i));
				communityInfo = communityInfoService.queryBean(communityInfo);
				lgzg.setGwhId(communityInfo.getGwhId());
				lgzg.setGwhName(communityInfo.getGwhName());
				lgzgService.insert(lgzg);
			}
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "添加管理社区失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/delCommunity", method = RequestMethod.POST)
	public String delCommunity(LgzgMVO entity){
		try {
			throwAppException(StringUtils.isBlank(entity.getLgzgId()), RC.ADMIN_INFO_PARAM_ADMIN_ID_INVALID);
			List<String> list = Arrays.asList(entity.getLgzgId().split(","));
			for(int i=0; i<list.size(); i++){
				LgzgMVO lgzg = new LgzgMVO();
				lgzg.setLgzgId(list.get(i));
				lgzg.setSts("P");
				lgzgService.update(lgzg);
			}
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "删除管理社区失败", e);
		}
	}
	
}
