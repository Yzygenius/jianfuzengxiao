package com.jianfuzengxiao.pub.service;import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.RoleInfoMVO;
import javax.jws.WebService;
import java.util.List;


@WebService
public interface IRoleInfoService extends IService {    /**保存数据*/
    public RoleInfoMVO insert(RoleInfoMVO entity) throws SysException, AppException;
    /**更新数据*/
    public int update(RoleInfoMVO entity) throws SysException, AppException;
   /**删除数据*/
    public int delete(RoleInfoMVO entity) throws SysException, AppException;
   /**查询集合*/
    public List<RoleInfoMVO> queryList(RoleInfoMVO entity) throws SysException, AppException;
   /**查询对象*/
    public RoleInfoMVO queryBean(RoleInfoMVO entity) throws SysException, AppException;
   /**分页查询*/
     public PageInfo queryPage(RoleInfoMVO entity, PageInfo pagInfo) throws SysException, AppException;


}
