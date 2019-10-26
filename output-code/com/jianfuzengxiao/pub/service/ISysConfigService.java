package com.jianfuzengxiao.pub.service;import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.SysConfigMVO;
import javax.jws.WebService;
import java.util.List;


@WebService
public interface ISysConfigService extends IService {    /**保存数据*/
    public SysConfigMVO insert(SysConfigMVO entity) throws SysException, AppException;
    /**更新数据*/
    public int update(SysConfigMVO entity) throws SysException, AppException;
   /**删除数据*/
    public int delete(SysConfigMVO entity) throws SysException, AppException;
   /**查询集合*/
    public List<SysConfigMVO> queryList(SysConfigMVO entity) throws SysException, AppException;
   /**查询对象*/
    public SysConfigMVO queryBean(SysConfigMVO entity) throws SysException, AppException;
   /**分页查询*/
     public PageInfo queryPage(SysConfigMVO entity, PageInfo pagInfo) throws SysException, AppException;


}
