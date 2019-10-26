package com.jianfuzengxiao.pub.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.ICertificatesTypeMDAO;
import com.jianfuzengxiao.pub.entity.CertificatesTypeMVO;
import com.jianfuzengxiao.pub.service.ICertificatesTypeService;


@Service
public class CertificatesTypeService extends BaseService implements ICertificatesTypeService {

@Autowired 
private ICertificatesTypeMDAO certificatesTypeMDAO; 		/**插入*/
	    @Override
	    public CertificatesTypeMVO insert(CertificatesTypeMVO certificatesType) throws SysException, AppException {
 		return certificatesTypeMDAO.insert(certificatesType);
     }
		/**更新*/
	    @Override
	    public int update(CertificatesTypeMVO certificatesType) throws SysException, AppException {
 		return certificatesTypeMDAO.update(certificatesType);
     }
		/**删除*/
	    @Override
	    public int delete(CertificatesTypeMVO certificatesType) throws SysException, AppException {
 		return certificatesTypeMDAO.delete(certificatesType);
     }
		/**查询集合列表*/
	    @Override
	     public List<CertificatesTypeMVO> queryList(CertificatesTypeMVO certificatesType) throws SysException, AppException {
 		return certificatesTypeMDAO.queryList(certificatesType);
     }
		/**查询对象*/
	    @Override
	     public CertificatesTypeMVO queryBean(CertificatesTypeMVO certificatesType) throws SysException, AppException {
 		 return certificatesTypeMDAO.queryBean(certificatesType);
     }
		/**分页查询*/
	    @Override
	     public PageInfo queryPage(CertificatesTypeMVO certificatesType, PageInfo pagInfo) throws SysException, AppException {
 		 return certificatesTypeMDAO.queryPage(certificatesType, pagInfo);
     }


}
