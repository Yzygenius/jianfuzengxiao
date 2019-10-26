package com.jianfuzengxiao.pub.dao.impl;
import com.bamboo.framework.base.impl.BaseDAO;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IRoleFuncSDAO;
import com.jianfuzengxiao.pub.entity.RoleFuncMVO;
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
public class RoleFuncSDAO extends BaseDAO<RoleFuncMVO> implements IRoleFuncSDAO {
private static Logger logger = LoggerFactory.getLogger(RoleFuncSDAO.class);

@Override
    public RoleFuncMVO insert(final RoleFuncMVO entity) throws SysException { 
        final StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ROLE_FUNC (role_func_id,role_id,right_code,sts,sts_time) ");
        sql.append("VALUES (?,?,?,?,str_to_date(?,'%Y-%m-%d %H:%i:%s'))");
        try {
            logger.info(sql.toString());
            jdbcTemplate.update(
                new PreparedStatementCreator(){
                public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException{
                	int i = 0;
                	java.sql.PreparedStatement ps = conn.prepareStatement(sql.toString()); 
                	ps.setString(++i, StringUtils.trimToNull(entity.getRoleFuncId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getRoleId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getRightCode()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getSts()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getStsTime()));
                	return ps;
              }
            });
          } catch (DataAccessException e) {
          	logger.error("增加ROLE_FUNC 错误：{}", e.getMessage());
          	throw new SysException("10000", "增加ROLE_FUNC错误", e);
          }
          return entity;
       }
    @Override
    public int update(RoleFuncMVO entity) throws SysException {
        int rowsAffected;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE  ROLE_FUNC  SET ");
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity.getRoleId() != null) {
                sql.append("role_id=?,");
                params.add(entity.getRoleId());
            }
            if (entity.getRightCode() != null) {
                sql.append("right_code=?,");
                params.add(entity.getRightCode());
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
            sql.append(" WHERE role_func_id=?");
            params.add(entity.getRoleFuncId());
            logger.info(sql.toString() + "--" + params.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());
         } catch (DataAccessException e) {
            logger.error("更新ROLE_FUNC错误：{}", e.getMessage());
            throw new SysException("10000", "更新ROLE_FUNC错误", e);
         }
        return rowsAffected;
    }
    @Override
    public int delete(RoleFuncMVO entity) throws SysException {
    	   int rowsAffected;
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM ROLE_FUNC WHERE role_func_id=?");
        try {
        	   logger.info(sql.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(),
                           entity.getRoleFuncId());
        } catch (DataAccessException e) {
            logger.error("删除ROLE_FUNC错误：{}", e.getMessage());
            throw new SysException("10000", "删除ROLE_FUNC错误", e);
        }
        return rowsAffected;
    }
    @Override
    public List<RoleFuncMVO> queryList(RoleFuncMVO entity) throws SysException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT role_func_id,role_id,right_code,sts,date_format(sts_time,'%Y-%m-%d %H:%i:%s')sts_time ");
        sql.append("FROM  ROLE_FUNC ");
        sql.append("WHERE 1=1 ");
        List<RoleFuncMVO> resultList = null;
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
            	if (StringUtils.isNotBlank(entity.getRoleFuncId())) {
                sql.append(" AND role_func_id=?");
                params.add(entity.getRoleFuncId());
            }
            	if (StringUtils.isNotBlank(entity.getRoleId())) {
                sql.append(" AND role_id=?");
                params.add(entity.getRoleId());
            }
            	if (StringUtils.isNotBlank(entity.getRightCode())) {
                sql.append(" AND right_code=?");
                params.add(entity.getRightCode());
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
			new BeanPropertyRowMapper<RoleFuncMVO>(RoleFuncMVO.class));
        } catch (DataAccessException e) {
            logger.error("查询ROLE_FUNC错误：{}", e.getMessage());
            throw new SysException("10000", "查询ROLE_FUNC错误", e);
        }
        return resultList;
    }
    @Override
    public RoleFuncMVO queryBean(RoleFuncMVO entity) throws SysException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT role_func_id,role_id,right_code,sts,date_format(sts_time,'%Y-%m-%d %H:%i:%s')sts_time ");
        sql.append("FROM  ROLE_FUNC ");
        sql.append("WHERE role_func_id=? ");
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
        	   		params.add(entity.getRoleFuncId());
        	   } else {
        	   		sql.append(" AND 1=2");
        	   }
			logger.info(sql.toString() + "--" + params.toString());
			 entity = jdbcTemplate.queryForObject(sql.toString(),
			params.toArray(),
			new BeanPropertyRowMapper<RoleFuncMVO>(RoleFuncMVO.class));
        } catch (DataAccessException e) {
            logger.error("查询ROLE_FUNC错误：{}", e.getMessage());
            throw new SysException("10000", "查询ROLE_FUNC错误", e);
        }
        return entity;
    }


}
