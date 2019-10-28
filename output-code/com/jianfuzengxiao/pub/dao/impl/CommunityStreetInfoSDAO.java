package com.jianfuzengxiao.pub.dao.impl;
import com.bamboo.framework.base.impl.BaseDAO;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.ICommunityStreetInfoSDAO;
import com.jianfuzengxiao.pub.entity.CommunityStreetInfoMVO;
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
public class CommunityStreetInfoSDAO extends BaseDAO<CommunityStreetInfoMVO> implements ICommunityStreetInfoSDAO {
private static Logger logger = LoggerFactory.getLogger(CommunityStreetInfoSDAO.class);

@Override
    public CommunityStreetInfoMVO insert(final CommunityStreetInfoMVO entity) throws SysException { 
        final StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO COMMUNITY_STREET_INFO (community_street_id,community_street_name,status,community_id,list_order,create_time,update_time,sts) ");
        sql.append("VALUES (?,?,?,?,?,str_to_date(?,'%Y-%m-%d %H:%i:%s'),str_to_date(?,'%Y-%m-%d %H:%i:%s'),?)");
        try {
            logger.info(sql.toString());
            jdbcTemplate.update(
                new PreparedStatementCreator(){
                public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException{
                	int i = 0;
                	java.sql.PreparedStatement ps = conn.prepareStatement(sql.toString()); 
                	ps.setString(++i, StringUtils.trimToNull(entity.getCommunityStreetId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCommunityStreetName()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getStatus()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCommunityId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getListOrder()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCreateTime()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getUpdateTime()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getSts()));
                	return ps;
              }
            });
          } catch (DataAccessException e) {
          	logger.error("增加COMMUNITY_STREET_INFO 错误：{}", e.getMessage());
          	throw new SysException("增加COMMUNITY_STREET_INFO错误", "10000", e);
          }
          return entity;
       }
    @Override
    public int update(CommunityStreetInfoMVO entity) throws SysException {
        int rowsAffected;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE  COMMUNITY_STREET_INFO  SET ");
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity.getCommunityStreetName() != null) {
                sql.append("community_street_name=?,");
                params.add(entity.getCommunityStreetName());
            }
            if (entity.getStatus() != null) {
                sql.append("status=?,");
                params.add(entity.getStatus());
            }
            if (entity.getCommunityId() != null) {
                sql.append("community_id=?,");
                params.add(entity.getCommunityId());
            }
            if (entity.getListOrder() != null) {
                sql.append("list_order=?,");
                params.add(entity.getListOrder());
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
            sql.append(" WHERE community_street_id=?");
            params.add(entity.getCommunityStreetId());
            logger.info(sql.toString() + "--" + params.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());
         } catch (DataAccessException e) {
            logger.error("更新COMMUNITY_STREET_INFO错误：{}", e.getMessage());
            throw new SysException("更新COMMUNITY_STREET_INFO错误", "10000", e);
         }
        return rowsAffected;
    }
    @Override
    public int delete(CommunityStreetInfoMVO entity) throws SysException {
    	   int rowsAffected;
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM COMMUNITY_STREET_INFO WHERE community_street_id=?");
        try {
        	   logger.info(sql.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(),
                           entity.getCommunityStreetId());
        } catch (DataAccessException e) {
            logger.error("删除COMMUNITY_STREET_INFO错误：{}", e.getMessage());
            throw new SysException("删除COMMUNITY_STREET_INFO错误", "10000", e);
        }
        return rowsAffected;
    }
    @Override
    public List<CommunityStreetInfoMVO> queryList(CommunityStreetInfoMVO entity) throws SysException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT community_street_id,community_street_name,status,community_id,list_order,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
        sql.append("FROM  COMMUNITY_STREET_INFO ");
        sql.append("WHERE 1=1 ");
        List<CommunityStreetInfoMVO> resultList = null;
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
            	if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
                sql.append(" AND community_street_id=?");
                params.add(entity.getCommunityStreetId());
            }
            	if (StringUtils.isNotBlank(entity.getCommunityStreetName())) {
                sql.append(" AND community_street_name=?");
                params.add(entity.getCommunityStreetName());
            }
            	if (StringUtils.isNotBlank(entity.getStatus())) {
                sql.append(" AND status=?");
                params.add(entity.getStatus());
            }
            	if (StringUtils.isNotBlank(entity.getCommunityId())) {
                sql.append(" AND community_id=?");
                params.add(entity.getCommunityId());
            }
            	if (StringUtils.isNotBlank(entity.getListOrder())) {
                sql.append(" AND list_order=?");
                params.add(entity.getListOrder());
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
			new BeanPropertyRowMapper<CommunityStreetInfoMVO>(CommunityStreetInfoMVO.class));
        } catch (DataAccessException e) {
            logger.error("查询COMMUNITY_STREET_INFO错误：{}", e.getMessage());
            throw new SysException("查询COMMUNITY_STREET_INFO错误", "10000", e);
        }
        return resultList;
    }
    @Override
    public CommunityStreetInfoMVO queryBean(CommunityStreetInfoMVO entity) throws SysException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT community_street_id,community_street_name,status,community_id,list_order,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
        sql.append("FROM  COMMUNITY_STREET_INFO ");
        sql.append("WHERE community_street_id=? ");
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
        	   		params.add(entity.getCommunityStreetId());
        	   } else {
        	   		sql.append(" AND 1=2");
        	   }
			logger.info(sql.toString() + "--" + params.toString());
			 entity = jdbcTemplate.queryForObject(sql.toString(),
			params.toArray(),
			new BeanPropertyRowMapper<CommunityStreetInfoMVO>(CommunityStreetInfoMVO.class));
        } catch (DataAccessException e) {
            logger.error("查询COMMUNITY_STREET_INFO错误：{}", e.getMessage());
            throw new SysException("查询COMMUNITY_STREET_INFO错误", "10000", e);
        }
        return entity;
    }


}
