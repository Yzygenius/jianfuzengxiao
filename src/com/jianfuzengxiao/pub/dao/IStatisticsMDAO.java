package com.jianfuzengxiao.pub.dao;

import java.util.List;

import com.bamboo.framework.base.IDAO;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.PersonnelInfoMVO;
import com.jianfuzengxiao.pub.entity.Statistics;

public interface IStatisticsMDAO extends IDAO<Statistics> {
	
	/* 首页 */
	/** 首页最新上报信息 */
	public Statistics queryTodayReportPer(Statistics entity) throws SysException, AppException;
	
	/** 房屋信息统计 */
	public Statistics queryHousesCount(Statistics entity) throws SysException, AppException;
	
	/** 人员信息统计 */
	public Statistics queryPersonnelCount(Statistics entity) throws SysException, AppException;
	
	/** 人员信息统计 */
	public PageInfo queryTodayReportPage(PersonnelInfoMVO entity, PageInfo pageInfo) throws SysException, AppException;

	/* 房屋 */
	/** 房屋分类情况 */
	public Statistics queryHousesType(Statistics entity) throws SysException, AppException;
	
	/** 房屋出租情况 */
	public Statistics queryHousesRent(Statistics entity) throws SysException, AppException;
	
	/** 房屋户型情况 */
	public List<Statistics> queryHouseType(Statistics entity) throws SysException, AppException;
	
	/* 人员 */
	/** 人员分类 */
	public Statistics queryPersonnelType(Statistics entity) throws SysException, AppException;
	
	/** 人员性别 */
	public Statistics queryPersonnelGender(Statistics entity) throws SysException, AppException;
	
	/** 人员年龄情况 */
	public List<Statistics> queryPersonnelAge(Statistics entity) throws SysException, AppException;
	
	/** 人员民族情况 */
	public List<Statistics> queryPersonnelNation(Statistics entity) throws SysException, AppException;
	
	/*上报*/
	/** 上报信息 */
	public Statistics queryReportInfo(Statistics entity) throws SysException, AppException;
	
	/** 房屋上报通过 */
	public Statistics queryFangwuReportPass(Statistics entity) throws SysException, AppException;
	
	/** 门店上报通过 */
	public Statistics queryMendianReportPass(Statistics entity) throws SysException, AppException;
	
	/** 上报曲线 */
	public List<Statistics> queryReportCurve(Statistics entity) throws SysException, AppException;
	
	/** 上报周期变化率 */
	public Statistics queryReportChangeCount(Statistics entity) throws SysException, AppException;
}
