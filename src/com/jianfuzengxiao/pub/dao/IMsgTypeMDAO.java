package com.jianfuzengxiao.pub.dao;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.MsgTypeMVO;

public interface IMsgTypeMDAO extends IMsgTypeSDAO {
	/** 分页查询 */
	public PageInfo queryPage(MsgTypeMVO msgType, PageInfo pagInfo) throws SysException;

}
