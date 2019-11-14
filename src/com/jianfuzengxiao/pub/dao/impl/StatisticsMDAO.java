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
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IStatisticsMDAO;
import com.jianfuzengxiao.pub.entity.FuncListMVO;
import com.jianfuzengxiao.pub.entity.PersonnelInfoMVO;
import com.jianfuzengxiao.pub.entity.Statistics;

@Repository
public class StatisticsMDAO extends BaseDAO<Statistics> implements IStatisticsMDAO {
	private static Logger logger = LoggerFactory.getLogger(StatisticsMDAO.class);

	@Override
	public Statistics queryHousesType(Statistics entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ifnull(COUNT(houses_id),0)total ");
		sql.append(
				",sum(case when houses_type_id='1' then 1 else 0 end) zjf,cast((sum(case when houses_type_id='1' then 1 else 0 end)/COUNT(houses_id)) as decimal(18,2))*100 as zjfratio ");
		sql.append(
				",sum(case when houses_type_id='2' then 1 else 0 end) szf,cast((sum(case when houses_type_id='2' then 1 else 0 end)/COUNT(houses_id)) as decimal(18,2))*100 as szfratio ");
		sql.append(
				",sum(case when houses_type_id='3' then 1 else 0 end) sp,cast((sum(case when houses_type_id='3' then 1 else 0 end)/COUNT(houses_id)) as decimal(18,2))*100 as spratio ");
		sql.append("FROM  houses_info ");
		sql.append("WHERE sts='A' ");
		List<Statistics> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND community_id in (" + entity.getCommunityId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
					sql.append(" AND community_street_id in (" + entity.getCommunityStreetId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND houses_id in (" + entity.getHousesId()+ ")");
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<Statistics>(Statistics.class));
			if (resultList.size() > 0) {
				entity = resultList.get(0);
			} else {
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
		sql.append("from personnel_info where sts ='A' and live_type_id in ('3','4') ");
		if (entity != null) {
			sql.append("and houses_id in ( SELECT houses_id from houses_info b WHERE b.sts='A' ");
			if (StringUtils.isNotBlank(entity.getHousesId())) {
				sql.append(" AND houses_id in (" + entity.getHousesId() + ")");
			}
			if (StringUtils.isNotBlank(entity.getCommunityId())) {
				sql.append(" AND community_id in (" + entity.getCommunityId() + ")");
			}
			if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
				sql.append(" AND community_street_id in (" + entity.getCommunityStreetId() + ")");
			}
			if (StringUtils.isNotBlank(entity.getHousesTypeId())) {
				sql.append(" AND houses_type_id in (" + entity.getHousesTypeId() + ")");
			}
			sql.append(") ");
		}

		sql.append(")as 'rent' ");
		sql.append("from houses_info b ");
		sql.append("WHERE b.sts='A' ");
		List<Statistics> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND b.houses_id in (" + entity.getHousesId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND b.community_id in (" + entity.getCommunityId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
					sql.append(" AND b.community_street_id in (" + entity.getCommunityStreetId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getHousesTypeId())) {
					sql.append(" AND b.houses_type_id in (" + entity.getHousesTypeId() + ")");
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<Statistics>(Statistics.class));
			if (resultList.size() > 0) {
				entity = resultList.get(0);
			} else {
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
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT COUNT(houses_id) count,house_type,cast(COUNT(houses_id)/(SELECT count(houses_id) from houses_info where sts='A') as decimal(18,2)) as ratio ");
		sql.append("from houses_info where sts='A' ");
		List<Statistics> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND houses_id in (" + entity.getHousesId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND community_id in (" + entity.getCommunityId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
					sql.append(" AND community_street_id in (" + entity.getCommunityStreetId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getHousesTypeId())) {
					sql.append(" AND houses_type_id in (" + entity.getHousesTypeId() + ")");
				}
			}
			sql.append(" GROUP BY house_type ");
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<Statistics>(Statistics.class));
		} catch (DataAccessException e) {
			logger.error("查询统计错误：{}", e.getMessage());
			throw new SysException("查询统计错误", "10000", e);
		}
		return resultList;
	}

	@Override
	public Statistics queryPersonnelType(Statistics entity) throws SysException, AppException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ifnull(COUNT(a.personnel_id), 0) total,");
		sql.append(
				"ifnull(sum(case when a.live_type_id in ('1','3') then 1 else 0 end), 0)fangzhunum,ifnull(cast((sum(case when a.live_type_id in ('1','3')  then 1 else 0 end)/COUNT(a.personnel_id)) as decimal(18,2))*100, 0) as fangzhuratio,");
		sql.append(
				"ifnull(sum(case when a.live_type_id in ('2','4') then 1 else 0 end), 0)dianzhunum,ifnull(cast((sum(case when a.live_type_id in ('2','4')  then 1 else 0 end)/COUNT(a.personnel_id)) as decimal(18,2))*100, 0) as dianzhuratio,");
		sql.append(
				"ifnull(sum(case when a.live_type_id='5' then 1 else 0 end), 0)zuhunum,ifnull(cast((sum(case when a.live_type_id='5' then 1 else 0 end)/COUNT(a.personnel_id)) as decimal(18,2))*100, 0) as zuhuratio,");
		sql.append(
				"ifnull(sum(case when a.live_type_id='6' then 1 else 0 end), 0)yuangongnum,ifnull(cast((sum(case when a.live_type_id='6' then 1 else 0 end)/COUNT(a.personnel_id)) as decimal(18,2))*100, 0) as yuangongratio,");
		sql.append(
				"ifnull(sum(case when a.live_type_id='7' then 1 else 0 end), 0)jiashunum,ifnull(cast((sum(case when a.live_type_id='7' then 1 else 0 end)/COUNT(a.personnel_id)) as decimal(18,2))*100, 0)as jiashuratio  ");
		sql.append("from personnel_info  a ");
		sql.append("LEFT JOIN houses_info b on(a.houses_id=b.houses_id) ");
		sql.append("WHERE a.sts='A' ");
		List<Statistics> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND a.houses_id in (" + entity.getHousesId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND b.community_id in (" + entity.getCommunityId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
					sql.append(" AND b.community_street_id in (" + entity.getCommunityStreetId() + ")");
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<Statistics>(Statistics.class));
			if (resultList.size() > 0) {
				entity = resultList.get(0);
			} else {
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
		sql.append(
				"SELECT ifnull(sum(case when a.gender='1' then 1 else 0 end), 0)nannum,ifnull(cast((sum(case when a.gender='1' then 1 else 0 end)/COUNT(a.personnel_id)) as decimal(18,2))*100, 0) as nanratio,");
		sql.append(
				"ifnull(sum(case when a.gender='2' then 1 else 0 end), 0)nvnum,ifnull(cast((sum(case when a.gender='2' then 1 else 0 end)/COUNT(a.personnel_id)) as decimal(18,2))*100, 0)as nvratio ");
		sql.append("from personnel_info  a ");
		sql.append("LEFT JOIN houses_info b on(a.houses_id=b.houses_id) ");
		sql.append("WHERE a.sts='A' ");
		List<Statistics> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getLiveTypeId())) {
					sql.append(" AND a.live_type_id in (" + entity.getLiveTypeId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND a.houses_id in (" + entity.getHousesId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND b.community_id in (" + entity.getCommunityId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
					sql.append(" AND b.community_street_id in (" + entity.getCommunityStreetId() + ")");
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<Statistics>(Statistics.class));
			if (resultList.size() > 0) {
				entity = resultList.get(0);
			} else {
				return null;
			}
		} catch (DataAccessException e) {
			logger.error("查询统计错误：{}", e.getMessage());
			throw new SysException("查询统计错误", "10000", e);
		}
		return entity;
	}

	@Override
	public List<Statistics> queryPersonnelAge(Statistics entity) throws SysException, AppException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT nnd as agerange,count(*) as count from( ");
		sql.append("SELECT ");
		sql.append("CASE ");
		sql.append(
				" WHEN ROUND(DATEDIFF(CURDATE(), birth_date)/365.2422) >= 0 and ROUND(DATEDIFF(CURDATE(), birth_date)/365.2422) <= 6 THEN 1 ");
		sql.append(
				" WHEN ROUND(DATEDIFF(CURDATE(), birth_date)/365.2422) >= 7 and ROUND(DATEDIFF(CURDATE(), birth_date)/365.2422) <= 17 THEN 2 ");
		sql.append(
				" WHEN ROUND(DATEDIFF(CURDATE(), birth_date)/365.2422) >= 18 and ROUND(DATEDIFF(CURDATE(), birth_date)/365.2422) <= 40 THEN 3 ");
		sql.append(
				" WHEN ROUND(DATEDIFF(CURDATE(), birth_date)/365.2422) >= 41 and ROUND(DATEDIFF(CURDATE(), birth_date)/365.2422) <= 47 THEN 4 ");
		sql.append(
				" WHEN ROUND(DATEDIFF(CURDATE(), birth_date)/365.2422) >= 48 and ROUND(DATEDIFF(CURDATE(), birth_date)/365.2422) <= 65 THEN 5 ");
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
					sql.append(" AND a.live_type_id in (" + entity.getLiveTypeId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND a.houses_id in (" + entity.getHousesId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND b.community_id in (" + entity.getCommunityId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
					sql.append(" AND b.community_street_id in (" + entity.getCommunityStreetId() + ")");
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

	@Override
	public Statistics queryTodayReportPer(Statistics entity) throws SysException, AppException {
		StringBuilder sql = new StringBuilder();
		sql.append("select ifnull(sum(case when status !='1' then 1 else 0 end),0) as audit, ");
		sql.append("ifnull(sum(case when status='1' then 1 else 0 end),0) as waitaudit, ");
		sql.append("count(personnel_id) as total,");
		sql.append(
				"ifnull(cast((sum(case when status !='1' then 1 else 0 end)/COUNT(personnel_id)) as decimal(18,2)),0) as auditratio  ");
		sql.append("from personnel_info a ");
		sql.append("left join houses_info b on(a.houses_id=b.houses_id) ");
		sql.append("WHERE a.sts='A' and date(a.update_time) = curdate() ");
		List<Statistics> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getLiveTypeId())) {
					sql.append(" AND a.live_type_id in (" + entity.getLiveTypeId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND a.houses_id in (" + entity.getHousesId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND b.community_id in (" + entity.getCommunityId() + ")");
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<Statistics>(Statistics.class));
			if (resultList.size() > 0) {
				entity = resultList.get(0);
			} else {
				return null;
			}
		} catch (DataAccessException e) {
			logger.error("查询统计错误：{}", e.getMessage());
			throw new SysException("查询统计错误", "10000", e);
		}
		return entity;
	}

	@Override
	public Statistics queryHousesCount(Statistics entity) throws SysException, AppException {
		StringBuilder sql = new StringBuilder();
		sql.append("select COUNT(*) as housescount, ");
		sql.append("sum(case when houses_type_id ='1' then 1 else 0 end) as zjf, ");
		sql.append("sum(case when houses_type_id ='2' then 1 else 0 end) as szf, ");
		sql.append("sum(case when houses_type_id ='3' then 1 else 0 end) as sp, ");
		sql.append("(select COUNT(*) ");
		sql.append("from houses_info a where sts ='A' ");
		if (StringUtils.isNotBlank(entity.getCommunityId())) {
			sql.append(" AND community_id in("+entity.getCommunityId()+") ");
		}
		sql.append(" and a.houses_id in (SELECT houses_id from personnel_info WHERE sts='A' ");
		if (StringUtils.isNotBlank(entity.getHousesId())) {
			sql.append(" AND houses_id in("+entity.getHousesId()+") ");
		}
		sql.append(" ))as used, ");
		sql.append("(select COUNT(*) ");
		sql.append("from houses_info a where sts ='A' ");
		if (StringUtils.isNotBlank(entity.getCommunityId())) {
			sql.append(" AND community_id in("+entity.getCommunityId()+") ");
		}
		sql.append(" and a.houses_id not in (SELECT houses_id from personnel_info WHERE sts='A' ");
		if (StringUtils.isNotBlank(entity.getHousesId())) {
			sql.append(" AND houses_id in("+entity.getHousesId()+") ");
		}
		sql.append(" ))as idle ");
		sql.append("from houses_info b where sts ='A' ");
		List<Statistics> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getStartTime())) {
					sql.append(" AND b.create_time >= ? ");
					params.add(entity.getStartTime());
				}
				if (StringUtils.isNotBlank(entity.getStopTime())) {
					sql.append(" AND b.create_time <= ? ");
					params.add(entity.getStopTime());
				}
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND b.houses_id in("+entity.getHousesId()+") ");
				}
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND b.community_id in("+entity.getCommunityId()+") ");
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<Statistics>(Statistics.class));
			if (resultList.size() > 0) {
				entity = resultList.get(0);
			} else {
				return null;
			}
		} catch (DataAccessException e) {
			logger.error("查询统计错误：{}", e.getMessage());
			throw new SysException("查询统计错误", "10000", e);
		}
		return entity;
	}

	@Override
	public Statistics queryPersonnelCount(Statistics entity) throws SysException, AppException {
		StringBuilder sql = new StringBuilder();
		sql.append("select COUNT(*) as percount, ");
		sql.append("sum(case when live_type_id in ('1','3')   then 1 else 0 end) as fangzhunum, ");
		sql.append("sum(case when live_type_id in ('2','4')   then 1 else 0 end) as dianzhunum, ");
		sql.append("sum(case when live_type_id in ('5')   then 1 else 0 end) as zuhunum, ");
		sql.append("sum(case when live_type_id in ('7')   then 1 else 0 end) as jiashunum, ");
		sql.append("sum(case when live_type_id in ('6')   then 1 else 0 end) as yuangongnum  ");
		sql.append("from personnel_info a where a.sts ='A' ");
		List<Statistics> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getStartTime())) {
					sql.append(" AND a.create_time >= ? ");
					params.add(entity.getStartTime());
				}
				if (StringUtils.isNotBlank(entity.getStopTime())) {
					sql.append(" AND a.create_time <= ? ");
					params.add(entity.getStopTime());
				}
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND a.houses_id in("+entity.getHousesId()+") ");
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<Statistics>(Statistics.class));
			if (resultList.size() > 0) {
				entity = resultList.get(0);
			} else {
				return null;
			}
		} catch (DataAccessException e) {
			logger.error("查询统计错误：{}", e.getMessage());
			throw new SysException("查询统计错误", "10000", e);
		}
		return entity;
	}

	@Override
	public List<Statistics> queryPersonnelNation(Statistics entity) throws SysException, AppException {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT COUNT(personnel_id) count,nation_name, cast(COUNT(personnel_id)/(SELECT count(personnel_id) from personnel_info a left join houses_info b on(a.houses_id=b.houses_id)  ");
		sql.append("where a.sts='A' ");
		
		if (StringUtils.isNotBlank(entity.getLiveTypeId())) {
			sql.append(" AND a.live_type_id in (" + entity.getLiveTypeId() + ")");
		}
		if (StringUtils.isNotBlank(entity.getHousesId())) {
			sql.append(" AND a.houses_id in (" + entity.getHousesId() + ")");
		}
		if (StringUtils.isNotBlank(entity.getCommunityId())) {
			sql.append(" AND b.community_id in (" + entity.getCommunityId() + ")");
		}
		if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
			sql.append(" AND b.community_street_id in (" + entity.getCommunityStreetId() + ")");
		}
		
		sql.append(" ) as decimal(18,2)) as ratio ");
		sql.append("from personnel_info a  ");
		sql.append(" left join houses_info b on(a.houses_id=b.houses_id) ");
		sql.append("where a.sts='A' ");
		List<Statistics> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getLiveTypeId())) {
					sql.append(" AND a.live_type_id in (" + entity.getLiveTypeId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND a.houses_id in (" + entity.getHousesId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND b.community_id in (" + entity.getCommunityId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
					sql.append(" AND b.community_street_id in (" + entity.getCommunityStreetId() + ")");
				}
			}
			sql.append("GROUP BY nation_id ");
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<Statistics>(Statistics.class));

		} catch (DataAccessException e) {
			logger.error("查询统计错误：{}", e.getMessage());
			throw new SysException("查询统计错误", "10000", e);
		}
		return resultList;
	}

	@Override
	public Statistics queryReportInfo(Statistics entity) throws SysException, AppException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT count(personnel_id) total ");
		sql.append(",ifnull(sum(case when status in(2,3) then 1 else 0 end),0) as total_pass ");
		sql.append(",ifnull(sum(case when status in(1) then 1 else 0 end),0) as total_wait ");
		sql.append(",ifnull(cast((sum(case when status in(2,3) then 1 else 0 end)/count(personnel_id)) as decimal(18,2)),0) as total_pass_ratio ");
		sql.append(",ifnull(cast((sum(case when status in(1) then 1 else 0 end)/count(personnel_id)) as decimal(18,2)),0) as total_wait_ratio ");
		sql.append(",ifnull(sum(case when live_type_id in(1,3) then 1 else 0 end),0) as fangzhunum");
		sql.append(",ifnull(sum(case when live_type_id in(1,3) and status in(2,3) then 1 else 0 end),0) as fangzhu_pass");
		sql.append(",ifnull(sum(case when live_type_id in(1,3) and status in(1) then 1 else 0 end),0) as fangzhu_wait");
		sql.append(",ifnull(cast((sum(case when live_type_id in(1,3) and status in(2,3) then 1 else 0 end)/sum(case when live_type_id in(1,3) then 1 else 0 end)) as decimal(18,2)),0) as fangzhu_pass_ratio");
		sql.append(",ifnull(cast((sum(case when live_type_id in(1,3) and status in(1) then 1 else 0 end)/sum(case when live_type_id in(1,3) then 1 else 0 end)) as decimal(18,2)),0) as fangzhu_wait_ratio");
		sql.append(",ifnull(sum(case when live_type_id in(5) then 1 else 0 end),0) as zuhunum");
		sql.append(",ifnull(sum(case when live_type_id in(5) and status in(2,3) then 1 else 0 end),0) as zuhu_pass");
		sql.append(",ifnull(sum(case when live_type_id in(5) and status in(1) then 1 else 0 end),0) as zuhu_wait");
		sql.append(",ifnull(cast((sum(case when live_type_id in(5) and status in(2,3) then 1 else 0 end)/sum(case when live_type_id in(5) then 1 else 0 end)) as decimal(18,2)),0) as zuhu_pass_ratio");
		sql.append(",ifnull(cast((sum(case when live_type_id in(5) and status in(1) then 1 else 0 end)/sum(case when live_type_id in(5) then 1 else 0 end)) as decimal(18,2)),0) as zuhu_wait_ratio");
		sql.append(",ifnull(sum(case when live_type_id in(7) then 1 else 0 end),0) as jiashunum");
		sql.append(",ifnull(sum(case when live_type_id in(7) and status in(2,3) then 1 else 0 end),0) as jiashu_pass");
		sql.append(",ifnull(sum(case when live_type_id in(7) and status in(1) then 1 else 0 end),0) as jiashu_wait");
		sql.append(",ifnull(cast((sum(case when live_type_id in(7) and status in(2,3) then 1 else 0 end)/sum(case when live_type_id in(7) then 1 else 0 end)) as decimal(18,2)),0) as jiashu_pass_ratio");
		sql.append(",ifnull(cast((sum(case when live_type_id in(7) and status in(1) then 1 else 0 end)/sum(case when live_type_id in(7) then 1 else 0 end)) as decimal(18,2)),0) as jiashu_wait_ratio");
		sql.append(",ifnull(sum(case when live_type_id in(2,4) then 1 else 0 end),0) as dianzhunum");
		sql.append(",ifnull(sum(case when live_type_id in(2,4) and status in(2,3) then 1 else 0 end),0) as dianzhu_pass");
		sql.append(",ifnull(sum(case when live_type_id in(2,4) and status in(1) then 1 else 0 end),0) as dianzhu_wait");
		sql.append(",ifnull(cast((sum(case when live_type_id in(2,4) and status in(2,3) then 1 else 0 end)/sum(case when live_type_id in(2,4) then 1 else 0 end)) as decimal(18,2)),0) as dianzhu_pass_ratio");
		sql.append(",ifnull(cast((sum(case when live_type_id in(2,4) and status in(1) then 1 else 0 end)/sum(case when live_type_id in(2,4) then 1 else 0 end)) as decimal(18,2)),0) as dianzhu_wait_ratio");
		sql.append(",ifnull(sum(case when live_type_id in(6) then 1 else 0 end),0) as yuangongnum");
		sql.append(",ifnull(sum(case when live_type_id in(6) and status in(2,3) then 1 else 0 end),0) as yuangong_pass");
		sql.append(",ifnull(sum(case when live_type_id in(6) and status in(1) then 1 else 0 end),0) as yuangong_wait");
		sql.append(",ifnull(cast((sum(case when live_type_id in(6) and status in(2,3) then 1 else 0 end)/sum(case when live_type_id in(6) then 1 else 0 end)) as decimal(18,2)),0) as yuangong_pass_ratio");
		sql.append(",ifnull(cast((sum(case when live_type_id in(6) and status in(1) then 1 else 0 end)/sum(case when live_type_id in(6) then 1 else 0 end)) as decimal(18,2)),0) as yuangong_wait_ratio  ");
		sql.append("from personnel_info a  ");
		sql.append("LEFT JOIN houses_info b on(a.houses_id=b.houses_id) ");
		//sql.append("WHERE a.sts='A' ");
		sql.append("WHERE 1=1 ");
		List<Statistics> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND a.houses_id in (" + entity.getHousesId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND b.community_id in (" + entity.getCommunityId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
					sql.append(" AND b.community_street_id in (" + entity.getCommunityStreetId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getStartTime())) {
					sql.append(" AND a.update_time >= ? ");
					params.add(entity.getStartTime());
				}
				if (StringUtils.isNotBlank(entity.getStopTime())) {
					sql.append(" AND a.update_time <= ? ");
					params.add(entity.getStopTime());
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<Statistics>(Statistics.class));
			if (resultList.size() > 0) {
				entity = resultList.get(0);
			} else {
				return null;
			}
		} catch (DataAccessException e) {
			logger.error("查询统计错误：{}", e.getMessage());
			throw new SysException("查询统计错误", "10000", e);
		}
		return entity;
	}

	@Override
	public Statistics queryFangwuReportPass(Statistics entity) throws SysException, AppException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ifnull(sum(case when live_type_id in(1,3) and status in(2) then 1 else 0 end),0) as fangzhu_pass ");
		sql.append(",ifnull(cast((sum(case when live_type_id in(1,3) and status in(2) then 1 else 0 end)/sum(case when live_type_id in(1,3,5,7) AND status in(2) then 1 else 0 end)) as decimal(18,2)),0) as fangzhu_ratio ");
		sql.append(",ifnull(cast((sum(case when live_type_id in(1,3) and status in(2) then 1 else 0 end)/sum(case when live_type_id in(1,3) then 1 else 0 end)) as decimal(18,2)),0) as fangzhu_pass_ratio ");
		sql.append(",ifnull(sum(case when live_type_id in(5) and status in(2) then 1 else 0 end),0) as zuhu_pass");
		sql.append(",ifnull(cast((sum(case when live_type_id in(5) and status in(2) then 1 else 0 end)/sum(case when live_type_id in(1,3,5,7) AND status in(2) then 1 else 0 end)) as decimal(18,2)),0) as zuhu_ratio");
		sql.append(",ifnull(cast((sum(case when live_type_id in(5) and status in(2) then 1 else 0 end)/sum(case when live_type_id in(5) then 1 else 0 end)) as decimal(18,2)),0) as zuhu_pass_ratio");
		sql.append(",ifnull(sum(case when live_type_id in(7) and status in(2) then 1 else 0 end),0) as jiashu_pass");
		sql.append(",ifnull(cast((sum(case when live_type_id in(7) and status in(2) then 1 else 0 end)/sum(case when live_type_id in(1,3,5,7) AND status in(2) then 1 else 0 end)) as decimal(18,2)),0) as jiashu_ratio");
		sql.append(",ifnull(cast((sum(case when live_type_id in(7) and status in(2) then 1 else 0 end)/sum(case when live_type_id in(7) then 1 else 0 end)) as decimal(18,2)),0) as jiashu_pass_ratio ");
		sql.append("from personnel_info a  ");
		sql.append("LEFT JOIN houses_info b on(a.houses_id=b.houses_id) ");
		//sql.append("WHERE a.sts='A' ");
		sql.append("WHERE 1=1 ");
		List<Statistics> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND a.houses_id in (" + entity.getHousesId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND b.community_id in (" + entity.getCommunityId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
					sql.append(" AND b.community_street_id in (" + entity.getCommunityStreetId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getStartTime())) {
					sql.append(" AND a.update_time >= ? ");
					params.add(entity.getStartTime());
				}
				if (StringUtils.isNotBlank(entity.getStopTime())) {
					sql.append(" AND a.update_time <= ? ");
					params.add(entity.getStopTime());
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<Statistics>(Statistics.class));
			if (resultList.size() > 0) {
				entity = resultList.get(0);
			} else {
				return null;
			}
		} catch (DataAccessException e) {
			logger.error("查询统计错误：{}", e.getMessage());
			throw new SysException("查询统计错误", "10000", e);
		}
		return entity;
	}

	@Override
	public Statistics queryMendianReportPass(Statistics entity) throws SysException, AppException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ifnull(sum(case when live_type_id in(2,4) and status in(2) then 1 else 0 end),0) as dianzhu_pass ");
		sql.append(",ifnull(cast((sum(case when live_type_id in(2,4) and status in(2) then 1 else 0 end)/sum(case when live_type_id in(2,4,6) AND status in(2) then 1 else 0 end)) as decimal(18,2)),0) as dianzhu_ratio ");
		sql.append(",ifnull(cast((sum(case when live_type_id in(2,4) and status in(2) then 1 else 0 end)/sum(case when live_type_id in(2,4) then 1 else 0 end)) as decimal(18,2)),0) as dianzhu_pass_ratio ");
		sql.append(",ifnull(sum(case when live_type_id in(6) and status in(2) then 1 else 0 end),0) as yuangong_pass");
		sql.append(",ifnull(cast((sum(case when live_type_id in(6) and status in(2) then 1 else 0 end)/sum(case when live_type_id in(2,4,6) AND status in(2) then 1 else 0 end)) as decimal(18,2)),0) as yuangong_ratio");
		sql.append(",ifnull(cast((sum(case when live_type_id in(6) and status in(2) then 1 else 0 end)/sum(case when live_type_id in(6) then 1 else 0 end)) as decimal(18,2)),0) as yuangong_pass_ratio ");
		sql.append("from personnel_info a  ");
		sql.append("LEFT JOIN houses_info b on(a.houses_id=b.houses_id) ");
		//sql.append("WHERE a.sts='A' ");
		sql.append("WHERE 1=1 ");
		List<Statistics> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND a.houses_id in (" + entity.getHousesId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND b.community_id in (" + entity.getCommunityId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
					sql.append(" AND b.community_street_id in (" + entity.getCommunityStreetId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getStartTime())) {
					sql.append(" AND a.update_time >= ? ");
					params.add(entity.getStartTime());
				}
				if (StringUtils.isNotBlank(entity.getStopTime())) {
					sql.append(" AND a.update_time <= ? ");
					params.add(entity.getStopTime());
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<Statistics>(Statistics.class));
			if (resultList.size() > 0) {
				entity = resultList.get(0);
			} else {
				return null;
			}
		} catch (DataAccessException e) {
			logger.error("查询统计错误：{}", e.getMessage());
			throw new SysException("查询统计错误", "10000", e);
		}
		return entity;
	}

	@Override
	public List<Statistics> queryReportCurve(Statistics entity) throws SysException, AppException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ifnull(COUNT(personnel_id),0)count,ifnull(year(a.update_time),'') as year,ifnull(month(a.update_time),'') as month,ifnull(day(a.update_time),'') as day ");
		sql.append("from personnel_info a  ");
		sql.append("LEFT JOIN houses_info b on(a.houses_id=b.houses_id) ");
		//sql.append("WHERE a.sts='A' ");
		sql.append("WHERE 1=1 ");
		List<Statistics> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND a.houses_id in (" + entity.getHousesId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND b.community_id in (" + entity.getCommunityId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
					sql.append(" AND b.community_street_id in (" + entity.getCommunityStreetId() + ")");
				}
				if (StringUtils.isNotBlank(entity.getStartTime())) {
					sql.append(" AND a.update_time >= ? ");
					params.add(entity.getStartTime());
				}
				if (StringUtils.isNotBlank(entity.getStopTime())) {
					sql.append(" AND a.update_time <= ? ");
					params.add(entity.getStopTime());
				}
			}
			sql.append(" GROUP BY day ");
			sql.append(" order by a.update_time asc ");
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<Statistics>(Statistics.class));
			
		} catch (DataAccessException e) {
			logger.error("查询统计错误：{}", e.getMessage());
			throw new SysException("查询统计错误", "10000", e);
		}
		return resultList;
	}

	@Override
	public PageInfo queryTodayReportPage(PersonnelInfoMVO entity, PageInfo pageInfo) throws SysException, AppException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select a.personnel_id,a.houses_id,a.user_id,a.per_sort,a.live_type_id,a.live_type_name,a.lease_mode,date_format(a.lease_start_time,'%Y-%m-%d')lease_start_time,date_format(a.lease_stop_time,'%Y-%m-%d')lease_stop_time,a.username,a.gender,a.face_photo,a.face_file,date_format(a.birth_date,'%Y-%m-%d')birth_date,a.nation_id,a.nation_name,a.telephone,a.certificates_type_id,a.certificates_type_name,a.certificates_number,date_format(a.certificates_start_time,'%Y-%m-%d')certificates_start_time,date_format(a.certificates_stop_time,'%Y-%m-%d')certificates_stop_time,a.certificates_address,a.certificates_office,a.enterprise_name,a.status,a.audit_remark,date_format(a.create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(a.update_time,'%Y-%m-%d %H:%i:%s')update_time,a.sts,a.update_status ");
		sql.append(",b.houses_status,b.community_name,b.community_street_name,b.storied_building_number,b.unit,b.house_number,b.houses_address,ifnull(b.store_location, 0)store_location ");
		sql.append("from PERSONNEL_INFO a ");
		sql.append("left join houses_info b on(a.houses_id=b.houses_id) ");
		sql.append("where date(a.update_time)=curdate() ");

		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getStatus())) {
					sql.append(" AND a.status in("+ entity.getStatus() +") ");
				}
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND a.houses_id in("+ entity.getHousesId() +") ");
				}
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND b.community_id in("+ entity.getCommunityId() +") ");
				}
			}
			logger.info(sql.toString() + " -- " + params.toString());
			pageInfo = this.pagingQuery(sql.toString(), pageInfo, params,
					new BeanPropertyRowMapper<PersonnelInfoMVO>(PersonnelInfoMVO.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			logger.error("查询统计错误：{}", e.getMessage());
			throw new SysException("查询统计错误", "10000", e);
		}
		return pageInfo;
	}

}
