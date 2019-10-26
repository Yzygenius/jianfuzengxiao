package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.base.impl.BaseDAO;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IAduitDistributionSDAO;
import com.jianfuzengxiao.pub.entity.AduitDistributionMVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.lang.StringUtils;
import java.util.List;
import java.util.ArrayList;

public class AduitDistributionSDAO extends BaseDAO<AduitDistributionMVO> implements IAduitDistributionSDAO {
	private static Logger logger = LoggerFactory.getLogger(AduitDistributionSDAO.class);

	@Override
	public AduitDistributionMVO insert(final AduitDistributionMVO entity) throws SysException {
		final StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ADUIT_DISTRIBUTION (id,admin_id,houses_id,status,create_time,update_time,sts) ");
		sql.append("VALUES (?,?,?,?,str_to_date(?,'%Y-%m-%d %H:%i:%s'),str_to_date(?,'%Y-%m-%d %H:%i:%s'),?)");
		try {
			logger.info(sql.toString());
			jdbcTemplate.update(new PreparedStatementCreator() {
				public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					int i = 0;
					java.sql.PreparedStatement ps = conn.prepareStatement(sql.toString());
					ps.setString(++i, StringUtils.trimToNull(entity.getId()));
					ps.setString(++i, StringUtils.trimToNull(entity.getAdminId()));
					ps.setString(++i, StringUtils.trimToNull(entity.getHousesId()));
					ps.setString(++i, StringUtils.trimToNull(entity.getStatus()));
					ps.setString(++i, StringUtils.trimToNull(entity.getCreateTime()));
					ps.setString(++i, StringUtils.trimToNull(entity.getUpdateTime()));
					ps.setString(++i, StringUtils.trimToNull(entity.getSts()));
					return ps;
				}
			});
		} catch (DataAccessException e) {
			logger.error("增加ADUIT_DISTRIBUTION 错误：{}", e.getMessage());
			throw new SysException("10000", "增加ADUIT_DISTRIBUTION错误", e);
		}
		return entity;
	}

	@Override
	public int update(AduitDistributionMVO entity) throws SysException {
		int rowsAffected;
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE  ADUIT_DISTRIBUTION  SET ");
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity.getAdminId() != null) {
				sql.append("admin_id=?,");
				params.add(entity.getAdminId());
			}
			if (entity.getHousesId() != null) {
				sql.append("houses_id=?,");
				params.add(entity.getHousesId());
			}
			if (entity.getStatus() != null) {
				sql.append("status=?,");
				params.add(entity.getStatus());
			}
			if (entity.getCreateTime() != null) {
				sql.append("create_time=str_to_date(?,'%Y-%m-%d %H:%i:%s'),");
				params.add(entity.getCreateTime());
			}
			if (entity.getUpdateTime() != null) {
				sql.append("update_time=str_to_date(?,'%Y-%m-%d %H:%i:%s'),");
				params.add(entity.getUpdateTime());
			}
			if (entity.getSts() != null) {
				sql.append("sts=?,");
				params.add(entity.getSts());
			}
			sql.deleteCharAt(sql.length() - 1);
			sql.append(" WHERE id=?");
			params.add(entity.getId());
			logger.info(sql.toString() + "--" + params.toString());
			rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());
		} catch (DataAccessException e) {
			logger.error("更新ADUIT_DISTRIBUTION错误：{}", e.getMessage());
			throw new SysException("10000", "更新ADUIT_DISTRIBUTION错误", e);
		}
		return rowsAffected;
	}

	@Override
	public int delete(AduitDistributionMVO entity) throws SysException {
		int rowsAffected;
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM ADUIT_DISTRIBUTION WHERE id=?");
		try {
			logger.info(sql.toString());
			rowsAffected = jdbcTemplate.update(sql.toString(), entity.getId());
		} catch (DataAccessException e) {
			logger.error("删除ADUIT_DISTRIBUTION错误：{}", e.getMessage());
			throw new SysException("10000", "删除ADUIT_DISTRIBUTION错误", e);
		}
		return rowsAffected;
	}

	@Override
	public List<AduitDistributionMVO> queryList(AduitDistributionMVO entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT id,admin_id,houses_id,status,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
		sql.append("FROM  ADUIT_DISTRIBUTION ");
		sql.append("WHERE 1=1 ");
		List<AduitDistributionMVO> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getId())) {
					sql.append(" AND id=?");
					params.add(entity.getId());
				}
				if (StringUtils.isNotBlank(entity.getAdminId())) {
					sql.append(" AND admin_id=?");
					params.add(entity.getAdminId());
				}
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND houses_id=?");
					params.add(entity.getHousesId());
				}
				if (StringUtils.isNotBlank(entity.getStatus())) {
					sql.append(" AND status=?");
					params.add(entity.getStatus());
				}
				if (StringUtils.isNotBlank(entity.getCreateTime())) {
					sql.append("  AND create_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
					params.add(entity.getCreateTime());
				}
				if (StringUtils.isNotBlank(entity.getUpdateTime())) {
					sql.append("  AND update_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
					params.add(entity.getUpdateTime());
				}
				if (StringUtils.isNotBlank(entity.getSts())) {
					sql.append(" AND sts=?");
					params.add(entity.getSts());
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<AduitDistributionMVO>(AduitDistributionMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询ADUIT_DISTRIBUTION错误：{}", e.getMessage());
			throw new SysException("10000", "查询ADUIT_DISTRIBUTION错误", e);
		}
		return resultList;
	}

	@Override
	public AduitDistributionMVO queryBean(AduitDistributionMVO entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT id,admin_id,houses_id,status,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
		sql.append("FROM  ADUIT_DISTRIBUTION ");
		sql.append("WHERE id=? ");
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				params.add(entity.getId());
			} else {
				sql.append(" AND 1=2");
			}
			logger.info(sql.toString() + "--" + params.toString());
			entity = jdbcTemplate.queryForObject(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<AduitDistributionMVO>(AduitDistributionMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询ADUIT_DISTRIBUTION错误：{}", e.getMessage());
			throw new SysException("10000", "查询ADUIT_DISTRIBUTION错误", e);
		}
		return entity;
	}

}
