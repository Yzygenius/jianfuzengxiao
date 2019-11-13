package com.jianfuzengxiao.pub.dao;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.LgzgMVO;


public interface ILgzgMDAO extends ILgzgSDAO {
/**分页查询*/
public PageInfo queryPage(LgzgMVO lgzg, PageInfo pagInfo) throws SysException;


}
