package com.jianfuzengxiao.pub.dao;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.RoleFuncMVO;

public interface IRoleFuncMDAO extends IRoleFuncSDAO {
	/** 分页查询 */
	public PageInfo queryPage(RoleFuncMVO roleFunc, PageInfo pagInfo) throws SysException;

}
