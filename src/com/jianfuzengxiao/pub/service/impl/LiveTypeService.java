package com.jianfuzengxiao.pub.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.ILiveTypeMDAO;
import com.jianfuzengxiao.pub.entity.LiveTypeMVO;
import com.jianfuzengxiao.pub.service.ILiveTypeService;

@Service
public class LiveTypeService extends BaseService implements ILiveTypeService {

	@Autowired
	private ILiveTypeMDAO liveTypeMDAO;

	/** 插入 */
	@Override
	public LiveTypeMVO insert(LiveTypeMVO liveType) throws SysException, AppException {
		return liveTypeMDAO.insert(liveType);
	}

	/** 更新 */
	@Override
	public int update(LiveTypeMVO liveType) throws SysException, AppException {
		return liveTypeMDAO.update(liveType);
	}

	/** 删除 */
	@Override
	public int delete(LiveTypeMVO liveType) throws SysException, AppException {
		return liveTypeMDAO.delete(liveType);
	}

	/** 查询集合列表 */
	@Override
	public List<LiveTypeMVO> queryList(LiveTypeMVO liveType) throws SysException, AppException {
		return liveTypeMDAO.queryList(liveType);
	}

	/** 查询对象 */
	@Override
	public LiveTypeMVO queryBean(LiveTypeMVO liveType) throws SysException, AppException {
		return liveTypeMDAO.queryBean(liveType);
	}

	/** 分页查询 */
	@Override
	public PageInfo queryPage(LiveTypeMVO liveType, PageInfo pagInfo) throws SysException, AppException {
		return liveTypeMDAO.queryPage(liveType, pagInfo);
	}

}
