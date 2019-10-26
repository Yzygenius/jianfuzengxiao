package com.jianfuzengxiao.pub.service;import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.AduitDistributionMVO;
import javax.jws.WebService;
import java.util.List;


@WebService
public interface IAduitDistributionService extends IService {    /**保存数据*/
    public AduitDistributionMVO insert(AduitDistributionMVO entity) throws SysException, AppException;
    /**更新数据*/
    public int update(AduitDistributionMVO entity) throws SysException, AppException;
   /**删除数据*/
    public int delete(AduitDistributionMVO entity) throws SysException, AppException;
   /**查询集合*/
    public List<AduitDistributionMVO> queryList(AduitDistributionMVO entity) throws SysException, AppException;
   /**查询对象*/
    public AduitDistributionMVO queryBean(AduitDistributionMVO entity) throws SysException, AppException;
   /**分页查询*/
     public PageInfo queryPage(AduitDistributionMVO entity, PageInfo pagInfo) throws SysException, AppException;


}
