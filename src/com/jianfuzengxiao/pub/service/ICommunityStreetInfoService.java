package com.jianfuzengxiao.pub.service;

import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.CommunityStreetInfoMVO;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ICommunityStreetInfoService extends IService {
	/** 保存数据 */
	public CommunityStreetInfoMVO insert(CommunityStreetInfoMVO entity) throws SysException, AppException;

	/** 更新数据 */
	public int update(CommunityStreetInfoMVO entity) throws SysException, AppException;

	/** 删除数据 */
	public int delete(CommunityStreetInfoMVO entity) throws SysException, AppException;

	/** 查询集合 */
	public List<CommunityStreetInfoMVO> queryList(CommunityStreetInfoMVO entity) throws SysException, AppException;

	/** 查询对象 */
	public CommunityStreetInfoMVO queryBean(CommunityStreetInfoMVO entity) throws SysException, AppException;

	/** 分页查询 */
	public PageInfo queryPage(CommunityStreetInfoMVO entity, PageInfo pagInfo) throws SysException, AppException;

}
