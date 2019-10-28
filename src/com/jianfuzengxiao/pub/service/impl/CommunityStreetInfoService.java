package com.jianfuzengxiao.pub.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.common.util.DateUtil;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.ICommunityStreetInfoMDAO;
import com.jianfuzengxiao.pub.entity.CommunityStreetInfoMVO;
import com.jianfuzengxiao.pub.service.ICommunityStreetInfoService;

@Service
public class CommunityStreetInfoService extends BaseService implements ICommunityStreetInfoService {

	@Autowired
	private ICommunityStreetInfoMDAO communityStreetInfoMDAO;

	/** 插入 */
	@Override
	public CommunityStreetInfoMVO insert(CommunityStreetInfoMVO communityStreetInfo) throws SysException, AppException {
		communityStreetInfo.setCreateTime(DateUtil.nowTime());
		communityStreetInfo.setSts(STS_NORMAL);
		return communityStreetInfoMDAO.insert(communityStreetInfo);
	}

	/** 更新 */
	@Override
	public int update(CommunityStreetInfoMVO communityStreetInfo) throws SysException, AppException {
		communityStreetInfo.setUpdateTime(DateUtil.nowTime());
		return communityStreetInfoMDAO.update(communityStreetInfo);
	}

	/** 删除 */
	@Override
	public int delete(CommunityStreetInfoMVO communityStreetInfo) throws SysException, AppException {
		return communityStreetInfoMDAO.delete(communityStreetInfo);
	}

	/** 查询集合列表 */
	@Override
	public List<CommunityStreetInfoMVO> queryList(CommunityStreetInfoMVO communityStreetInfo)
			throws SysException, AppException {
		return communityStreetInfoMDAO.queryList(communityStreetInfo);
	}

	/** 查询对象 */
	@Override
	public CommunityStreetInfoMVO queryBean(CommunityStreetInfoMVO communityStreetInfo)
			throws SysException, AppException {
		return communityStreetInfoMDAO.queryBean(communityStreetInfo);
	}

	/** 分页查询 */
	@Override
	public PageInfo queryPage(CommunityStreetInfoMVO communityStreetInfo, PageInfo pagInfo)
			throws SysException, AppException {
		return communityStreetInfoMDAO.queryPage(communityStreetInfo, pagInfo);
	}

}
