package com.jianfuzengxiao.pub.service;import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.UserHousesInfoMVO;
import javax.jws.WebService;
import java.util.List;


@WebService
public interface IUserHousesInfoService extends IService {    /**保存数据*/
    public UserHousesInfoMVO insert(UserHousesInfoMVO entity) throws SysException, AppException;
    /**更新数据*/
    public int update(UserHousesInfoMVO entity) throws SysException, AppException;
   /**删除数据*/
    public int delete(UserHousesInfoMVO entity) throws SysException, AppException;
   /**查询集合*/
    public List<UserHousesInfoMVO> queryList(UserHousesInfoMVO entity) throws SysException, AppException;
   /**查询对象*/
    public UserHousesInfoMVO queryBean(UserHousesInfoMVO entity) throws SysException, AppException;
   /**分页查询*/
     public PageInfo queryPage(UserHousesInfoMVO entity, PageInfo pagInfo) throws SysException, AppException;


}
