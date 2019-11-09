package com.jianfuzengxiao.pub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.base.utils.BigDouble;
import com.jianfuzengxiao.pub.dao.IStatisticsMDAO;
import com.jianfuzengxiao.pub.entity.Statistics;
import com.jianfuzengxiao.pub.service.IStatisticsService;

@Service
public class StatisticsService extends BaseService implements IStatisticsService {

	@Autowired
	private IStatisticsMDAO statisticsMDAO;

	@Override
	public Statistics queryHousesType(Statistics entity) throws SysException, AppException {
		return statisticsMDAO.queryHousesType(entity);
	}

	@Override
	public Statistics queryHousesRent(Statistics entity) throws SysException, AppException {
		entity = statisticsMDAO.queryHousesRent(entity);
		double total = Double.parseDouble(entity.getTotal());
		double rent = Double.parseDouble(entity.getRent());
		double waitrent = BigDouble.getMinusCount(total, rent);
		double rentratio = BigDouble.getRoundingCount(BigDouble.getDivisionCount(rent, total));
		double waitrentratio = BigDouble.getRoundingCount(BigDouble.getDivisionCount(waitrent, total));
		entity.setRentratio(BigDouble.scientificNotation(rentratio));
		entity.setWaitrent(BigDouble.scientificNotation(waitrent));
		entity.setWaitrentratio(BigDouble.scientificNotation(waitrentratio));
		return entity;
	}

	@Override
	public List<Statistics> queryHouseType(Statistics entity) throws SysException, AppException {
		return statisticsMDAO.queryHouseType(entity);
	}

	@Override
	public Statistics queryPersonnelType(Statistics entity) throws SysException, AppException {
		return statisticsMDAO.queryPersonnelType(entity);
	}

	@Override
	public Statistics queryPersonnelGender(Statistics entity) throws SysException, AppException {
		return statisticsMDAO.queryPersonnelGender(entity);
	}

	@Override
	public List<Statistics> queryPersonnelAge(Statistics entity) throws SysException, AppException {
		return statisticsMDAO.queryPersonnelAge(entity);
	}
}