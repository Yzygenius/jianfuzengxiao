package com.jianfuzengxiao.pub.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.IPersonnelInfoMDAO;
import com.jianfuzengxiao.pub.entity.PersonnelInfoMVO;
import com.jianfuzengxiao.pub.service.IPersonnelInfoService;


@Service
public class PersonnelInfoService extends BaseService implements IPersonnelInfoService {

@Autowired 
private IPersonnelInfoMDAO personnelInfoMDAO; 		/**插入*/
	    @Override
	    public PersonnelInfoMVO insert(PersonnelInfoMVO personnelInfo) throws SysException, AppException {
 		return personnelInfoMDAO.insert(personnelInfo);
     }
		/**更新*/
	    @Override
	    public int update(PersonnelInfoMVO personnelInfo) throws SysException, AppException {
 		return personnelInfoMDAO.update(personnelInfo);
     }
		/**删除*/
	    @Override
	    public int delete(PersonnelInfoMVO personnelInfo) throws SysException, AppException {
 		return personnelInfoMDAO.delete(personnelInfo);
     }
		/**查询集合列表*/
	    @Override
	     public List<PersonnelInfoMVO> queryList(PersonnelInfoMVO personnelInfo) throws SysException, AppException {
 		return personnelInfoMDAO.queryList(personnelInfo);
     }
		/**查询对象*/
	    @Override
	     public PersonnelInfoMVO queryBean(PersonnelInfoMVO personnelInfo) throws SysException, AppException {
 		 return personnelInfoMDAO.queryBean(personnelInfo);
     }
		/**分页查询*/
	    @Override
	     public PageInfo queryPage(PersonnelInfoMVO personnelInfo, PageInfo pagInfo) throws SysException, AppException {
 		 return personnelInfoMDAO.queryPage(personnelInfo, pagInfo);
     }


}
