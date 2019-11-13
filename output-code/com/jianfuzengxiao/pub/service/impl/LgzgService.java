package com.jianfuzengxiao.pub.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.ILgzgMDAO;
import com.jianfuzengxiao.pub.entity.LgzgMVO;
import com.jianfuzengxiao.pub.service.ILgzgService;


@Service
public class LgzgService extends BaseService implements ILgzgService {

@Autowired 
private ILgzgMDAO lgzgMDAO; 		/**插入*/
	    @Override
	    public LgzgMVO insert(LgzgMVO lgzg) throws SysException, AppException {
 		return lgzgMDAO.insert(lgzg);
     }
		/**更新*/
	    @Override
	    public int update(LgzgMVO lgzg) throws SysException, AppException {
 		return lgzgMDAO.update(lgzg);
     }
		/**删除*/
	    @Override
	    public int delete(LgzgMVO lgzg) throws SysException, AppException {
 		return lgzgMDAO.delete(lgzg);
     }
		/**查询集合列表*/
	    @Override
	     public List<LgzgMVO> queryList(LgzgMVO lgzg) throws SysException, AppException {
 		return lgzgMDAO.queryList(lgzg);
     }
		/**查询对象*/
	    @Override
	     public LgzgMVO queryBean(LgzgMVO lgzg) throws SysException, AppException {
 		 return lgzgMDAO.queryBean(lgzg);
     }
		/**分页查询*/
	    @Override
	     public PageInfo queryPage(LgzgMVO lgzg, PageInfo pagInfo) throws SysException, AppException {
 		 return lgzgMDAO.queryPage(lgzg, pagInfo);
     }


}
