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
				"select a.personnel_id,a.houses_id,a.user_id,a.per_sort,a.live_type_id,a.live_type_name,a.lease_mode,date_format(a.lease_start_time,'%Y-%m-%d')lease_start_time,date_format(a.lease_stop_time,'%Y-%m-%d')lease_stop_time,a.username,a.gender,a.face_photo,a.face_file,date_format(a.birth_date,'%Y-%m-%d')birth_date,a.nation_id,a.nation_name,a.telephone,a.certificates_type_id,a.certificates_type_name,a.certificates_number,a.certificates_start_time,a.certificates_stop_time,a.certificates_address,a.certificates_office,a.enterprise_name,a.status,a.audit_remark,date_format(a.create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(a.update_time,'%Y-%m-%d %H:%i:%s')update_time,a.sts,a.update_status ");
		sql.append(",b.houses_status,b.community_name,b.community_street_name,ifnull(b.storied_building_number,'')storied_building_number,ifnull(b.unit,'')unit,b.house_number,b.houses_address,ifnull(b.store_location, 0)store_location ");
		sql.append("from PERSONNEL_INFO a ");
		sql.append("left join houses_info b on(a.houses_id=b.houses_id) ");
		sql.append("where 1=1");

		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND b.community_id in("+entity.getCommunityId()+") ");
				}
				if (StringUtils.isNotBlank(entity.getPersonnelId())) {
					sql.append(" AND a.personnel_id=?");
					params.add(entity.getPersonnelId());
				}
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND a.houses_id in("+entity.getHousesId()+")");
				}
				if (StringUtils.isNotBlank(entity.getUserId())) {
					sql.append(" AND a.user_id like ?");
					params.add("%" + entity.getUserId() + "%");
				}
				if (StringUtils.isNotBlank(entity.getPerSort())) {
					sql.append(" AND a.per_sort=?");
					params.add(entity.getPerSort());
				}
				if (StringUtils.isNotBlank(entity.getLiveTypeId())) {
					sql.append(" AND a.live_type_id in ("+entity.getLiveTypeId()+")");
				}
				if (StringUtils.isNotBlank(entity.getLiveTypeName())) {
					sql.append(" AND a.live_type_name like ?");
					params.add("%" + entity.getLiveTypeName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getLeaseMode())) {
					sql.append(" AND a.lease_mode=?");
					params.add(entity.getLeaseMode());
				}
				if (StringUtils.isNotBlank(entity.getLeaseStartTime())) {
					sql.append("  AND a.lease_start_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
					params.add(entity.getLeaseStartTime());
				}
				if (StringUtils.isNotBlank(entity.getLeaseStopTime())) {
					sql.append("  AND a.lease_stop_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
					params.add(entity.getLeaseStopTime());
				}
				if (StringUtils.isNotBlank(entity.getUsername())) {
					sql.append(" AND a.username like ?");
					params.add("%" + entity.getUsername() + "%");
				}
				if (StringUtils.isNotBlank(entity.getGender())) {
					sql.append(" AND a.gender=?");
					params.add(entity.getGender());
				}
				if (StringUtils.isNotBlank(entity.getFacePhoto())) {
					sql.append(" AND a.face_photo like ?");
					params.add("%" + entity.getFacePhoto() + "%");
				}
				if (StringUtils.isNotBlank(entity.getFaceFile())) {
					sql.append(" AND a.face_file like ?");
					params.add("%" + entity.getFaceFile() + "%");
				}
				if (StringUtils.isNotBlank(entity.getBirthDate())) {
					sql.append("  AND a.birth_date=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
					params.add(entity.getBirthDate());
				}
				if (StringUtils.isNotBlank(entity.getNationId())) {
					sql.append(" AND a.nation_id=?");
					params.add(entity.getNationId());
				}
				if (StringUtils.isNotBlank(entity.getNationName())) {
					sql.append(" AND a.nation_name like ?");
					params.add("%" + entity.getNationName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getTelephone())) {
					sql.append(" AND a.telephone like ?");
					params.add("%" + entity.getTelephone() + "%");
				}
				if (StringUtils.isNotBlank(entity.getCertificatesTypeId())) {
					sql.append(" AND a.certificates_type_id=?");
					params.add(entity.getCertificatesTypeId());
				}
				if (StringUtils.isNotBlank(entity.getCertificatesTypeName())) {
					sql.append(" AND a.certificates_type_name like ?");
					params.add("%" + entity.getCertificatesTypeName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getCertificatesPositivePhoto())) {
					sql.append(" AND a.certificates_positive_photo like ?");
					params.add("%" + entity.getCertificatesPositivePhoto() + "%");
				}
				if (StringUtils.isNotBlank(entity.getCertificatesPositiveFile())) {
					sql.append(" AND a.certificates_positive_file like ?");
					params.add("%" + entity.getCertificatesPositiveFile() + "%");
				}
				if (StringUtils.isNotBlank(entity.getCertificatesNegativePhoto())) {
					sql.append(" AND a.certificates_negative_photo like ?");
					params.add("%" + entity.getCertificatesNegativePhoto() + "%");
				}
				if (StringUtils.isNotBlank(entity.getCertificatesNegativeFile())) {
					sql.append(" AND a.certificates_negative_file like ?");
					params.add("%" + entity.getCertificatesNegativeFile() + "%");
				}
				if (StringUtils.isNotBlank(entity.getCertificatesNumber())) {
					sql.append(" AND a.certificates_number like ?");
					params.add("%" + entity.getCertificatesNumber() + "%");
				}
				
				if (StringUtils.isNotBlank(entity.getCertificatesAddress())) {
					sql.append(" AND a.certificates_address like ?");
					params.add("%" + entity.getCertificatesAddress() + "%");
				}
				if (StringUtils.isNotBlank(entity.getCertificatesOffice())) {
					sql.append(" AND a.certificates_office like ?");
					params.add("%" + entity.getCertificatesOffice() + "%");
				}
				if (StringUtils.isNotBlank(entity.getEnterpriseName())) {
					sql.append(" AND a.enterprise_name like ?");
					params.add("%" + entity.getEnterpriseName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getStatus())) {
					sql.append(" AND a.status in ("+entity.getStatus()+")");
				}
				if (StringUtils.isNotBlank(entity.getAuditRemark())) {
					sql.append(" AND a.audit_remark like ?");
					params.add("%" + entity.getAuditRemark() + "%");
				}
				if (StringUtils.isNotBlank(entity.getCreateTime())) {
					sql.append("  AND a.create_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
					params.add(entity.getCreateTime());
				}
				if (StringUtils.isNotBlank(entity.getUpdateTime())) {
					sql.append("  AND a.update_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
					params.add(entity.getUpdateTime());
				}
				if (StringUtils.isNotBlank(entity.getSts())) {
					sql.append(" AND a.sts like ?");
					params.add("%" + entity.getSts() + "%");
				}
				if (StringUtils.isNotBlank(entity.getUpdateStatus())) {
					sql.append(" AND a.update_status = ?");
					params.add(entity.getUpdateStatus());
				}
			}
			logger.info(sql.toString() + " -- " + params.toString());
			pageInfo = this.pagingQuery(sql.toString(), pageInfo, params,
					new BeanPropertyRowMapper<PersonnelInfoMVO>(PersonnelInfoMVO.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			logger.error("查询PersonnelInfo错误：{}", e.getMessage());
			throw new SysException("查询PersonnelInfo错误", "10000", e);
		}
		return pageInfo;
	}

	@Override
	public PageInfo queryHousesPage(PersonnelInfoMVO entity, PageInfo pageInfo) throws SysException {
		StringBuffer sql = new StringBuffer();
		sql.append("select a.personnel_id,a.houses_id,a.user_id,a.username,a.status,a.live_type_id,a.live_type_name,TIMESTAMPDIFF(YEAR,a.birth_date,CURDATE())age ");
		sql.append(",a.gender,a.nation_name,a.certificates_number,str_to_date(a.create_time,'%Y-%m-%d %H:%i:%s')create_time ");
		sql.append(",b.houses_status,b.prov_name,b.city_name,b.area_name,ifnull(b.community_name,'')community_name,ifnull(b.community_street_name,'')community_street_name ");
		sql.append(",ifnull(b.storied_building_number,'')storied_building_number,ifnull(b.unit,'')unit,b.house_number,b.houses_address ");
		sql.append("from PERSONNEL_INFO a ");
		sql.append("left join houses_info b on(a.houses_id=b.houses_id) ");
		sql.append("where 1=1");

		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getUserId())) {
					sql.append(" AND a.user_id=?");
					params.add(entity.getUserId());
				}
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND a.houses_id in ("+entity.getHousesId()+")");
				}
				if (StringUtils.isNotBlank(entity.getStatus())) {
					sql.append(" AND a.status in ("+entity.getStatus()+")");
				}
				if (StringUtils.isNotBlank(entity.getLiveTypeId())) {
					sql.append(" AND a.live_type_id in ("+entity.getLiveTypeId()+")");
				}
				if (StringUtils.isNotBlank(entity.getSts())) {
					sql.append(" AND a.sts=?");
					params.add(entity.getSts());
				}
			}
			logger.info(sql.toString() + " -- " + params.toString());
			pageInfo = this.pagingQuery(sql.toString(), pageInfo, params,
					new BeanPropertyRowMapper<PersonnelInfoMVO>(PersonnelInfoMVO.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			logger.error("查询PersonnelInfo错误：{}", e.getMessage());
			throw new SysException("查询房产列表错误", "10000", e);
		}
		return pageInfo;
	}

	@Override
	public List<PersonnelInfoMVO> queryHousesList(PersonnelInfoMVO entity) throws SysException {
		StringBuffer sql = new StringBuffer();
		sql.append("select a.personnel_id,a.houses_id,a.user_id ");
		sql.append(",b.houses_status,b.prov_name,b.city_name,b.area_name,ifnull(b.community_name,'')community_name,ifnull(b.community_street_name,'')community_street_name ");
		sql.append(",ifnull(b.storied_building_number,'')storied_building_number,ifnull(b.unit,'')unit,b.house_number,b.houses_address ");
		sql.append("from PERSONNEL_INFO a ");
		sql.append("left join houses_info b on(a.houses_id=b.houses_id) ");
		sql.append("where 1=1 ");
		List<PersonnelInfoMVO> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getUserId())) {
					sql.append(" AND a.user_id=?");
					params.add(entity.getUserId());
				}
				if (StringUtils.isNotBlank(entity.getSts())) {
					sql.append(" AND a.sts=?");
					params.add(entity.getSts());
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<PersonnelInfoMVO>(PersonnelInfoMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询PERSONNEL_INFO错误：{}", e.getMessage());
			throw new SysException("查询房产列表错误", "10000", e);
		}
		return resultList;
	}

	@Override
	public PersonnelInfoMVO queryPersonnelBean(PersonnelInfoMVO entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append( "SELECT a.personnel_id,a.houses_id,a.user_id,a.per_sort,a.live_type_id,a.live_type_name,a.lease_mode,date_format(a.lease_start_time,'%Y-%m-%d')lease_start_time,date_format(a.lease_stop_time,'%Y-%m-%d')lease_stop_time,a.username,a.gender,a.face_photo,a.face_file,date_format(a.birth_date,'%Y-%m-%d')birth_date,a.nation_id,a.nation_name,a.telephone,a.certificates_type_id,a.certificates_type_name,a.certificates_positive_photo,a.certificates_positive_file,a.certificates_negative_photo,a.certificates_negative_file,a.certificates_number,a.certificates_start_time,a.certificates_stop_time,a.certificates_address,a.certificates_office,a.enterprise_name,a.status,ifnull(a.audit_remark,'')audit_remark,date_format(a.create_time,'%Y-%m-%d %H:%i:%s')create_time,ifnull(date_format(a.update_time,'%Y-%m-%d %H:%i:%s'),'')update_time,a.sts,DATEDIFF(current_date, a.lease_start_time)lease_day,TIMESTAMPDIFF(YEAR,a.birth_date,CURDATE())age ");
		sql.append(",b.houses_status,b.prov_name,b.city_name,b.area_name,ifnull(b.community_name,'')community_name,ifnull(b.community_street_name,'')community_street_name ");
		sql.append(",ifnull(b.storied_building_number,'')storied_building_number,ifnull(b.unit,'')unit,b.house_number,b.houses_address,b.property_owner_name ");
		sql.append(",b.house_type,b.houses_type_name,b.houses_type_id ");
		sql.append("FROM PERSONNEL_INFO a ");
		sql.append("left join houses_info b on(a.houses_id=b.houses_id) ");
		sql.append("WHERE 1=1 ");
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				sql.append(" and a.personnel_id=? ");
				params.add(entity.getPersonnelId());
			}
			logger.info(sql.toString() + "--" + params.toString());
			entity = jdbcTemplate.queryForObject(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<PersonnelInfoMVO>(PersonnelInfoMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询PERSONNEL_INFO错误：{}", e.getMessage());
			throw new SysException("查询PERSONNEL_INFO错误", "10000", e);
		}
		return entity;
	}

	@Override
	public List<PersonnelInfoMVO> queryPerList(PersonnelInfoMVO entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT personnel_id,houses_id,user_id,per_sort,live_type_id,live_type_name,lease_mode,date_format(lease_start_time,'%Y-%m-%d')lease_start_time,date_format(lease_stop_time,'%Y-%m-%d')lease_stop_time,username,gender,face_photo,face_file,date_format(birth_date,'%Y-%m-%d')birth_date,nation_id,nation_name,telephone,certificates_type_id,certificates_type_name,certificates_number,certificates_start_time,certificates_stop_time,certificates_address,certificates_office,enterprise_name,status,audit_remark,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
		sql.append(",DATEDIFF(current_date, lease_start_time)lease_day,TIMESTAMPDIFF(YEAR,birth_date,CURDATE())age  ");
		sql.append("FROM  PERSONNEL_INFO ");
		sql.append("WHERE 1=1 ");
		List<PersonnelInfoMVO> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getPersonnelId())) {
					sql.append(" AND personnel_id=?");
					params.add(entity.getPersonnelId());
				}
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND houses_id in ("+entity.getHousesId()+")");
				}
				if (StringUtils.isNotBlank(entity.getUserId())) {
					sql.append(" AND user_id=?");
					params.add(entity.getUserId());
				}
				if (StringUtils.isNotBlank(entity.getPerSort())) {
					sql.append(" AND per_sort=?");
					params.add(entity.getPerSort());
				}
				if (StringUtils.isNotBlank(entity.getLiveTypeId())) {
					sql.append(" AND live_type_id in ("+entity.getLiveTypeId()+")");
				}
				if (StringUtils.isNotBlank(entity.getLiveTypeName())) {
					sql.append(" AND live_type_name=?");
					params.add(entity.getLiveTypeName());
				}
				if (StringUtils.isNotBlank(entity.getLeaseMode())) {
					sql.append(" AND lease_mode=?");
					params.add(entity.getLeaseMode());
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
				if (StringUtils.isNotBlank(entity.getEnterpriseName())) {
					sql.append(" AND enterprise_name=?");
					params.add(entity.getEnterpriseName());
				}
				if (StringUtils.isNotBlank(entity.getStatus())) {
					sql.append(" AND status in ("+entity.getStatus()+")");
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
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<PersonnelInfoMVO>(PersonnelInfoMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询PERSONNEL_INFO错误：{}", e.getMessage());
			throw new SysException("查询PERSONNEL_INFO错误", "10000", e);
		}
		return resultList;
	}

	@Override
	public List<PersonnelInfoMVO> queryPersonnelList(PersonnelInfoMVO entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append( "SELECT a.personnel_id,a.houses_id,a.user_id,a.per_sort,a.live_type_id,a.live_type_name,a.lease_mode,date_format(a.lease_start_time,'%Y-%m-%d')lease_start_time,date_format(a.lease_stop_time,'%Y-%m-%d')lease_stop_time,a.username,a.gender,a.face_photo,a.face_file,date_format(a.birth_date,'%Y-%m-%d')birth_date,a.nation_id,a.nation_name,a.telephone,a.certificates_type_id,a.certificates_type_name,a.certificates_positive_photo,a.certificates_positive_file,a.certificates_negative_photo,a.certificates_negative_file,a.certificates_number,a.certificates_start_time,a.certificates_stop_time,a.certificates_address,a.certificates_office,a.enterprise_name,a.status,ifnull(a.audit_remark,'')audit_remark,date_format(a.create_time,'%Y-%m-%d %H:%i:%s')create_time,ifnull(date_format(a.update_time,'%Y-%m-%d %H:%i:%s'),'')update_time,a.sts,DATEDIFF(current_date, a.lease_start_time)lease_day,TIMESTAMPDIFF(YEAR,a.birth_date,CURDATE())age ");
		sql.append(",b.houses_status,b.prov_name,b.city_name,b.area_name,ifnull(b.community_name,'')community_name,ifnull(b.community_street_name,'')community_street_name ");
		sql.append(",ifnull(b.storied_building_number,'')storied_building_number,ifnull(b.unit,'')unit,b.house_number,b.houses_address,b.property_owner_name ");
		sql.append(",b.house_type,b.houses_type_name,b.houses_type_id ");
		sql.append("FROM PERSONNEL_INFO a ");
		sql.append("left join houses_info b on(a.houses_id=b.houses_id) ");
		sql.append("WHERE 1=1 ");
		List<PersonnelInfoMVO> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getPersonnelId())) {
					sql.append(" AND a.personnel_id in("+entity.getPersonnelId()+") ");
				}
				if (StringUtils.isNotBlank(entity.getUsername())) {
					sql.append(" AND a.username like ?");
					params.add("%"+entity.getUsername()+"%");
				}
				if (StringUtils.isNotBlank(entity.getGender())) {
					sql.append(" AND a.gender = ?");
					params.add(entity.getGender());
				}
				if (StringUtils.isNotBlank(entity.getNationId())) {
					sql.append(" AND a.nation_id = ?");
					params.add(entity.getNationId());
				}
				if (StringUtils.isNotBlank(entity.getLiveTypeId())) {
					sql.append(" AND a.live_type_id in ("+entity.getLiveTypeId()+")");
				}
				if (StringUtils.isNotBlank(entity.getStatus())) {
					sql.append(" AND a.status in ("+entity.getStatus()+")");
				}
				if (StringUtils.isNotBlank(entity.getCertificatesNumber())) {
					sql.append(" AND a.certificates_number like ?");
					params.add("%"+entity.getCertificatesNumber()+"%");
				}
				if (StringUtils.isNotBlank(entity.getTelephone())) {
					sql.append(" AND a.telephone like ?");
					params.add("%"+entity.getTelephone()+"%");
				}
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND b.houses_id in ("+entity.getHousesId()+")");
				}
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND b.community_id in ("+entity.getCommunityId()+")");
				}
				if (StringUtils.isNotBlank(entity.getSts())) {
					sql.append(" AND a.sts = ?");
					params.add(entity.getSts());
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<PersonnelInfoMVO>(PersonnelInfoMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询PERSONNEL_INFO错误：{}", e.getMessage());
			throw new SysException("查询PERSONNEL_INFO错误", "10000", e);
		}
		return resultList;
	}
}
