package com.jianfuzengxiao.pub.dao.impl;
import com.bamboo.framework.base.impl.BaseDAO;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.ICommunityInfoSDAO;
import com.jianfuzengxiao.pub.entity.CommunityInfoMVO;
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
public class CommunityInfoSDAO extends BaseDAO<CommunityInfoMVO> implements ICommunityInfoSDAO {
private static Logger logger = LoggerFactory.getLogger(CommunityInfoSDAO.class);

@Override
    public CommunityInfoMVO insert(final CommunityInfoMVO entity) throws SysException { 
        final StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO COMMUNITY_INFO (community_id,community_name,list_order,create_time,update_time,sts,prov_name,prov_code,city_code,city_name,area_code,area_name,gwh_id,gwh_name) ");
        sql.append("VALUES (?,?,?,str_to_date(?,'%Y-%m-%d %H:%i:%s'),str_to_date(?,'%Y-%m-%d %H:%i:%s'),?,?,?,?,?,?,?,?,?)");
        try {
            logger.info(sql.toString());
            jdbcTemplate.update(
                new PreparedStatementCreator(){
                public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException{
                	int i = 0;
                	java.sql.PreparedStatement ps = conn.prepareStatement(sql.toString()); 
                	ps.setString(++i, StringUtils.trimToNull(entity.getCommunityId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCommunityName()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getListOrder()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCreateTime()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getUpdateTime()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getSts()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getProvName()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getProvCode()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCityCode()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCityName()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getAreaCode()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getAreaName()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getGwhId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getGwhName()));
                	return ps;
              }
            });
          } catch (DataAccessException e) {
          	logger.error("增加COMMUNITY_INFO 错误：{}", e.getMessage());
          	throw new SysException("增加COMMUNITY_INFO错误", "10000", e);
          }
          return entity;
       }
    @Override
    public int update(CommunityInfoMVO entity) throws SysException {
        int rowsAffected;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE  COMMUNITY_INFO  SET ");
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity.getCommunityName() != null) {
                sql.append("community_name=?,");
                params.add(entity.getCommunityName());
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
            if (entity.getProvName() != null) {
                sql.append("prov_name=?,");
                params.add(entity.getProvName());
            }
            if (entity.getProvCode() != null) {
                sql.append("prov_code=?,");
                params.add(entity.getProvCode());
            }
            if (entity.getCityCode() != null) {
                sql.append("city_code=?,");
                params.add(entity.getCityCode());
            }
            if (entity.getCityName() != null) {
                sql.append("city_name=?,");
                params.add(entity.getCityName());
            }
            if (entity.getAreaCode() != null) {
                sql.append("area_code=?,");
                params.add(entity.getAreaCode());
            }
            if (entity.getAreaName() != null) {
                sql.append("area_name=?,");
                params.add(entity.getAreaName());
            }
            if (entity.getGwhId() != null) {
                sql.append("gwh_id=?,");
                params.add(entity.getGwhId());
            }
            if (entity.getGwhName() != null) {
                sql.append("gwh_name=?,");
                params.add(entity.getGwhName());
            }
            sql.deleteCharAt(sql.length() - 1);
            sql.append(" WHERE community_id=?");
            params.add(entity.getCommunityId());
            logger.info(sql.toString() + "--" + params.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());
         } catch (DataAccessException e) {
            logger.error("更新COMMUNITY_INFO错误：{}", e.getMessage());
            throw new SysException("更新COMMUNITY_INFO错误", "10000", e);
         }
        return rowsAffected;
    }
    @Override
    public int delete(CommunityInfoMVO entity) throws SysException {
    	   int rowsAffected;
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM COMMUNITY_INFO WHERE community_id=?");
        try {
        	   logger.info(sql.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(),
                           entity.getCommunityId());
        } catch (DataAccessException e) {
            logger.error("删除COMMUNITY_INFO错误：{}", e.getMessage());
            throw new SysException("删除COMMUNITY_INFO错误", "10000", e);
        }
        return rowsAffected;
    }
    @Override
    public List<CommunityInfoMVO> queryList(CommunityInfoMVO entity) throws SysException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT community_id,community_name,list_order,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts,prov_name,prov_code,city_code,city_name,area_code,area_name,gwh_id,gwh_name ");
        sql.append("FROM  COMMUNITY_INFO ");
        sql.append("WHERE 1=1 ");
        List<CommunityInfoMVO> resultList = null;
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
            	if (StringUtils.isNotBlank(entity.getCommunityId())) {
                sql.append(" AND community_id=?");
                params.add(entity.getCommunityId());
            }
            	if (StringUtils.isNotBlank(entity.getCommunityName())) {
                sql.append(" AND community_name=?");
                params.add(entity.getCommunityName());
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
            	if (StringUtils.isNotBlank(entity.getProvName())) {
                sql.append(" AND prov_name=?");
                params.add(entity.getProvName());
            }
            	if (StringUtils.isNotBlank(entity.getProvCode())) {
                sql.append(" AND prov_code=?");
                params.add(entity.getProvCode());
            }
            	if (StringUtils.isNotBlank(entity.getCityCode())) {
                sql.append(" AND city_code=?");
                params.add(entity.getCityCode());
            }
            	if (StringUtils.isNotBlank(entity.getCityName())) {
                sql.append(" AND city_name=?");
                params.add(entity.getCityName());
            }
            	if (StringUtils.isNotBlank(entity.getAreaCode())) {
                sql.append(" AND area_code=?");
                params.add(entity.getAreaCode());
            }
            	if (StringUtils.isNotBlank(entity.getAreaName())) {
                sql.append(" AND area_name=?");
                params.add(entity.getAreaName());
            }
            	if (StringUtils.isNotBlank(entity.getGwhId())) {
                sql.append(" AND gwh_id=?");
                params.add(entity.getGwhId());
            }
            	if (StringUtils.isNotBlank(entity.getGwhName())) {
                sql.append(" AND gwh_name=?");
                params.add(entity.getGwhName());
            }
        	   }
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(),
			params.toArray(),
			new BeanPropertyRowMapper<CommunityInfoMVO>(CommunityInfoMVO.class));
        } catch (DataAccessException e) {
            logger.error("查询COMMUNITY_INFO错误：{}", e.getMessage());
            throw new SysException("查询COMMUNITY_INFO错误", "10000", e);
        }
        return resultList;
    }
    @Override
    public CommunityInfoMVO queryBean(CommunityInfoMVO entity) throws SysException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT community_id,community_name,list_order,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts,prov_name,prov_code,city_code,city_name,area_code,area_name,gwh_id,gwh_name ");
        sql.append("FROM  COMMUNITY_INFO ");
        sql.append("WHERE community_id=? ");
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
        	   		params.add(entity.getCommunityId());
        	   } else {
        	   		sql.append(" AND 1=2");
        	   }
			logger.info(sql.toString() + "--" + params.toString());
			 entity = jdbcTemplate.queryForObject(sql.toString(),
			params.toArray(),
			new BeanPropertyRowMapper<CommunityInfoMVO>(CommunityInfoMVO.class));
        } catch (DataAccessException e) {
            logger.error("查询COMMUNITY_INFO错误：{}", e.getMessage());
            throw new SysException("查询COMMUNITY_INFO错误", "10000", e);
        }
        return entity;
    }


}
