package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.base.impl.BaseDAO;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.ISysConfigSDAO;
import com.jianfuzengxiao.pub.entity.SysConfigMVO;
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

public class SysConfigSDAO extends BaseDAO<SysConfigMVO> implements ISysConfigSDAO {
	private static Logger logger = LoggerFactory.getLogger(SysConfigSDAO.class);

	@Override
	public SysConfigMVO insert(final SysConfigMVO entity) throws SysException {
		final StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO SYS_CONFIG (config_id,config_name,config_value,type,remarks,update_time,editable) ");
		sql.append("VALUES (?,?,?,?,?,str_to_date(?,'%Y-%m-%d %H:%i:%s'),?)");
		try {
			logger.info(sql.toString());
			jdbcTemplate.update(new PreparedStatementCreator() {
				public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					int i = 0;
					java.sql.PreparedStatement ps = conn.prepareStatement(sql.toString());
					ps.setString(++i, StringUtils.trimToNull(entity.getConfigId()));
					ps.setString(++i, StringUtils.trimToNull(entity.getConfigName()));
					ps.setString(++i, StringUtils.trimToNull(entity.getConfigValue()));
					ps.setString(++i, StringUtils.trimToNull(entity.getType()));
					ps.setString(++i, StringUtils.trimToNull(entity.getRemarks()));
					ps.setString(++i, StringUtils.trimToNull(entity.getUpdateTime()));
					ps.setString(++i, StringUtils.trimToNull(entity.getEditable()));
					return ps;
				}
			});
		} catch (DataAccessException e) {
			logger.error("增加SYS_CONFIG 错误：{}", e.getMessage());
			throw new SysException("10000", "增加SYS_CONFIG错误", e);
		}
		return entity;
	}

	@Override
	public int update(SysConfigMVO entity) throws SysException {
		int rowsAffected;
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE  SYS_CONFIG  SET ");
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity.getConfigName() != null) {
				sql.append("config_name=?,");
				params.add(entity.getConfigName());
			}
			if (entity.getConfigValue() != null) {
				sql.append("config_value=?,");
				params.add(entity.getConfigValue());
			}
			if (entity.getType() != null) {
				sql.append("type=?,");
				params.add(entity.getType());
			}
			if (entity.getRemarks() != null) {
				sql.append("remarks=?,");
				params.add(entity.getRemarks());
			}
			if (entity.getUpdateTime() != null) {
				sql.append("update_time=str_to_date(?,'%Y-%m-%d %H:%i:%s'),");
				params.add(entity.getUpdateTime());
			}
			if (entity.getEditable() != null) {
				sql.append("editable=?,");
				params.add(entity.getEditable());
			}
			sql.deleteCharAt(sql.length() - 1);
			sql.append(" WHERE config_id=?");
			params.add(entity.getConfigId());
			logger.info(sql.toString() + "--" + params.toString());
			rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());
		} catch (DataAccessException e) {
			logger.error("更新SYS_CONFIG错误：{}", e.getMessage());
			throw new SysException("10000", "更新SYS_CONFIG错误", e);
		}
		return rowsAffected;
	}

	@Override
	public int delete(SysConfigMVO entity) throws SysException {
		int rowsAffected;
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM SYS_CONFIG WHERE config_id=?");
		try {
			logger.info(sql.toString());
			rowsAffected = jdbcTemplate.update(sql.toString(), entity.getConfigId());
		} catch (DataAccessException e) {
			logger.error("删除SYS_CONFIG错误：{}", e.getMessage());
			throw new SysException("10000", "删除SYS_CONFIG错误", e);
		}
		return rowsAffected;
	}

	@Override
	public List<SysConfigMVO> queryList(SysConfigMVO entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT config_id,config_name,config_value,type,remarks,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,editable ");
		sql.append("FROM  SYS_CONFIG ");
		sql.append("WHERE 1=1 ");
		List<SysConfigMVO> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getConfigId())) {
					sql.append(" AND config_id=?");
					params.add(entity.getConfigId());
				}
				if (StringUtils.isNotBlank(entity.getConfigName())) {
					sql.append(" AND config_name=?");
					params.add(entity.getConfigName());
				}
				if (StringUtils.isNotBlank(entity.getConfigValue())) {
					sql.append(" AND config_value=?");
					params.add(entity.getConfigValue());
				}
				if (StringUtils.isNotBlank(entity.getType())) {
					sql.append(" AND type=?");
					params.add(entity.getType());
				}
				if (StringUtils.isNotBlank(entity.getRemarks())) {
					sql.append(" AND remarks=?");
					params.add(entity.getRemarks());
				}
				if (StringUtils.isNotBlank(entity.getUpdateTime())) {
					sql.append("  AND update_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
					params.add(entity.getUpdateTime());
				}
				if (StringUtils.isNotBlank(entity.getEditable())) {
					sql.append(" AND editable=?");
					params.add(entity.getEditable());
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<SysConfigMVO>(SysConfigMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询SYS_CONFIG错误：{}", e.getMessage());
			throw new SysException("10000", "查询SYS_CONFIG错误", e);
		}
		return resultList;
	}

	@Override
	public SysConfigMVO queryBean(SysConfigMVO entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT config_id,config_name,config_value,type,remarks,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,editable ");
		sql.append("FROM  SYS_CONFIG ");
		sql.append("WHERE config_id=? ");
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				params.add(entity.getConfigId());
			} else {
				sql.append(" AND 1=2");
			}
			logger.info(sql.toString() + "--" + params.toString());
			entity = jdbcTemplate.queryForObject(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<SysConfigMVO>(SysConfigMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询SYS_CONFIG错误：{}", e.getMessage());
			throw new SysException("10000", "查询SYS_CONFIG错误", e);
		}
		return entity;
	}

}
