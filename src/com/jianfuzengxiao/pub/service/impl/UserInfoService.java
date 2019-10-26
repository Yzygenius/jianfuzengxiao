package com.jianfuzengxiao.pub.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.IUserInfoMDAO;
import com.jianfuzengxiao.pub.entity.UserInfoMVO;
import com.jianfuzengxiao.pub.service.IUserInfoService;

@Service
public class UserInfoService extends BaseService implements IUserInfoService {

	@Autowired
	private IUserInfoMDAO userInfoMDAO;

	/** 插入 */
	@Override
	public UserInfoMVO insert(UserInfoMVO userInfo) throws SysException, AppException {
		return userInfoMDAO.insert(userInfo);
	}

	/** 更新 */
	@Override
	public int update(UserInfoMVO userInfo) throws SysException, AppException {
		return userInfoMDAO.update(userInfo);
	}

	/** 删除 */
	@Override
	public int delete(UserInfoMVO userInfo) throws SysException, AppException {
		return userInfoMDAO.delete(userInfo);
	}

	/** 查询集合列表 */
	@Override
	public List<UserInfoMVO> queryList(UserInfoMVO userInfo) throws SysException, AppException {
		return userInfoMDAO.queryList(userInfo);
	}

	/** 查询对象 */
	@Override
	public UserInfoMVO queryBean(UserInfoMVO userInfo) throws SysException, AppException {
		return userInfoMDAO.queryBean(userInfo);
	}

	/** 分页查询 */
	@Override
	public PageInfo queryPage(UserInfoMVO userInfo, PageInfo pagInfo) throws SysException, AppException {
		return userInfoMDAO.queryPage(userInfo, pagInfo);
	}

}
