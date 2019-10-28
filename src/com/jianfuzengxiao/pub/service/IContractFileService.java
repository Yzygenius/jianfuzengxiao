package com.jianfuzengxiao.pub.service;import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.ContractFileMVO;
import javax.jws.WebService;
import java.util.List;


@WebService
public interface IContractFileService extends IService {    /**保存数据*/
    public ContractFileMVO insert(ContractFileMVO entity) throws SysException, AppException;
    /**更新数据*/
    public int update(ContractFileMVO entity) throws SysException, AppException;
   /**删除数据*/
    public int delete(ContractFileMVO entity) throws SysException, AppException;
   /**查询集合*/
    public List<ContractFileMVO> queryList(ContractFileMVO entity) throws SysException, AppException;
   /**查询对象*/
    public ContractFileMVO queryBean(ContractFileMVO entity) throws SysException, AppException;
   /**分页查询*/
     public PageInfo queryPage(ContractFileMVO entity, PageInfo pagInfo) throws SysException, AppException;


}
