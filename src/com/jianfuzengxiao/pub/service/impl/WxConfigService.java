package com.jianfuzengxiao.pub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.common.util.DateUtil;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IWxConfigMDAO;
import com.jianfuzengxiao.pub.entity.WxConfigMVO;
import com.jianfuzengxiao.pub.service.IWxConfigService;

@Service
public class WxConfigService extends BaseService implements IWxConfigService {

	@Autowired
	private IWxConfigMDAO wxConfigMDAO;
	
	@Override
	public WxConfigMVO insert(WxConfigMVO entity) throws SysException, AppException {
		return wxConfigMDAO.insert(entity);
	}

	@Override
	public int update(WxConfigMVO entity) throws SysException, AppException {
		entity.setUpdateTime(DateUtil.nowTime());
		return wxConfigMDAO.update(entity);
	}

	@Override
	public int delete(WxConfigMVO entity) throws SysException, AppException {
		return wxConfigMDAO.delete(entity);
	}

	@Override
	public List<WxConfigMVO> queryList(WxConfigMVO entity) throws SysException, AppException {
		return wxConfigMDAO.queryList(entity);
	}

	@Override
	public WxConfigMVO queryBean(WxConfigMVO entity) throws SysException, AppException {
		return wxConfigMDAO.queryBean(entity);
	}

}
