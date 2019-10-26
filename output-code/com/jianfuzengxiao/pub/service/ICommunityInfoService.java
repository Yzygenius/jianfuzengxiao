package com.jianfuzengxiao.pub.service;import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.CommunityInfoMVO;
import javax.jws.WebService;
import java.util.List;


@WebService
public interface ICommunityInfoService extends IService {    /**保存数据*/
    public CommunityInfoMVO insert(CommunityInfoMVO entity) throws SysException, AppException;
    /**更新数据*/
    public int update(CommunityInfoMVO entity) throws SysException, AppException;
   /**删除数据*/
    public int delete(CommunityInfoMVO entity) throws SysException, AppException;
   /**查询集合*/
    public List<CommunityInfoMVO> queryList(CommunityInfoMVO entity) throws SysException, AppException;
   /**查询对象*/
    public CommunityInfoMVO queryBean(CommunityInfoMVO entity) throws SysException, AppException;
   /**分页查询*/
     public PageInfo queryPage(CommunityInfoMVO entity, PageInfo pagInfo) throws SysException, AppException;


}
