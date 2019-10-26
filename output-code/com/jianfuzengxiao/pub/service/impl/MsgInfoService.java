package com.jianfuzengxiao.pub.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.IMsgInfoMDAO;
import com.jianfuzengxiao.pub.entity.MsgInfoMVO;
import com.jianfuzengxiao.pub.service.IMsgInfoService;


@Service
public class MsgInfoService extends BaseService implements IMsgInfoService {

@Autowired 
private IMsgInfoMDAO msgInfoMDAO; 		/**插入*/
	    @Override
	    public MsgInfoMVO insert(MsgInfoMVO msgInfo) throws SysException, AppException {
 		return msgInfoMDAO.insert(msgInfo);
     }
		/**更新*/
	    @Override
	    public int update(MsgInfoMVO msgInfo) throws SysException, AppException {
 		return msgInfoMDAO.update(msgInfo);
     }
		/**删除*/
	    @Override
	    public int delete(MsgInfoMVO msgInfo) throws SysException, AppException {
 		return msgInfoMDAO.delete(msgInfo);
     }
		/**查询集合列表*/
	    @Override
	     public List<MsgInfoMVO> queryList(MsgInfoMVO msgInfo) throws SysException, AppException {
 		return msgInfoMDAO.queryList(msgInfo);
     }
		/**查询对象*/
	    @Override
	     public MsgInfoMVO queryBean(MsgInfoMVO msgInfo) throws SysException, AppException {
 		 return msgInfoMDAO.queryBean(msgInfo);
     }
		/**分页查询*/
	    @Override
	     public PageInfo queryPage(MsgInfoMVO msgInfo, PageInfo pagInfo) throws SysException, AppException {
 		 return msgInfoMDAO.queryPage(msgInfo, pagInfo);
     }


}
