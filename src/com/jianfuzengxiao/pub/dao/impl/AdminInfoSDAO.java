package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.base.impl.BaseDAO;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IAdminInfoSDAO;
import com.jianfuzengxiao.pub.entity.AdminInfoMVO;
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

public class AdminInfoSDAO extends BaseDAO<AdminInfoMVO> implements IAdminInfoSDAO {
	private static Logger logger = LoggerFactory.getLogger(AdminInfoSDAO.class);

	@Override
	public AdminInfoMVO insert(final AdminInfoMVO entity) throws SysException {
		final StringBuilder sql = new StringBuilder();
		sql.append(
				"INSERT INTO ADMIN_INFO (admin_id,login_name,password,satl,username,gender,birth_date,nation_id,nation_name,telephone,role_id,role_name,is_wx,wx_name,wx_account_number,wx_openid,wx_photo,wx_time,wx_password,create_time,update_time,sts) ");
		sql.append(
				"VALUES (?,?,?,?,?,?,str_to_date(?,'%Y-%m-%d %H:%i:%s'),?,?,?,?,?,?,?,?,?,?,str_to_date(?,'%Y-%m-%d %H:%i:%s'),?,str_to_date(?,'%Y-%m-%d %H:%i:%s'),str_to_date(?,'%Y-%m-%d %H:%i:%s'),?)");
		try {
			logger.info(sql.toString());
			jdbcTemplate.update(new PreparedStatementCreator() {
				public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					int i = 0;
					java.sql.PreparedStatement ps = conn.prepareStatement(sql.toString());
					ps.setString(++i, StringUtils.trimToNull(entity.getAdminId()));
					ps.setString(++i, StringUtils.trimToNull(entity.getLoginName()));
					ps.setString(++i, StringUtils.trimToNull(entity.getPassword()));
					ps.setString(++i, StringUtils.trimToNull(entity.getSatl()));
					ps.setString(++i, StringUtils.trimToNull(entity.getUsername()));
					ps.setString(++i, StringUtils.trimToNull(entity.getGender()));
					ps.setString(++i, StringUtils.trimToNull(entity.getBirthDate()));
					ps.setString(++i, StringUtils.trimToNull(entity.getNationId()));
					ps.setString(++i, StringUtils.trimToNull(entity.getNationName()));
					ps.setString(++i, StringUtils.trimToNull(entity.getTelephone()));
					ps.setString(++i, StringUtils.trimToNull(entity.getRoleId()));
					ps.setString(++i, StringUtils.trimToNull(entity.getRoleName()));
					ps.setString(++i, StringUtils.trimToNull(entity.getIsWx()));
					ps.setString(++i, StringUtils.trimToNull(entity.getWxName()));
					ps.setString(++i, StringUtils.trimToNull(entity.getWxAccountNumber()));
					ps.setString(++i, StringUtils.trimToNull(entity.getWxOpenid()));
					ps.setString(++i, StringUtils.trimToNull(entity.getWxPhoto()));
					ps.setString(++i, StringUtils.trimToNull(entity.getWxTime()));
					ps.setString(++i, StringUtils.trimToNull(entity.getWxPassword()));
					ps.setString(++i, StringUtils.trimToNull(entity.getCreateTime()));
					ps.setString(++i, StringUtils.trimToNull(entity.getUpdateTime()));
					ps.setString(++i, StringUtils.trimToNull(entity.getSts()));
					return ps;
				}
			});
		} catch (DataAccessException e) {
			logger.error("增加ADMIN_INFO 错误：{}", e.getMessage());
			throw new SysException("增加ADMIN_INFO错误", "10000", e);
		}
		return entity;
	}

	@Override
	public int update(AdminInfoMVO entity) throws SysException {
		int rowsAffected;
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE  ADMIN_INFO  SET ");
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity.getLoginName() != null) {
				sql.append("login_name=?,");
				params.add(entity.getLoginName());
			}
			if (entity.getPassword() != null) {
				sql.append("password=?,");
				params.add(entity.getPassword());
			}
			if (entity.getSatl() != null) {
				sql.append("satl=?,");
				params.add(entity.getSatl());
			}
			if (entity.getUsername() != null) {
				sql.append("username=?,");
				params.add(entity.getUsername());
			}
			if (entity.getGender() != null) {
				sql.append("gender=?,");
				params.add(entity.getGender());
			}
			if (entity.getBirthDate() != null) {
				sql.append("birth_date=str_to_date(?,'%Y-%m-%d %H:%i:%s'),");
				params.add(entity.getBirthDate());
			}
			if (entity.getNationId() != null) {
				sql.append("nation_id=?,");
				params.add(entity.getNationId());
			}
			if (entity.getNationName() != null) {
				sql.append("nation_name=?,");
				params.add(entity.getNationName());
			}
			if (entity.getTelephone() != null) {
				sql.append("telephone=?,");
				params.add(entity.getTelephone());
			}
			if (entity.getRoleId() != null) {
				sql.append("role_id=?,");
				params.add(entity.getRoleId());
			}
			if (entity.getRoleName() != null) {
				sql.append("role_name=?,");
				params.add(entity.getRoleName());
			}
			if (entity.getIsWx() != null) {
				sql.append("is_wx=?,");
				params.add(entity.getIsWx());
			}
			if (entity.getWxName() != null) {
				sql.append("wx_name=?,");
				params.add(entity.getWxName());
			}
			if (entity.getWxAccountNumber() != null) {
				sql.append("wx_account_number=?,");
				params.add(entity.getWxAccountNumber());
			}
			if (entity.getWxOpenid() != null) {
				sql.append("wx_openid=?,");
				params.add(entity.getWxOpenid());
			}
			if (entity.getWxPhoto() != null) {
				sql.append("wx_photo=?,");
				params.add(entity.getWxPhoto());
			}
			if (entity.getWxTime() != null) {
				sql.append("wx_time=str_to_date(?,'%Y-%m-%d %H:%i:%s'),");
				params.add(entity.getWxTime());
			}
			if (entity.getWxPassword() != null) {
				sql.append("wx_password=?,");
				params.add(entity.getWxPassword());
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
			sql.append(" WHERE admin_id=?");
			params.add(entity.getAdminId());
			logger.info(sql.toString() + "--" + params.toString());
			rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());
		} catch (DataAccessException e) {
			logger.error("更新ADMIN_INFO错误：{}", e.getMessage());
			throw new SysException("更新ADMIN_INFO错误", "10000", e);
		}
		return rowsAffected;
	}

	@Override
	public int delete(AdminInfoMVO entity) throws SysException {
		int rowsAffected;
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM ADMIN_INFO WHERE admin_id=?");
		try {
			logger.info(sql.toString());
			rowsAffected = jdbcTemplate.update(sql.toString(), entity.getAdminId());
		} catch (DataAccessException e) {
			logger.error("删除ADMIN_INFO错误：{}", e.getMessage());
			throw new SysException("删除ADMIN_INFO错误", "10000", e);
		}
		return rowsAffected;
	}

	@Override
	public List<AdminInfoMVO> queryList(AdminInfoMVO entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT admin_id,login_name,password,satl,username,gender,date_format(birth_date,'%Y-%m-%d %H:%i:%s')birth_date,nation_id,nation_name,telephone,role_id,role_name,is_wx,wx_name,wx_account_number,wx_openid,wx_photo,date_format(wx_time,'%Y-%m-%d %H:%i:%s')wx_time,wx_password,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
		sql.append("FROM  ADMIN_INFO ");
		sql.append("WHERE 1=1 ");
		List<AdminInfoMVO> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getAdminId())) {
					sql.append(" AND admin_id=?");
					params.add(entity.getAdminId());
				}
				if (StringUtils.isNotBlank(entity.getLoginName())) {
					sql.append(" AND login_name=?");
					params.add(entity.getLoginName());
				}
				if (StringUtils.isNotBlank(entity.getPassword())) {
					sql.append(" AND password=?");
					params.add(entity.getPassword());
				}
				if (StringUtils.isNotBlank(entity.getSatl())) {
					sql.append(" AND satl=?");
					params.add(entity.getSatl());
				}
				if (StringUtils.isNotBlank(entity.getUsername())) {
					sql.append(" AND username=?");
					params.add(entity.getUsername());
				}
				if (StringUtils.isNotBlank(entity.getGender())) {
					sql.append(" AND gender=?");
					params.add(entity.getGender());
				}
				if (StringUtils.isNotBlank(entity.getBirthDate())) {
					sql.append("  AND birth_date=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
					params.add(entity.getBirthDate());
				}
				if (StringUtils.isNotBlank(entity.getNationId())) {
					sql.append(" AND nation_id=?");
					params.add(entity.getNationId());
				}
				if (StringUtils.isNotBlank(entity.getNationName())) {
					sql.append(" AND nation_name=?");
					params.add(entity.getNationName());
				}
				if (StringUtils.isNotBlank(entity.getTelephone())) {
					sql.append(" AND telephone=?");
					params.add(entity.getTelephone());
				}
				if (StringUtils.isNotBlank(entity.getRoleId())) {
					sql.append(" AND role_id=?");
					params.add(entity.getRoleId());
				}
				if (StringUtils.isNotBlank(entity.getRoleName())) {
					sql.append(" AND role_name=?");
					params.add(entity.getRoleName());
				}
				if (StringUtils.isNotBlank(entity.getIsWx())) {
					sql.append(" AND is_wx=?");
					params.add(entity.getIsWx());
				}
				if (StringUtils.isNotBlank(entity.getWxName())) {
					sql.append(" AND wx_name=?");
					params.add(entity.getWxName());
				}
				if (StringUtils.isNotBlank(entity.getWxAccountNumber())) {
					sql.append(" AND wx_account_number=?");
					params.add(entity.getWxAccountNumber());
				}
				if (StringUtils.isNotBlank(entity.getWxOpenid())) {
					sql.append(" AND wx_openid=?");
					params.add(entity.getWxOpenid());
				}
				if (StringUtils.isNotBlank(entity.getWxPhoto())) {
					sql.append(" AND wx_photo=?");
					params.add(entity.getWxPhoto());
				}
				if (StringUtils.isNotBlank(entity.getWxTime())) {
					sql.append("  AND wx_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
					params.add(entity.getWxTime());
				}
				if (StringUtils.isNotBlank(entity.getWxPassword())) {
					sql.append(" AND wx_password=?");
					params.add(entity.getWxPassword());
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
					new BeanPropertyRowMapper<AdminInfoMVO>(AdminInfoMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询ADMIN_INFO错误：{}", e.getMessage());
			throw new SysException("查询ADMIN_INFO错误", "10000", e);
		}
		return resultList;
	}

	@Override
	public AdminInfoMVO queryBean(AdminInfoMVO entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT admin_id,login_name,password,satl,username,gender,date_format(birth_date,'%Y-%m-%d %H:%i:%s')birth_date,nation_id,nation_name,telephone,role_id,role_name,is_wx,wx_name,wx_account_number,wx_openid,wx_photo,date_format(wx_time,'%Y-%m-%d %H:%i:%s')wx_time,wx_password,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
		sql.append("FROM  ADMIN_INFO ");
		sql.append("WHERE admin_id=? ");
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				params.add(entity.getAdminId());
			} else {
				sql.append(" AND 1=2");
			}
			logger.info(sql.toString() + "--" + params.toString());
			entity = jdbcTemplate.queryForObject(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<AdminInfoMVO>(AdminInfoMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询ADMIN_INFO错误：{}", e.getMessage());
			throw new SysException("查询ADMIN_INFO错误", "10000", e);
		}
		return entity;
	}

}
