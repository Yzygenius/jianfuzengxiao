package com.jianfuzengxiao.pub.dao;

import java.util.List;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.PersonnelInfoMVO;

public interface IPersonnelInfoMDAO extends IPersonnelInfoSDAO {
	/** 分页查询 */
	public PageInfo queryPage(PersonnelInfoMVO personnelInfo, PageInfo pagInfo) throws SysException;
	
	public PageInfo queryHousesPage(PersonnelInfoMVO personnelInfo, PageInfo pageInfo) throws SysException;
	
	public List<PersonnelInfoMVO> queryHousesList(PersonnelInfoMVO personnelInfo) throws SysException;
	
	public PersonnelInfoMVO queryPersonnelBean(PersonnelInfoMVO personnelInfo) throws SysException;
	
	public List<PersonnelInfoMVO> queryPerList(PersonnelInfoMVO entity) throws SysException;

}
