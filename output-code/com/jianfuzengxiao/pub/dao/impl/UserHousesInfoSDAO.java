package com.jianfuzengxiao.pub.dao.impl;
import com.bamboo.framework.base.impl.BaseDAO;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IUserHousesInfoSDAO;
import com.jianfuzengxiao.pub.entity.UserHousesInfoMVO;
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
public class UserHousesInfoSDAO extends BaseDAO<UserHousesInfoMVO> implements IUserHousesInfoSDAO {
private static Logger logger = LoggerFactory.getLogger(UserHousesInfoSDAO.class);

@Override
    public UserHousesInfoMVO insert(final UserHousesInfoMVO entity) throws SysException { 
        final StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO USER_HOUSES_INFO (u_h_id,userid,houses_id,create_time,update_time,sts) ");
        sql.append("VALUES (?,?,?,str_to_date(?,'%Y-%m-%d %H:%i:%s'),str_to_date(?,'%Y-%m-%d %H:%i:%s'),?)");
        try {
            logger.info(sql.toString());
            jdbcTemplate.update(
                new PreparedStatementCreator(){
                public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException{
                	int i = 0;
                	java.sql.PreparedStatement ps = conn.prepareStatement(sql.toString()); 
                	ps.setString(++i, StringUtils.trimToNull(entity.getUHId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getUserid()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getHousesId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCreateTime()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getUpdateTime()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getSts()));
                	return ps;
              }
            });
          } catch (DataAccessException e) {
          	logger.error("增加USER_HOUSES_INFO 错误：{}", e.getMessage());
          	throw new SysException("增加USER_HOUSES_INFO错误", "10000", e);
          }
          return entity;
       }
    @Override
    public int update(UserHousesInfoMVO entity) throws SysException {
        int rowsAffected;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE  USER_HOUSES_INFO  SET ");
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity.getUserid() != null) {
                sql.append("userid=?,");
                params.add(entity.getUserid());
            }
            if (entity.getHousesId() != null) {
                sql.append("houses_id=?,");
                params.add(entity.getHousesId());
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
            sql.append(" WHERE u_h_id=?");
            params.add(entity.getUHId());
            logger.info(sql.toString() + "--" + params.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());
         } catch (DataAccessException e) {
            logger.error("更新USER_HOUSES_INFO错误：{}", e.getMessage());
            throw new SysException("更新USER_HOUSES_INFO错误", "10000", e);
         }
        return rowsAffected;
    }
    @Override
    public int delete(UserHousesInfoMVO entity) throws SysException {
    	   int rowsAffected;
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM USER_HOUSES_INFO WHERE u_h_id=?");
        try {
        	   logger.info(sql.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(),
                           entity.getUHId());
        } catch (DataAccessException e) {
            logger.error("删除USER_HOUSES_INFO错误：{}", e.getMessage());
            throw new SysException("删除USER_HOUSES_INFO错误", "10000", e);
        }
        return rowsAffected;
    }
    @Override
    public List<UserHousesInfoMVO> queryList(UserHousesInfoMVO entity) throws SysException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT u_h_id,userid,houses_id,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
        sql.append("FROM  USER_HOUSES_INFO ");
        sql.append("WHERE 1=1 ");
        List<UserHousesInfoMVO> resultList = null;
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
            	if (StringUtils.isNotBlank(entity.getUHId())) {
                sql.append(" AND u_h_id=?");
                params.add(entity.getUHId());
            }
            	if (StringUtils.isNotBlank(entity.getUserid())) {
                sql.append(" AND userid=?");
                params.add(entity.getUserid());
            }
            	if (StringUtils.isNotBlank(entity.getHousesId())) {
                sql.append(" AND houses_id=?");
                params.add(entity.getHousesId());
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
			resultList = jdbcTemplate.query(sql.toString(),
			params.toArray(),
			new BeanPropertyRowMapper<UserHousesInfoMVO>(UserHousesInfoMVO.class));
        } catch (DataAccessException e) {
            logger.error("查询USER_HOUSES_INFO错误：{}", e.getMessage());
            throw new SysException("查询USER_HOUSES_INFO错误", "10000", e);
        }
        return resultList;
    }
    @Override
    public UserHousesInfoMVO queryBean(UserHousesInfoMVO entity) throws SysException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT u_h_id,userid,houses_id,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
        sql.append("FROM  USER_HOUSES_INFO ");
        sql.append("WHERE u_h_id=? ");
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
        	   		params.add(entity.getUHId());
        	   } else {
        	   		sql.append(" AND 1=2");
        	   }
			logger.info(sql.toString() + "--" + params.toString());
			 entity = jdbcTemplate.queryForObject(sql.toString(),
			params.toArray(),
			new BeanPropertyRowMapper<UserHousesInfoMVO>(UserHousesInfoMVO.class));
        } catch (DataAccessException e) {
            logger.error("查询USER_HOUSES_INFO错误：{}", e.getMessage());
            throw new SysException("查询USER_HOUSES_INFO错误", "10000", e);
        }
        return entity;
    }


}
