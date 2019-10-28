package com.jianfuzengxiao.pub.dao.impl;
import com.bamboo.framework.base.impl.BaseDAO;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IMsgInfoSDAO;
import com.jianfuzengxiao.pub.entity.MsgInfoMVO;
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
public class MsgInfoSDAO extends BaseDAO<MsgInfoMVO> implements IMsgInfoSDAO {
private static Logger logger = LoggerFactory.getLogger(MsgInfoSDAO.class);

@Override
    public MsgInfoMVO insert(final MsgInfoMVO entity) throws SysException { 
        final StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO MSG_INFO (msg_id,user_id,msg_type_id,msg_type_name,title,content,status,create_time,update_time,sts) ");
        sql.append("VALUES (?,?,?,?,?,?,?,str_to_date(?,'%Y-%m-%d %H:%i:%s'),str_to_date(?,'%Y-%m-%d %H:%i:%s'),?)");
        try {
            logger.info(sql.toString());
            jdbcTemplate.update(
                new PreparedStatementCreator(){
                public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException{
                	int i = 0;
                	java.sql.PreparedStatement ps = conn.prepareStatement(sql.toString()); 
                	ps.setString(++i, StringUtils.trimToNull(entity.getMsgId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getUserId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getMsgTypeId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getMsgTypeName()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getTitle()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getContent()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getStatus()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCreateTime()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getUpdateTime()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getSts()));
                	return ps;
              }
            });
          } catch (DataAccessException e) {
          	logger.error("增加MSG_INFO 错误：{}", e.getMessage());
          	throw new SysException("增加MSG_INFO错误", "10000", e);
          }
          return entity;
       }
    @Override
    public int update(MsgInfoMVO entity) throws SysException {
        int rowsAffected;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE  MSG_INFO  SET ");
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity.getUserId() != null) {
                sql.append("user_id=?,");
                params.add(entity.getUserId());
            }
            if (entity.getMsgTypeId() != null) {
                sql.append("msg_type_id=?,");
                params.add(entity.getMsgTypeId());
            }
            if (entity.getMsgTypeName() != null) {
                sql.append("msg_type_name=?,");
                params.add(entity.getMsgTypeName());
            }
            if (entity.getTitle() != null) {
                sql.append("title=?,");
                params.add(entity.getTitle());
            }
            if (entity.getContent() != null) {
                sql.append("content=?,");
                params.add(entity.getContent());
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
            sql.append(" WHERE msg_id=?");
            params.add(entity.getMsgId());
            logger.info(sql.toString() + "--" + params.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());
         } catch (DataAccessException e) {
            logger.error("更新MSG_INFO错误：{}", e.getMessage());
            throw new SysException("更新MSG_INFO错误", "10000", e);
         }
        return rowsAffected;
    }
    @Override
    public int delete(MsgInfoMVO entity) throws SysException {
    	   int rowsAffected;
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM MSG_INFO WHERE msg_id=?");
        try {
        	   logger.info(sql.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(),
                           entity.getMsgId());
        } catch (DataAccessException e) {
            logger.error("删除MSG_INFO错误：{}", e.getMessage());
            throw new SysException("删除MSG_INFO错误", "10000", e);
        }
        return rowsAffected;
    }
    @Override
    public List<MsgInfoMVO> queryList(MsgInfoMVO entity) throws SysException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT msg_id,user_id,msg_type_id,msg_type_name,title,content,status,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
        sql.append("FROM  MSG_INFO ");
        sql.append("WHERE 1=1 ");
        List<MsgInfoMVO> resultList = null;
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
            	if (StringUtils.isNotBlank(entity.getMsgId())) {
                sql.append(" AND msg_id=?");
                params.add(entity.getMsgId());
            }
            	if (StringUtils.isNotBlank(entity.getUserId())) {
                sql.append(" AND user_id=?");
                params.add(entity.getUserId());
            }
            	if (StringUtils.isNotBlank(entity.getMsgTypeId())) {
                sql.append(" AND msg_type_id=?");
                params.add(entity.getMsgTypeId());
            }
            	if (StringUtils.isNotBlank(entity.getMsgTypeName())) {
                sql.append(" AND msg_type_name=?");
                params.add(entity.getMsgTypeName());
            }
            	if (StringUtils.isNotBlank(entity.getTitle())) {
                sql.append(" AND title=?");
                params.add(entity.getTitle());
            }
            	if (StringUtils.isNotBlank(entity.getContent())) {
                sql.append(" AND content=?");
                params.add(entity.getContent());
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
			new BeanPropertyRowMapper<MsgInfoMVO>(MsgInfoMVO.class));
        } catch (DataAccessException e) {
            logger.error("查询MSG_INFO错误：{}", e.getMessage());
            throw new SysException("查询MSG_INFO错误", "10000", e);
        }
        return resultList;
    }
    @Override
    public MsgInfoMVO queryBean(MsgInfoMVO entity) throws SysException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT msg_id,user_id,msg_type_id,msg_type_name,title,content,status,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
        sql.append("FROM  MSG_INFO ");
        sql.append("WHERE msg_id=? ");
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
        	   		params.add(entity.getMsgId());
        	   } else {
        	   		sql.append(" AND 1=2");
        	   }
			logger.info(sql.toString() + "--" + params.toString());
			 entity = jdbcTemplate.queryForObject(sql.toString(),
			params.toArray(),
			new BeanPropertyRowMapper<MsgInfoMVO>(MsgInfoMVO.class));
        } catch (DataAccessException e) {
            logger.error("查询MSG_INFO错误：{}", e.getMessage());
            throw new SysException("查询MSG_INFO错误", "10000", e);
        }
        return entity;
    }


}
