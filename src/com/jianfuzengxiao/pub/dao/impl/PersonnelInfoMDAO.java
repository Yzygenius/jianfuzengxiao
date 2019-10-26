package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IPersonnelInfoMDAO;
import com.jianfuzengxiao.pub.entity.PersonnelInfoMVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

@Repository
public class PersonnelInfoMDAO extends PersonnelInfoSDAO implements IPersonnelInfoMDAO {
	private static Logger logger = LoggerFactory.getLogger(PersonnelInfoMDAO.class);

	public PageInfo queryPage(PersonnelInfoMVO entity, PageInfo pageInfo) throws SysException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select personnel_id,houses_id,userid,per_sort,live_type_id,live_type_name,date_format(lease_start_time,'%Y-%m-%d %H:%i:%s')lease_start_time,date_format(lease_stop_time,'%Y-%m-%d %H:%i:%s')lease_stop_time,username,gender,face_photo,face_file,date_format(birth_date,'%Y-%m-%d %H:%i:%s')birth_date,nation_id,nation_name,telephone,certificates_type_id,certificates_type_name,certificates_positive_photo,certificates_positive_file,certificates_negative_photo,certificates_negative_file,certificates_number,date_format(certificates_start_time,'%Y-%m-%d %H:%i:%s')certificates_start_time,date_format(certificates_stop_time,'%Y-%m-%d %H:%i:%s')certificates_stop_time,certificates_address,certificates_office,enterprise_name,status,audit_remark,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
		sql.append("from PERSONNEL_INFO ");
		sql.append("where 1=1");

		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getPersonnelId())) {
					sql.append(" AND personnel_id=?");
					params.add(entity.getPersonnelId());
				}
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND houses_id=?");
					params.add(entity.getHousesId());
				}
				if (StringUtils.isNotBlank(entity.getUserid())) {
					sql.append(" AND userid like ?");
					params.add("%" + entity.getUserid() + "%");
				}
				if (StringUtils.isNotBlank(entity.getPerSort())) {
					sql.append(" AND per_sort=?");
					params.add(entity.getPerSort());
				}
				if (StringUtils.isNotBlank(entity.getLiveTypeId())) {
					sql.append(" AND live_type_id=?");
					params.add(entity.getLiveTypeId());
				}
				if (StringUtils.isNotBlank(entity.getLiveTypeName())) {
					sql.append(" AND live_type_name like ?");
					params.add("%" + entity.getLiveTypeName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getLeaseStartTime())) {
					sql.append("  AND lease_start_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
					params.add(entity.getLeaseStartTime());
				}
				if (StringUtils.isNotBlank(entity.getLeaseStopTime())) {
					sql.append("  AND lease_stop_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
					params.add(entity.getLeaseStopTime());
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
				if (StringUtils.isNotBlank(entity.getCertificatesPositiveFile())) {
					sql.append(" AND certificates_positive_file like ?");
					params.add("%" + entity.getCertificatesPositiveFile() + "%");
				}
				if (StringUtils.isNotBlank(entity.getCertificatesNegativePhoto())) {
					sql.append(" AND certificates_negative_photo like ?");
					params.add("%" + entity.getCertificatesNegativePhoto() + "%");
				}
				if (StringUtils.isNotBlank(entity.getCertificatesNegativeFile())) {
					sql.append(" AND certificates_negative_file like ?");
					params.add("%" + entity.getCertificatesNegativeFile() + "%");
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
				if (StringUtils.isNotBlank(entity.getEnterpriseName())) {
					sql.append(" AND enterprise_name like ?");
					params.add("%" + entity.getEnterpriseName() + "%");
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
					new BeanPropertyRowMapper<PersonnelInfoMVO>(PersonnelInfoMVO.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			logger.error("查询PersonnelInfo错误：{}", e.getMessage());
			throw new SysException("10000", "查询PersonnelInfo错误", e);
		}
		return pageInfo;
	}
}
