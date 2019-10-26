package com.jianfuzengxiao.pub.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.IFuncListMDAO;
import com.jianfuzengxiao.pub.entity.FuncListMVO;
import com.jianfuzengxiao.pub.service.IFuncListService;


@Service
public class FuncListService extends BaseService implements IFuncListService {

@Autowired 
private IFuncListMDAO funcListMDAO; 		/**插入*/
	    @Override
	    public FuncListMVO insert(FuncListMVO funcList) throws SysException, AppException {
 		return funcListMDAO.insert(funcList);
     }
		/**更新*/
	    @Override
	    public int update(FuncListMVO funcList) throws SysException, AppException {
 		return funcListMDAO.update(funcList);
     }
		/**删除*/
	    @Override
	    public int delete(FuncListMVO funcList) throws SysException, AppException {
 		return funcListMDAO.delete(funcList);
     }
		/**查询集合列表*/
	    @Override
	     public List<FuncListMVO> queryList(FuncListMVO funcList) throws SysException, AppException {
 		return funcListMDAO.queryList(funcList);
     }
		/**查询对象*/
	    @Override
	     public FuncListMVO queryBean(FuncListMVO funcList) throws SysException, AppException {
 		 return funcListMDAO.queryBean(funcList);
     }
		/**分页查询*/
	    @Override
	     public PageInfo queryPage(FuncListMVO funcList, PageInfo pagInfo) throws SysException, AppException {
 		 return funcListMDAO.queryPage(funcList, pagInfo);
     }


}
