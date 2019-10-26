package com.jianfuzengxiao.pub.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.IHousesTypeMDAO;
import com.jianfuzengxiao.pub.entity.HousesTypeMVO;
import com.jianfuzengxiao.pub.service.IHousesTypeService;


@Service
public class HousesTypeService extends BaseService implements IHousesTypeService {

@Autowired 
private IHousesTypeMDAO housesTypeMDAO; 		/**插入*/
	    @Override
	    public HousesTypeMVO insert(HousesTypeMVO housesType) throws SysException, AppException {
 		return housesTypeMDAO.insert(housesType);
     }
		/**更新*/
	    @Override
	    public int update(HousesTypeMVO housesType) throws SysException, AppException {
 		return housesTypeMDAO.update(housesType);
     }
		/**删除*/
	    @Override
	    public int delete(HousesTypeMVO housesType) throws SysException, AppException {
 		return housesTypeMDAO.delete(housesType);
     }
		/**查询集合列表*/
	    @Override
	     public List<HousesTypeMVO> queryList(HousesTypeMVO housesType) throws SysException, AppException {
 		return housesTypeMDAO.queryList(housesType);
     }
		/**查询对象*/
	    @Override
	     public HousesTypeMVO queryBean(HousesTypeMVO housesType) throws SysException, AppException {
 		 return housesTypeMDAO.queryBean(housesType);
     }
		/**分页查询*/
	    @Override
	     public PageInfo queryPage(HousesTypeMVO housesType, PageInfo pagInfo) throws SysException, AppException {
 		 return housesTypeMDAO.queryPage(housesType, pagInfo);
     }


}
