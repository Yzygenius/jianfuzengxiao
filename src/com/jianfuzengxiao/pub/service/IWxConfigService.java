package com.jianfuzengxiao.pub.service;

import java.util.List;

import javax.jws.WebService;

import com.bamboo.framework.base.IService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.WxConfigMVO;

@WebService
public interface IWxConfigService extends IService {
	
	/** 保存数据 */
	public WxConfigMVO insert(WxConfigMVO entity) throws SysException, AppException;

	/** 更新数据 */
	public int update(WxConfigMVO entity) throws SysException, AppException;

	/** 删除数据 */
	public int delete(WxConfigMVO entity) throws SysException, AppException;

	/** 查询集合 */
	public List<WxConfigMVO> queryList(WxConfigMVO entity) throws SysException, AppException;

	/** 查询对象 */
	public WxConfigMVO queryBean(WxConfigMVO entity) throws SysException, AppException;

}
