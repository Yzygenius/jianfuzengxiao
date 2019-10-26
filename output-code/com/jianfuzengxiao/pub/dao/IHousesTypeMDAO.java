package com.jianfuzengxiao.pub.dao;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.HousesTypeMVO;


public interface IHousesTypeMDAO extends IHousesTypeSDAO {
/**分页查询*/
public PageInfo queryPage(HousesTypeMVO housesType, PageInfo pagInfo) throws SysException;


}
