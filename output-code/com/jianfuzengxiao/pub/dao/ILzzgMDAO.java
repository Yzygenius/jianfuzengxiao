package com.jianfuzengxiao.pub.dao;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.LzzgMVO;


public interface ILzzgMDAO extends ILzzgSDAO {
/**分页查询*/
public PageInfo queryPage(LzzgMVO lzzg, PageInfo pagInfo) throws SysException;


}
