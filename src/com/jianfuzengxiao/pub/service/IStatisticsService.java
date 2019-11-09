package com.jianfuzengxiao.pub.service;

import java.util.List;

import javax.jws.WebService;

import com.bamboo.framework.base.IService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.Statistics;

@WebService
public interface IStatisticsService extends IService {
	
	
	/** 房屋分类情况 */
	public Statistics queryHousesType(Statistics entity) throws SysException, AppException;
	
	/** 房屋出租情况 */
	public Statistics queryHousesRent(Statistics entity) throws SysException, AppException;
	
	/** 房屋户型情况 */
	public List<Statistics> queryHouseType(Statistics entity) throws SysException, AppException;
	
	/** 人员分类 */
	public Statistics queryPersonnelType(Statistics entity) throws SysException, AppException;
	
	/** 人员性别 */
	public Statistics queryPersonnelGender(Statistics entity) throws SysException, AppException;
	
	/** 人员年龄情况 */
	public List<Statistics> queryPersonnelAge(Statistics entity) throws SysException, AppException;
}
