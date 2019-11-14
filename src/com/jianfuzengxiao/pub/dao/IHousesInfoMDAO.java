package com.jianfuzengxiao.pub.dao;

import java.util.List;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.HousesInfoMVO;

public interface IHousesInfoMDAO extends IHousesInfoSDAO {
	/** 分页查询 */
	public PageInfo queryPage(HousesInfoMVO housesInfo, PageInfo pagInfo) throws SysException;

	public List<HousesInfoMVO> queryBuildingUnitNumList(HousesInfoMVO housesInfo) throws SysException;
	
	public List<HousesInfoMVO> querySelHousesList(HousesInfoMVO housesInfo) throws SysException;
	
	public List<HousesInfoMVO> queryGroupByCommunity(HousesInfoMVO housesInfo) throws SysException;
}
