package com.jianfuzengxiao.pub.dao.impl;
import com.bamboo.framework.base.impl.BaseDAO;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IUserInfoSDAO;
import com.jianfuzengxiao.pub.entity.UserInfoMVO;
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
public class UserInfoSDAO extends BaseDAO<UserInfoMVO> implements IUserInfoSDAO {
private static Logger logger = LoggerFactory.getLogger(UserInfoSDAO.class);

@Override
    public UserInfoMVO insert(final UserInfoMVO entity) throws SysException { 
        final StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO USER_INFO (userid,username,gender,face_photo,face_file,birth_date,nation_id,nation_name,telephone,cert_type_id,cert_type_name,cert_number,cert_start_time,cert_stop_time,cert_address,cert_office,status,audit_remark,create_time,update_time,sts) ");
        sql.append("VALUES (?,?,?,?,?,str_to_date(?,'%Y-%m-%d %H:%i:%s'),?,?,?,?,?,?,str_to_date(?,'%Y-%m-%d %H:%i:%s'),str_to_date(?,'%Y-%m-%d %H:%i:%s'),?,?,?,?,str_to_date(?,'%Y-%m-%d %H:%i:%s'),str_to_date(?,'%Y-%m-%d %H:%i:%s'),?)");
        try {
            logger.info(sql.toString());
            jdbcTemplate.update(
                new PreparedStatementCreator(){
                public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException{
                	int i = 0;
                	java.sql.PreparedStatement ps = conn.prepareStatement(sql.toString()); 
                	ps.setString(++i, StringUtils.trimToNull(entity.getUserid()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getUsername()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getGender()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getFacePhoto()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getFaceFile()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getBirthDate()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getNationId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getNationName()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getTelephone()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCertTypeId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCertTypeName()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCertNumber()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCertStartTime()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCertStopTime()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCertAddress()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCertOffice()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getStatus()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getAuditRemark()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCreateTime()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getUpdateTime()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getSts()));
                	return ps;
              }
            });
          } catch (DataAccessException e) {
          	logger.error("增加USER_INFO 错误：{}", e.getMessage());
          	throw new SysException("10000", "增加USER_INFO错误", e);
          }
          return entity;
       }
    @Override
    public int update(UserInfoMVO entity) throws SysException {
        int rowsAffected;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE  USER_INFO  SET ");
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity.getUsername() != null) {
                sql.append("username=?,");
                params.add(entity.getUsername());
            }
            if (entity.getGender() != null) {
                sql.append("gender=?,");
                params.add(entity.getGender());
            }
            if (entity.getFacePhoto() != null) {
                sql.append("face_photo=?,");
                params.add(entity.getFacePhoto());
            }
            if (entity.getFaceFile() != null) {
                sql.append("face_file=?,");
                params.add(entity.getFaceFile());
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
            if (entity.getCertTypeId() != null) {
                sql.append("cert_type_id=?,");
                params.add(entity.getCertTypeId());
            }
            if (entity.getCertTypeName() != null) {
                sql.append("cert_type_name=?,");
                params.add(entity.getCertTypeName());
            }
            if (entity.getCertNumber() != null) {
                sql.append("cert_number=?,");
                params.add(entity.getCertNumber());
            }
            if (entity.getCertStartTime() != null) {
                sql.append("cert_start_time=str_to_date(?,'%Y-%m-%d %H:%i:%s'),");
                params.add(entity.getCertStartTime());
            }
            if (entity.getCertStopTime() != null) {
                sql.append("cert_stop_time=str_to_date(?,'%Y-%m-%d %H:%i:%s'),");
                params.add(entity.getCertStopTime());
            }
            if (entity.getCertAddress() != null) {
                sql.append("cert_address=?,");
                params.add(entity.getCertAddress());
            }
            if (entity.getCertOffice() != null) {
                sql.append("cert_office=?,");
                params.add(entity.getCertOffice());
            }
            if (entity.getStatus() != null) {
                sql.append("status=?,");
                params.add(entity.getStatus());
            }
            if (entity.getAuditRemark() != null) {
                sql.append("audit_remark=?,");
                params.add(entity.getAuditRemark());
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
            sql.append(" WHERE userid=?");
            params.add(entity.getUserid());
            logger.info(sql.toString() + "--" + params.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());
         } catch (DataAccessException e) {
            logger.error("更新USER_INFO错误：{}", e.getMessage());
            throw new SysException("10000", "更新USER_INFO错误", e);
         }
        return rowsAffected;
    }
    @Override
    public int delete(UserInfoMVO entity) throws SysException {
    	   int rowsAffected;
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM USER_INFO WHERE userid=?");
        try {
        	   logger.info(sql.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(),
                           entity.getUserid());
        } catch (DataAccessException e) {
            logger.error("删除USER_INFO错误：{}", e.getMessage());
            throw new SysException("10000", "删除USER_INFO错误", e);
        }
        return rowsAffected;
    }
    @Override
    public List<UserInfoMVO> queryList(UserInfoMVO entity) throws SysException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT userid,username,gender,face_photo,face_file,date_format(birth_date,'%Y-%m-%d %H:%i:%s')birth_date,nation_id,nation_name,telephone,cert_type_id,cert_type_name,cert_number,date_format(cert_start_time,'%Y-%m-%d %H:%i:%s')cert_start_time,date_format(cert_stop_time,'%Y-%m-%d %H:%i:%s')cert_stop_time,cert_address,cert_office,status,audit_remark,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
        sql.append("FROM  USER_INFO ");
        sql.append("WHERE 1=1 ");
        List<UserInfoMVO> resultList = null;
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
            	if (StringUtils.isNotBlank(entity.getUserid())) {
                sql.append(" AND userid=?");
                params.add(entity.getUserid());
            }
            	if (StringUtils.isNotBlank(entity.getUsername())) {
                sql.append(" AND username=?");
                params.add(entity.getUsername());
            }
            	if (StringUtils.isNotBlank(entity.getGender())) {
                sql.append(" AND gender=?");
                params.add(entity.getGender());
            }
            	if (StringUtils.isNotBlank(entity.getFacePhoto())) {
                sql.append(" AND face_photo=?");
                params.add(entity.getFacePhoto());
            }
            	if (StringUtils.isNotBlank(entity.getFaceFile())) {
                sql.append(" AND face_file=?");
                params.add(entity.getFaceFile());
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
            	if (StringUtils.isNotBlank(entity.getCertTypeId())) {
                sql.append(" AND cert_type_id=?");
                params.add(entity.getCertTypeId());
            }
            	if (StringUtils.isNotBlank(entity.getCertTypeName())) {
                sql.append(" AND cert_type_name=?");
                params.add(entity.getCertTypeName());
            }
            	if (StringUtils.isNotBlank(entity.getCertNumber())) {
                sql.append(" AND cert_number=?");
                params.add(entity.getCertNumber());
            }
            	if (StringUtils.isNotBlank(entity.getCertStartTime())) {
                sql.append("  AND cert_start_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
                params.add(entity.getCertStartTime());
            }
            	if (StringUtils.isNotBlank(entity.getCertStopTime())) {
                sql.append("  AND cert_stop_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
                params.add(entity.getCertStopTime());
            }
            	if (StringUtils.isNotBlank(entity.getCertAddress())) {
                sql.append(" AND cert_address=?");
                params.add(entity.getCertAddress());
            }
            	if (StringUtils.isNotBlank(entity.getCertOffice())) {
                sql.append(" AND cert_office=?");
                params.add(entity.getCertOffice());
            }
            	if (StringUtils.isNotBlank(entity.getStatus())) {
                sql.append(" AND status=?");
                params.add(entity.getStatus());
            }
            	if (StringUtils.isNotBlank(entity.getAuditRemark())) {
                sql.append(" AND audit_remark=?");
                params.add(entity.getAuditRemark());
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
			new BeanPropertyRowMapper<UserInfoMVO>(UserInfoMVO.class));
        } catch (DataAccessException e) {
            logger.error("查询USER_INFO错误：{}", e.getMessage());
            throw new SysException("10000", "查询USER_INFO错误", e);
        }
        return resultList;
    }
    @Override
    public UserInfoMVO queryBean(UserInfoMVO entity) throws SysException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT userid,username,gender,face_photo,face_file,date_format(birth_date,'%Y-%m-%d %H:%i:%s')birth_date,nation_id,nation_name,telephone,cert_type_id,cert_type_name,cert_number,date_format(cert_start_time,'%Y-%m-%d %H:%i:%s')cert_start_time,date_format(cert_stop_time,'%Y-%m-%d %H:%i:%s')cert_stop_time,cert_address,cert_office,status,audit_remark,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
        sql.append("FROM  USER_INFO ");
        sql.append("WHERE userid=? ");
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
        	   		params.add(entity.getUserid());
        	   } else {
        	   		sql.append(" AND 1=2");
        	   }
			logger.info(sql.toString() + "--" + params.toString());
			 entity = jdbcTemplate.queryForObject(sql.toString(),
			params.toArray(),
			new BeanPropertyRowMapper<UserInfoMVO>(UserInfoMVO.class));
        } catch (DataAccessException e) {
            logger.error("查询USER_INFO错误：{}", e.getMessage());
            throw new SysException("10000", "查询USER_INFO错误", e);
        }
        return entity;
    }


}
