package com.jianfuzengxiao.wx.controller;

import static com.jianfuzengxiao.base.utils.ApiUtil.throwAppException;

import java.util.List;

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
import com.jianfuzengxiao.pub.entity.AdminInfo;
import com.jianfuzengxiao.pub.entity.AduitDistributionMVO;
import com.jianfuzengxiao.pub.service.IAduitDistributionService;

/**
 * 主页面
 */
@Controller
@RequestMapping(value="/wx/main")
public class MainWxController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(MainWxController.class);
	
	@Autowired
	private IAduitDistributionService aduitDistributionService;
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 查询房产列表， 分页
	 * </p>
	 * @param adminId 管理员ID  ,  检索参数  propertyOwnerName 业主名, propertyOwnerTel 手机号
	 * @return     
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月29日 上午10:29:27
	 */
	@ResponseBody
	@RequestMapping(value="/getHousesPage")
	public String getHousesPage(AduitDistributionMVO model){
		try {
			throwAppException(StringUtils.isBlank(model.getAdminId()), RC.ADMIN_INFO_PARAM_ADMIN_ID_INVALID);
			PageInfo pageInfo = getPage();
			model.setSts("A");
			pageInfo = aduitDistributionService.queryHousesPage(model, pageInfo);
			return apiResult(RC.SUCCESS, pageInfo);
		} catch (Exception e) {
			return exceptionResult(logger, "获取房产列表失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 查询房产列表
	 * </p>
	 * @param adminId 管理员ID,  检索参数  propertyOwnerName 业主名, propertyOwnerTel 手机号
	 * @return     
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月29日 上午10:29:27
	 */
	@ResponseBody
	@RequestMapping(value="/getHousesList")
	public String getHousesList(AduitDistributionMVO model){
		try {
			throwAppException(StringUtils.isBlank(model.getAdminId()), RC.ADMIN_INFO_PARAM_ADMIN_ID_INVALID);
			model.setSts("A");
			List<AduitDistributionMVO> list = aduitDistributionService.queryHousesList(model);
			return apiResult(RC.SUCCESS, list);
		} catch (Exception e) {
			return exceptionResult(logger, "获取房产列表失败", e);
		}
	}
	
}
