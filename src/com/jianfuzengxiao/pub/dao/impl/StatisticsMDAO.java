package com.jianfuzengxiao.pub.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.bamboo.framework.base.impl.BaseDAO;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IStatisticsMDAO;
import com.jianfuzengxiao.pub.entity.FuncListMVO;
import com.jianfuzengxiao.pub.entity.Statistics;

@Repository
public class StatisticsMDAO extends BaseDAO<Statistics> implements IStatisticsMDAO {
	private static Logger logger = LoggerFactory.getLogger(StatisticsMDAO.class);

	@Override
	public Statistics queryHousesType(Statistics entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ifnull(COUNT(houses_id),0)total ");
		sql.append(",sum(case when houses_type_id='1' then 1 else 0 end) zjf,cast((sum(case when houses_type_id='1' then 1 else 0 end)/COUNT(houses_id)) as decimal(18,2))*100 as zjfratio ");
		sql.append(",sum(case when houses_type_id='2' then 1 else 0 end) szf,cast((sum(case when houses_type_id='2' then 1 else 0 end)/COUNT(houses_id)) as decimal(18,2))*100 as szfratio ");
		sql.append(",sum(case when houses_type_id='3' then 1 else 0 end) sp,cast((sum(case when houses_type_id='3' then 1 else 0 end)/COUNT(houses_id)) as decimal(18,2))*100 as spratio ");
		sql.append("FROM  houses_info ");
		sql.append("WHERE sts='A' ");
		List<Statistics> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND community_id in ("+entity.getCommunityId()+")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
					sql.append(" AND community_street_id in ("+entity.getCommunityStreetId()+")");
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<Statistics>(Statistics.class));
			if (resultList.size() > 0) {
				entity = resultList.get(0);
			}else{
				return null;
			}
		} catch (DataAccessException e) {
			logger.error("查询统计错误：{}", e.getMessage());
			throw new SysException("查询统计错误", "10000", e);
		}
		return entity;
	}

	@Override
	public Statistics queryHousesRent(Statistics entity) throws SysException, AppException {
		StringBuilder sql = new StringBuilder();
		sql.append("select COUNT(*) as 'total', ");
		sql.append("(select COUNT(*) ");
		sql.append("from personnel_info where sts ='A' and live_type_id in ('3','4'))as 'rent' ");
		sql.append("from houses_info b ");
		sql.append("WHERE b.sts='A' ");
		List<Statistics> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND b.community_id in ("+entity.getCommunityId()+")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
					sql.append(" AND b.community_street_id in ("+entity.getCommunityStreetId()+")");
				}
				if (StringUtils.isNotBlank(entity.getHousesTypeId())) {
					sql.append(" AND b.houses_type_id in ("+entity.getHousesTypeId()+")");
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<Statistics>(Statistics.class));
			if (resultList.size() > 0) {
				entity = resultList.get(0);
			}else{
				return null;
			}
		} catch (DataAccessException e) {
			logger.error("查询统计错误：{}", e.getMessage());
			throw new SysException("查询统计错误", "10000", e);
		}
		return entity;
	}

	@Override
	public List<Statistics> queryHouseType(Statistics entity) throws SysException, AppException {
		/*StringBuilder sql = new StringBuilder();
		sql.append("select COUNT(*) as 'total', ");
		sql.append("(select COUNT(*) ");
		sql.append("from personnel_info where sts ='A' and live_type_id in ('3','4'))as 'rent' ");
		sql.append("from houses_info b ");
		sql.append("WHERE b.sts='A' ");
		List<Statistics> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND b.community_id in ("+entity.getCommunityId()+")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
					sql.append(" AND b.community_street_id in ("+entity.getCommunityStreetId()+")");
				}
				if (StringUtils.isNotBlank(entity.getHousesTypeId())) {
					sql.append(" AND b.houses_type_id in ("+entity.getHousesTypeId()+")");
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<Statistics>(Statistics.class));
		} catch (DataAccessException e) {
			logger.error("查询统计错误：{}", e.getMessage());
			throw new SysException("查询统计错误", "10000", e);
		}*/
		return null;
	}

	@Override
	public Statistics queryPersonnelType(Statistics entity) throws SysException, AppException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ifnull(COUNT(a.personnel_id), 0) total,");
		sql.append("ifnull(sum(case when a.live_type_id in ('1','3') then 1 else 0 end), 0)fangzhunum,ifnull(cast((sum(case when a.live_type_id in ('1','3')  then 1 else 0 end)/COUNT(a.personnel_id)) as decimal(18,2))*100, 0) as fangzhuratio,");
		sql.append("ifnull(sum(case when a.live_type_id in ('2','4') then 1 else 0 end), 0)dianzhunum,ifnull(cast((sum(case when a.live_type_id in ('2','4')  then 1 else 0 end)/COUNT(a.personnel_id)) as decimal(18,2))*100, 0) as dianzhuratio,");
		sql.append("ifnull(sum(case when a.live_type_id='5' then 1 else 0 end), 0)zuhunum,ifnull(cast((sum(case when a.live_type_id='5' then 1 else 0 end)/COUNT(a.personnel_id)) as decimal(18,2))*100, 0) as zuhuratio,");
		sql.append("ifnull(sum(case when a.live_type_id='6' then 1 else 0 end), 0)yuangongnum,ifnull(cast((sum(case when a.live_type_id='6' then 1 else 0 end)/COUNT(a.personnel_id)) as decimal(18,2))*100, 0) as yuangongratio,");
		sql.append("ifnull(sum(case when a.live_type_id='7' then 1 else 0 end), 0)jiashunum,ifnull(cast((sum(case when a.live_type_id='7' then 1 else 0 end)/COUNT(a.personnel_id)) as decimal(18,2))*100, 0)as jiashuratio  ");
		sql.append("from personnel_info  a ");
		sql.append("LEFT JOIN houses_info b on(a.houses_id=b.houses_id) ");
		sql.append("WHERE a.sts='A' ");
		List<Statistics> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND b.community_id in ("+entity.getCommunityId()+")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
					sql.append(" AND b.community_street_id in ("+entity.getCommunityStreetId()+")");
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<Statistics>(Statistics.class));
			if (resultList.size() > 0) {
				entity = resultList.get(0);
			}else{
				return null;
			}
		} catch (DataAccessException e) {
			logger.error("查询统计错误：{}", e.getMessage());
			throw new SysException("查询统计错误", "10000", e);
		}
		return entity;
	}

	@Override
	public Statistics queryPersonnelGender(Statistics entity) throws SysException, AppException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ifnull(sum(case when a.gender='1' then 1 else 0 end), 0)nannum,ifnull(cast((sum(case when a.gender='1' then 1 else 0 end)/COUNT(a.personnel_id)) as decimal(18,2))*100, 0) as nanratio,");
		sql.append("ifnull(sum(case when a.gender='2' then 1 else 0 end), 0)nvnum,ifnull(cast((sum(case when a.gender='2' then 1 else 0 end)/COUNT(a.personnel_id)) as decimal(18,2))*100, 0)as nvratio ");
		sql.append("from personnel_info  a ");
		sql.append("LEFT JOIN houses_info b on(a.houses_id=b.houses_id) ");
		sql.append("WHERE a.sts='A' ");
		List<Statistics> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getLiveTypeId())) {
					sql.append(" AND a.live_type_id in ("+entity.getLiveTypeId()+")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND b.community_id in ("+entity.getCommunityId()+")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
					sql.append(" AND b.community_street_id in ("+entity.getCommunityStreetId()+")");
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<Statistics>(Statistics.class));
			if (resultList.size() > 0) {
				entity = resultList.get(0);
			}else{
				return null;
			}
		} catch (DataAccessException e) {
			logger.error("查询统计错误：{}", e.getMessage());
			throw new SysException("查询统计错误", "10000", e);
		}
		return null;
	}

	@Override
	public List<Statistics> queryPersonnelAge(Statistics entity) throws SysException, AppException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT nnd as agerange,count(*) as count from( ");
		sql.append("SELECT ");
		sql.append("CASE ");
		sql.append(" WHEN ROUND(DATEDIFF(CURDATE(), birth_date)/365.2422) >= 0 and ROUND(DATEDIFF(CURDATE(), birth_date)/365.2422) <= 6 THEN 1 ");
		sql.append(" WHEN ROUND(DATEDIFF(CURDATE(), birth_date)/365.2422) >= 7 and ROUND(DATEDIFF(CURDATE(), birth_date)/365.2422) <= 17 THEN 2 ");
		sql.append(" WHEN ROUND(DATEDIFF(CURDATE(), birth_date)/365.2422) >= 18 and ROUND(DATEDIFF(CURDATE(), birth_date)/365.2422) <= 40 THEN 3 ");
		sql.append(" WHEN ROUND(DATEDIFF(CURDATE(), birth_date)/365.2422) >= 41 and ROUND(DATEDIFF(CURDATE(), birth_date)/365.2422) <= 47 THEN 4 ");
		sql.append(" WHEN ROUND(DATEDIFF(CURDATE(), birth_date)/365.2422) >= 48 and ROUND(DATEDIFF(CURDATE(), birth_date)/365.2422) <= 65 THEN 5 ");
		sql.append(" WHEN ROUND(DATEDIFF(CURDATE(), birth_date)/365.2422) >= 66 THEN 6 ");
		sql.append("END as nnd ");
		sql.append(" from personnel_info a  ");
		sql.append("LEFT JOIN houses_info b on(a.houses_id=b.houses_id) ");
		sql.append("where a.sts='A' ");
		List<Statistics> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getLiveTypeId())) {
					sql.append(" AND a.live_type_id in ("+entity.getLiveTypeId()+")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND b.community_id in ("+entity.getCommunityId()+")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
					sql.append(" AND b.community_street_id in ("+entity.getCommunityStreetId()+")");
				}
			}
			sql.append(" ) a GROUP BY nnd ");
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<Statistics>(Statistics.class));
		} catch (DataAccessException e) {
			logger.error("查询统计错误：{}", e.getMessage());
			throw new SysException("查询统计错误", "10000", e);
		}
		return resultList;
	}
	
	
}
