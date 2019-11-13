package com.jianfuzengxiao.pub.service;import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.LgzgMVO;
import javax.jws.WebService;
import java.util.List;


@WebService
public interface ILgzgService extends IService {    /**保存数据*/
    public LgzgMVO insert(LgzgMVO entity) throws SysException, AppException;
    /**更新数据*/
    public int update(LgzgMVO entity) throws SysException, AppException;
   /**删除数据*/
    public int delete(LgzgMVO entity) throws SysException, AppException;
   /**查询集合*/
    public List<LgzgMVO> queryList(LgzgMVO entity) throws SysException, AppException;
   /**查询对象*/
    public LgzgMVO queryBean(LgzgMVO entity) throws SysException, AppException;
   /**分页查询*/
     public PageInfo queryPage(LgzgMVO entity, PageInfo pagInfo) throws SysException, AppException;


}
