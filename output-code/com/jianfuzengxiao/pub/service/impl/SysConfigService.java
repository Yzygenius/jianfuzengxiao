package com.jianfuzengxiao.pub.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.ISysConfigMDAO;
import com.jianfuzengxiao.pub.entity.SysConfigMVO;
import com.jianfuzengxiao.pub.service.ISysConfigService;


@Service
public class SysConfigService extends BaseService implements ISysConfigService {

@Autowired 
private ISysConfigMDAO sysConfigMDAO; 		/**插入*/
	    @Override
	    public SysConfigMVO insert(SysConfigMVO sysConfig) throws SysException, AppException {
 		return sysConfigMDAO.insert(sysConfig);
     }
		/**更新*/
	    @Override
	    public int update(SysConfigMVO sysConfig) throws SysException, AppException {
 		return sysConfigMDAO.update(sysConfig);
     }
		/**删除*/
	    @Override
	    public int delete(SysConfigMVO sysConfig) throws SysException, AppException {
 		return sysConfigMDAO.delete(sysConfig);
     }
		/**查询集合列表*/
	    @Override
	     public List<SysConfigMVO> queryList(SysConfigMVO sysConfig) throws SysException, AppException {
 		return sysConfigMDAO.queryList(sysConfig);
     }
		/**查询对象*/
	    @Override
	     public SysConfigMVO queryBean(SysConfigMVO sysConfig) throws SysException, AppException {
 		 return sysConfigMDAO.queryBean(sysConfig);
     }
		/**分页查询*/
	    @Override
	     public PageInfo queryPage(SysConfigMVO sysConfig, PageInfo pagInfo) throws SysException, AppException {
 		 return sysConfigMDAO.queryPage(sysConfig, pagInfo);
     }


}
