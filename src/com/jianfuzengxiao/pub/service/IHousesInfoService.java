package com.jianfuzengxiao.pub.service;

import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.HousesInfoMVO;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface IHousesInfoService extends IService {
	/** 保存数据 */
	public HousesInfoMVO insert(HousesInfoMVO entity) throws SysException, AppException;

	/** 更新数据 */
	public int update(HousesInfoMVO entity) throws SysException, AppException;

	/** 删除数据 */
	public int delete(HousesInfoMVO entity) throws SysException, AppException;

	/** 查询集合 */
	public List<HousesInfoMVO> queryList(HousesInfoMVO entity) throws SysException, AppException;

	/** 查询对象 */
	public HousesInfoMVO queryBean(HousesInfoMVO entity) throws SysException, AppException;

	/** 分页查询 */
	public PageInfo queryPage(HousesInfoMVO entity, PageInfo pagInfo) throws SysException, AppException;
	
	public List<HousesInfoMVO> queryBuildingUnitNumList(HousesInfoMVO housesInfo) throws SysException, AppException;
	
	public List<HousesInfoMVO> querySelHousesList(HousesInfoMVO housesInfo) throws SysException, AppException;

}
