package com.jianfuzengxiao.pub.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.ILzzgMDAO;
import com.jianfuzengxiao.pub.entity.LzzgMVO;
import com.jianfuzengxiao.pub.service.ILzzgService;


@Service
public class LzzgService extends BaseService implements ILzzgService {

@Autowired 
private ILzzgMDAO lzzgMDAO; 		/**插入*/
	    @Override
	    public LzzgMVO insert(LzzgMVO lzzg) throws SysException, AppException {
 		return lzzgMDAO.insert(lzzg);
     }
		/**更新*/
	    @Override
	    public int update(LzzgMVO lzzg) throws SysException, AppException {
 		return lzzgMDAO.update(lzzg);
     }
		/**删除*/
	    @Override
	    public int delete(LzzgMVO lzzg) throws SysException, AppException {
 		return lzzgMDAO.delete(lzzg);
     }
		/**查询集合列表*/
	    @Override
	     public List<LzzgMVO> queryList(LzzgMVO lzzg) throws SysException, AppException {
 		return lzzgMDAO.queryList(lzzg);
     }
		/**查询对象*/
	    @Override
	     public LzzgMVO queryBean(LzzgMVO lzzg) throws SysException, AppException {
 		 return lzzgMDAO.queryBean(lzzg);
     }
		/**分页查询*/
	    @Override
	     public PageInfo queryPage(LzzgMVO lzzg, PageInfo pagInfo) throws SysException, AppException {
 		 return lzzgMDAO.queryPage(lzzg, pagInfo);
     }


}
