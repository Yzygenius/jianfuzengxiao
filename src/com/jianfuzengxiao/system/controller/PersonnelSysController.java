package com.jianfuzengxiao.system.controller;

import static com.jianfuzengxiao.base.utils.ApiUtil.throwAppException;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
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
import com.jianfuzengxiao.pub.entity.AduitDistributionMVO;
import com.jianfuzengxiao.pub.entity.HousesInfoMVO;
import com.jianfuzengxiao.pub.entity.PersonnelInfoMVO;
import com.jianfuzengxiao.pub.service.IPersonnelInfoService;

@Controller
@RequestMapping(value="/system/per")
public class PersonnelSysController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(PersonnelSysController.class);
	
	@Autowired
	private IPersonnelInfoService personnelInfoService;
	
	//社区人员管理
	@RequestMapping(value="/toPerPage")
	public String toPerPage(){
		return "/system/per-page";
	}
	
	@RequestMapping(value="/toPerDetail")
	public String toPerDetail(PersonnelInfoMVO entity, Model model){
		try {
			entity = personnelInfoService.queryBean(entity);
			model.addAttribute("per", entity);
		} catch (Exception e) {
			return "/system/error";
		}
		return "/system/per-detail";
	}
	
	//业主审核
	@RequestMapping(value="/toAuditYezhuPage")
	public String toAuditPerPage(){
		return "/system/per-auditYezhuPage";
	}
	
	@RequestMapping(value="/toAuditYezhuDetail")
	public String toAuditYezhuDetail(PersonnelInfoMVO entity, Model model){
		try {
			entity = personnelInfoService.queryPersonnelBean(entity);
			if (entity.getGender().equals("1")) {
				entity.setGender("男");
			}else if (entity.getGender().equals("2")) {
				entity.setGender("女");
			}
			model.addAttribute("per", entity);
		} catch (Exception e) {
			return "/system/error";
		}
		return "/system/per-auditYezhuDetail";
	}
	
	//房屋成员审核
	@RequestMapping(value="/toAuditZuhuPage")
	public String toAuditZuhuPage(){
		return "/system/per-auditZuhuPage";
	}
	
	@RequestMapping(value="/toAuditZuhuDetail")
	public String toAuditZuhuDetail(PersonnelInfoMVO entity, Model model){
		try {
			entity = personnelInfoService.queryPersonnelBean(entity);
			if (entity.getGender().equals("1")) {
				entity.setGender("男");
			}else if (entity.getGender().equals("2")) {
				entity.setGender("女");
			}
			model.addAttribute("per", entity);
		} catch (Exception e) {
			return "/system/error";
		}
		return "/system/per-auditZuhuDetail";
	}
	
	@ResponseBody
	@RequestMapping(value="/getPerPage", method=RequestMethod.POST)
	public String getPerPage(PersonnelInfoMVO entity){
		try{
			PageInfo pageInfo = getPage();
			entity.setSts("A");
			pageInfo = personnelInfoService.queryPage(entity, pageInfo);
			return apiResult(RC.SUCCESS, pageInfo);
		} catch (Exception e) {
			return exceptionResult(logger, "获取人员列表失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/delPer", method=RequestMethod.POST)
	public String delPer(PersonnelInfoMVO entity){
		try{
			throwAppException(StringUtils.isBlank(entity.getPersonnelId()), RC.PERSONNEL_PARAM_PERSONNEL_ID_INVALID);
			List<String> list = Arrays.asList(entity.getPersonnelId().split(","));
			for(int i=0; i<list.size(); i++){
				PersonnelInfoMVO per = new PersonnelInfoMVO();
				per.setPersonnelId(list.get(i));
				per.setSts("P");
				personnelInfoService.update(per);
			}
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "删除人员失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/auditPer", method=RequestMethod.POST)
	public String auditPer(PersonnelInfoMVO entity){
		try{
			throwAppException(StringUtils.isBlank(entity.getPersonnelId()), RC.PERSONNEL_PARAM_PERSONNEL_ID_INVALID);
			throwAppException(StringUtils.isBlank(entity.getStatus()), RC.COMPANY_CERT_STATE_INVALID);
			
			personnelInfoService.updateAuditPersonnel(entity);
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "审核人员失败", e);
		}
	}
	
}
