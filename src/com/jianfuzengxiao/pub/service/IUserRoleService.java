package com.jianfuzengxiao.pub.service;

import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.UserRoleMVO;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface IUserRoleService extends IService {
	/** 保存数据 */
	public UserRoleMVO insert(UserRoleMVO entity) throws SysException, AppException;

	/** 更新数据 */
	public int update(UserRoleMVO entity) throws SysException, AppException;

	/** 删除数据 */
	public int delete(UserRoleMVO entity) throws SysException, AppException;

	/** 查询集合 */
	public List<UserRoleMVO> queryList(UserRoleMVO entity) throws SysException, AppException;

	/** 查询对象 */
	public UserRoleMVO queryBean(UserRoleMVO entity) throws SysException, AppException;

	/** 分页查询 */
	public PageInfo queryPage(UserRoleMVO entity, PageInfo pagInfo) throws SysException, AppException;

}
