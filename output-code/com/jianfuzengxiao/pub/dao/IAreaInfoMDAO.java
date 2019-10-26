package com.jianfuzengxiao.pub.dao;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.AreaInfoMVO;


public interface IAreaInfoMDAO extends IAreaInfoSDAO {
/**分页查询*/
public PageInfo queryPage(AreaInfoMVO areaInfo, PageInfo pagInfo) throws SysException;


}
