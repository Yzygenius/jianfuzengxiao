package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IUserInfoMDAO;
import com.jianfuzengxiao.pub.entity.UserInfoMVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;


@Repository
public class UserInfoMDAO extends UserInfoSDAO implements IUserInfoMDAO {
    private static Logger logger = LoggerFactory.getLogger(UserInfoMDAO.class);
    public PageInfo queryPage(UserInfoMVO entity, PageInfo pageInfo) throws SysException {
        StringBuffer sql = new StringBuffer();
        sql.append("select userid,username,gender,face_photo,face_file,date_format(birth_date,'%Y-%m-%d %H:%i:%s')birth_date,nation_id,nation_name,telephone,cert_type_id,cert_type_name,cert_number,date_format(cert_start_time,'%Y-%m-%d %H:%i:%s')cert_start_time,date_format(cert_stop_time,'%Y-%m-%d %H:%i:%s')cert_stop_time,cert_address,cert_office,status,audit_remark,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
        sql.append("from USER_INFO ");
        sql.append("where 1=1");

        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
            	if (StringUtils.isNotBlank(entity.getUserid())) {
                sql.append(" AND userid like ?");
                params.add("%" + entity.getUserid() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getUsername())) {
                sql.append(" AND username like ?");
                params.add("%" + entity.getUsername() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getGender())) {
                sql.append(" AND gender=?");
                params.add(entity.getGender());
            }
            	if (StringUtils.isNotBlank(entity.getFacePhoto())) {
                sql.append(" AND face_photo like ?");
                params.add("%" + entity.getFacePhoto() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getFaceFile())) {
                sql.append(" AND face_file like ?");
                params.add("%" + entity.getFaceFile() + "%");
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
                sql.append(" AND nation_name like ?");
                params.add("%" + entity.getNationName() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getTelephone())) {
                sql.append(" AND telephone like ?");
                params.add("%" + entity.getTelephone() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getCertTypeId())) {
                sql.append(" AND cert_type_id=?");
                params.add(entity.getCertTypeId());
            }
            	if (StringUtils.isNotBlank(entity.getCertTypeName())) {
                sql.append(" AND cert_type_name like ?");
                params.add("%" + entity.getCertTypeName() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getCertNumber())) {
                sql.append(" AND cert_number like ?");
                params.add("%" + entity.getCertNumber() + "%");
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
                sql.append(" AND cert_address like ?");
                params.add("%" + entity.getCertAddress() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getCertOffice())) {
                sql.append(" AND cert_office like ?");
                params.add("%" + entity.getCertOffice() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getStatus())) {
                sql.append(" AND status=?");
                params.add(entity.getStatus());
            }
            	if (StringUtils.isNotBlank(entity.getAuditRemark())) {
                sql.append(" AND audit_remark like ?");
                params.add("%" + entity.getAuditRemark() + "%");
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
                sql.append(" AND sts like ?");
                params.add("%" + entity.getSts() + "%");
            }
            }
            pageInfo = this.pagingQuery(sql.toString(), pageInfo, params, 
                    new BeanPropertyRowMapper<UserInfoMVO>(UserInfoMVO.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            logger.error("查询UserInfo错误：{}", e.getMessage());
            throw new SysException("10000", "查询UserInfo错误", e);
        }
        return pageInfo;
    }
}
