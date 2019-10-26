package com.jianfuzengxiao.pub.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.IMsgTypeMDAO;
import com.jianfuzengxiao.pub.entity.MsgTypeMVO;
import com.jianfuzengxiao.pub.service.IMsgTypeService;


@Service
public class MsgTypeService extends BaseService implements IMsgTypeService {

@Autowired 
private IMsgTypeMDAO msgTypeMDAO; 		/**插入*/
	    @Override
	    public MsgTypeMVO insert(MsgTypeMVO msgType) throws SysException, AppException {
 		return msgTypeMDAO.insert(msgType);
     }
		/**更新*/
	    @Override
	    public int update(MsgTypeMVO msgType) throws SysException, AppException {
 		return msgTypeMDAO.update(msgType);
     }
		/**删除*/
	    @Override
	    public int delete(MsgTypeMVO msgType) throws SysException, AppException {
 		return msgTypeMDAO.delete(msgType);
     }
		/**查询集合列表*/
	    @Override
	     public List<MsgTypeMVO> queryList(MsgTypeMVO msgType) throws SysException, AppException {
 		return msgTypeMDAO.queryList(msgType);
     }
		/**查询对象*/
	    @Override
	     public MsgTypeMVO queryBean(MsgTypeMVO msgType) throws SysException, AppException {
 		 return msgTypeMDAO.queryBean(msgType);
     }
		/**分页查询*/
	    @Override
	     public PageInfo queryPage(MsgTypeMVO msgType, PageInfo pagInfo) throws SysException, AppException {
 		 return msgTypeMDAO.queryPage(msgType, pagInfo);
     }


}
