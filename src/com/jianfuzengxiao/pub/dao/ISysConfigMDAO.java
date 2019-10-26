package com.jianfuzengxiao.pub.dao;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.SysConfigMVO;

public interface ISysConfigMDAO extends ISysConfigSDAO {
	/** 分页查询 */
	public PageInfo queryPage(SysConfigMVO sysConfig, PageInfo pagInfo) throws SysException;

}
