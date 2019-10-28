package com.jianfuzengxiao.pub.dao.impl;
import com.bamboo.framework.base.impl.BaseDAO;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IRoleInfoSDAO;
import com.jianfuzengxiao.pub.entity.RoleInfoMVO;
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
public class RoleInfoSDAO extends BaseDAO<RoleInfoMVO> implements IRoleInfoSDAO {
private static Logger logger = LoggerFactory.getLogger(RoleInfoSDAO.class);

@Override
    public RoleInfoMVO insert(final RoleInfoMVO entity) throws SysException { 
        final StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ROLE_INFO (role_id,role_name,role_desc,sts,sts_time) ");
        sql.append("VALUES (?,?,?,?,str_to_date(?,'%Y-%m-%d %H:%i:%s'))");
        try {
            logger.info(sql.toString());
            jdbcTemplate.update(
                new PreparedStatementCreator(){
                public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException{
                	int i = 0;
                	java.sql.PreparedStatement ps = conn.prepareStatement(sql.toString()); 
                	ps.setString(++i, StringUtils.trimToNull(entity.getRoleId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getRoleName()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getRoleDesc()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getSts()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getStsTime()));
                	return ps;
              }
            });
          } catch (DataAccessException e) {
          	logger.error("增加ROLE_INFO 错误：{}", e.getMessage());
          	throw new SysException("增加ROLE_INFO错误", "10000", e);
          }
          return entity;
       }
    @Override
    public int update(RoleInfoMVO entity) throws SysException {
        int rowsAffected;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE  ROLE_INFO  SET ");
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity.getRoleName() != null) {
                sql.append("role_name=?,");
                params.add(entity.getRoleName());
            }
            if (entity.getRoleDesc() != null) {
                sql.append("role_desc=?,");
                params.add(entity.getRoleDesc());
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
            sql.append(" WHERE role_id=?");
            params.add(entity.getRoleId());
            logger.info(sql.toString() + "--" + params.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());
         } catch (DataAccessException e) {
            logger.error("更新ROLE_INFO错误：{}", e.getMessage());
            throw new SysException("更新ROLE_INFO错误", "10000", e);
         }
        return rowsAffected;
    }
    @Override
    public int delete(RoleInfoMVO entity) throws SysException {
    	   int rowsAffected;
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM ROLE_INFO WHERE role_id=?");
        try {
        	   logger.info(sql.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(),
                           entity.getRoleId());
        } catch (DataAccessException e) {
            logger.error("删除ROLE_INFO错误：{}", e.getMessage());
            throw new SysException("删除ROLE_INFO错误", "10000", e);
        }
        return rowsAffected;
    }
    @Override
    public List<RoleInfoMVO> queryList(RoleInfoMVO entity) throws SysException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT role_id,role_name,role_desc,sts,date_format(sts_time,'%Y-%m-%d %H:%i:%s')sts_time ");
        sql.append("FROM  ROLE_INFO ");
        sql.append("WHERE 1=1 ");
        List<RoleInfoMVO> resultList = null;
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
            	if (StringUtils.isNotBlank(entity.getRoleId())) {
                sql.append(" AND role_id=?");
                params.add(entity.getRoleId());
            }
            	if (StringUtils.isNotBlank(entity.getRoleName())) {
                sql.append(" AND role_name=?");
                params.add(entity.getRoleName());
            }
            	if (StringUtils.isNotBlank(entity.getRoleDesc())) {
                sql.append(" AND role_desc=?");
                params.add(entity.getRoleDesc());
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
			resultList = jdbcTemplate.query(sql.toString(),
			params.toArray(),
			new BeanPropertyRowMapper<RoleInfoMVO>(RoleInfoMVO.class));
        } catch (DataAccessException e) {
            logger.error("查询ROLE_INFO错误：{}", e.getMessage());
            throw new SysException("查询ROLE_INFO错误", "10000", e);
        }
        return resultList;
    }
    @Override
    public RoleInfoMVO queryBean(RoleInfoMVO entity) throws SysException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT role_id,role_name,role_desc,sts,date_format(sts_time,'%Y-%m-%d %H:%i:%s')sts_time ");
        sql.append("FROM  ROLE_INFO ");
        sql.append("WHERE role_id=? ");
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
        	   		params.add(entity.getRoleId());
        	   } else {
        	   		sql.append(" AND 1=2");
        	   }
			logger.info(sql.toString() + "--" + params.toString());
			 entity = jdbcTemplate.queryForObject(sql.toString(),
			params.toArray(),
			new BeanPropertyRowMapper<RoleInfoMVO>(RoleInfoMVO.class));
        } catch (DataAccessException e) {
            logger.error("查询ROLE_INFO错误：{}", e.getMessage());
            throw new SysException("查询ROLE_INFO错误", "10000", e);
        }
        return entity;
    }


}
