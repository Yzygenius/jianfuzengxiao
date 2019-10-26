package com.jianfuzengxiao.pub.service;

import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.AreaInfoMVO;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface IAreaInfoService extends IService {
	/** 保存数据 */
	public AreaInfoMVO insert(AreaInfoMVO entity) throws SysException, AppException;

	/** 更新数据 */
	public int update(AreaInfoMVO entity) throws SysException, AppException;

	/** 删除数据 */
	public int delete(AreaInfoMVO entity) throws SysException, AppException;

	/** 查询集合 */
	public List<AreaInfoMVO> queryList(AreaInfoMVO entity) throws SysException, AppException;

	/** 查询对象 */
	public AreaInfoMVO queryBean(AreaInfoMVO entity) throws SysException, AppException;

	/** 分页查询 */
	public PageInfo queryPage(AreaInfoMVO entity, PageInfo pagInfo) throws SysException, AppException;

}
