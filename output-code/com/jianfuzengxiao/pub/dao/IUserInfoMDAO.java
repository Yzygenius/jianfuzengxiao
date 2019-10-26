package com.jianfuzengxiao.pub.dao;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.UserInfoMVO;


public interface IUserInfoMDAO extends IUserInfoSDAO {
/**分页查询*/
public PageInfo queryPage(UserInfoMVO userInfo, PageInfo pagInfo) throws SysException;


}
