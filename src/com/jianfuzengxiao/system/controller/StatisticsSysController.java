package com.jianfuzengxiao.system.controller;

import java.util.ArrayList;
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
import com.jianfuzengxiao.base.common.SessionAdmin;
import com.jianfuzengxiao.base.controller.BaseController;
import com.jianfuzengxiao.base.utils.BigDouble;
import com.jianfuzengxiao.pub.entity.AduitDistributionMVO;
import com.jianfuzengxiao.pub.entity.CommunityStreetInfoMVO;
import com.jianfuzengxiao.pub.entity.HousesInfoMVO;
import com.jianfuzengxiao.pub.entity.LgzgMVO;
import com.jianfuzengxiao.pub.entity.PersonnelInfoMVO;
import com.jianfuzengxiao.pub.entity.Statistics;
import com.jianfuzengxiao.pub.service.IAduitDistributionService;
import com.jianfuzengxiao.pub.service.ICommunityStreetInfoService;
import com.jianfuzengxiao.pub.service.IHousesInfoService;
import com.jianfuzengxiao.pub.service.ILgzgService;
import com.jianfuzengxiao.pub.service.IStatisticsService;

@Controller
@RequestMapping(value="/system/statistics")
public class StatisticsSysController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(StatisticsSysController.class);
	
	@Autowired
	private IStatisticsService statisticsService;
	
	@Autowired
	private ILgzgService lgzgService;
	
	@Autowired
	private IAduitDistributionService aduitDistributionService;
	
	@Autowired
	private IHousesInfoService husesInfoService;
	
	@Autowired
	private ICommunityStreetInfoService communityStreetInfoService;
	
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
	 * 首页场所
	 * */
	@ResponseBody
	@RequestMapping(value="/getCommunityStreetCount")
	public String getCommunityStreetCount(CommunityStreetInfoMVO entity){
		try {
			//流管专干
			if (StringUtils.isBlank(entity.getCommunityId())) {
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
			}
			//包户干部
			if (StringUtils.equals(SessionAdmin.get(SessionAdmin.ROLE_ID), "2")) {
				AduitDistributionMVO aduitDistribution = new AduitDistributionMVO();
				aduitDistribution.setAdminId(SessionAdmin.get(SessionAdmin.ADMIN_ID));
				aduitDistribution.setSts("A");
				List<AduitDistributionMVO> list = aduitDistributionService.queryList(aduitDistribution);
				if (list.size() > 0) {
					List<String> list2 = new ArrayList<String>();
					for (AduitDistributionMVO ad : list) {
						list2.add(ad.getHousesId());
					}
					String housesId = StringUtils.join(list2.toArray(),",");
					HousesInfoMVO housesInfo = new HousesInfoMVO();
					housesInfo.setHousesId(housesId);
					housesInfo.setSts("A");
					List<HousesInfoMVO> hList = husesInfoService.queryGroupByCommunity(housesInfo);
					if (hList.size() > 0) {
						List<String> sList = new ArrayList<>();
						for(HousesInfoMVO h : hList){
							sList.add(h.getCommunityId());
						}
						entity.setCommunityId(StringUtils.join(sList.toArray(),","));
					}else {
						entity.setCommunityId("0");
					}
				}else {
					entity.setCommunityId("0");
				}
			}
			entity.setSts("A");
			List<CommunityStreetInfoMVO> list = communityStreetInfoService.queryList(entity);
			return apiResult(RC.SUCCESS, list.size());
		} catch (Exception e) {
			return exceptionResult(logger, "查询统计失败", e);
		}
	}
	
	/** 
	 * 周期变化率
	 * */
	@ResponseBody
	@RequestMapping(value="/getZqbhl")
	public String getZqbhl(Statistics entity){
		try {
			//流管专干
			if (StringUtils.isBlank(entity.getCommunityId())) {
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
			}
			//包户干部
			if (StringUtils.equals(SessionAdmin.get(SessionAdmin.ROLE_ID), "2")) {
				AduitDistributionMVO aduitDistribution = new AduitDistributionMVO();
				aduitDistribution.setAdminId(SessionAdmin.get(SessionAdmin.ADMIN_ID));
				aduitDistribution.setSts("A");
				List<AduitDistributionMVO> list = aduitDistributionService.queryList(aduitDistribution);
				if (list.size() > 0) {
					List<String> list2 = new ArrayList<String>();
					for (AduitDistributionMVO ad : list) {
						list2.add(ad.getHousesId());
					}
					String housesId = StringUtils.join(list2.toArray(),",");
					entity.setHousesId(housesId);
				}else {
					entity.setHousesId("0");
				}
			}
			
			entity = statisticsService.queryReportChangeCount(entity);
			return apiResult(RC.SUCCESS, entity);
		} catch (Exception e) {
			return exceptionResult(logger, "查询统计失败", e);
		}
	}
	
	
	/** 
	 * 今日上报信息列表
	 * */
	@ResponseBody
	@RequestMapping(value="/getTodayReportPage")
	public String getTodayReportPage(PersonnelInfoMVO entity){
		try {
			//流管专干
			if (StringUtils.isBlank(entity.getCommunityId())) {
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
			}
			//包户干部
			if (StringUtils.equals(SessionAdmin.get(SessionAdmin.ROLE_ID), "2")) {
				AduitDistributionMVO aduitDistribution = new AduitDistributionMVO();
				aduitDistribution.setAdminId(SessionAdmin.get(SessionAdmin.ADMIN_ID));
				aduitDistribution.setSts("A");
				List<AduitDistributionMVO> list = aduitDistributionService.queryList(aduitDistribution);
				if (list.size() > 0) {
					List<String> list2 = new ArrayList<String>();
					for (AduitDistributionMVO ad : list) {
						list2.add(ad.getHousesId());
					}
					String housesId = StringUtils.join(list2.toArray(),",");
					entity.setHousesId(housesId);
				}else {
					entity.setHousesId("0");
				}
			}
			PageInfo pageInfo = getPage();
			pageInfo.setSortName("updateTime");
			pageInfo.setSortOrder("desc");
			pageInfo = statisticsService.queryTodayReportPage(entity, pageInfo);
			return apiResult(RC.SUCCESS, pageInfo);
		} catch (Exception e) {
			return exceptionResult(logger, "查询统计失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 首页最新上报信息
	 * </p>
	 *	@param live_type_id(1,3), 店主传参:live_type_id(2,4), 租户传参:live_type_id(5), 家属传参:live_type_id(7), 员工传参:live_type_id(6), 
	 *	@return total 总数， audit 已处理   waitaudit 未处理  auditratio 比例 
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年11月9日 上午11:18:27
	 */
	@ResponseBody
	@RequestMapping(value="/getTodayReportPer")
	public String getTodayReportPer(Statistics entity){
		try {
			//流管专干
			if (StringUtils.isBlank(entity.getCommunityId())) {
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
			}
			//包户干部
			if (StringUtils.equals(SessionAdmin.get(SessionAdmin.ROLE_ID), "2")) {
				AduitDistributionMVO aduitDistribution = new AduitDistributionMVO();
				aduitDistribution.setAdminId(SessionAdmin.get(SessionAdmin.ADMIN_ID));
				aduitDistribution.setSts("A");
				List<AduitDistributionMVO> list = aduitDistributionService.queryList(aduitDistribution);
				if (list.size() > 0) {
					List<String> list2 = new ArrayList<String>();
					for (AduitDistributionMVO ad : list) {
						list2.add(ad.getHousesId());
					}
					String housesId = StringUtils.join(list2.toArray(),",");
					entity.setHousesId(housesId);
				}else {
					entity.setHousesId("0");
				}
			}
			entity = statisticsService.queryTodayReportPer(entity);
			return apiResult(RC.SUCCESS, entity);
		} catch (Exception e) {
			return exceptionResult(logger, "查询统计失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 首页房屋信息统计
	 * </p>
	 *	@param  startTime  stopTime
	 *	@return housesCount 房屋总数， zjf 自建房 , szf 商住房, sp 商铺, used 已用， idle 闲置
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年11月9日 上午11:18:27
	 */
	@ResponseBody
	@RequestMapping(value="/getHousesCount")
	public String getHousesCount(Statistics entity){
		try {
			//流管专干
			if (StringUtils.isBlank(entity.getCommunityId())) {
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
			}
			//包户干部
			if (StringUtils.equals(SessionAdmin.get(SessionAdmin.ROLE_ID), "2")) {
				AduitDistributionMVO aduitDistribution = new AduitDistributionMVO();
				aduitDistribution.setAdminId(SessionAdmin.get(SessionAdmin.ADMIN_ID));
				aduitDistribution.setSts("A");
				List<AduitDistributionMVO> list = aduitDistributionService.queryList(aduitDistribution);
				if (list.size() > 0) {
					List<String> list2 = new ArrayList<String>();
					for (AduitDistributionMVO ad : list) {
						list2.add(ad.getHousesId());
					}
					String housesId = StringUtils.join(list2.toArray(),",");
					entity.setHousesId(housesId);
				}else {
					entity.setHousesId("0");
				}
			}
			entity = statisticsService.queryHousesCount(entity);
			return apiResult(RC.SUCCESS, entity);
		} catch (Exception e) {
			return exceptionResult(logger, "查询统计失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 首页人员信息统计
	 * </p>
	 *	@param  startTime  stopTime
	 *	@return percount 人员总数， fangzhunum 房主， dianzhunum 店主， zuhunum 租户， yuangongnum 员工， jiashunum 家属
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年11月9日 上午11:18:27
	 */
	@ResponseBody
	@RequestMapping(value="/getPersonnelCount")
	public String getPersonnelCount(Statistics entity){
		try {
			//流管专干
			if (StringUtils.isBlank(entity.getCommunityId())) {
				if (SessionAdmin.get(SessionAdmin.ROLE_ID).equals("3")) {
					LgzgMVO lgzg = new LgzgMVO();
					lgzg.setAdminId(SessionAdmin.get(SessionAdmin.ADMIN_ID));
					lgzg.setSts("A");
					List<LgzgMVO> lgzgList = lgzgService.queryList(lgzg);
					String communityId = "0";
					if (lgzgList.size() > 0) {
						List<String> list = new ArrayList<String>();
						for(LgzgMVO lg : lgzgList){
							list.add(lg.getCommunityId());
						}
						communityId = StringUtils.join(list.toArray(),",");
						
						HousesInfoMVO housesInfoMVO = new HousesInfoMVO();
						housesInfoMVO.setCommunityId(communityId);
						housesInfoMVO.setSts("A");
						List<HousesInfoMVO> list2 = husesInfoService.queryList(housesInfoMVO);
						if (list2.size() > 0) {
							List<String> list3 = new ArrayList<String>();
							for (HousesInfoMVO ad : list2) {
								list3.add(ad.getHousesId());
							}
							String housesId = StringUtils.join(list3.toArray(),",");
							entity.setHousesId(housesId);
						}else {
							entity.setHousesId("0");
						}
					}else{
						entity.setHousesId("0");
					}
				}
			}
			//包户干部
			if (StringUtils.equals(SessionAdmin.get(SessionAdmin.ROLE_ID), "2")) {
				AduitDistributionMVO aduitDistribution = new AduitDistributionMVO();
				aduitDistribution.setAdminId(SessionAdmin.get(SessionAdmin.ADMIN_ID));
				aduitDistribution.setSts("A");
				List<AduitDistributionMVO> list = aduitDistributionService.queryList(aduitDistribution);
				if (list.size() > 0) {
					List<String> list2 = new ArrayList<String>();
					for (AduitDistributionMVO ad : list) {
						list2.add(ad.getHousesId());
					}
					String housesId = StringUtils.join(list2.toArray(),",");
					entity.setHousesId(housesId);
				}else {
					entity.setHousesId("0");
				}
			}
			entity = statisticsService.queryPersonnelCount(entity);
			return apiResult(RC.SUCCESS, entity);
		} catch (Exception e) {
			return exceptionResult(logger, "查询统计失败", e);
		}
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
			//流管专干
			if (StringUtils.isBlank(entity.getCommunityId())) {
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
			}
			//包户干部
			if (StringUtils.equals(SessionAdmin.get(SessionAdmin.ROLE_ID), "2")) {
				AduitDistributionMVO aduitDistribution = new AduitDistributionMVO();
				aduitDistribution.setAdminId(SessionAdmin.get(SessionAdmin.ADMIN_ID));
				aduitDistribution.setSts("A");
				List<AduitDistributionMVO> list = aduitDistributionService.queryList(aduitDistribution);
				if (list.size() > 0) {
					List<String> list2 = new ArrayList<String>();
					for (AduitDistributionMVO ad : list) {
						list2.add(ad.getHousesId());
					}
					String housesId = StringUtils.join(list2.toArray(),",");
					entity.setHousesId(housesId);
				}else {
					entity.setHousesId("0");
				}
			}
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
			//流管专干
			if (StringUtils.isBlank(entity.getCommunityId())) {
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
			}
			//包户干部
			if (StringUtils.equals(SessionAdmin.get(SessionAdmin.ROLE_ID), "2")) {
				AduitDistributionMVO aduitDistribution = new AduitDistributionMVO();
				aduitDistribution.setAdminId(SessionAdmin.get(SessionAdmin.ADMIN_ID));
				aduitDistribution.setSts("A");
				List<AduitDistributionMVO> list = aduitDistributionService.queryList(aduitDistribution);
				if (list.size() > 0) {
					List<String> list2 = new ArrayList<String>();
					for (AduitDistributionMVO ad : list) {
						list2.add(ad.getHousesId());
					}
					String housesId = StringUtils.join(list2.toArray(),",");
					entity.setHousesId(housesId);
				}else {
					entity.setHousesId("0");
				}
			}
			entity = statisticsService.queryHousesRent(entity);
			return apiResult(RC.SUCCESS, entity);
		} catch (Exception e) {
			return exceptionResult(logger, "查询统计失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 房屋户型情况
	 * </p>
	 * @param communityId 社区ID， communityStreetId 小区/街道ID， housesTypeId 房屋分类(1自建房,2商住房,3商铺)
	 * @return  count 数量，houseType 名称， ratio 比例
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年11月9日 上午11:18:27
	 */
	@ResponseBody
	@RequestMapping(value="/getHouseType")
	public String getHouseType(Statistics entity){
		try {
			//流管专干
			if (StringUtils.isBlank(entity.getCommunityId())) {
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
			}
			//包户干部
			if (StringUtils.equals(SessionAdmin.get(SessionAdmin.ROLE_ID), "2")) {
				AduitDistributionMVO aduitDistribution = new AduitDistributionMVO();
				aduitDistribution.setAdminId(SessionAdmin.get(SessionAdmin.ADMIN_ID));
				aduitDistribution.setSts("A");
				List<AduitDistributionMVO> list = aduitDistributionService.queryList(aduitDistribution);
				if (list.size() > 0) {
					List<String> list2 = new ArrayList<String>();
					for (AduitDistributionMVO ad : list) {
						list2.add(ad.getHousesId());
					}
					String housesId = StringUtils.join(list2.toArray(),",");
					entity.setHousesId(housesId);
				}else {
					entity.setHousesId("0");
				}
			}
			List<Statistics> list = statisticsService.queryHouseType(entity);
			return apiResult(RC.SUCCESS, list);
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
			//流管专干
			if (StringUtils.isBlank(entity.getCommunityId())) {
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
			}
			//包户干部
			if (StringUtils.equals(SessionAdmin.get(SessionAdmin.ROLE_ID), "2")) {
				AduitDistributionMVO aduitDistribution = new AduitDistributionMVO();
				aduitDistribution.setAdminId(SessionAdmin.get(SessionAdmin.ADMIN_ID));
				aduitDistribution.setSts("A");
				List<AduitDistributionMVO> list = aduitDistributionService.queryList(aduitDistribution);
				if (list.size() > 0) {
					List<String> list2 = new ArrayList<String>();
					for (AduitDistributionMVO ad : list) {
						list2.add(ad.getHousesId());
					}
					String housesId = StringUtils.join(list2.toArray(),",");
					entity.setHousesId(housesId);
				}else {
					entity.setHousesId("0");
				}
			}
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
			//流管专干
			if (StringUtils.isBlank(entity.getCommunityId())) {
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
			}
			//包户干部
			if (StringUtils.equals(SessionAdmin.get(SessionAdmin.ROLE_ID), "2")) {
				AduitDistributionMVO aduitDistribution = new AduitDistributionMVO();
				aduitDistribution.setAdminId(SessionAdmin.get(SessionAdmin.ADMIN_ID));
				aduitDistribution.setSts("A");
				List<AduitDistributionMVO> list = aduitDistributionService.queryList(aduitDistribution);
				if (list.size() > 0) {
					List<String> list2 = new ArrayList<String>();
					for (AduitDistributionMVO ad : list) {
						list2.add(ad.getHousesId());
					}
					String housesId = StringUtils.join(list2.toArray(),",");
					entity.setHousesId(housesId);
				}else {
					entity.setHousesId("0");
				}
			}
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
	 * @return agerange 1(0-6) 2(7-17) 3(18-40) 4(41-47) 5(48-65) 6(66-)    ,  count 对应数量 , ratio 比例
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年11月9日 上午11:18:27
	 */
	@ResponseBody
	@RequestMapping(value="/getPersonnelAge")
	public String getPersonnelAge(Statistics entity){
		try {
			//流管专干
			if (StringUtils.isBlank(entity.getCommunityId())) {
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
			}
			//包户干部
			if (StringUtils.equals(SessionAdmin.get(SessionAdmin.ROLE_ID), "2")) {
				AduitDistributionMVO aduitDistribution = new AduitDistributionMVO();
				aduitDistribution.setAdminId(SessionAdmin.get(SessionAdmin.ADMIN_ID));
				aduitDistribution.setSts("A");
				List<AduitDistributionMVO> list = aduitDistributionService.queryList(aduitDistribution);
				if (list.size() > 0) {
					List<String> list2 = new ArrayList<String>();
					for (AduitDistributionMVO ad : list) {
						list2.add(ad.getHousesId());
					}
					String housesId = StringUtils.join(list2.toArray(),",");
					entity.setHousesId(housesId);
				}else {
					entity.setHousesId("0");
				}
			}
			List<Statistics> list = statisticsService.queryPersonnelAge(entity);
			if(list.size() > 0){
				double count = 0;
				for(Statistics s : list){
					count += Double.parseDouble(s.getCount());
				}
				for(Statistics st : list){
					st.setRatio(String.valueOf(BigDouble.getRoundingCount(BigDouble.getDivisionCount(Double.parseDouble(st.getCount()), count))));
				}
			}
			return apiResult(RC.SUCCESS, list);
		} catch (Exception e) {
			return exceptionResult(logger, "查询统计失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 人员民族情况
	 * </p>
	 * @param communityId 社区ID， communityStreetId 小区/街道ID, liveTypeId 人员分布 1,3 房主 、2,4店主、 5租户、6员工、7家属
	 * @return count 数量， nationName 名称,  ratio 比例
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年11月9日 上午11:18:27
	 */
	@ResponseBody
	@RequestMapping(value="/getPersonnelNation")
	public String getPersonnelNation(Statistics entity){
		try {
			//流管专干
			if (StringUtils.isBlank(entity.getCommunityId())) {
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
			}
			//包户干部
			if (StringUtils.equals(SessionAdmin.get(SessionAdmin.ROLE_ID), "2")) {
				AduitDistributionMVO aduitDistribution = new AduitDistributionMVO();
				aduitDistribution.setAdminId(SessionAdmin.get(SessionAdmin.ADMIN_ID));
				aduitDistribution.setSts("A");
				List<AduitDistributionMVO> list = aduitDistributionService.queryList(aduitDistribution);
				if (list.size() > 0) {
					List<String> list2 = new ArrayList<String>();
					for (AduitDistributionMVO ad : list) {
						list2.add(ad.getHousesId());
					}
					String housesId = StringUtils.join(list2.toArray(),",");
					entity.setHousesId(housesId);
				}else {
					entity.setHousesId("0");
				}
			}
			List<Statistics> list = statisticsService.queryPersonnelNation(entity);
			return apiResult(RC.SUCCESS, list);
		} catch (Exception e) {
			return exceptionResult(logger, "查询统计失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 上报信息
	 * </p>
	 * @param communityId 社区, communityStreetId 小区, startTime stopTime
	 * @return    
	 * 
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年11月12日 上午9:33:47
	 */
	@ResponseBody
	@RequestMapping(value="/getReportInfo")
	public String getReportInfo(Statistics entity){
		try {
			//流管专干
			if (StringUtils.isBlank(entity.getCommunityId())) {
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
			}
			//包户干部
			if (StringUtils.equals(SessionAdmin.get(SessionAdmin.ROLE_ID), "2")) {
				AduitDistributionMVO aduitDistribution = new AduitDistributionMVO();
				aduitDistribution.setAdminId(SessionAdmin.get(SessionAdmin.ADMIN_ID));
				aduitDistribution.setSts("A");
				List<AduitDistributionMVO> list = aduitDistributionService.queryList(aduitDistribution);
				if (list.size() > 0) {
					List<String> list2 = new ArrayList<String>();
					for (AduitDistributionMVO ad : list) {
						list2.add(ad.getHousesId());
					}
					String housesId = StringUtils.join(list2.toArray(),",");
					entity.setHousesId(housesId);
				}else {
					entity.setHousesId("0");
				}
			}
			entity = statisticsService.queryReportInfo(entity);
			return apiResult(RC.SUCCESS, entity);
		} catch (Exception e) {
			return exceptionResult(logger, "查询统计失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 房屋上报已通过
	 * </p>
	 * @param communityId 社区, communityStreetId 小区, startTime stopTime
	 * @return    
	 * fangzhuPass 房主通过数量, fangzhuRatio 房主比例, fangzhuPassRatio 房主通过率, zuhuPass 租户通过数量, zuhuRatio 租户比例, zuhuPassRatio 租户通过率, jiashuPass 家属数量, jiashuRatio 家属比例, jiashuPassRatio 家属通过率
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年11月12日 上午9:33:47
	 */
	@ResponseBody
	@RequestMapping(value="/getFangwuReportPass")
	public String getFangwuReportPass(Statistics entity){
		try {
			//流管专干
			if (StringUtils.isBlank(entity.getCommunityId())) {
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
			}
			//包户干部
			if (StringUtils.equals(SessionAdmin.get(SessionAdmin.ROLE_ID), "2")) {
				AduitDistributionMVO aduitDistribution = new AduitDistributionMVO();
				aduitDistribution.setAdminId(SessionAdmin.get(SessionAdmin.ADMIN_ID));
				aduitDistribution.setSts("A");
				List<AduitDistributionMVO> list = aduitDistributionService.queryList(aduitDistribution);
				if (list.size() > 0) {
					List<String> list2 = new ArrayList<String>();
					for (AduitDistributionMVO ad : list) {
						list2.add(ad.getHousesId());
					}
					String housesId = StringUtils.join(list2.toArray(),",");
					entity.setHousesId(housesId);
				}else {
					entity.setHousesId("0");
				}
			}
			entity = statisticsService.queryFangwuReportPass(entity);
			return apiResult(RC.SUCCESS, entity);
		} catch (Exception e) {
			return exceptionResult(logger, "查询统计失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	   * 门店上报已通过
	 * </p>
	 * @param communityId 社区, communityStreetId 小区, startTime stopTime
	 * @return    
	 * dianzhuPass 店主通过数量, dianzhuRatio 店主比例, dianzhuPassRatio 店主通过率, yuangongPass 员工通过数量, yuangongRatio 员工比例, yuangongPassRatio 员工通过率
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年11月12日 上午9:33:47
	 */
	@ResponseBody
	@RequestMapping(value="/getMendianReportPass")
	public String getMendianReportPass(Statistics entity){
		try {
			//流管专干
			if (StringUtils.isBlank(entity.getCommunityId())) {
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
			}
			//包户干部
			if (StringUtils.equals(SessionAdmin.get(SessionAdmin.ROLE_ID), "2")) {
				AduitDistributionMVO aduitDistribution = new AduitDistributionMVO();
				aduitDistribution.setAdminId(SessionAdmin.get(SessionAdmin.ADMIN_ID));
				aduitDistribution.setSts("A");
				List<AduitDistributionMVO> list = aduitDistributionService.queryList(aduitDistribution);
				if (list.size() > 0) {
					List<String> list2 = new ArrayList<String>();
					for (AduitDistributionMVO ad : list) {
						list2.add(ad.getHousesId());
					}
					String housesId = StringUtils.join(list2.toArray(),",");
					entity.setHousesId(housesId);
				}else {
					entity.setHousesId("0");
				}
			}
			entity = statisticsService.queryMendianReportPass(entity);
			return apiResult(RC.SUCCESS, entity);
		} catch (Exception e) {
			return exceptionResult(logger, "查询统计失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 上报信息曲线
	 * </p>
	 * @param communityId 社区, communityStreetId 小区, startTime stopTime
	 * @return    
	 * count 数量，year 年, month 月,  day 天
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年11月12日 上午9:33:47
	 */
	@ResponseBody
	@RequestMapping(value="/getReportCurve")
	public String getReportCurve(Statistics entity){
		try {
			//流管专干
			if (StringUtils.isBlank(entity.getCommunityId())) {
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
			}
			//包户干部
			if (StringUtils.equals(SessionAdmin.get(SessionAdmin.ROLE_ID), "2")) {
				AduitDistributionMVO aduitDistribution = new AduitDistributionMVO();
				aduitDistribution.setAdminId(SessionAdmin.get(SessionAdmin.ADMIN_ID));
				aduitDistribution.setSts("A");
				List<AduitDistributionMVO> list = aduitDistributionService.queryList(aduitDistribution);
				if (list.size() > 0) {
					List<String> list2 = new ArrayList<String>();
					for (AduitDistributionMVO ad : list) {
						list2.add(ad.getHousesId());
					}
					String housesId = StringUtils.join(list2.toArray(),",");
					entity.setHousesId(housesId);
				}else {
					entity.setHousesId("0");
				}
			}
			List<Statistics> list = statisticsService.queryReportCurve(entity);
			return apiResult(RC.SUCCESS, list);
		} catch (Exception e) {
			return exceptionResult(logger, "查询统计失败", e);
		}
	}
}
