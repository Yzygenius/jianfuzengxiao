package com.jianfuzengxiao.pub.dao;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.LiveTypeMVO;

public interface ILiveTypeMDAO extends ILiveTypeSDAO {
	/** 分页查询 */
	public PageInfo queryPage(LiveTypeMVO liveType, PageInfo pagInfo) throws SysException;

}
