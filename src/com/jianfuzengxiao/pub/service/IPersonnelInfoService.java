package com.jianfuzengxiao.pub.service;

import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.PersonnelInfoMVO;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface IPersonnelInfoService extends IService {
	/** 保存数据 */
	public PersonnelInfoMVO insert(PersonnelInfoMVO entity) throws SysException, AppException;

	/** 更新数据 */
	public int update(PersonnelInfoMVO entity) throws SysException, AppException;

	/** 删除数据 */
	public int delete(PersonnelInfoMVO entity) throws SysException, AppException;

	/** 查询集合 */
	public List<PersonnelInfoMVO> queryList(PersonnelInfoMVO entity) throws SysException, AppException;

	/** 查询对象 */
	public PersonnelInfoMVO queryBean(PersonnelInfoMVO entity) throws SysException, AppException;

	/** 分页查询 */
	public PageInfo queryPage(PersonnelInfoMVO entity, PageInfo pagInfo) throws SysException, AppException;
	
	public PageInfo queryHousesPage(PersonnelInfoMVO personnelInfo, PageInfo pageInfo) throws SysException, AppException;
	
	public List<PersonnelInfoMVO> queryHousesList(PersonnelInfoMVO personnelInfo) throws SysException, AppException;
	
	public PersonnelInfoMVO queryPersonnelBean(PersonnelInfoMVO personnelInfo) throws SysException, AppException;
	
	public PersonnelInfoMVO addUserPersonnel(PersonnelInfoMVO entity) throws SysException, AppException;
	
	public PersonnelInfoMVO addPersonnel(PersonnelInfoMVO entity) throws SysException, AppException;
	
	public int updatePersonnel(PersonnelInfoMVO entity) throws SysException, AppException;
	
	public int updateAuditPersonnel(PersonnelInfoMVO entity) throws SysException, AppException;

}
