package com.jianfuzengxiao.pub.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.common.util.DateUtil;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.IGwhInfoMDAO;
import com.jianfuzengxiao.pub.entity.GwhInfoMVO;
import com.jianfuzengxiao.pub.service.IGwhInfoService;

@Service
public class GwhInfoService extends BaseService implements IGwhInfoService {

	@Autowired
	private IGwhInfoMDAO gwhInfoMDAO;

	/** 插入 */
	@Override
	public GwhInfoMVO insert(GwhInfoMVO gwhInfo) throws SysException, AppException {
		gwhInfo.setCreateTime(DateUtil.nowTime());
		gwhInfo.setSts(STS_NORMAL);
		return gwhInfoMDAO.insert(gwhInfo);
	}

	/** 更新 */
	@Override
	public int update(GwhInfoMVO gwhInfo) throws SysException, AppException {
		gwhInfo.setUpdateTime(DateUtil.nowTime());
		return gwhInfoMDAO.update(gwhInfo);
	}

	/** 删除 */
	@Override
	public int delete(GwhInfoMVO gwhInfo) throws SysException, AppException {
		return gwhInfoMDAO.delete(gwhInfo);
	}

	/** 查询集合列表 */
	@Override
	public List<GwhInfoMVO> queryList(GwhInfoMVO gwhInfo) throws SysException, AppException {
		return gwhInfoMDAO.queryList(gwhInfo);
	}

	/** 查询对象 */
	@Override
	public GwhInfoMVO queryBean(GwhInfoMVO gwhInfo) throws SysException, AppException {
		return gwhInfoMDAO.queryBean(gwhInfo);
	}

	/** 分页查询 */
	@Override
	public PageInfo queryPage(GwhInfoMVO gwhInfo, PageInfo pagInfo) throws SysException, AppException {
		return gwhInfoMDAO.queryPage(gwhInfo, pagInfo);
	}

}
