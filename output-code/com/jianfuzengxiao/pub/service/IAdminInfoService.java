package com.jianfuzengxiao.pub.service;import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.AdminInfoMVO;
import javax.jws.WebService;
import java.util.List;


@WebService
public interface IAdminInfoService extends IService {    /**保存数据*/
    public AdminInfoMVO insert(AdminInfoMVO entity) throws SysException, AppException;
    /**更新数据*/
    public int update(AdminInfoMVO entity) throws SysException, AppException;
   /**删除数据*/
    public int delete(AdminInfoMVO entity) throws SysException, AppException;
   /**查询集合*/
    public List<AdminInfoMVO> queryList(AdminInfoMVO entity) throws SysException, AppException;
   /**查询对象*/
    public AdminInfoMVO queryBean(AdminInfoMVO entity) throws SysException, AppException;
   /**分页查询*/
     public PageInfo queryPage(AdminInfoMVO entity, PageInfo pagInfo) throws SysException, AppException;


}
