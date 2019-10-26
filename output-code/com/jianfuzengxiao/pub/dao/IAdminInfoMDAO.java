package com.jianfuzengxiao.pub.dao;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.AdminInfoMVO;


public interface IAdminInfoMDAO extends IAdminInfoSDAO {
/**分页查询*/
public PageInfo queryPage(AdminInfoMVO adminInfo, PageInfo pagInfo) throws SysException;


}
