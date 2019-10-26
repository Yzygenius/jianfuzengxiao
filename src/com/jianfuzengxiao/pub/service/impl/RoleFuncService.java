package com.jianfuzengxiao.pub.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.IRoleFuncMDAO;
import com.jianfuzengxiao.pub.entity.RoleFuncMVO;
import com.jianfuzengxiao.pub.service.IRoleFuncService;

@Service
public class RoleFuncService extends BaseService implements IRoleFuncService {

	@Autowired
	private IRoleFuncMDAO roleFuncMDAO;

	/** 插入 */
	@Override
	public RoleFuncMVO insert(RoleFuncMVO roleFunc) throws SysException, AppException {
		return roleFuncMDAO.insert(roleFunc);
	}

	/** 更新 */
	@Override
	public int update(RoleFuncMVO roleFunc) throws SysException, AppException {
		return roleFuncMDAO.update(roleFunc);
	}

	/** 删除 */
	@Override
	public int delete(RoleFuncMVO roleFunc) throws SysException, AppException {
		return roleFuncMDAO.delete(roleFunc);
	}

	/** 查询集合列表 */
	@Override
	public List<RoleFuncMVO> queryList(RoleFuncMVO roleFunc) throws SysException, AppException {
		return roleFuncMDAO.queryList(roleFunc);
	}

	/** 查询对象 */
	@Override
	public RoleFuncMVO queryBean(RoleFuncMVO roleFunc) throws SysException, AppException {
		return roleFuncMDAO.queryBean(roleFunc);
	}

	/** 分页查询 */
	@Override
	public PageInfo queryPage(RoleFuncMVO roleFunc, PageInfo pagInfo) throws SysException, AppException {
		return roleFuncMDAO.queryPage(roleFunc, pagInfo);
	}

}
