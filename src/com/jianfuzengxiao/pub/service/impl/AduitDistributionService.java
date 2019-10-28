package com.jianfuzengxiao.pub.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.common.util.DateUtil;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.IAduitDistributionMDAO;
import com.jianfuzengxiao.pub.entity.AduitDistributionMVO;
import com.jianfuzengxiao.pub.service.IAduitDistributionService;

@Service
public class AduitDistributionService extends BaseService implements IAduitDistributionService {

	@Autowired
	private IAduitDistributionMDAO aduitDistributionMDAO;

	/** 插入 */
	@Override
	public AduitDistributionMVO insert(AduitDistributionMVO aduitDistribution) throws SysException, AppException {
		aduitDistribution.setCreateTime(DateUtil.nowTime());
		aduitDistribution.setSts(STS_NORMAL);
		return aduitDistributionMDAO.insert(aduitDistribution);
	}

	/** 更新 */
	@Override
	public int update(AduitDistributionMVO aduitDistribution) throws SysException, AppException {
		aduitDistribution.setUpdateTime(DateUtil.nowTime());
		return aduitDistributionMDAO.update(aduitDistribution);
	}

	/** 删除 */
	@Override
	public int delete(AduitDistributionMVO aduitDistribution) throws SysException, AppException {
		return aduitDistributionMDAO.delete(aduitDistribution);
	}

	/** 查询集合列表 */
	@Override
	public List<AduitDistributionMVO> queryList(AduitDistributionMVO aduitDistribution)
			throws SysException, AppException {
		return aduitDistributionMDAO.queryList(aduitDistribution);
	}

	/** 查询对象 */
	@Override
	public AduitDistributionMVO queryBean(AduitDistributionMVO aduitDistribution) throws SysException, AppException {
		return aduitDistributionMDAO.queryBean(aduitDistribution);
	}

	/** 分页查询 */
	@Override
	public PageInfo queryPage(AduitDistributionMVO aduitDistribution, PageInfo pagInfo)
			throws SysException, AppException {
		return aduitDistributionMDAO.queryPage(aduitDistribution, pagInfo);
	}

}
