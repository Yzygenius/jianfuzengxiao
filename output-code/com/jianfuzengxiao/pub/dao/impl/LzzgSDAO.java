package com.jianfuzengxiao.pub.dao.impl;
import com.bamboo.framework.base.impl.BaseDAO;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.ILzzgSDAO;
import com.jianfuzengxiao.pub.entity.LzzgMVO;
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
public class LzzgSDAO extends BaseDAO<LzzgMVO> implements ILzzgSDAO {
private static Logger logger = LoggerFactory.getLogger(LzzgSDAO.class);

@Override
    public LzzgMVO insert(final LzzgMVO entity) throws SysException { 
        final StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO LZZG (lzzg_id,admin_id,community_id,status,create_time,update_time,sts) ");
        sql.append("VALUES (?,?,?,?,str_to_date(?,'%Y-%m-%d %H:%i:%s'),str_to_date(?,'%Y-%m-%d %H:%i:%s'),?)");
        try {
            logger.info(sql.toString());
            jdbcTemplate.update(
                new PreparedStatementCreator(){
                public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException{
                	int i = 0;
                	java.sql.PreparedStatement ps = conn.prepareStatement(sql.toString()); 
                	ps.setString(++i, StringUtils.trimToNull(entity.getLzzgId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getAdminId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCommunityId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getStatus()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCreateTime()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getUpdateTime()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getSts()));
                	return ps;
              }
            });
          } catch (DataAccessException e) {
          	logger.error("增加LZZG 错误：{}", e.getMessage());
          	throw new SysException("增加LZZG错误", "10000", e);
          }
          return entity;
       }
    @Override
    public int update(LzzgMVO entity) throws SysException {
        int rowsAffected;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE  LZZG  SET ");
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity.getAdminId() != null) {
                sql.append("admin_id=?,");
                params.add(entity.getAdminId());
            }
            if (entity.getCommunityId() != null) {
                sql.append("community_id=?,");
                params.add(entity.getCommunityId());
            }
            if (entity.getStatus() != null) {
                sql.append("status=?,");
                params.add(entity.getStatus());
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
            sql.append(" WHERE lzzg_id=?");
            params.add(entity.getLzzgId());
            logger.info(sql.toString() + "--" + params.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());
         } catch (DataAccessException e) {
            logger.error("更新LZZG错误：{}", e.getMessage());
            throw new SysException("更新LZZG错误", "10000", e);
         }
        return rowsAffected;
    }
    @Override
    public int delete(LzzgMVO entity) throws SysException {
    	   int rowsAffected;
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM LZZG WHERE lzzg_id=?");
        try {
        	   logger.info(sql.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(),
                           entity.getLzzgId());
        } catch (DataAccessException e) {
            logger.error("删除LZZG错误：{}", e.getMessage());
            throw new SysException("删除LZZG错误", "10000", e);
        }
        return rowsAffected;
    }
    @Override
    public List<LzzgMVO> queryList(LzzgMVO entity) throws SysException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT lzzg_id,admin_id,community_id,status,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
        sql.append("FROM  LZZG ");
        sql.append("WHERE 1=1 ");
        List<LzzgMVO> resultList = null;
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
            	if (StringUtils.isNotBlank(entity.getLzzgId())) {
                sql.append(" AND lzzg_id=?");
                params.add(entity.getLzzgId());
            }
            	if (StringUtils.isNotBlank(entity.getAdminId())) {
                sql.append(" AND admin_id=?");
                params.add(entity.getAdminId());
            }
            	if (StringUtils.isNotBlank(entity.getCommunityId())) {
                sql.append(" AND community_id=?");
                params.add(entity.getCommunityId());
            }
            	if (StringUtils.isNotBlank(entity.getStatus())) {
                sql.append(" AND status=?");
                params.add(entity.getStatus());
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
			new BeanPropertyRowMapper<LzzgMVO>(LzzgMVO.class));
        } catch (DataAccessException e) {
            logger.error("查询LZZG错误：{}", e.getMessage());
            throw new SysException("查询LZZG错误", "10000", e);
        }
        return resultList;
    }
    @Override
    public LzzgMVO queryBean(LzzgMVO entity) throws SysException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT lzzg_id,admin_id,community_id,status,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
        sql.append("FROM  LZZG ");
        sql.append("WHERE lzzg_id=? ");
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
        	   		params.add(entity.getLzzgId());
        	   } else {
        	   		sql.append(" AND 1=2");
        	   }
			logger.info(sql.toString() + "--" + params.toString());
			 entity = jdbcTemplate.queryForObject(sql.toString(),
			params.toArray(),
			new BeanPropertyRowMapper<LzzgMVO>(LzzgMVO.class));
        } catch (DataAccessException e) {
            logger.error("查询LZZG错误：{}", e.getMessage());
            throw new SysException("查询LZZG错误", "10000", e);
        }
        return entity;
    }


}
