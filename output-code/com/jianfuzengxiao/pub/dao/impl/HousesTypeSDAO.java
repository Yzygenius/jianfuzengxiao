package com.jianfuzengxiao.pub.dao.impl;
import com.bamboo.framework.base.impl.BaseDAO;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IHousesTypeSDAO;
import com.jianfuzengxiao.pub.entity.HousesTypeMVO;
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
public class HousesTypeSDAO extends BaseDAO<HousesTypeMVO> implements IHousesTypeSDAO {
private static Logger logger = LoggerFactory.getLogger(HousesTypeSDAO.class);

@Override
    public HousesTypeMVO insert(final HousesTypeMVO entity) throws SysException { 
        final StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO HOUSES_TYPE (houses_type_id,houses_type_name,list_order,create_time,update_time,sts) ");
        sql.append("VALUES (?,?,?,str_to_date(?,'%Y-%m-%d %H:%i:%s'),str_to_date(?,'%Y-%m-%d %H:%i:%s'),?)");
        try {
            logger.info(sql.toString());
            jdbcTemplate.update(
                new PreparedStatementCreator(){
                public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException{
                	int i = 0;
                	java.sql.PreparedStatement ps = conn.prepareStatement(sql.toString()); 
                	ps.setString(++i, StringUtils.trimToNull(entity.getHousesTypeId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getHousesTypeName()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getListOrder()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCreateTime()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getUpdateTime()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getSts()));
                	return ps;
              }
            });
          } catch (DataAccessException e) {
          	logger.error("增加HOUSES_TYPE 错误：{}", e.getMessage());
          	throw new SysException("增加HOUSES_TYPE错误", "10000", e);
          }
          return entity;
       }
    @Override
    public int update(HousesTypeMVO entity) throws SysException {
        int rowsAffected;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE  HOUSES_TYPE  SET ");
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity.getHousesTypeName() != null) {
                sql.append("houses_type_name=?,");
                params.add(entity.getHousesTypeName());
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
            sql.append(" WHERE houses_type_id=?");
            params.add(entity.getHousesTypeId());
            logger.info(sql.toString() + "--" + params.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());
         } catch (DataAccessException e) {
            logger.error("更新HOUSES_TYPE错误：{}", e.getMessage());
            throw new SysException("更新HOUSES_TYPE错误", "10000", e);
         }
        return rowsAffected;
    }
    @Override
    public int delete(HousesTypeMVO entity) throws SysException {
    	   int rowsAffected;
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM HOUSES_TYPE WHERE houses_type_id=?");
        try {
        	   logger.info(sql.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(),
                           entity.getHousesTypeId());
        } catch (DataAccessException e) {
            logger.error("删除HOUSES_TYPE错误：{}", e.getMessage());
            throw new SysException("删除HOUSES_TYPE错误", "10000", e);
        }
        return rowsAffected;
    }
    @Override
    public List<HousesTypeMVO> queryList(HousesTypeMVO entity) throws SysException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT houses_type_id,houses_type_name,list_order,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
        sql.append("FROM  HOUSES_TYPE ");
        sql.append("WHERE 1=1 ");
        List<HousesTypeMVO> resultList = null;
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
            	if (StringUtils.isNotBlank(entity.getHousesTypeId())) {
                sql.append(" AND houses_type_id=?");
                params.add(entity.getHousesTypeId());
            }
            	if (StringUtils.isNotBlank(entity.getHousesTypeName())) {
                sql.append(" AND houses_type_name=?");
                params.add(entity.getHousesTypeName());
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
			new BeanPropertyRowMapper<HousesTypeMVO>(HousesTypeMVO.class));
        } catch (DataAccessException e) {
            logger.error("查询HOUSES_TYPE错误：{}", e.getMessage());
            throw new SysException("查询HOUSES_TYPE错误", "10000", e);
        }
        return resultList;
    }
    @Override
    public HousesTypeMVO queryBean(HousesTypeMVO entity) throws SysException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT houses_type_id,houses_type_name,list_order,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
        sql.append("FROM  HOUSES_TYPE ");
        sql.append("WHERE houses_type_id=? ");
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
        	   		params.add(entity.getHousesTypeId());
        	   } else {
        	   		sql.append(" AND 1=2");
        	   }
			logger.info(sql.toString() + "--" + params.toString());
			 entity = jdbcTemplate.queryForObject(sql.toString(),
			params.toArray(),
			new BeanPropertyRowMapper<HousesTypeMVO>(HousesTypeMVO.class));
        } catch (DataAccessException e) {
            logger.error("查询HOUSES_TYPE错误：{}", e.getMessage());
            throw new SysException("查询HOUSES_TYPE错误", "10000", e);
        }
        return entity;
    }


}
