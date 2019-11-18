package com.jianfuzengxiao.pub.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.bamboo.framework.base.impl.BaseDAO;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IWxConfigSDAO;
import com.jianfuzengxiao.pub.entity.WxConfigMVO;

public class WxConfigSDAO extends BaseDAO<WxConfigMVO> implements IWxConfigSDAO {

	private static Logger logger = LoggerFactory.getLogger(AreaInfoSDAO.class);

	@Override
	public WxConfigMVO insert(final WxConfigMVO entity) throws SysException {
		final StringBuilder sql = new StringBuilder();
		sql.append(
				"INSERT INTO wx_config (config_id,config_name,config_key,config_value,type,remark,update_time) ");
		sql.append("VALUES (?,?,?,?,?,?,str_to_date(?,'%Y-%m-%d %H:%i:%s'))");
		try {
			logger.info(sql.toString());
			jdbcTemplate.update(new PreparedStatementCreator() {
				public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					int i = 0;
					java.sql.PreparedStatement ps = conn.prepareStatement(sql.toString());
					ps.setString(++i, StringUtils.trimToNull(entity.getConfigId()));
					ps.setString(++i, StringUtils.trimToNull(entity.getConfigName()));
					ps.setString(++i, StringUtils.trimToNull(entity.getConfigKey()));
					ps.setString(++i, StringUtils.trimToNull(entity.getConfigValue()));
					ps.setString(++i, StringUtils.trimToNull(entity.getType()));
					ps.setString(++i, StringUtils.trimToNull(entity.getRemark()));
					ps.setString(++i, StringUtils.trimToNull(entity.getUpdateTime()));
					return ps;
				}
			});
		} catch (DataAccessException e) {
			logger.error("增加wx_config 错误：{}", e.getMessage());
			throw new SysException("10000", "增加wx_config错误", e);
		}
		return entity;
	}

	@Override
	public int update(WxConfigMVO entity) throws SysException {
		int rowsAffected;
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE wx_config  SET ");
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity.getConfigName() != null) {
				sql.append("config_name=?,");
				params.add(entity.getConfigName());
			}
			if (entity.getConfigKey() != null) {
				sql.append("config_key=?,");
				params.add(entity.getConfigKey());
			}
			if (entity.getConfigValue() != null) {
				sql.append("config_value=?,");
				params.add(entity.getConfigValue());
			}
			if (entity.getType() != null) {
				sql.append("type=?,");
				params.add(entity.getType());
			}
			if (entity.getRemark() != null) {
				sql.append("remark=?,");
				params.add(entity.getRemark());
			}
			if (entity.getUpdateTime() != null) {
				sql.append("update_time=str_to_date(?,'%Y-%m-%d %H:%i:%s'),");
				params.add(entity.getUpdateTime());
			}
			sql.deleteCharAt(sql.length() - 1);
			sql.append(" WHERE config_id=?");
			params.add(entity.getConfigId());
			logger.info(sql.toString() + "--" + params.toString());
			rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());
		} catch (DataAccessException e) {
			logger.error("更新wx_config错误：{}", e.getMessage());
			throw new SysException("10000", "更新wx_config错误", e);
		}
		return rowsAffected;
	}

	@Override
	public int delete(WxConfigMVO entity) throws SysException {
		int rowsAffected;
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM wx_config WHERE config_id=?");
		try {
			logger.info(sql.toString());
			rowsAffected = jdbcTemplate.update(sql.toString(), entity.getConfigId());
		} catch (DataAccessException e) {
			logger.error("删除wx_config错误：{}", e.getMessage());
			throw new SysException("10000", "删除wx_config错误", e);
		}
		return rowsAffected;
	}

	@Override
	public List<WxConfigMVO> queryList(WxConfigMVO entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT config_id,config_name,config_key,config_value,type,remark,str_to_date(update_time,'%Y-%m-%d %H:%i:%s')update_time ");
		sql.append("FROM  wx_config ");
		sql.append("WHERE 1=1 ");
		List<WxConfigMVO> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getConfigId())) {
					sql.append(" AND config_id = ?");
					params.add(entity.getConfigId());
				}
				if (StringUtils.isNotBlank(entity.getConfigName())) {
					sql.append(" AND config_name = ?");
					params.add(entity.getConfigName());
				}
				if (StringUtils.isNotBlank(entity.getConfigKey())) {
					sql.append(" AND config_key=?");
					params.add(entity.getConfigKey());
				}
				if (StringUtils.isNotBlank(entity.getConfigValue())) {
					sql.append(" AND config_value=?");
					params.add(entity.getConfigValue());
				}
				if (StringUtils.isNotBlank(entity.getType())) {
					sql.append(" AND amap_code = ?");
					params.add(entity.getType());
				}
				if (StringUtils.isNotBlank(entity.getRemark())) {
					sql.append(" AND remark like ?");
					params.add("%" + entity.getRemark() + "%");
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<WxConfigMVO>(WxConfigMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询wx_config错误：{}", e.getMessage());
			throw new SysException("10000", "查询wx_config错误", e);
		}
		return resultList;
	}

	@Override
	public WxConfigMVO queryBean(WxConfigMVO entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT config_id,config_name,config_key,config_value,type,remark,str_to_date(update_time,'%Y-%m-%d %H:%i:%s')update_time ");
		sql.append("FROM  wx_config ");
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
					new BeanPropertyRowMapper<WxConfigMVO>(WxConfigMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询wx_config错误：{}", e.getMessage());
			throw new SysException("10000", "查询wx_config错误", e);
		}
		return entity;
	}
}
