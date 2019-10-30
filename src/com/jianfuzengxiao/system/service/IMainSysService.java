package com.jianfuzengxiao.system.service;

import com.bamboo.framework.base.IService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.AdminInfoMVO;

public interface IMainSysService extends IService {

	/**
	 * 用户登录
	 * @param userInfo
	 * @return
	 * @throws SysException
	 * @throws AppException
	 */
    public boolean login(AdminInfoMVO adminInfo) throws SysException, AppException;
    
    /**
     * 退出登录
     * @throws SysException
     * @throws AppException
     */
    public void logout() throws SysException, AppException;
}
