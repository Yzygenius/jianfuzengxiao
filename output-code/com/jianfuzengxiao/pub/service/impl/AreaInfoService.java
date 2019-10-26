package com.jianfuzengxiao.pub.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.IAreaInfoMDAO;
import com.jianfuzengxiao.pub.entity.AreaInfoMVO;
import com.jianfuzengxiao.pub.service.IAreaInfoService;


@Service
public class AreaInfoService extends BaseService implements IAreaInfoService {

@Autowired 
private IAreaInfoMDAO areaInfoMDAO; 		/**插入*/
	    @Override
	    public AreaInfoMVO insert(AreaInfoMVO areaInfo) throws SysException, AppException {
 		return areaInfoMDAO.insert(areaInfo);
     }
		/**更新*/
	    @Override
	    public int update(AreaInfoMVO areaInfo) throws SysException, AppException {
 		return areaInfoMDAO.update(areaInfo);
     }
		/**删除*/
	    @Override
	    public int delete(AreaInfoMVO areaInfo) throws SysException, AppException {
 		return areaInfoMDAO.delete(areaInfo);
     }
		/**查询集合列表*/
	    @Override
	     public List<AreaInfoMVO> queryList(AreaInfoMVO areaInfo) throws SysException, AppException {
 		return areaInfoMDAO.queryList(areaInfo);
     }
		/**查询对象*/
	    @Override
	     public AreaInfoMVO queryBean(AreaInfoMVO areaInfo) throws SysException, AppException {
 		 return areaInfoMDAO.queryBean(areaInfo);
     }
		/**分页查询*/
	    @Override
	     public PageInfo queryPage(AreaInfoMVO areaInfo, PageInfo pagInfo) throws SysException, AppException {
 		 return areaInfoMDAO.queryPage(areaInfo, pagInfo);
     }


}
