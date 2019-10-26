package com.jianfuzengxiao.pub.service;import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.MsgTypeMVO;
import javax.jws.WebService;
import java.util.List;


@WebService
public interface IMsgTypeService extends IService {    /**保存数据*/
    public MsgTypeMVO insert(MsgTypeMVO entity) throws SysException, AppException;
    /**更新数据*/
    public int update(MsgTypeMVO entity) throws SysException, AppException;
   /**删除数据*/
    public int delete(MsgTypeMVO entity) throws SysException, AppException;
   /**查询集合*/
    public List<MsgTypeMVO> queryList(MsgTypeMVO entity) throws SysException, AppException;
   /**查询对象*/
    public MsgTypeMVO queryBean(MsgTypeMVO entity) throws SysException, AppException;
   /**分页查询*/
     public PageInfo queryPage(MsgTypeMVO entity, PageInfo pagInfo) throws SysException, AppException;


}
