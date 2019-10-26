package com.jianfuzengxiao.pub.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.IRoleInfoMDAO;
import com.jianfuzengxiao.pub.entity.RoleInfoMVO;
import com.jianfuzengxiao.pub.service.IRoleInfoService;


@Service
public class RoleInfoService extends BaseService implements IRoleInfoService {

@Autowired 
private IRoleInfoMDAO roleInfoMDAO; 		/**插入*/
	    @Override
	    public RoleInfoMVO insert(RoleInfoMVO roleInfo) throws SysException, AppException {
 		return roleInfoMDAO.insert(roleInfo);
     }
		/**更新*/
	    @Override
	    public int update(RoleInfoMVO roleInfo) throws SysException, AppException {
 		return roleInfoMDAO.update(roleInfo);
     }
		/**删除*/
	    @Override
	    public int delete(RoleInfoMVO roleInfo) throws SysException, AppException {
 		return roleInfoMDAO.delete(roleInfo);
     }
		/**查询集合列表*/
	    @Override
	     public List<RoleInfoMVO> queryList(RoleInfoMVO roleInfo) throws SysException, AppException {
 		return roleInfoMDAO.queryList(roleInfo);
     }
		/**查询对象*/
	    @Override
	     public RoleInfoMVO queryBean(RoleInfoMVO roleInfo) throws SysException, AppException {
 		 return roleInfoMDAO.queryBean(roleInfo);
     }
		/**分页查询*/
	    @Override
	     public PageInfo queryPage(RoleInfoMVO roleInfo, PageInfo pagInfo) throws SysException, AppException {
 		 return roleInfoMDAO.queryPage(roleInfo, pagInfo);
     }


}
