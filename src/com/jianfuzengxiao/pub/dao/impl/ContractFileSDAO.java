package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.base.impl.BaseDAO;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IContractFileSDAO;
import com.jianfuzengxiao.pub.entity.ContractFileMVO;
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

public class ContractFileSDAO extends BaseDAO<ContractFileMVO> implements IContractFileSDAO {
	private static Logger logger = LoggerFactory.getLogger(ContractFileSDAO.class);

	@Override
	public ContractFileMVO insert(final ContractFileMVO entity) throws SysException {
		final StringBuilder sql = new StringBuilder();
		sql.append(
				"INSERT INTO CONTRACT_FILE (file_id,personnel_id,houses_id,user_id,file_thumb,create_time,update_time,sts) ");
		sql.append("VALUES (?,?,?,?,?,str_to_date(?,'%Y-%m-%d %H:%i:%s'),str_to_date(?,'%Y-%m-%d %H:%i:%s'),?)");
		try {
			logger.info(sql.toString());
			jdbcTemplate.update(new PreparedStatementCreator() {
				public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					int i = 0;
					java.sql.PreparedStatement ps = conn.prepareStatement(sql.toString());
					ps.setString(++i, StringUtils.trimToNull(entity.getFileId()));
					ps.setString(++i, StringUtils.trimToNull(entity.getPersonnelId()));
					ps.setString(++i, StringUtils.trimToNull(entity.getHousesId()));
					ps.setString(++i, StringUtils.trimToNull(entity.getUserId()));
					ps.setString(++i, StringUtils.trimToNull(entity.getFileThumb()));
					ps.setString(++i, StringUtils.trimToNull(entity.getCreateTime()));
					ps.setString(++i, StringUtils.trimToNull(entity.getUpdateTime()));
					ps.setString(++i, StringUtils.trimToNull(entity.getSts()));
					return ps;
				}
			});
		} catch (DataAccessException e) {
			logger.error("增加CONTRACT_FILE 错误：{}", e.getMessage());
			throw new SysException("增加CONTRACT_FILE错误", "10000", e);
		}
		return entity;
	}

	@Override
	public int update(ContractFileMVO entity) throws SysException {
		int rowsAffected;
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE  CONTRACT_FILE  SET ");
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity.getPersonnelId() != null) {
				sql.append("personnel_id=?,");
				params.add(entity.getPersonnelId());
			}
			if (entity.getHousesId() != null) {
				sql.append("houses_id=?,");
				params.add(entity.getHousesId());
			}
			if (entity.getUserId() != null) {
				sql.append("user_id=?,");
				params.add(entity.getUserId());
			}
			if (entity.getFileThumb() != null) {
				sql.append("file_thumb=?,");
				params.add(entity.getFileThumb());
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
			sql.append(" WHERE file_id=?");
			params.add(entity.getFileId());
			logger.info(sql.toString() + "--" + params.toString());
			rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());
		} catch (DataAccessException e) {
			logger.error("更新CONTRACT_FILE错误：{}", e.getMessage());
			throw new SysException("更新CONTRACT_FILE错误", "10000", e);
		}
		return rowsAffected;
	}

	@Override
	public int delete(ContractFileMVO entity) throws SysException {
		int rowsAffected;
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM CONTRACT_FILE WHERE file_id=?");
		try {
			logger.info(sql.toString());
			rowsAffected = jdbcTemplate.update(sql.toString(), entity.getFileId());
		} catch (DataAccessException e) {
			logger.error("删除CONTRACT_FILE错误：{}", e.getMessage());
			throw new SysException("删除CONTRACT_FILE错误", "10000", e);
		}
		return rowsAffected;
	}

	@Override
	public List<ContractFileMVO> queryList(ContractFileMVO entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT file_id,personnel_id,houses_id,user_id,file_thumb,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
		sql.append("FROM  CONTRACT_FILE ");
		sql.append("WHERE 1=1 ");
		List<ContractFileMVO> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getFileId())) {
					sql.append(" AND file_id=?");
					params.add(entity.getFileId());
				}
				if (StringUtils.isNotBlank(entity.getPersonnelId())) {
					sql.append(" AND personnel_id=?");
					params.add(entity.getPersonnelId());
				}
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND houses_id=?");
					params.add(entity.getHousesId());
				}
				if (StringUtils.isNotBlank(entity.getUserId())) {
					sql.append(" AND user_id=?");
					params.add(entity.getUserId());
				}
				if (StringUtils.isNotBlank(entity.getFileThumb())) {
					sql.append(" AND file_thumb=?");
					params.add(entity.getFileThumb());
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
					new BeanPropertyRowMapper<ContractFileMVO>(ContractFileMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询CONTRACT_FILE错误：{}", e.getMessage());
			throw new SysException("查询CONTRACT_FILE错误", "10000", e);
		}
		return resultList;
	}

	@Override
	public ContractFileMVO queryBean(ContractFileMVO entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT file_id,personnel_id,houses_id,user_id,file_thumb,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
		sql.append("FROM  CONTRACT_FILE ");
		sql.append("WHERE file_id=? ");
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				params.add(entity.getFileId());
			} else {
				sql.append(" AND 1=2");
			}
			logger.info(sql.toString() + "--" + params.toString());
			entity = jdbcTemplate.queryForObject(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<ContractFileMVO>(ContractFileMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询CONTRACT_FILE错误：{}", e.getMessage());
			throw new SysException("查询CONTRACT_FILE错误", "10000", e);
		}
		return entity;
	}

}
