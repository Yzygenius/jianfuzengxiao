package com.jianfuzengxiao.pub.dao;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.MsgInfoMVO;


public interface IMsgInfoMDAO extends IMsgInfoSDAO {
/**分页查询*/
public PageInfo queryPage(MsgInfoMVO msgInfo, PageInfo pagInfo) throws SysException;


}
