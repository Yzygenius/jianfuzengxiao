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
import com.jianfuzengxiao.pub.entity.CommunityStreetInfoMVO;
import com.jianfuzengxiao.pub.entity.LgzgMVO;
import com.jianfuzengxiao.pub.service.ICommunityInfoService;
import com.jianfuzengxiao.pub.service.ICommunityStreetInfoService;
import com.jianfuzengxiao.pub.service.ILgzgService;

import static com.jianfuzengxiao.base.utils.ApiUtil.throwAppException;

@Controller
@RequestMapping(value="/system/communityStreet")
public class CommunityStreetSysController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(CommunityStreetSysController.class);
	
	@Autowired
	private ICommunityInfoService communityInfoService;
	
	@Autowired
	private ICommunityStreetInfoService communityStreetInfoService;
	
	@Autowired
	private ILgzgService lgzgService;
	
	@RequestMapping(value="/toCommunityStreetPage")
	public String toCommunityStreetPage(){
		return "/system/communityStreet-page";
	}
	
	@RequestMapping(value="/toAddCommunityStreet")
	public String toAddCommunityStreet(){
		return "/system/communityStreet-add";
	}
	
	@RequestMapping(value="/toUpdateCommunityStreet")
	public String toUpdateCommunityStreet(CommunityStreetInfoMVO communityStreetInfo, Model model){
		try {
			communityStreetInfo = communityStreetInfoService.queryBean(communityStreetInfo);
			model.addAttribute("communityStreet", communityStreetInfo);
		} catch (Exception e) {
			return "/system/error";
		}
		return "/system/communityStreet-update";
	}
	
	@RequestMapping(value="/toCommunityStreetDetail")
	public String toCommunityStreetDetail(CommunityStreetInfoMVO communityStreetInfo, Model model){
		try {
			communityStreetInfo = communityStreetInfoService.queryBean(communityStreetInfo);
			CommunityInfoMVO communityInfo = new CommunityInfoMVO();
			communityInfo.setCommunityId(communityStreetInfo.getCommunityId());
			communityInfo = communityInfoService.queryBean(communityInfo);
			communityStreetInfo.setCommunityName(communityInfo.getCommunityName());
			communityStreetInfo.setProvName(communityInfo.getProvName());
			communityStreetInfo.setCityName(communityInfo.getCityName());
			communityStreetInfo.setAreaName(communityInfo.getAreaName());
			model.addAttribute("communityStreet", communityStreetInfo);
		} catch (Exception e) {
			return "/system/error";
		}
		return "/system/communityStreet-detail";
	}
	
	@ResponseBody
	@RequestMapping(value="/getCommunityStreetPage")
	public String getCommunityStreetPage(CommunityStreetInfoMVO communityStreetInfo){
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
					communityStreetInfo.setCommunityId(StringUtils.join(list.toArray(),","));
				}else{
					communityStreetInfo.setCommunityId("0");
				}
			}
			PageInfo pageInfo = getPage();
			/*pageInfo.setSortName("listOrder");
			pageInfo.setSortOrder("asc");*/
			communityStreetInfo.setSts("A");
			pageInfo = communityStreetInfoService.queryPage(communityStreetInfo, pageInfo);
			return apiResult(RC.SUCCESS, pageInfo);
		} catch (Exception e) {
			return exceptionResult(logger, "获取小区街道列表失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/getCommunityStreetList")
	public String getCommunityStreetList(CommunityStreetInfoMVO communityStreetInfo){
		try {
			if(StringUtils.isBlank(communityStreetInfo.getCommunityId())){
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
						communityStreetInfo.setCommunityId(StringUtils.join(list.toArray(),","));
					}else{
						communityStreetInfo.setCommunityId("0");
					}
				}
			}
			
			communityStreetInfo.setSts("A");
			List<CommunityStreetInfoMVO> list = communityStreetInfoService.queryList(communityStreetInfo);
			return apiResult(RC.SUCCESS, list);
		} catch (Exception e) {
			return exceptionResult(logger, "获取小区街道列表失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/addCommunityStreet")
	public String addCommunityStreet(CommunityStreetInfoMVO communityStreetInfo){
		try {
			throwAppException(StringUtils.isBlank(communityStreetInfo.getCommunityId()), RC.COMMUNITY_INFO_PARAM_COMMUNITY_NAME_NULL);
			throwAppException(StringUtils.isBlank(communityStreetInfo.getCommunityStreetName()), RC.COMMUNITY_STREET_INFO_PARAM_COMMUNITY_STREET_NAME_NULL);
	//		throwAppException(StringUtils.isBlank(communityStreetInfo.getListOrder()), RC.COMMON_LIST_ORDER_NULL);
			throwAppException(StringUtils.isBlank(communityStreetInfo.getStatus()), RC.COMMON_TYPE_INVALID);
			//查询新增社区名称是否重复
			CommunityStreetInfoMVO communityStreetInfoMVO = new CommunityStreetInfoMVO();
			communityStreetInfoMVO.setCommunityStreetName(communityStreetInfo.getCommunityStreetName());
			communityStreetInfoMVO.setSts("A");
			List<CommunityStreetInfoMVO> list = communityStreetInfoService.queryList(communityStreetInfoMVO);
			throwAppException(list.size() > 0, RC.COMMUNITY_STREET_INFO_PARAM_COMMUNITY_STREET_NAME_EXIST);
			
			communityStreetInfoService.insert(communityStreetInfo);
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "添加小区或街道失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/updateCommunityStreet")
	public String updateCommunityStreet(CommunityStreetInfoMVO communityStreetInfo){
		try {
			throwAppException(StringUtils.isBlank(communityStreetInfo.getCommunityStreetId()), RC.COMMUNITY_STREET_INFO_PARAM_COMMUNITY_STREET_ID_INVALID);
			throwAppException(StringUtils.isBlank(communityStreetInfo.getCommunityId()), RC.COMMUNITY_INFO_PARAM_COMMUNITY_NAME_NULL);
			throwAppException(StringUtils.isBlank(communityStreetInfo.getCommunityStreetName()), RC.COMMUNITY_STREET_INFO_PARAM_COMMUNITY_STREET_NAME_NULL);
	//		throwAppException(StringUtils.isBlank(communityStreetInfo.getListOrder()), RC.COMMON_LIST_ORDER_NULL);
			throwAppException(StringUtils.isBlank(communityStreetInfo.getStatus()), RC.COMMON_TYPE_INVALID);
			//查询新增社区名称是否重复
			CommunityStreetInfoMVO communityStreetInfoMVO = new CommunityStreetInfoMVO();
			communityStreetInfoMVO.setCommunityStreetName(communityStreetInfo.getCommunityStreetName());
			communityStreetInfoMVO.setSts("A");
			List<CommunityStreetInfoMVO> list = communityStreetInfoService.queryList(communityStreetInfoMVO);
			throwAppException(list.size() > 1, RC.COMMUNITY_STREET_INFO_PARAM_COMMUNITY_STREET_NAME_EXIST);
			
			communityStreetInfoService.update(communityStreetInfo);
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "更新小区或街道失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/delCommunityStreet")
	public String delCommunityStreet(CommunityStreetInfoMVO communityStreetInfo){
		try {
			throwAppException(StringUtils.isBlank(communityStreetInfo.getCommunityStreetId()), RC.COMMUNITY_STREET_INFO_PARAM_COMMUNITY_STREET_ID_INVALID);
			List<String> list = Arrays.asList(communityStreetInfo.getCommunityStreetId().split(","));
			for(int i=0; i<list.size(); i++){
				CommunityStreetInfoMVO cMvo = new CommunityStreetInfoMVO();
				cMvo.setCommunityStreetId(list.get(i));
				cMvo.setSts("P");
				communityStreetInfoService.update(cMvo);
			}
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "更新小区或街道失败", e);
		}
	}
}
