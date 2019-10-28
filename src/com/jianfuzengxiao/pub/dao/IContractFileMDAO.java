package com.jianfuzengxiao.pub.dao;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.ContractFileMVO;


public interface IContractFileMDAO extends IContractFileSDAO {
/**分页查询*/
public PageInfo queryPage(ContractFileMVO contractFile, PageInfo pagInfo) throws SysException;


}
