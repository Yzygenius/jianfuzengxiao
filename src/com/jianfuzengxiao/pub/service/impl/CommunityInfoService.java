package com.jianfuzengxiao.pub.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.ICommunityInfoMDAO;
import com.jianfuzengxiao.pub.entity.CommunityInfoMVO;
import com.jianfuzengxiao.pub.service.ICommunityInfoService;

@Service
public class CommunityInfoService extends BaseService implements ICommunityInfoService {

	@Autowired
	private ICommunityInfoMDAO communityInfoMDAO;

	/** 插入 */
	@Override
	public CommunityInfoMVO insert(CommunityInfoMVO communityInfo) throws SysException, AppException {
		return communityInfoMDAO.insert(communityInfo);
	}

	/** 更新 */
	@Override
	public int update(CommunityInfoMVO communityInfo) throws SysException, AppException {
		return communityInfoMDAO.update(communityInfo);
	}

	/** 删除 */
	@Override
	public int delete(CommunityInfoMVO communityInfo) throws SysException, AppException {
		return communityInfoMDAO.delete(communityInfo);
	}

	/** 查询集合列表 */
	@Override
	public List<CommunityInfoMVO> queryList(CommunityInfoMVO communityInfo) throws SysException, AppException {
		return communityInfoMDAO.queryList(communityInfo);
	}

	/** 查询对象 */
	@Override
	public CommunityInfoMVO queryBean(CommunityInfoMVO communityInfo) throws SysException, AppException {
		return communityInfoMDAO.queryBean(communityInfo);
	}

	/** 分页查询 */
	@Override
	public PageInfo queryPage(CommunityInfoMVO communityInfo, PageInfo pagInfo) throws SysException, AppException {
		return communityInfoMDAO.queryPage(communityInfo, pagInfo);
	}

}
