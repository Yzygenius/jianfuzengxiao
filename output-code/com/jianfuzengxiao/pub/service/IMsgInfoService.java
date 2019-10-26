package com.jianfuzengxiao.pub.service;import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.MsgInfoMVO;
import javax.jws.WebService;
import java.util.List;


@WebService
public interface IMsgInfoService extends IService {    /**保存数据*/
    public MsgInfoMVO insert(MsgInfoMVO entity) throws SysException, AppException;
    /**更新数据*/
    public int update(MsgInfoMVO entity) throws SysException, AppException;
   /**删除数据*/
    public int delete(MsgInfoMVO entity) throws SysException, AppException;
   /**查询集合*/
    public List<MsgInfoMVO> queryList(MsgInfoMVO entity) throws SysException, AppException;
   /**查询对象*/
    public MsgInfoMVO queryBean(MsgInfoMVO entity) throws SysException, AppException;
   /**分页查询*/
     public PageInfo queryPage(MsgInfoMVO entity, PageInfo pagInfo) throws SysException, AppException;


}
