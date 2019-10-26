package com.jianfuzengxiao.pub.service;

import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.FuncListMVO;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface IFuncListService extends IService {
	/** 保存数据 */
	public FuncListMVO insert(FuncListMVO entity) throws SysException, AppException;

	/** 更新数据 */
	public int update(FuncListMVO entity) throws SysException, AppException;

	/** 删除数据 */
	public int delete(FuncListMVO entity) throws SysException, AppException;

	/** 查询集合 */
	public List<FuncListMVO> queryList(FuncListMVO entity) throws SysException, AppException;

	/** 查询对象 */
	public FuncListMVO queryBean(FuncListMVO entity) throws SysException, AppException;

	/** 分页查询 */
	public PageInfo queryPage(FuncListMVO entity, PageInfo pagInfo) throws SysException, AppException;

}
