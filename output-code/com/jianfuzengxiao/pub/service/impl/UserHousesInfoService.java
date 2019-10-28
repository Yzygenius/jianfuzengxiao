package com.jianfuzengxiao.pub.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.IUserHousesInfoMDAO;
import com.jianfuzengxiao.pub.entity.UserHousesInfoMVO;
import com.jianfuzengxiao.pub.service.IUserHousesInfoService;


@Service
public class UserHousesInfoService extends BaseService implements IUserHousesInfoService {

@Autowired 
private IUserHousesInfoMDAO userHousesInfoMDAO; 		/**插入*/
	    @Override
	    public UserHousesInfoMVO insert(UserHousesInfoMVO userHousesInfo) throws SysException, AppException {
 		return userHousesInfoMDAO.insert(userHousesInfo);
     }
		/**更新*/
	    @Override
	    public int update(UserHousesInfoMVO userHousesInfo) throws SysException, AppException {
 		return userHousesInfoMDAO.update(userHousesInfo);
     }
		/**删除*/
	    @Override
	    public int delete(UserHousesInfoMVO userHousesInfo) throws SysException, AppException {
 		return userHousesInfoMDAO.delete(userHousesInfo);
     }
		/**查询集合列表*/
	    @Override
	     public List<UserHousesInfoMVO> queryList(UserHousesInfoMVO userHousesInfo) throws SysException, AppException {
 		return userHousesInfoMDAO.queryList(userHousesInfo);
     }
		/**查询对象*/
	    @Override
	     public UserHousesInfoMVO queryBean(UserHousesInfoMVO userHousesInfo) throws SysException, AppException {
 		 return userHousesInfoMDAO.queryBean(userHousesInfo);
     }
		/**分页查询*/
	    @Override
	     public PageInfo queryPage(UserHousesInfoMVO userHousesInfo, PageInfo pagInfo) throws SysException, AppException {
 		 return userHousesInfoMDAO.queryPage(userHousesInfo, pagInfo);
     }


}
