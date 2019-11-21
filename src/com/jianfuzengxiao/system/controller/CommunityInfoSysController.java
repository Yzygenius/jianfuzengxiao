package com.jianfuzengxiao.system.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.base.common.RC;
import com.jianfuzengxiao.base.common.SessionAdmin;
import com.jianfuzengxiao.base.controller.BaseController;
import com.jianfuzengxiao.pub.entity.CommunityInfoMVO;
import com.jianfuzengxiao.pub.entity.LgzgMVO;
import com.jianfuzengxiao.pub.service.ICommunityInfoService;
import com.jianfuzengxiao.pub.service.ILgzgService;

import static com.jianfuzengxiao.base.utils.ApiUtil.throwAppException;

@Controller
@RequestMapping(value="/system/community")
public class CommunityInfoSysController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(CommunityInfoSysController.class);
	
	@Autowired
	private ICommunityInfoService communityInfoService;
	
	@Autowired
	private ILgzgService lgzgService;
	
	@RequestMapping(value="/toCommunityPage")
	public String toCommunityPage(){
		return "/system/community-page";
	}
	
	@RequestMapping(value="/toAddCommunity")
	public String toAddCommunity(){
		return "/system/community-add";
	}
	
	@RequestMapping(value="/toUpdateCommunity")
	public String toUpdateCommunity(CommunityInfoMVO communityInfo, Model model){
		try {
			communityInfo = communityInfoService.queryBean(communityInfo);
			model.addAttribute("community", communityInfo);
		} catch (Exception e) {
			return "/system/error";
		}
		return "/system/community-update";
	}
	
	@RequestMapping(value="/toCommunityDetail")
	public String toCommunityDetail(CommunityInfoMVO communityInfo, Model model){
		try {
			communityInfo = communityInfoService.queryBean(communityInfo);
			model.addAttribute("community", communityInfo);
		} catch (Exception e) {
			return "/system/error";
		}
		return "/system/community-detail";
	}
	
	@ResponseBody
	@RequestMapping(value="/getCommunityPage")
	public String getCommunityPage(CommunityInfoMVO communityInfo){
		try {
			
			if (SessionAdmin.get(SessionAdmin.ROLE_ID).equals("3")) {
				LgzgMVO lgzg = new LgzgMVO();
				lgzg.setAdminId(SessionAdmin.get(SessionAdmin.ADMIN_ID));
				lgzg.setSts("A");
				List<LgzgMVO> lgzgList = lgzgService.queryList(lgzg);
				if (lgzgList.size() > 0) {
					List<String> list = new ArrayList<String>();
					for(LgzgMVO lg : lgzgList){
						list.add(lg.getCommunityId());
					}
					communityInfo.setCommunityId(StringUtils.join(list.toArray(),","));
				}else{
					communityInfo.setCommunityId("0");
				}
			}
			
			PageInfo pageInfo = getPage();
			/*pageInfo.setSortName("listOrder");
			pageInfo.setSortOrder("asc");*/
			communityInfo.setSts("A");
			pageInfo = communityInfoService.queryPage(communityInfo, pageInfo);
			return apiResult(RC.SUCCESS, pageInfo);
		} catch (Exception e) {
			return exceptionResult(logger, "获取社区列表失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/getCommunityList")
	public String getCommunityList(CommunityInfoMVO communityInfo){
		try {
			if (SessionAdmin.get(SessionAdmin.ROLE_ID).equals("3")) {
				LgzgMVO lgzg = new LgzgMVO();
				lgzg.setAdminId(SessionAdmin.get(SessionAdmin.ADMIN_ID));
				lgzg.setSts("A");
				List<LgzgMVO> lgzgList = lgzgService.queryList(lgzg);
				if (lgzgList.size() > 0) {
					List<String> list = new ArrayList<String>();
					for(LgzgMVO lg : lgzgList){
						list.add(lg.getCommunityId());
					}
					communityInfo.setCommunityId(StringUtils.join(list.toArray(),","));
				}else{
					communityInfo.setCommunityId("0");
				}
			}
			communityInfo.setSts("A");
			List<CommunityInfoMVO> list = communityInfoService.queryList(communityInfo);
			return apiResult(RC.SUCCESS, list);
		} catch (Exception e) {
			return exceptionResult(logger, "获取社区列表失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/addCommunity")
	public String addCommunity(CommunityInfoMVO communityInfo){
		try {
			throwAppException(StringUtils.isBlank(communityInfo.getCommunityName()), RC.COMMUNITY_INFO_PARAM_COMMUNITY_NAME_NULL);
			//throwAppException(StringUtils.isBlank(communityInfo.getListOrder()), RC.COMMON_LIST_ORDER_NULL);
			//查询新增社区名称是否重复
			CommunityInfoMVO communityInfoMVO = new CommunityInfoMVO();
			communityInfoMVO.setCommunityName(communityInfo.getCommunityName());
			communityInfoMVO.setSts("A");
			List<CommunityInfoMVO> list = communityInfoService.queryList(communityInfoMVO);
			throwAppException(list.size() > 0, RC.COMMUNITY_INFO_PARAM_COMMUNITY_NAME_EXIST);
			
			communityInfoService.insert(communityInfo);
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "添加社区失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/updateCommunity")
	public String updateCommunity(CommunityInfoMVO communityInfo){
		try {
			throwAppException(StringUtils.isBlank(communityInfo.getCommunityId()), RC.COMMUNITY_INFO_PARAM_COMMUNITY_ID_INVALID);
			throwAppException(StringUtils.isBlank(communityInfo.getCommunityName()), RC.COMMUNITY_INFO_PARAM_COMMUNITY_NAME_NULL);
			//throwAppException(StringUtils.isBlank(communityInfo.getListOrder()), RC.COMMON_LIST_ORDER_NULL);
			//查询新增社区名称是否重复
			CommunityInfoMVO communityInfoMVO = new CommunityInfoMVO();
			communityInfoMVO.setCommunityName(communityInfo.getCommunityName());
			communityInfoMVO.setSts("A");
			List<CommunityInfoMVO> list = communityInfoService.queryList(communityInfoMVO);
			throwAppException(list.size() > 1, RC.COMMUNITY_INFO_PARAM_COMMUNITY_NAME_EXIST);
			
			communityInfoService.update(communityInfo);
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "更新社区失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/delCommunity")
	public String delCommunity(CommunityInfoMVO communityInfo){
		try {
			throwAppException(StringUtils.isBlank(communityInfo.getCommunityId()), RC.COMMUNITY_INFO_PARAM_COMMUNITY_ID_INVALID);
			List<String> list = Arrays.asList(communityInfo.getCommunityId().split(","));
			for(int i=0; i<list.size(); i++){
				CommunityInfoMVO cMvo = new CommunityInfoMVO();
				cMvo.setCommunityId(list.get(i));
				cMvo.setSts("P");
				communityInfoService.update(cMvo);
			}
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "更新社区失败", e);
		}
	}
}
