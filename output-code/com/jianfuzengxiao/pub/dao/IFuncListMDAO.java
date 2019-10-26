package com.jianfuzengxiao.pub.dao;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.FuncListMVO;


public interface IFuncListMDAO extends IFuncListSDAO {
/**分页查询*/
public PageInfo queryPage(FuncListMVO funcList, PageInfo pagInfo) throws SysException;


}
