package com.jianfuzengxiao.pub.service;

import java.util.List;

import javax.jws.WebService;

import com.bamboo.framework.base.IService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.entity.PersonnelInfoMVO;

@WebService
public interface IExcelImportService extends IService {

	public boolean addPersonnelExcel(String filePath) throws Exception;
}
