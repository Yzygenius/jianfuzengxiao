package com.jianfuzengxiao.pub.dao;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.GwhInfoMVO;


public interface IGwhInfoMDAO extends IGwhInfoSDAO {
/**分页查询*/
public PageInfo queryPage(GwhInfoMVO gwhInfo, PageInfo pagInfo) throws SysException;


}
