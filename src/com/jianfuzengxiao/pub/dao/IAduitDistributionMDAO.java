package com.jianfuzengxiao.pub.dao;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.AduitDistributionMVO;

public interface IAduitDistributionMDAO extends IAduitDistributionSDAO {
	/** 分页查询 */
	public PageInfo queryPage(AduitDistributionMVO aduitDistribution, PageInfo pagInfo) throws SysException;

}
