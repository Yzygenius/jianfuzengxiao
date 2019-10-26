package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.base.impl.BaseDAO;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IAreaInfoSDAO;
import com.jianfuzengxiao.pub.entity.AreaInfoMVO;
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

public class AreaInfoSDAO extends BaseDAO<AreaInfoMVO> implements IAreaInfoSDAO {
	private static Logger logger = LoggerFactory.getLogger(AreaInfoSDAO.class);

	@Override
	public AreaInfoMVO insert(final AreaInfoMVO entity) throws SysException {
		final StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO AREA_INFO (area_code,parent_code,area_name,area_level) ");
		sql.append("VALUES (?,?,?,?)");
		try {
			logger.info(sql.toString());
			jdbcTemplate.update(new PreparedStatementCreator() {
				public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					int i = 0;
					java.sql.PreparedStatement ps = conn.prepareStatement(sql.toString());
					ps.setString(++i, StringUtils.trimToNull(entity.getAreaCode()));
					ps.setString(++i, StringUtils.trimToNull(entity.getParentCode()));
					ps.setString(++i, StringUtils.trimToNull(entity.getAreaName()));
					ps.setString(++i, StringUtils.trimToNull(entity.getAreaLevel()));
					return ps;
				}
			});
		} catch (DataAccessException e) {
			logger.error("增加AREA_INFO 错误：{}", e.getMessage());
			throw new SysException("10000", "增加AREA_INFO错误", e);
		}
		return entity;
	}

	@Override
	public int update(AreaInfoMVO entity) throws SysException {
		int rowsAffected;
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE  AREA_INFO  SET ");
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity.getParentCode() != null) {
				sql.append("parent_code=?,");
				params.add(entity.getParentCode());
			}
			if (entity.getAreaName() != null) {
				sql.append("area_name=?,");
				params.add(entity.getAreaName());
			}
			if (entity.getAreaLevel() != null) {
				sql.append("area_level=?,");
				params.add(entity.getAreaLevel());
			}
			sql.deleteCharAt(sql.length() - 1);
			sql.append(" WHERE area_code=?");
			params.add(entity.getAreaCode());
			logger.info(sql.toString() + "--" + params.toString());
			rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());
		} catch (DataAccessException e) {
			logger.error("更新AREA_INFO错误：{}", e.getMessage());
			throw new SysException("10000", "更新AREA_INFO错误", e);
		}
		return rowsAffected;
	}

	@Override
	public int delete(AreaInfoMVO entity) throws SysException {
		int rowsAffected;
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM AREA_INFO WHERE area_code=?");
		try {
			logger.info(sql.toString());
			rowsAffected = jdbcTemplate.update(sql.toString(), entity.getAreaCode());
		} catch (DataAccessException e) {
			logger.error("删除AREA_INFO错误：{}", e.getMessage());
			throw new SysException("10000", "删除AREA_INFO错误", e);
		}
		return rowsAffected;
	}

	@Override
	public List<AreaInfoMVO> queryList(AreaInfoMVO entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT area_code,parent_code,area_name,area_level ");
		sql.append("FROM  AREA_INFO ");
		sql.append("WHERE 1=1 ");
		List<AreaInfoMVO> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getAreaCode())) {
					sql.append(" AND area_code=?");
					params.add(entity.getAreaCode());
				}
				if (StringUtils.isNotBlank(entity.getParentCode())) {
					sql.append(" AND parent_code=?");
					params.add(entity.getParentCode());
				}
				if (StringUtils.isNotBlank(entity.getAreaName())) {
					sql.append(" AND area_name=?");
					params.add(entity.getAreaName());
				}
				if (StringUtils.isNotBlank(entity.getAreaLevel())) {
					sql.append(" AND area_level=?");
					params.add(entity.getAreaLevel());
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<AreaInfoMVO>(AreaInfoMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询AREA_INFO错误：{}", e.getMessage());
			throw new SysException("10000", "查询AREA_INFO错误", e);
		}
		return resultList;
	}

	@Override
	public AreaInfoMVO queryBean(AreaInfoMVO entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT area_code,parent_code,area_name,area_level ");
		sql.append("FROM  AREA_INFO ");
		sql.append("WHERE area_code=? ");
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				params.add(entity.getAreaCode());
			} else {
				sql.append(" AND 1=2");
			}
			logger.info(sql.toString() + "--" + params.toString());
			entity = jdbcTemplate.queryForObject(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<AreaInfoMVO>(AreaInfoMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询AREA_INFO错误：{}", e.getMessage());
			throw new SysException("10000", "查询AREA_INFO错误", e);
		}
		return entity;
	}

}
