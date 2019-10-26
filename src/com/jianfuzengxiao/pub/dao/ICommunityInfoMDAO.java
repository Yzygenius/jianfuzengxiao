package com.jianfuzengxiao.pub.dao;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.CommunityInfoMVO;

public interface ICommunityInfoMDAO extends ICommunityInfoSDAO {
	/** 分页查询 */
	public PageInfo queryPage(CommunityInfoMVO communityInfo, PageInfo pagInfo) throws SysException;

}
