package com.jianfuzengxiao.pub.service;

import com.bamboo.framework.base.IService;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.AttachFileMVO;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface IAttachFileService extends IService {
	/** 保存数据 */
	public AttachFileMVO insert(AttachFileMVO entity) throws SysException, AppException;

	/** 更新数据 */
	public int update(AttachFileMVO entity) throws SysException, AppException;

	/** 删除数据 */
	public int delete(AttachFileMVO entity) throws SysException, AppException;

	/** 查询集合 */
	public List<AttachFileMVO> queryList(AttachFileMVO entity) throws SysException, AppException;

	/** 查询对象 */
	public AttachFileMVO queryBean(AttachFileMVO entity) throws SysException, AppException;

	/** 分页查询 */
	public PageInfo queryPage(AttachFileMVO entity, PageInfo pagInfo) throws SysException, AppException;

}
