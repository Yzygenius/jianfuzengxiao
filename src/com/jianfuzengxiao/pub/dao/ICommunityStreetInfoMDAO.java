package com.jianfuzengxiao.pub.dao;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.CommunityStreetInfoMVO;

public interface ICommunityStreetInfoMDAO extends ICommunityStreetInfoSDAO {
	/** 分页查询 */
	public PageInfo queryPage(CommunityStreetInfoMVO communityStreetInfo, PageInfo pagInfo) throws SysException;

}
