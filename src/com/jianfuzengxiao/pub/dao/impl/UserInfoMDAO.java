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
		sql.append(
				"select user_id,username,gender,face_photo,face_file,date_format(birth_date,'%Y-%m-%d %H:%i:%s')birth_date,nation_id,nation_name,telephone,certificates_type_id,certificates_type_name,certificates_number,date_format(certificates_start_time,'%Y-%m-%d %H:%i:%s')certificates_start_time,date_format(certificates_stop_time,'%Y-%m-%d %H:%i:%s')certificates_stop_time,certificates_address,certificates_office,status,audit_remark,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts,date_format(lease_start_time,'%Y-%m-%d %H:%i:%s')lease_start_time ");
		sql.append("from USER_INFO ");
		sql.append("where 1=1");

		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getUserId())) {
					sql.append(" AND user_id like ?");
					params.add("%" + entity.getUserId() + "%");
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
				if (StringUtils.isNotBlank(entity.getCertificatesTypeId())) {
					sql.append(" AND certificates_type_id=?");
					params.add(entity.getCertificatesTypeId());
				}
				if (StringUtils.isNotBlank(entity.getCertificatesTypeName())) {
					sql.append(" AND certificates_type_name like ?");
					params.add("%" + entity.getCertificatesTypeName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getCertificatesPositivePhoto())) {
					sql.append(" AND certificates_positive_photo like ?");
					params.add("%" + entity.getCertificatesPositivePhoto() + "%");
				}
				if (StringUtils.isNotBlank(entity.getCertificatesNegativePhoto())) {
					sql.append(" AND certificates_negative_photo like ?");
					params.add("%" + entity.getCertificatesNegativePhoto() + "%");
				}
				if (StringUtils.isNotBlank(entity.getCertificatesNumber())) {
					sql.append(" AND certificates_number like ?");
					params.add("%" + entity.getCertificatesNumber() + "%");
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
					sql.append(" AND certificates_address like ?");
					params.add("%" + entity.getCertificatesAddress() + "%");
				}
				if (StringUtils.isNotBlank(entity.getCertificatesOffice())) {
					sql.append(" AND certificates_office like ?");
					params.add("%" + entity.getCertificatesOffice() + "%");
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
				if (StringUtils.isNotBlank(entity.getLeaseStartTime())) {
					sql.append("  AND lease_start_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
					params.add(entity.getLeaseStartTime());
				}
			}
			pageInfo = this.pagingQuery(sql.toString(), pageInfo, params,
					new BeanPropertyRowMapper<UserInfoMVO>(UserInfoMVO.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			logger.error("查询UserInfo错误：{}", e.getMessage());
			throw new SysException("查询UserInfo错误", "10000", e);
		}
		return pageInfo;
	}
}
