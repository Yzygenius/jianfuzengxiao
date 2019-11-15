package com.jianfuzengxiao.pub.dao.impl;
import com.bamboo.framework.base.impl.BaseDAO;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IGwhInfoSDAO;
import com.jianfuzengxiao.pub.entity.GwhInfoMVO;
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
public class GwhInfoSDAO extends BaseDAO<GwhInfoMVO> implements IGwhInfoSDAO {
private static Logger logger = LoggerFactory.getLogger(GwhInfoSDAO.class);

@Override
    public GwhInfoMVO insert(final GwhInfoMVO entity) throws SysException { 
        final StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO GWH_INFO (gwh_id,gwh_name,list_order,prov_code,city_code,area_code,create_time,update_time,sts) ");
        sql.append("VALUES (?,?,?,?,?,?,str_to_date(?,'%Y-%m-%d %H:%i:%s'),str_to_date(?,'%Y-%m-%d %H:%i:%s'),?)");
        try {
            logger.info(sql.toString());
            jdbcTemplate.update(
                new PreparedStatementCreator(){
                public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException{
                	int i = 0;
                	java.sql.PreparedStatement ps = conn.prepareStatement(sql.toString()); 
                	ps.setString(++i, StringUtils.trimToNull(entity.getGwhId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getGwhName()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getListOrder()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getProvCode()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCityCode()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getAreaCode()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCreateTime()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getUpdateTime()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getSts()));
                	return ps;
              }
            });
          } catch (DataAccessException e) {
          	logger.error("增加GWH_INFO 错误：{}", e.getMessage());
          	throw new SysException("增加GWH_INFO错误", "10000", e);
          }
          return entity;
       }
    @Override
    public int update(GwhInfoMVO entity) throws SysException {
        int rowsAffected;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE  GWH_INFO  SET ");
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity.getGwhName() != null) {
                sql.append("gwh_name=?,");
                params.add(entity.getGwhName());
            }
            if (entity.getListOrder() != null) {
                sql.append("list_order=?,");
                params.add(entity.getListOrder());
            }
            if (entity.getProvCode() != null) {
                sql.append("prov_code=?,");
                params.add(entity.getProvCode());
            }
            if (entity.getCityCode() != null) {
                sql.append("city_code=?,");
                params.add(entity.getCityCode());
            }
            if (entity.getAreaCode() != null) {
                sql.append("area_code=?,");
                params.add(entity.getAreaCode());
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
            sql.append(" WHERE gwh_id=?");
            params.add(entity.getGwhId());
            logger.info(sql.toString() + "--" + params.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());
         } catch (DataAccessException e) {
            logger.error("更新GWH_INFO错误：{}", e.getMessage());
            throw new SysException("更新GWH_INFO错误", "10000", e);
         }
        return rowsAffected;
    }
    @Override
    public int delete(GwhInfoMVO entity) throws SysException {
    	   int rowsAffected;
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM GWH_INFO WHERE gwh_id=?");
        try {
        	   logger.info(sql.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(),
                           entity.getGwhId());
        } catch (DataAccessException e) {
            logger.error("删除GWH_INFO错误：{}", e.getMessage());
            throw new SysException("删除GWH_INFO错误", "10000", e);
        }
        return rowsAffected;
    }
    @Override
    public List<GwhInfoMVO> queryList(GwhInfoMVO entity) throws SysException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT gwh_id,gwh_name,list_order,prov_code,city_code,area_code,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
        sql.append("FROM  GWH_INFO ");
        sql.append("WHERE 1=1 ");
        List<GwhInfoMVO> resultList = null;
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
            	if (StringUtils.isNotBlank(entity.getGwhId())) {
                sql.append(" AND gwh_id=?");
                params.add(entity.getGwhId());
            }
            	if (StringUtils.isNotBlank(entity.getGwhName())) {
                sql.append(" AND gwh_name=?");
                params.add(entity.getGwhName());
            }
            	if (StringUtils.isNotBlank(entity.getListOrder())) {
                sql.append(" AND list_order=?");
                params.add(entity.getListOrder());
            }
            	if (StringUtils.isNotBlank(entity.getProvCode())) {
                sql.append(" AND prov_code=?");
                params.add(entity.getProvCode());
            }
            	if (StringUtils.isNotBlank(entity.getCityCode())) {
                sql.append(" AND city_code=?");
                params.add(entity.getCityCode());
            }
            	if (StringUtils.isNotBlank(entity.getAreaCode())) {
                sql.append(" AND area_code=?");
                params.add(entity.getAreaCode());
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
			new BeanPropertyRowMapper<GwhInfoMVO>(GwhInfoMVO.class));
        } catch (DataAccessException e) {
            logger.error("查询GWH_INFO错误：{}", e.getMessage());
            throw new SysException("查询GWH_INFO错误", "10000", e);
        }
        return resultList;
    }
    @Override
    public GwhInfoMVO queryBean(GwhInfoMVO entity) throws SysException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT gwh_id,gwh_name,list_order,prov_code,city_code,area_code,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
        sql.append("FROM  GWH_INFO ");
        sql.append("WHERE gwh_id=? ");
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
        	   		params.add(entity.getGwhId());
        	   } else {
        	   		sql.append(" AND 1=2");
        	   }
			logger.info(sql.toString() + "--" + params.toString());
			 entity = jdbcTemplate.queryForObject(sql.toString(),
			params.toArray(),
			new BeanPropertyRowMapper<GwhInfoMVO>(GwhInfoMVO.class));
        } catch (DataAccessException e) {
            logger.error("查询GWH_INFO错误：{}", e.getMessage());
            throw new SysException("查询GWH_INFO错误", "10000", e);
        }
        return entity;
    }


}
