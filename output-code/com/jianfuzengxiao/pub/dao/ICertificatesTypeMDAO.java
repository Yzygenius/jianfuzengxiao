package com.jianfuzengxiao.pub.dao;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.CertificatesTypeMVO;


public interface ICertificatesTypeMDAO extends ICertificatesTypeSDAO {
/**分页查询*/
public PageInfo queryPage(CertificatesTypeMVO certificatesType, PageInfo pagInfo) throws SysException;


}
