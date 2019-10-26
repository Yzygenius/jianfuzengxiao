package com.jianfuzengxiao.pub.service;

import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.RoleFuncMVO;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface IRoleFuncService extends IService {
	/** 保存数据 */
	public RoleFuncMVO insert(RoleFuncMVO entity) throws SysException, AppException;

	/** 更新数据 */
	public int update(RoleFuncMVO entity) throws SysException, AppException;

	/** 删除数据 */
	public int delete(RoleFuncMVO entity) throws SysException, AppException;

	/** 查询集合 */
	public List<RoleFuncMVO> queryList(RoleFuncMVO entity) throws SysException, AppException;

	/** 查询对象 */
	public RoleFuncMVO queryBean(RoleFuncMVO entity) throws SysException, AppException;

	/** 分页查询 */
	public PageInfo queryPage(RoleFuncMVO entity, PageInfo pagInfo) throws SysException, AppException;

}
