package com.jianfuzengxiao.pub.dao;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.NationMVO;

public interface INationMDAO extends INationSDAO {
	/** 分页查询 */
	public PageInfo queryPage(NationMVO nation, PageInfo pagInfo) throws SysException;

}
