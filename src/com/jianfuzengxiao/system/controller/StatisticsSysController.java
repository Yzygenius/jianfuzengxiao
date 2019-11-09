package com.jianfuzengxiao.system.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jianfuzengxiao.base.common.RC;
import com.jianfuzengxiao.base.controller.BaseController;
import com.jianfuzengxiao.pub.entity.Statistics;
import com.jianfuzengxiao.pub.service.IStatisticsService;

@Controller
@RequestMapping(value="/system/statistics")
public class StatisticsSysController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(StatisticsSysController.class);
	
	@Autowired
	private IStatisticsService statisticsService;
	
	@RequestMapping(value="/toIndex")
	public String toIndex(){
		return "/system/statistics-index";
	}
	
	@RequestMapping(value="/toHouses")
	public String toHouses(){
		return "/system/statistics-houses";
	}
	
	@RequestMapping(value="/toPersonnel")
	public String toPersonnel(){
		return "/system/statistics-personnel";
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 房屋分类情况
	 * </p>
	 *	@param communityId 社区ID， communityStreetId 小区/街道ID
	 *	@return zjf 自建房， zjfratio 自建房比列， szh 商住房, sp 商铺
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年11月9日 上午11:18:27
	 */
	@ResponseBody
	@RequestMapping(value="/getHousesType")
	public String getHousesType(Statistics entity){
		try {
			entity = statisticsService.queryHousesType(entity);
			return apiResult(RC.SUCCESS, entity);
		} catch (Exception e) {
			return exceptionResult(logger, "查询统计失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 房屋出租情况
	 * </p>
	 * @param communityId 社区ID， communityStreetId 小区/街道ID， housesTypeId 房屋分类(1自建房,2商住房,3商铺)
	 * @return  total 总数， rent 已出租， rentratio 已出租比列, waitrent 未出租，waitrentratio 未出租比列
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年11月9日 上午11:18:27
	 */
	@ResponseBody
	@RequestMapping(value="/getHousesRent")
	public String getHousesRent(Statistics entity){
		try {
			entity = statisticsService.queryHousesRent(entity);
			return apiResult(RC.SUCCESS, entity);
		} catch (Exception e) {
			return exceptionResult(logger, "查询统计失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 人员分类情况
	 * </p>
	 * @param communityId 社区ID， communityStreetId 小区/街道ID
	 * @return  total 总数， fangzhunum 房主 ，fangzhuratio 房主比例， dianzhunum 店主， dianzhuratio 店主比例，zuhunum 租户， zuhuratio 租户比例，yuangongnum 员工， yuangongratio 员工比例，jiashunum 家属， jiashuratio 家属比例
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年11月9日 上午11:18:27
	 */
	@ResponseBody
	@RequestMapping(value="/getPersonnelType")
	public String getPersonnelType(Statistics entity){
		try {
			entity = statisticsService.queryPersonnelType(entity);
			return apiResult(RC.SUCCESS, entity);
		} catch (Exception e) {
			return exceptionResult(logger, "查询统计失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 人员性别情况
	 * </p>
	 * @param communityId 社区ID， communityStreetId 小区/街道ID, liveTypeId 人员分布 1,3 房主 、2,4店主、 5租户、6员工、7家属
	 * @return  namnum 男， nanratio 男比例， nvnum 女， nvratio 女比例
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年11月9日 上午11:18:27
	 */
	@ResponseBody
	@RequestMapping(value="/getPersonnelGender")
	public String getPersonnelGender(Statistics entity){
		try {
			entity = statisticsService.queryPersonnelGender(entity);
			return apiResult(RC.SUCCESS, entity);
		} catch (Exception e) {
			return exceptionResult(logger, "查询统计失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 人员年龄情况
	 * </p>
	 * @param communityId 社区ID， communityStreetId 小区/街道ID, liveTypeId 人员分布 1,3 房主 、2,4店主、 5租户、6员工、7家属
	 * @return agerange 1(0-6) 2(7-17) 3(18-40) 4(41-47) 5(48-65) 6(66-)    ,  count 对应数量
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年11月9日 上午11:18:27
	 */
	@ResponseBody
	@RequestMapping(value="/getPersonnelAge")
	public String getPersonnelAge(Statistics entity){
		try {
			List<Statistics> list = statisticsService.queryPersonnelAge(entity);
			return apiResult(RC.SUCCESS, list);
		} catch (Exception e) {
			return exceptionResult(logger, "查询统计失败", e);
		}
	}
	
}