package com.jianfuzengxiao.pub.dao;

import java.util.List;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.AduitDistributionMVO;
import com.jianfuzengxiao.pub.entity.HousesInfoMVO;

public interface IAduitDistributionMDAO extends IAduitDistributionSDAO {
	/** 分页查询 */
	public PageInfo queryPage(AduitDistributionMVO aduitDistribution, PageInfo pagInfo) throws SysException;
	
	public PageInfo queryHousesPage(AduitDistributionMVO aduitDistribution, PageInfo pageInfo) throws SysException;
	
	public List<AduitDistributionMVO> queryHousesList(AduitDistributionMVO aduitDistribution) throws SysException;
	
	public PageInfo queryPageNotAdminHouses(HousesInfoMVO entity, PageInfo pageInfo) throws SysException;

}
