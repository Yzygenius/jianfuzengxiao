package com.jianfuzengxiao.pub.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.common.util.DateUtil;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.IAdminInfoMDAO;
import com.jianfuzengxiao.pub.entity.AdminInfoMVO;
import com.jianfuzengxiao.pub.service.IAdminInfoService;

@Service
public class AdminInfoService extends BaseService implements IAdminInfoService {

	@Autowired
	private IAdminInfoMDAO adminInfoMDAO;

	/** 插入 */
	@Override
	public AdminInfoMVO insert(AdminInfoMVO adminInfo) throws SysException, AppException {
		adminInfo.setCreateTime(DateUtil.nowTime());
		adminInfo.setSts(STS_NORMAL);
		return adminInfoMDAO.insert(adminInfo);
	}

	/** 更新 */
	@Override
	public int update(AdminInfoMVO adminInfo) throws SysException, AppException {
		adminInfo.setUpdateTime(DateUtil.nowTime());
		return adminInfoMDAO.update(adminInfo);
	}

	/** 删除 */
	@Override
	public int delete(AdminInfoMVO adminInfo) throws SysException, AppException {
		return adminInfoMDAO.delete(adminInfo);
	}

	/** 查询集合列表 */
	@Override
	public List<AdminInfoMVO> queryList(AdminInfoMVO adminInfo) throws SysException, AppException {
		return adminInfoMDAO.queryList(adminInfo);
	}

	/** 查询对象 */
	@Override
	public AdminInfoMVO queryBean(AdminInfoMVO adminInfo) throws SysException, AppException {
		return adminInfoMDAO.queryBean(adminInfo);
	}

	/** 分页查询 */
	@Override
	public PageInfo queryPage(AdminInfoMVO adminInfo, PageInfo pagInfo) throws SysException, AppException {
		return adminInfoMDAO.queryPage(adminInfo, pagInfo);
	}

}
