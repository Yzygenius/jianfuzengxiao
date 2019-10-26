package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.base.impl.BaseDAO;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IAttachFileSDAO;
import com.jianfuzengxiao.pub.entity.AttachFileMVO;
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

public class AttachFileSDAO extends BaseDAO<AttachFileMVO> implements IAttachFileSDAO {
	private static Logger logger = LoggerFactory.getLogger(AttachFileSDAO.class);

	@Override
	public AttachFileMVO insert(final AttachFileMVO entity) throws SysException {
		final StringBuilder sql = new StringBuilder();
		sql.append(
				"INSERT INTO ATTACH_FILE (file_id,file_type,file_name,save_name,state,sts,create_time,update_time) ");
		sql.append("VALUES (?,?,?,?,?,?,str_to_date(?,'%Y-%m-%d %H:%i:%s'),str_to_date(?,'%Y-%m-%d %H:%i:%s'))");
		try {
			logger.info(sql.toString());
			jdbcTemplate.update(new PreparedStatementCreator() {
				public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					int i = 0;
					java.sql.PreparedStatement ps = conn.prepareStatement(sql.toString());
					ps.setString(++i, StringUtils.trimToNull(entity.getFileId()));
					ps.setString(++i, StringUtils.trimToNull(entity.getFileType()));
					ps.setString(++i, StringUtils.trimToNull(entity.getFileName()));
					ps.setString(++i, StringUtils.trimToNull(entity.getSaveName()));
					ps.setString(++i, StringUtils.trimToNull(entity.getState()));
					ps.setString(++i, StringUtils.trimToNull(entity.getSts()));
					ps.setString(++i, StringUtils.trimToNull(entity.getCreateTime()));
					ps.setString(++i, StringUtils.trimToNull(entity.getUpdateTime()));
					return ps;
				}
			});
		} catch (DataAccessException e) {
			logger.error("增加ATTACH_FILE 错误：{}", e.getMessage());
			throw new SysException("10000", "增加ATTACH_FILE错误", e);
		}
		return entity;
	}

	@Override
	public int update(AttachFileMVO entity) throws SysException {
		int rowsAffected;
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE  ATTACH_FILE  SET ");
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity.getFileType() != null) {
				sql.append("file_type=?,");
				params.add(entity.getFileType());
			}
			if (entity.getFileName() != null) {
				sql.append("file_name=?,");
				params.add(entity.getFileName());
			}
			if (entity.getSaveName() != null) {
				sql.append("save_name=?,");
				params.add(entity.getSaveName());
			}
			if (entity.getState() != null) {
				sql.append("state=?,");
				params.add(entity.getState());
			}
			if (entity.getSts() != null) {
				sql.append("sts=?,");
				params.add(entity.getSts());
			}
			if (entity.getCreateTime() != null) {
				sql.append("create_time=str_to_date(?,'%Y-%m-%d %H:%i:%s'),");
				params.add(entity.getCreateTime());
			}
			if (entity.getUpdateTime() != null) {
				sql.append("update_time=str_to_date(?,'%Y-%m-%d %H:%i:%s'),");
				params.add(entity.getUpdateTime());
			}
			sql.deleteCharAt(sql.length() - 1);
			sql.append(" WHERE file_id=?");
			params.add(entity.getFileId());
			logger.info(sql.toString() + "--" + params.toString());
			rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());
		} catch (DataAccessException e) {
			logger.error("更新ATTACH_FILE错误：{}", e.getMessage());
			throw new SysException("10000", "更新ATTACH_FILE错误", e);
		}
		return rowsAffected;
	}

	@Override
	public int delete(AttachFileMVO entity) throws SysException {
		int rowsAffected;
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM ATTACH_FILE WHERE file_id=?");
		try {
			logger.info(sql.toString());
			rowsAffected = jdbcTemplate.update(sql.toString(), entity.getFileId());
		} catch (DataAccessException e) {
			logger.error("删除ATTACH_FILE错误：{}", e.getMessage());
			throw new SysException("10000", "删除ATTACH_FILE错误", e);
		}
		return rowsAffected;
	}

	@Override
	public List<AttachFileMVO> queryList(AttachFileMVO entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT file_id,file_type,file_name,save_name,state,sts,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time ");
		sql.append("FROM  ATTACH_FILE ");
		sql.append("WHERE 1=1 ");
		List<AttachFileMVO> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getFileId())) {
					sql.append(" AND file_id=?");
					params.add(entity.getFileId());
				}
				if (StringUtils.isNotBlank(entity.getFileType())) {
					sql.append(" AND file_type=?");
					params.add(entity.getFileType());
				}
				if (StringUtils.isNotBlank(entity.getFileName())) {
					sql.append(" AND file_name=?");
					params.add(entity.getFileName());
				}
				if (StringUtils.isNotBlank(entity.getSaveName())) {
					sql.append(" AND save_name=?");
					params.add(entity.getSaveName());
				}
				if (StringUtils.isNotBlank(entity.getState())) {
					sql.append(" AND state=?");
					params.add(entity.getState());
				}
				if (StringUtils.isNotBlank(entity.getSts())) {
					sql.append(" AND sts=?");
					params.add(entity.getSts());
				}
				if (StringUtils.isNotBlank(entity.getCreateTime())) {
					sql.append("  AND create_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
					params.add(entity.getCreateTime());
				}
				if (StringUtils.isNotBlank(entity.getUpdateTime())) {
					sql.append("  AND update_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
					params.add(entity.getUpdateTime());
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<AttachFileMVO>(AttachFileMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询ATTACH_FILE错误：{}", e.getMessage());
			throw new SysException("10000", "查询ATTACH_FILE错误", e);
		}
		return resultList;
	}

	@Override
	public AttachFileMVO queryBean(AttachFileMVO entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT file_id,file_type,file_name,save_name,state,sts,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time ");
		sql.append("FROM  ATTACH_FILE ");
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
					new BeanPropertyRowMapper<AttachFileMVO>(AttachFileMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询ATTACH_FILE错误：{}", e.getMessage());
			throw new SysException("10000", "查询ATTACH_FILE错误", e);
		}
		return entity;
	}

}
