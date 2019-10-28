package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.base.impl.BaseDAO;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IUserRoleSDAO;
import com.jianfuzengxiao.pub.entity.UserRoleMVO;
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

public class UserRoleSDAO extends BaseDAO<UserRoleMVO> implements IUserRoleSDAO {
	private static Logger logger = LoggerFactory.getLogger(UserRoleSDAO.class);

	@Override
	public UserRoleMVO insert(final UserRoleMVO entity) throws SysException {
		final StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO USER_ROLE (user_role_id,user_id,role_id,sts,sts_time) ");
		sql.append("VALUES (?,?,?,?,str_to_date(?,'%Y-%m-%d %H:%i:%s'))");
		try {
			logger.info(sql.toString());
			jdbcTemplate.update(new PreparedStatementCreator() {
				public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					int i = 0;
					java.sql.PreparedStatement ps = conn.prepareStatement(sql.toString());
					ps.setString(++i, StringUtils.trimToNull(entity.getUserRoleId()));
					ps.setString(++i, StringUtils.trimToNull(entity.getUserId()));
					ps.setString(++i, StringUtils.trimToNull(entity.getRoleId()));
					ps.setString(++i, StringUtils.trimToNull(entity.getSts()));
					ps.setString(++i, StringUtils.trimToNull(entity.getStsTime()));
					return ps;
				}
			});
		} catch (DataAccessException e) {
			logger.error("增加USER_ROLE 错误：{}", e.getMessage());
			throw new SysException("增加USER_ROLE错误", "10000", e);
		}
		return entity;
	}

	@Override
	public int update(UserRoleMVO entity) throws SysException {
		int rowsAffected;
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE  USER_ROLE  SET ");
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity.getUserId() != null) {
				sql.append("user_id=?,");
				params.add(entity.getUserId());
			}
			if (entity.getRoleId() != null) {
				sql.append("role_id=?,");
				params.add(entity.getRoleId());
			}
			if (entity.getSts() != null) {
				sql.append("sts=?,");
				params.add(entity.getSts());
			}
			if (entity.getStsTime() != null) {
				sql.append("sts_time=str_to_date(?,'%Y-%m-%d %H:%i:%s'),");
				params.add(entity.getStsTime());
			}
			sql.deleteCharAt(sql.length() - 1);
			sql.append(" WHERE user_role_id=?");
			params.add(entity.getUserRoleId());
			logger.info(sql.toString() + "--" + params.toString());
			rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());
		} catch (DataAccessException e) {
			logger.error("更新USER_ROLE错误：{}", e.getMessage());
			throw new SysException("更新USER_ROLE错误", "10000", e);
		}
		return rowsAffected;
	}

	@Override
	public int delete(UserRoleMVO entity) throws SysException {
		int rowsAffected;
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM USER_ROLE WHERE user_role_id=?");
		try {
			logger.info(sql.toString());
			rowsAffected = jdbcTemplate.update(sql.toString(), entity.getUserRoleId());
		} catch (DataAccessException e) {
			logger.error("删除USER_ROLE错误：{}", e.getMessage());
			throw new SysException("删除USER_ROLE错误", "10000", e);
		}
		return rowsAffected;
	}

	@Override
	public List<UserRoleMVO> queryList(UserRoleMVO entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT user_role_id,user_id,role_id,sts,date_format(sts_time,'%Y-%m-%d %H:%i:%s')sts_time ");
		sql.append("FROM  USER_ROLE ");
		sql.append("WHERE 1=1 ");
		List<UserRoleMVO> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getUserRoleId())) {
					sql.append(" AND user_role_id=?");
					params.add(entity.getUserRoleId());
				}
				if (StringUtils.isNotBlank(entity.getUserId())) {
					sql.append(" AND user_id=?");
					params.add(entity.getUserId());
				}
				if (StringUtils.isNotBlank(entity.getRoleId())) {
					sql.append(" AND role_id=?");
					params.add(entity.getRoleId());
				}
				if (StringUtils.isNotBlank(entity.getSts())) {
					sql.append(" AND sts=?");
					params.add(entity.getSts());
				}
				if (StringUtils.isNotBlank(entity.getStsTime())) {
					sql.append("  AND sts_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
					params.add(entity.getStsTime());
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<UserRoleMVO>(UserRoleMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询USER_ROLE错误：{}", e.getMessage());
			throw new SysException("查询USER_ROLE错误", "10000", e);
		}
		return resultList;
	}

	@Override
	public UserRoleMVO queryBean(UserRoleMVO entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT user_role_id,user_id,role_id,sts,date_format(sts_time,'%Y-%m-%d %H:%i:%s')sts_time ");
		sql.append("FROM  USER_ROLE ");
		sql.append("WHERE user_role_id=? ");
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				params.add(entity.getUserRoleId());
			} else {
				sql.append(" AND 1=2");
			}
			logger.info(sql.toString() + "--" + params.toString());
			entity = jdbcTemplate.queryForObject(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<UserRoleMVO>(UserRoleMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询USER_ROLE错误：{}", e.getMessage());
			throw new SysException("查询USER_ROLE错误", "10000", e);
		}
		return entity;
	}

}
