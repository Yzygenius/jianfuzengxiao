package com.jianfuzengxiao.pub.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.common.util.DateUtil;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.ILgzgMDAO;
import com.jianfuzengxiao.pub.entity.CommunityInfoMVO;
import com.jianfuzengxiao.pub.entity.LgzgMVO;
import com.jianfuzengxiao.pub.service.ILgzgService;

@Service
public class LgzgService extends BaseService implements ILgzgService {

	@Autowired
	private ILgzgMDAO lzzgMDAO;

	/** 插入 */
	@Override
	public LgzgMVO insert(LgzgMVO lzzg) throws SysException, AppException {
		lzzg.setCreateTime(DateUtil.nowTime());
		lzzg.setSts(STS_NORMAL);
		return lzzgMDAO.insert(lzzg);
	}

	/** 更新 */
	@Override
	public int update(LgzgMVO lzzg) throws SysException, AppException {
		lzzg.setUpdateTime(DateUtil.nowTime());
		return lzzgMDAO.update(lzzg);
	}

	/** 删除 */
	@Override
	public int delete(LgzgMVO lzzg) throws SysException, AppException {
		return lzzgMDAO.delete(lzzg);
	}

	/** 查询集合列表 */
	@Override
	public List<LgzgMVO> queryList(LgzgMVO lzzg) throws SysException, AppException {
		return lzzgMDAO.queryList(lzzg);
	}

	/** 查询对象 */
	@Override
	public LgzgMVO queryBean(LgzgMVO lzzg) throws SysException, AppException {
		return lzzgMDAO.queryBean(lzzg);
	}

	/** 分页查询 */
	@Override
	public PageInfo queryPage(LgzgMVO lzzg, PageInfo pagInfo) throws SysException, AppException {
		return lzzgMDAO.queryPage(lzzg, pagInfo);
	}

	@Override
	public PageInfo queryManageCommunityPage(LgzgMVO lzzg, PageInfo pageInfo) throws SysException, AppException {
		return lzzgMDAO.queryManageCommunityPage(lzzg, pageInfo);
	}

	@Override
	public PageInfo queryPageNotAdminCommuntiy(CommunityInfoMVO entity, PageInfo pageInfo) throws SysException {
		return lzzgMDAO.queryPageNotAdminCommuntiy(entity, pageInfo);
	}

}
