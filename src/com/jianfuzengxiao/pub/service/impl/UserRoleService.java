package com.jianfuzengxiao.pub.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.IUserRoleMDAO;
import com.jianfuzengxiao.pub.entity.UserRoleMVO;
import com.jianfuzengxiao.pub.service.IUserRoleService;

@Service
public class UserRoleService extends BaseService implements IUserRoleService {

	@Autowired
	private IUserRoleMDAO userRoleMDAO;

	/** 插入 */
	@Override
	public UserRoleMVO insert(UserRoleMVO userRole) throws SysException, AppException {
		return userRoleMDAO.insert(userRole);
	}

	/** 更新 */
	@Override
	public int update(UserRoleMVO userRole) throws SysException, AppException {
		return userRoleMDAO.update(userRole);
	}

	/** 删除 */
	@Override
	public int delete(UserRoleMVO userRole) throws SysException, AppException {
		return userRoleMDAO.delete(userRole);
	}

	/** 查询集合列表 */
	@Override
	public List<UserRoleMVO> queryList(UserRoleMVO userRole) throws SysException, AppException {
		return userRoleMDAO.queryList(userRole);
	}

	/** 查询对象 */
	@Override
	public UserRoleMVO queryBean(UserRoleMVO userRole) throws SysException, AppException {
		return userRoleMDAO.queryBean(userRole);
	}

	/** 分页查询 */
	@Override
	public PageInfo queryPage(UserRoleMVO userRole, PageInfo pagInfo) throws SysException, AppException {
		return userRoleMDAO.queryPage(userRole, pagInfo);
	}

}
