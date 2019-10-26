package com.jianfuzengxiao.pub.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.INationMDAO;
import com.jianfuzengxiao.pub.entity.NationMVO;
import com.jianfuzengxiao.pub.service.INationService;

@Service
public class NationService extends BaseService implements INationService {

	@Autowired
	private INationMDAO nationMDAO;

	/** 插入 */
	@Override
	public NationMVO insert(NationMVO nation) throws SysException, AppException {
		return nationMDAO.insert(nation);
	}

	/** 更新 */
	@Override
	public int update(NationMVO nation) throws SysException, AppException {
		return nationMDAO.update(nation);
	}

	/** 删除 */
	@Override
	public int delete(NationMVO nation) throws SysException, AppException {
		return nationMDAO.delete(nation);
	}

	/** 查询集合列表 */
	@Override
	public List<NationMVO> queryList(NationMVO nation) throws SysException, AppException {
		return nationMDAO.queryList(nation);
	}

	/** 查询对象 */
	@Override
	public NationMVO queryBean(NationMVO nation) throws SysException, AppException {
		return nationMDAO.queryBean(nation);
	}

	/** 分页查询 */
	@Override
	public PageInfo queryPage(NationMVO nation, PageInfo pagInfo) throws SysException, AppException {
		return nationMDAO.queryPage(nation, pagInfo);
	}

}
