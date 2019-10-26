package com.jianfuzengxiao.pub.dao;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.RoleInfoMVO;


public interface IRoleInfoMDAO extends IRoleInfoSDAO {
/**分页查询*/
public PageInfo queryPage(RoleInfoMVO roleInfo, PageInfo pagInfo) throws SysException;


}
