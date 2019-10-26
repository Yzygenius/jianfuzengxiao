package com.jianfuzengxiao.pub.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.IAttachFileMDAO;
import com.jianfuzengxiao.pub.entity.AttachFileMVO;
import com.jianfuzengxiao.pub.service.IAttachFileService;


@Service
public class AttachFileService extends BaseService implements IAttachFileService {

@Autowired 
private IAttachFileMDAO attachFileMDAO; 		/**插入*/
	    @Override
	    public AttachFileMVO insert(AttachFileMVO attachFile) throws SysException, AppException {
 		return attachFileMDAO.insert(attachFile);
     }
		/**更新*/
	    @Override
	    public int update(AttachFileMVO attachFile) throws SysException, AppException {
 		return attachFileMDAO.update(attachFile);
     }
		/**删除*/
	    @Override
	    public int delete(AttachFileMVO attachFile) throws SysException, AppException {
 		return attachFileMDAO.delete(attachFile);
     }
		/**查询集合列表*/
	    @Override
	     public List<AttachFileMVO> queryList(AttachFileMVO attachFile) throws SysException, AppException {
 		return attachFileMDAO.queryList(attachFile);
     }
		/**查询对象*/
	    @Override
	     public AttachFileMVO queryBean(AttachFileMVO attachFile) throws SysException, AppException {
 		 return attachFileMDAO.queryBean(attachFile);
     }
		/**分页查询*/
	    @Override
	     public PageInfo queryPage(AttachFileMVO attachFile, PageInfo pagInfo) throws SysException, AppException {
 		 return attachFileMDAO.queryPage(attachFile, pagInfo);
     }


}
