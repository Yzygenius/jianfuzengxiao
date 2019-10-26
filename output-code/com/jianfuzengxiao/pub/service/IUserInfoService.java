package com.jianfuzengxiao.pub.service;import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.UserInfoMVO;
import javax.jws.WebService;
import java.util.List;


@WebService
public interface IUserInfoService extends IService {    /**保存数据*/
    public UserInfoMVO insert(UserInfoMVO entity) throws SysException, AppException;
    /**更新数据*/
    public int update(UserInfoMVO entity) throws SysException, AppException;
   /**删除数据*/
    public int delete(UserInfoMVO entity) throws SysException, AppException;
   /**查询集合*/
    public List<UserInfoMVO> queryList(UserInfoMVO entity) throws SysException, AppException;
   /**查询对象*/
    public UserInfoMVO queryBean(UserInfoMVO entity) throws SysException, AppException;
   /**分页查询*/
     public PageInfo queryPage(UserInfoMVO entity, PageInfo pagInfo) throws SysException, AppException;


}
