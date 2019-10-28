package com.jianfuzengxiao.pub.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.IContractFileMDAO;
import com.jianfuzengxiao.pub.entity.ContractFileMVO;
import com.jianfuzengxiao.pub.service.IContractFileService;


@Service
public class ContractFileService extends BaseService implements IContractFileService {

@Autowired 
private IContractFileMDAO contractFileMDAO; 		/**插入*/
	    @Override
	    public ContractFileMVO insert(ContractFileMVO contractFile) throws SysException, AppException {
 		return contractFileMDAO.insert(contractFile);
     }
		/**更新*/
	    @Override
	    public int update(ContractFileMVO contractFile) throws SysException, AppException {
 		return contractFileMDAO.update(contractFile);
     }
		/**删除*/
	    @Override
	    public int delete(ContractFileMVO contractFile) throws SysException, AppException {
 		return contractFileMDAO.delete(contractFile);
     }
		/**查询集合列表*/
	    @Override
	     public List<ContractFileMVO> queryList(ContractFileMVO contractFile) throws SysException, AppException {
 		return contractFileMDAO.queryList(contractFile);
     }
		/**查询对象*/
	    @Override
	     public ContractFileMVO queryBean(ContractFileMVO contractFile) throws SysException, AppException {
 		 return contractFileMDAO.queryBean(contractFile);
     }
		/**分页查询*/
	    @Override
	     public PageInfo queryPage(ContractFileMVO contractFile, PageInfo pagInfo) throws SysException, AppException {
 		 return contractFileMDAO.queryPage(contractFile, pagInfo);
     }


}
