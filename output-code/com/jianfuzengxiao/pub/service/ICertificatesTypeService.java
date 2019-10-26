package com.jianfuzengxiao.pub.service;import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.CertificatesTypeMVO;
import javax.jws.WebService;
import java.util.List;


@WebService
public interface ICertificatesTypeService extends IService {    /**保存数据*/
    public CertificatesTypeMVO insert(CertificatesTypeMVO entity) throws SysException, AppException;
    /**更新数据*/
    public int update(CertificatesTypeMVO entity) throws SysException, AppException;
   /**删除数据*/
    public int delete(CertificatesTypeMVO entity) throws SysException, AppException;
   /**查询集合*/
    public List<CertificatesTypeMVO> queryList(CertificatesTypeMVO entity) throws SysException, AppException;
   /**查询对象*/
    public CertificatesTypeMVO queryBean(CertificatesTypeMVO entity) throws SysException, AppException;
   /**分页查询*/
     public PageInfo queryPage(CertificatesTypeMVO entity, PageInfo pagInfo) throws SysException, AppException;


}
