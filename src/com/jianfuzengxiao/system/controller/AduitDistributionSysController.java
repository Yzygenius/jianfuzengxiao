package com.jianfuzengxiao.system.controller;

import static com.jianfuzengxiao.base.utils.ApiUtil.throwAppException;

import java.util.ArrayList;
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
import com.jianfuzengxiao.base.common.SessionAdmin;
import com.jianfuzengxiao.base.controller.BaseController;
import com.jianfuzengxiao.pub.entity.AdminInfoMVO;
import com.jianfuzengxiao.pub.entity.AduitDistributionMVO;
import com.jianfuzengxiao.pub.entity.HousesInfoMVO;
import com.jianfuzengxiao.pub.entity.LgzgMVO;
import com.jianfuzengxiao.pub.service.IAduitDistributionService;
import com.jianfuzengxiao.pub.service.IHousesInfoService;
import com.jianfuzengxiao.pub.service.ILgzgService;

@Controller
@RequestMapping(value="/system/auditDistribution")
public class AduitDistributionSysController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(AduitDistributionSysController.class);
	
	@Autowired
	private IAduitDistributionService aduitDistributionService;
	
	@Autowired
	private ILgzgService lgzgService;
	
	@Autowired
	private IHousesInfoService housesInfoService;
	
	@RequestMapping(value="/toManageHousesPage")
	public String toManageHousesPage(){
		return "/system/admin-manageHousesPage";
	}
	
	@RequestMapping(value="/toChooseHousesPage")
	public String toChooseHouses(){
		return "/system/admin-chooseHousesPage";
	}
	
	@ResponseBody
	@RequestMapping(value="/getManageHousesPage", method = RequestMethod.POST)
	public String getManageHousesPage(AduitDistributionMVO entity){
		try {
			PageInfo pageInfo = getPage();
			entity.setSts("A");
			pageInfo = aduitDistributionService.queryHousesPage(entity, pageInfo);
			return apiResult(RC.SUCCESS, pageInfo);
		} catch (Exception e) {
			return exceptionResult(logger, "获取房屋列表失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/delAduitDistribution", method = RequestMethod.POST)
	public String delAduitDistribution(AduitDistributionMVO entity){
		try {
			throwAppException(StringUtils.isBlank(entity.getId()), RC.ADMIN_INFO_PARAM_ADMIN_ID_INVALID);
			List<String> list = Arrays.asList(entity.getId().split(","));
			for(int i=0; i<list.size(); i++){
				AduitDistributionMVO adminInfo = new AduitDistributionMVO();
				adminInfo.setId(list.get(i));
				adminInfo.setSts("P");
				aduitDistributionService.update(adminInfo);
			}
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "获取房屋列表失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/getHousesPage", method = RequestMethod.POST)
	public String getHousesPage(HousesInfoMVO entity){
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
					entity.setCommunityId(StringUtils.join(list.toArray(),","));
				}else{
					entity.setCommunityId("0");
				}
			}
			PageInfo pageInfo = getPage();
			entity.setSts("A");
			pageInfo = aduitDistributionService.queryPageNotAdminHouses(entity, pageInfo);
			return apiResult(RC.SUCCESS, pageInfo);
		} catch (Exception e) {
			return exceptionResult(logger, "获取房屋列表失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/addAuditDistribution", method = RequestMethod.POST)
	public String addAuditDistribution(AduitDistributionMVO entity){
		try {
			throwAppException(StringUtils.isBlank(entity.getHousesId()), RC.HOUSES_INFO_PARAM_HOUSES_ID_INVALID);
			throwAppException(StringUtils.isBlank(entity.getAdminId()), RC.ADMIN_INFO_PARAM_ADMIN_ID_INVALID);
			List<String> list = Arrays.asList(entity.getHousesId().split(","));
			for(int i=0; i<list.size(); i++){
				HousesInfoMVO housesInfoMVO = new HousesInfoMVO();
				housesInfoMVO.setHousesId(list.get(i));
				housesInfoMVO = housesInfoService.queryBean(housesInfoMVO);
				
				AduitDistributionMVO aduitDistribution = new AduitDistributionMVO();
				aduitDistribution.setAdminId(entity.getAdminId());
				aduitDistribution.setCommunityId(housesInfoMVO.getCommunityId());
				aduitDistribution.setHousesId(housesInfoMVO.getHousesId());
				aduitDistribution.setGwhId(housesInfoMVO.getGwhId());
				aduitDistribution.setGwhName(housesInfoMVO.getGwhName());
				aduitDistributionService.insert(aduitDistribution);
			}
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "添加权限失败", e);
		}
	}
	
}
