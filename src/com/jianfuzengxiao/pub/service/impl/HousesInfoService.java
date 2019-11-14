package com.jianfuzengxiao.pub.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.common.util.DateUtil;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.IHousesInfoMDAO;
import com.jianfuzengxiao.pub.entity.HousesInfoMVO;
import com.jianfuzengxiao.pub.service.IHousesInfoService;

@Service
public class HousesInfoService extends BaseService implements IHousesInfoService {

	@Autowired
	private IHousesInfoMDAO housesInfoMDAO;

	/** 插入 */
	@Override
	public HousesInfoMVO insert(HousesInfoMVO housesInfo) throws SysException, AppException {
		housesInfo.setCreateTime(DateUtil.nowTime());
		housesInfo.setSts(STS_NORMAL);
		return housesInfoMDAO.insert(housesInfo);
	}

	/** 更新 */
	@Override
	public int update(HousesInfoMVO housesInfo) throws SysException, AppException {
		housesInfo.setUpdateTime(DateUtil.nowTime());
		return housesInfoMDAO.update(housesInfo);
	}

	/** 删除 */
	@Override
	public int delete(HousesInfoMVO housesInfo) throws SysException, AppException {
		return housesInfoMDAO.delete(housesInfo);
	}

	/** 查询集合列表 */
	@Override
	public List<HousesInfoMVO> queryList(HousesInfoMVO housesInfo) throws SysException, AppException {
		return housesInfoMDAO.queryList(housesInfo);
	}

	/** 查询对象 */
	@Override
	public HousesInfoMVO queryBean(HousesInfoMVO housesInfo) throws SysException, AppException {
		return housesInfoMDAO.queryBean(housesInfo);
	}

	/** 分页查询 */
	@Override
	public PageInfo queryPage(HousesInfoMVO housesInfo, PageInfo pagInfo) throws SysException, AppException {
		return housesInfoMDAO.queryPage(housesInfo, pagInfo);
	}

	@Override
	public List<HousesInfoMVO> queryBuildingUnitNumList(HousesInfoMVO housesInfo) throws SysException, AppException {
		return housesInfoMDAO.queryBuildingUnitNumList(housesInfo);
	}

	@Override
	public List<HousesInfoMVO> querySelHousesList(HousesInfoMVO housesInfo) throws SysException, AppException {
		housesInfo.setSts(STS_NORMAL);
		return housesInfoMDAO.querySelHousesList(housesInfo);
	}

	@Override
	public List<HousesInfoMVO> queryGroupByCommunity(HousesInfoMVO housesInfo) throws SysException, AppException {
		return housesInfoMDAO.queryGroupByCommunity(housesInfo);
	}

}
