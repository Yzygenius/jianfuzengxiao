package com.jianfuzengxiao.pub.dao;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.PersonnelInfoMVO;

public interface IPersonnelInfoMDAO extends IPersonnelInfoSDAO {
	/** 分页查询 */
	public PageInfo queryPage(PersonnelInfoMVO personnelInfo, PageInfo pagInfo) throws SysException;

}
