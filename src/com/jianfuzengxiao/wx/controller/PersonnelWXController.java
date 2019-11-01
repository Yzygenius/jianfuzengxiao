package com.jianfuzengxiao.wx.controller;

import static com.jianfuzengxiao.base.utils.ApiUtil.throwAppException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jianfuzengxiao.base.common.RC;
import com.jianfuzengxiao.base.controller.BaseController;
import com.jianfuzengxiao.pub.entity.ContractFileMVO;
import com.jianfuzengxiao.pub.entity.HousesInfoMVO;
import com.jianfuzengxiao.pub.entity.PersonnelInfoMVO;
import com.jianfuzengxiao.pub.service.IContractFileService;
import com.jianfuzengxiao.pub.service.IHousesInfoService;
import com.jianfuzengxiao.pub.service.IPersonnelInfoService;

/**
 *房产、人员
 */
@Controller
@RequestMapping(value="/wx/per")
public class PersonnelWXController extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(PersonnelWXController.class);
	
	@Autowired
	private IHousesInfoService housesInfoService;
	
	@Autowired
	private IPersonnelInfoService personnelInfoService;
	
	@Autowired
	private IContractFileService contractFileService;
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 查询房产详情
	 * </p>
	 * @param housesId 房产ID
	 * @return    houses 房产信息, per 人员列表
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月28日 下午5:07:50
	 */
	@ResponseBody
	@RequestMapping(value="/getHousesDetail", method=RequestMethod.POST)
	public String getHousesDetail(PersonnelInfoMVO model){
		try {
			throwAppException(StringUtils.isBlank(model.getHousesId()), RC.HOUSES_INFO_PARAM_HOUSES_ID_INVALID);
			HousesInfoMVO housesInfo = new HousesInfoMVO();
			housesInfo.setHousesId(model.getHousesId());
			housesInfo = housesInfoService.queryBean(housesInfo);
			
			PersonnelInfoMVO personnelInfo = new PersonnelInfoMVO();
			personnelInfo.setHousesId(model.getHousesId());
			personnelInfo.setSts("A");
			List<PersonnelInfoMVO> list = personnelInfoService.queryList(personnelInfo);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("houses", housesInfo);
			map.put("per", list);
			return apiResult(RC.SUCCESS, map);
		} catch (Exception e) {
			return exceptionResult(logger, "查询房产列表失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 查询人员详情
	 * </p>
	 * @param personnelId 人员ID
	 * @return    
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月28日 下午5:44:36
	 */
	@ResponseBody
	@RequestMapping(value="/getPerDetail", method=RequestMethod.POST)
	public String getPerDetail(PersonnelInfoMVO model){
		try {
			throwAppException(StringUtils.isBlank(model.getPersonnelId()), RC.PERSONNEL_PARAM_PERSONNEL_ID_INVALID);
			model = personnelInfoService.queryPersonnelBean(model);
			return apiResult(RC.SUCCESS, model);
		} catch (Exception e) {
			return exceptionResult(logger, "查询房产列表失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 获取合同列表
	 * </p>
	 * @param personnelId 人员ID, housesId 房产ID
	 * @return    
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年11月1日 下午5:02:39
	 */
	@ResponseBody
	@RequestMapping(value="/getContractList")
	public String getContractList(ContractFileMVO model){
		try {
			throwAppException(StringUtils.isBlank(model.getPersonnelId()), RC.PERSONNEL_PARAM_PERSONNEL_ID_INVALID);
			throwAppException(StringUtils.isBlank(model.getHousesId()), RC.HOUSES_INFO_PARAM_HOUSES_ID_INVALID);
			model.setSts("A");
			List<ContractFileMVO> list = contractFileService.queryList(model);
			return apiResult(RC.SUCCESS, list);
		} catch (Exception e) {
			return exceptionResult(logger, "查询房产列表失败", e);
		}
	}
}
