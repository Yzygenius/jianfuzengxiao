package com.jianfuzengxiao.pub.dao;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.AttachFileMVO;


public interface IAttachFileMDAO extends IAttachFileSDAO {
/**分页查询*/
public PageInfo queryPage(AttachFileMVO attachFile, PageInfo pagInfo) throws SysException;


}
