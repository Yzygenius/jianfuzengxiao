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
        sql.append("INSERT INTO USER_INFO (user_id,op_id,username,gender,face_photo,face_file,birth_date,nation_id,nation_name,telephone,certificates_type_id,certificates_type_name,certificates_positive_photo,certificates_negative_photo,certificates_number,certificates_start_time,certificates_stop_time,certificates_address,certificates_office,status,audit_remark,create_time,update_time,sts,lease_start_time) ");
        sql.append("VALUES (?,?,?,?,?,?,str_to_date(?,'%Y-%m-%d %H:%i:%s'),?,?,?,?,?,?,?,?,str_to_date(?,'%Y-%m-%d %H:%i:%s'),str_to_date(?,'%Y-%m-%d %H:%i:%s'),?,?,?,?,str_to_date(?,'%Y-%m-%d %H:%i:%s'),str_to_date(?,'%Y-%m-%d %H:%i:%s'),?,str_to_date(?,'%Y-%m-%d %H:%i:%s'))");
        try {
            logger.info(sql.toString());
            jdbcTemplate.update(
                new PreparedStatementCreator(){
                public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException{
                	int i = 0;
                	java.sql.PreparedStatement ps = conn.prepareStatement(sql.toString()); 
                	ps.setString(++i, StringUtils.trimToNull(entity.getUserId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getOpId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getUsername()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getGender()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getFacePhoto()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getFaceFile()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getBirthDate()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getNationId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getNationName()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getTelephone()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCertificatesTypeId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCertificatesTypeName()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCertificatesPositivePhoto()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCertificatesNegativePhoto()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCertificatesNumber()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCertificatesStartTime()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCertificatesStopTime()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCertificatesAddress()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCertificatesOffice()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getStatus()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getAuditRemark()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getCreateTime()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getUpdateTime()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getSts()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getLeaseStartTime()));
                	return ps;
              }
            });
          } catch (DataAccessException e) {
          	logger.error("增加USER_INFO 错误：{}", e.getMessage());
          	throw new SysException("增加USER_INFO错误", "10000", e);
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
            if (entity.getOpId() != null) {
                sql.append("op_id=?,");
                params.add(entity.getOpId());
            }
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
            if (entity.getCertificatesTypeId() != null) {
                sql.append("certificates_type_id=?,");
                params.add(entity.getCertificatesTypeId());
            }
            if (entity.getCertificatesTypeName() != null) {
                sql.append("certificates_type_name=?,");
                params.add(entity.getCertificatesTypeName());
            }
            if (entity.getCertificatesPositivePhoto() != null) {
                sql.append("certificates_positive_photo=?,");
                params.add(entity.getCertificatesPositivePhoto());
            }
            if (entity.getCertificatesNegativePhoto() != null) {
                sql.append("certificates_negative_photo=?,");
                params.add(entity.getCertificatesNegativePhoto());
            }
            if (entity.getCertificatesNumber() != null) {
                sql.append("certificates_number=?,");
                params.add(entity.getCertificatesNumber());
            }
            if (entity.getCertificatesStartTime() != null) {
                sql.append("certificates_start_time=str_to_date(?,'%Y-%m-%d %H:%i:%s'),");
                params.add(entity.getCertificatesStartTime());
            }
            if (entity.getCertificatesStopTime() != null) {
                sql.append("certificates_stop_time=str_to_date(?,'%Y-%m-%d %H:%i:%s'),");
                params.add(entity.getCertificatesStopTime());
            }
            if (entity.getCertificatesAddress() != null) {
                sql.append("certificates_address=?,");
                params.add(entity.getCertificatesAddress());
            }
            if (entity.getCertificatesOffice() != null) {
                sql.append("certificates_office=?,");
                params.add(entity.getCertificatesOffice());
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
            if (entity.getLeaseStartTime() != null) {
                sql.append("lease_start_time=str_to_date(?,'%Y-%m-%d %H:%i:%s'),");
                params.add(entity.getLeaseStartTime());
            }
            sql.deleteCharAt(sql.length() - 1);
            sql.append(" WHERE user_id=?");
            params.add(entity.getUserId());
            logger.info(sql.toString() + "--" + params.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());
         } catch (DataAccessException e) {
            logger.error("更新USER_INFO错误：{}", e.getMessage());
            throw new SysException("更新USER_INFO错误", "10000", e);
         }
        return rowsAffected;
    }
    @Override
    public int delete(UserInfoMVO entity) throws SysException {
    	   int rowsAffected;
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM USER_INFO WHERE user_id=?");
        try {
        	   logger.info(sql.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(),
                           entity.getUserId());
        } catch (DataAccessException e) {
            logger.error("删除USER_INFO错误：{}", e.getMessage());
            throw new SysException("删除USER_INFO错误", "10000", e);
        }
        return rowsAffected;
    }
    @Override
    public List<UserInfoMVO> queryList(UserInfoMVO entity) throws SysException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT user_id,op_id,username,gender,face_photo,face_file,date_format(birth_date,'%Y-%m-%d %H:%i:%s')birth_date,nation_id,nation_name,telephone,certificates_type_id,certificates_type_name,certificates_positive_photo,certificates_negative_photo,certificates_number,date_format(certificates_start_time,'%Y-%m-%d %H:%i:%s')certificates_start_time,date_format(certificates_stop_time,'%Y-%m-%d %H:%i:%s')certificates_stop_time,certificates_address,certificates_office,status,audit_remark,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts,date_format(lease_start_time,'%Y-%m-%d %H:%i:%s')lease_start_time ");
        sql.append("FROM  USER_INFO ");
        sql.append("WHERE 1=1 ");
        List<UserInfoMVO> resultList = null;
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
            	if (StringUtils.isNotBlank(entity.getUserId())) {
                sql.append(" AND user_id=?");
                params.add(entity.getUserId());
            }
            	if (StringUtils.isNotBlank(entity.getOpId())) {
                sql.append(" AND op_id=?");
                params.add(entity.getOpId());
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
            	if (StringUtils.isNotBlank(entity.getCertificatesTypeId())) {
                sql.append(" AND certificates_type_id=?");
                params.add(entity.getCertificatesTypeId());
            }
            	if (StringUtils.isNotBlank(entity.getCertificatesTypeName())) {
                sql.append(" AND certificates_type_name=?");
                params.add(entity.getCertificatesTypeName());
            }
            	if (StringUtils.isNotBlank(entity.getCertificatesPositivePhoto())) {
                sql.append(" AND certificates_positive_photo=?");
                params.add(entity.getCertificatesPositivePhoto());
            }
            	if (StringUtils.isNotBlank(entity.getCertificatesNegativePhoto())) {
                sql.append(" AND certificates_negative_photo=?");
                params.add(entity.getCertificatesNegativePhoto());
            }
            	if (StringUtils.isNotBlank(entity.getCertificatesNumber())) {
                sql.append(" AND certificates_number=?");
                params.add(entity.getCertificatesNumber());
            }
            	if (StringUtils.isNotBlank(entity.getCertificatesStartTime())) {
                sql.append("  AND certificates_start_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
                params.add(entity.getCertificatesStartTime());
            }
            	if (StringUtils.isNotBlank(entity.getCertificatesStopTime())) {
                sql.append("  AND certificates_stop_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
                params.add(entity.getCertificatesStopTime());
            }
            	if (StringUtils.isNotBlank(entity.getCertificatesAddress())) {
                sql.append(" AND certificates_address=?");
                params.add(entity.getCertificatesAddress());
            }
            	if (StringUtils.isNotBlank(entity.getCertificatesOffice())) {
                sql.append(" AND certificates_office=?");
                params.add(entity.getCertificatesOffice());
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
            	if (StringUtils.isNotBlank(entity.getLeaseStartTime())) {
                sql.append("  AND lease_start_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
                params.add(entity.getLeaseStartTime());
            }
        	   }
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(),
			params.toArray(),
			new BeanPropertyRowMapper<UserInfoMVO>(UserInfoMVO.class));
        } catch (DataAccessException e) {
            logger.error("查询USER_INFO错误：{}", e.getMessage());
            throw new SysException("查询USER_INFO错误", "10000", e);
        }
        return resultList;
    }
    @Override
    public UserInfoMVO queryBean(UserInfoMVO entity) throws SysException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT user_id,op_id,username,gender,face_photo,face_file,date_format(birth_date,'%Y-%m-%d %H:%i:%s')birth_date,nation_id,nation_name,telephone,certificates_type_id,certificates_type_name,certificates_positive_photo,certificates_negative_photo,certificates_number,date_format(certificates_start_time,'%Y-%m-%d %H:%i:%s')certificates_start_time,date_format(certificates_stop_time,'%Y-%m-%d %H:%i:%s')certificates_stop_time,certificates_address,certificates_office,status,audit_remark,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts,date_format(lease_start_time,'%Y-%m-%d %H:%i:%s')lease_start_time ");
        sql.append("FROM  USER_INFO ");
        sql.append("WHERE user_id=? ");
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
        	   		params.add(entity.getUserId());
        	   } else {
        	   		sql.append(" AND 1=2");
        	   }
			logger.info(sql.toString() + "--" + params.toString());
			 entity = jdbcTemplate.queryForObject(sql.toString(),
			params.toArray(),
			new BeanPropertyRowMapper<UserInfoMVO>(UserInfoMVO.class));
        } catch (DataAccessException e) {
            logger.error("查询USER_INFO错误：{}", e.getMessage());
            throw new SysException("查询USER_INFO错误", "10000", e);
        }
        return entity;
    }


}
