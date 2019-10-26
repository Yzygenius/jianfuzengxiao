package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.base.impl.BaseDAO;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.INationSDAO;
import com.jianfuzengxiao.pub.entity.NationMVO;
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

public class NationSDAO extends BaseDAO<NationMVO> implements INationSDAO {
	private static Logger logger = LoggerFactory.getLogger(NationSDAO.class);

	@Override
	public NationMVO insert(final NationMVO entity) throws SysException {
		final StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO NATION (nation_id,nation_name) ");
		sql.append("VALUES (?,?)");
		try {
			logger.info(sql.toString());
			jdbcTemplate.update(new PreparedStatementCreator() {
				public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					int i = 0;
					java.sql.PreparedStatement ps = conn.prepareStatement(sql.toString());
					ps.setString(++i, StringUtils.trimToNull(entity.getNationId()));
					ps.setString(++i, StringUtils.trimToNull(entity.getNationName()));
					return ps;
				}
			});
		} catch (DataAccessException e) {
			logger.error("增加NATION 错误：{}", e.getMessage());
			throw new SysException("10000", "增加NATION错误", e);
		}
		return entity;
	}

	@Override
	public int update(NationMVO entity) throws SysException {
		int rowsAffected;
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE  NATION  SET ");
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity.getNationName() != null) {
				sql.append("nation_name=?,");
				params.add(entity.getNationName());
			}
			sql.deleteCharAt(sql.length() - 1);
			sql.append(" WHERE nation_id=?");
			params.add(entity.getNationId());
			logger.info(sql.toString() + "--" + params.toString());
			rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());
		} catch (DataAccessException e) {
			logger.error("更新NATION错误：{}", e.getMessage());
			throw new SysException("10000", "更新NATION错误", e);
		}
		return rowsAffected;
	}

	@Override
	public int delete(NationMVO entity) throws SysException {
		int rowsAffected;
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM NATION WHERE nation_id=?");
		try {
			logger.info(sql.toString());
			rowsAffected = jdbcTemplate.update(sql.toString(), entity.getNationId());
		} catch (DataAccessException e) {
			logger.error("删除NATION错误：{}", e.getMessage());
			throw new SysException("10000", "删除NATION错误", e);
		}
		return rowsAffected;
	}

	@Override
	public List<NationMVO> queryList(NationMVO entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT nation_id,nation_name ");
		sql.append("FROM  NATION ");
		sql.append("WHERE 1=1 ");
		List<NationMVO> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getNationId())) {
					sql.append(" AND nation_id=?");
					params.add(entity.getNationId());
				}
				if (StringUtils.isNotBlank(entity.getNationName())) {
					sql.append(" AND nation_name=?");
					params.add(entity.getNationName());
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<NationMVO>(NationMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询NATION错误：{}", e.getMessage());
			throw new SysException("10000", "查询NATION错误", e);
		}
		return resultList;
	}

	@Override
	public NationMVO queryBean(NationMVO entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT nation_id,nation_name ");
		sql.append("FROM  NATION ");
		sql.append("WHERE nation_id=? ");
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				params.add(entity.getNationId());
			} else {
				sql.append(" AND 1=2");
			}
			logger.info(sql.toString() + "--" + params.toString());
			entity = jdbcTemplate.queryForObject(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<NationMVO>(NationMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询NATION错误：{}", e.getMessage());
			throw new SysException("10000", "查询NATION错误", e);
		}
		return entity;
	}

}
