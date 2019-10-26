package com.jianfuzengxiao.pub.service;import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.LiveTypeMVO;
import javax.jws.WebService;
import java.util.List;


@WebService
public interface ILiveTypeService extends IService {    /**保存数据*/
    public LiveTypeMVO insert(LiveTypeMVO entity) throws SysException, AppException;
    /**更新数据*/
    public int update(LiveTypeMVO entity) throws SysException, AppException;
   /**删除数据*/
    public int delete(LiveTypeMVO entity) throws SysException, AppException;
   /**查询集合*/
    public List<LiveTypeMVO> queryList(LiveTypeMVO entity) throws SysException, AppException;
   /**查询对象*/
    public LiveTypeMVO queryBean(LiveTypeMVO entity) throws SysException, AppException;
   /**分页查询*/
     public PageInfo queryPage(LiveTypeMVO entity, PageInfo pagInfo) throws SysException, AppException;


}
