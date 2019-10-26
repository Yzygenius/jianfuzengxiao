package com.jianfuzengxiao.pub.dao;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.UserRoleMVO;

public interface IUserRoleMDAO extends IUserRoleSDAO {
	/** 分页查询 */
	public PageInfo queryPage(UserRoleMVO userRole, PageInfo pagInfo) throws SysException;

}
