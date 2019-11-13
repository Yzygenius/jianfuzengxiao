package com.jianfuzengxiao.pub.service;import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.LzzgMVO;
import javax.jws.WebService;
import java.util.List;


@WebService
public interface ILzzgService extends IService {    /**保存数据*/
    public LzzgMVO insert(LzzgMVO entity) throws SysException, AppException;
    /**更新数据*/
    public int update(LzzgMVO entity) throws SysException, AppException;
   /**删除数据*/
    public int delete(LzzgMVO entity) throws SysException, AppException;
   /**查询集合*/
    public List<LzzgMVO> queryList(LzzgMVO entity) throws SysException, AppException;
   /**查询对象*/
    public LzzgMVO queryBean(LzzgMVO entity) throws SysException, AppException;
   /**分页查询*/
     public PageInfo queryPage(LzzgMVO entity, PageInfo pagInfo) throws SysException, AppException;


}
