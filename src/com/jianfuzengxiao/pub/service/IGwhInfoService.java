package com.jianfuzengxiao.pub.service;

import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.GwhInfoMVO;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface IGwhInfoService extends IService {
	/** 保存数据 */
	public GwhInfoMVO insert(GwhInfoMVO entity) throws SysException, AppException;

	/** 更新数据 */
	public int update(GwhInfoMVO entity) throws SysException, AppException;

	/** 删除数据 */
	public int delete(GwhInfoMVO entity) throws SysException, AppException;

	/** 查询集合 */
	public List<GwhInfoMVO> queryList(GwhInfoMVO entity) throws SysException, AppException;

	/** 查询对象 */
	public GwhInfoMVO queryBean(GwhInfoMVO entity) throws SysException, AppException;

	/** 分页查询 */
	public PageInfo queryPage(GwhInfoMVO entity, PageInfo pagInfo) throws SysException, AppException;

}
