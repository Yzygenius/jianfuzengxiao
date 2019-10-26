package com.jianfuzengxiao.pub.service;

import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.HousesTypeMVO;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface IHousesTypeService extends IService {
	/** 保存数据 */
	public HousesTypeMVO insert(HousesTypeMVO entity) throws SysException, AppException;

	/** 更新数据 */
	public int update(HousesTypeMVO entity) throws SysException, AppException;

	/** 删除数据 */
	public int delete(HousesTypeMVO entity) throws SysException, AppException;

	/** 查询集合 */
	public List<HousesTypeMVO> queryList(HousesTypeMVO entity) throws SysException, AppException;

	/** 查询对象 */
	public HousesTypeMVO queryBean(HousesTypeMVO entity) throws SysException, AppException;

	/** 分页查询 */
	public PageInfo queryPage(HousesTypeMVO entity, PageInfo pagInfo) throws SysException, AppException;

}
