package com.jianfuzengxiao.pub.service;

import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.NationMVO;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface INationService extends IService {
	/** 保存数据 */
	public NationMVO insert(NationMVO entity) throws SysException, AppException;

	/** 更新数据 */
	public int update(NationMVO entity) throws SysException, AppException;

	/** 删除数据 */
	public int delete(NationMVO entity) throws SysException, AppException;

	/** 查询集合 */
	public List<NationMVO> queryList(NationMVO entity) throws SysException, AppException;

	/** 查询对象 */
	public NationMVO queryBean(NationMVO entity) throws SysException, AppException;

	/** 分页查询 */
	public PageInfo queryPage(NationMVO entity, PageInfo pagInfo) throws SysException, AppException;

}
