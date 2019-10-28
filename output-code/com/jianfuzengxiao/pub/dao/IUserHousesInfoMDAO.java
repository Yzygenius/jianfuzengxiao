package com.jianfuzengxiao.pub.dao;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.UserHousesInfoMVO;


public interface IUserHousesInfoMDAO extends IUserHousesInfoSDAO {
/**分页查询*/
public PageInfo queryPage(UserHousesInfoMVO userHousesInfo, PageInfo pagInfo) throws SysException;


}
