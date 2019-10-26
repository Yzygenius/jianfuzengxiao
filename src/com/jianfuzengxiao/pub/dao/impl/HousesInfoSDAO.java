package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.base.impl.BaseDAO;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IHousesInfoSDAO;
import com.jianfuzengxiao.pub.entity.HousesInfoMVO;
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

public class HousesInfoSDAO extends BaseDAO<HousesInfoMVO> implements IHousesInfoSDAO {
	private static Logger logger = LoggerFactory.getLogger(HousesInfoSDAO.class);

	@Override
	public HousesInfoMVO insert(final HousesInfoMVO entity) throws SysException {
		final StringBuilder sql = new StringBuilder();
		sql.append(
				"INSERT INTO HOUSES_INFO (houses_id,houses_status,property_owner_name,property_owner_tel,property_owner_idcard,property_certificates_number,property_certificates_photo,property_certificates_file,community_id,community_name,community_street_id,community_street_name,house_type,house_type_photo,house_type_file,storied_building_number,unit,house_number,houses_address,houses_type_id,houses_type_name,store_location,prov_name,prov_code,city_name,city_code,area_name,area_code,create_time,update_time,sts) ");
		sql.append(
				"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,str_to_date(?,'%Y-%m-%d %H:%i:%s'),str_to_date(?,'%Y-%m-%d %H:%i:%s'),?)");
		try {
			logger.info(sql.toString());
			jdbcTemplate.update(new PreparedStatementCreator() {
				public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					int i = 0;
					java.sql.PreparedStatement ps = conn.prepareStatement(sql.toString());
					ps.setString(++i, StringUtils.trimToNull(entity.getHousesId()));
					ps.setString(++i, StringUtils.trimToNull(entity.getHousesStatus()));
					ps.setString(++i, StringUtils.trimToNull(entity.getPropertyOwnerName()));
					ps.setString(++i, StringUtils.trimToNull(entity.getPropertyOwnerTel()));
					ps.setString(++i, StringUtils.trimToNull(entity.getPropertyOwnerIdcard()));
					ps.setString(++i, StringUtils.trimToNull(entity.getPropertyCertificatesNumber()));
					ps.setString(++i, StringUtils.trimToNull(entity.getPropertyCertificatesPhoto()));
					ps.setString(++i, StringUtils.trimToNull(entity.getPropertyCertificatesFile()));
					ps.setString(++i, StringUtils.trimToNull(entity.getCommunityId()));
					ps.setString(++i, StringUtils.trimToNull(entity.getCommunityName()));
					ps.setString(++i, StringUtils.trimToNull(entity.getCommunityStreetId()));
					ps.setString(++i, StringUtils.trimToNull(entity.getCommunityStreetName()));
					ps.setString(++i, StringUtils.trimToNull(entity.getHouseType()));
					ps.setString(++i, StringUtils.trimToNull(entity.getHouseTypePhoto()));
					ps.setString(++i, StringUtils.trimToNull(entity.getHouseTypeFile()));
					ps.setString(++i, StringUtils.trimToNull(entity.getStoriedBuildingNumber()));
					ps.setString(++i, StringUtils.trimToNull(entity.getUnit()));
					ps.setString(++i, StringUtils.trimToNull(entity.getHouseNumber()));
					ps.setString(++i, StringUtils.trimToNull(entity.getHousesAddress()));
					ps.setString(++i, StringUtils.trimToNull(entity.getHousesTypeId()));
					ps.setString(++i, StringUtils.trimToNull(entity.getHousesTypeName()));
					ps.setString(++i, StringUtils.trimToNull(entity.getStoreLocation()));
					ps.setString(++i, StringUtils.trimToNull(entity.getProvName()));
					ps.setString(++i, StringUtils.trimToNull(entity.getProvCode()));
					ps.setString(++i, StringUtils.trimToNull(entity.getCityName()));
					ps.setString(++i, StringUtils.trimToNull(entity.getCityCode()));
					ps.setString(++i, StringUtils.trimToNull(entity.getAreaName()));
					ps.setString(++i, StringUtils.trimToNull(entity.getAreaCode()));
					ps.setString(++i, StringUtils.trimToNull(entity.getCreateTime()));
					ps.setString(++i, StringUtils.trimToNull(entity.getUpdateTime()));
					ps.setString(++i, StringUtils.trimToNull(entity.getSts()));
					return ps;
				}
			});
		} catch (DataAccessException e) {
			logger.error("增加HOUSES_INFO 错误：{}", e.getMessage());
			throw new SysException("10000", "增加HOUSES_INFO错误", e);
		}
		return entity;
	}

	@Override
	public int update(HousesInfoMVO entity) throws SysException {
		int rowsAffected;
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE  HOUSES_INFO  SET ");
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity.getHousesStatus() != null) {
				sql.append("houses_status=?,");
				params.add(entity.getHousesStatus());
			}
			if (entity.getPropertyOwnerName() != null) {
				sql.append("property_owner_name=?,");
				params.add(entity.getPropertyOwnerName());
			}
			if (entity.getPropertyOwnerTel() != null) {
				sql.append("property_owner_tel=?,");
				params.add(entity.getPropertyOwnerTel());
			}
			if (entity.getPropertyOwnerIdcard() != null) {
				sql.append("property_owner_idcard=?,");
				params.add(entity.getPropertyOwnerIdcard());
			}
			if (entity.getPropertyCertificatesNumber() != null) {
				sql.append("property_certificates_number=?,");
				params.add(entity.getPropertyCertificatesNumber());
			}
			if (entity.getPropertyCertificatesPhoto() != null) {
				sql.append("property_certificates_photo=?,");
				params.add(entity.getPropertyCertificatesPhoto());
			}
			if (entity.getPropertyCertificatesFile() != null) {
				sql.append("property_certificates_file=?,");
				params.add(entity.getPropertyCertificatesFile());
			}
			if (entity.getCommunityId() != null) {
				sql.append("community_id=?,");
				params.add(entity.getCommunityId());
			}
			if (entity.getCommunityName() != null) {
				sql.append("community_name=?,");
				params.add(entity.getCommunityName());
			}
			if (entity.getCommunityStreetId() != null) {
				sql.append("community_street_id=?,");
				params.add(entity.getCommunityStreetId());
			}
			if (entity.getCommunityStreetName() != null) {
				sql.append("community_street_name=?,");
				params.add(entity.getCommunityStreetName());
			}
			if (entity.getHouseType() != null) {
				sql.append("house_type=?,");
				params.add(entity.getHouseType());
			}
			if (entity.getHouseTypePhoto() != null) {
				sql.append("house_type_photo=?,");
				params.add(entity.getHouseTypePhoto());
			}
			if (entity.getHouseTypeFile() != null) {
				sql.append("house_type_file=?,");
				params.add(entity.getHouseTypeFile());
			}
			if (entity.getStoriedBuildingNumber() != null) {
				sql.append("storied_building_number=?,");
				params.add(entity.getStoriedBuildingNumber());
			}
			if (entity.getUnit() != null) {
				sql.append("unit=?,");
				params.add(entity.getUnit());
			}
			if (entity.getHouseNumber() != null) {
				sql.append("house_number=?,");
				params.add(entity.getHouseNumber());
			}
			if (entity.getHousesAddress() != null) {
				sql.append("houses_address=?,");
				params.add(entity.getHousesAddress());
			}
			if (entity.getHousesTypeId() != null) {
				sql.append("houses_type_id=?,");
				params.add(entity.getHousesTypeId());
			}
			if (entity.getHousesTypeName() != null) {
				sql.append("houses_type_name=?,");
				params.add(entity.getHousesTypeName());
			}
			if (entity.getStoreLocation() != null) {
				sql.append("store_location=?,");
				params.add(entity.getStoreLocation());
			}
			if (entity.getProvName() != null) {
				sql.append("prov_name=?,");
				params.add(entity.getProvName());
			}
			if (entity.getProvCode() != null) {
				sql.append("prov_code=?,");
				params.add(entity.getProvCode());
			}
			if (entity.getCityName() != null) {
				sql.append("city_name=?,");
				params.add(entity.getCityName());
			}
			if (entity.getCityCode() != null) {
				sql.append("city_code=?,");
				params.add(entity.getCityCode());
			}
			if (entity.getAreaName() != null) {
				sql.append("area_name=?,");
				params.add(entity.getAreaName());
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
			sql.append(" WHERE houses_id=?");
			params.add(entity.getHousesId());
			logger.info(sql.toString() + "--" + params.toString());
			rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());
		} catch (DataAccessException e) {
			logger.error("更新HOUSES_INFO错误：{}", e.getMessage());
			throw new SysException("10000", "更新HOUSES_INFO错误", e);
		}
		return rowsAffected;
	}

	@Override
	public int delete(HousesInfoMVO entity) throws SysException {
		int rowsAffected;
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM HOUSES_INFO WHERE houses_id=?");
		try {
			logger.info(sql.toString());
			rowsAffected = jdbcTemplate.update(sql.toString(), entity.getHousesId());
		} catch (DataAccessException e) {
			logger.error("删除HOUSES_INFO错误：{}", e.getMessage());
			throw new SysException("10000", "删除HOUSES_INFO错误", e);
		}
		return rowsAffected;
	}

	@Override
	public List<HousesInfoMVO> queryList(HousesInfoMVO entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT houses_id,houses_status,property_owner_name,property_owner_tel,property_owner_idcard,property_certificates_number,property_certificates_photo,property_certificates_file,community_id,community_name,community_street_id,community_street_name,house_type,house_type_photo,house_type_file,storied_building_number,unit,house_number,houses_address,houses_type_id,houses_type_name,store_location,prov_name,prov_code,city_name,city_code,area_name,area_code,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
		sql.append("FROM  HOUSES_INFO ");
		sql.append("WHERE 1=1 ");
		List<HousesInfoMVO> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND houses_id=?");
					params.add(entity.getHousesId());
				}
				if (StringUtils.isNotBlank(entity.getHousesStatus())) {
					sql.append(" AND houses_status=?");
					params.add(entity.getHousesStatus());
				}
				if (StringUtils.isNotBlank(entity.getPropertyOwnerName())) {
					sql.append(" AND property_owner_name=?");
					params.add(entity.getPropertyOwnerName());
				}
				if (StringUtils.isNotBlank(entity.getPropertyOwnerTel())) {
					sql.append(" AND property_owner_tel=?");
					params.add(entity.getPropertyOwnerTel());
				}
				if (StringUtils.isNotBlank(entity.getPropertyOwnerIdcard())) {
					sql.append(" AND property_owner_idcard=?");
					params.add(entity.getPropertyOwnerIdcard());
				}
				if (StringUtils.isNotBlank(entity.getPropertyCertificatesNumber())) {
					sql.append(" AND property_certificates_number=?");
					params.add(entity.getPropertyCertificatesNumber());
				}
				if (StringUtils.isNotBlank(entity.getPropertyCertificatesPhoto())) {
					sql.append(" AND property_certificates_photo=?");
					params.add(entity.getPropertyCertificatesPhoto());
				}
				if (StringUtils.isNotBlank(entity.getPropertyCertificatesFile())) {
					sql.append(" AND property_certificates_file=?");
					params.add(entity.getPropertyCertificatesFile());
				}
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND community_id=?");
					params.add(entity.getCommunityId());
				}
				if (StringUtils.isNotBlank(entity.getCommunityName())) {
					sql.append(" AND community_name=?");
					params.add(entity.getCommunityName());
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
					sql.append(" AND community_street_id=?");
					params.add(entity.getCommunityStreetId());
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetName())) {
					sql.append(" AND community_street_name=?");
					params.add(entity.getCommunityStreetName());
				}
				if (StringUtils.isNotBlank(entity.getHouseType())) {
					sql.append(" AND house_type=?");
					params.add(entity.getHouseType());
				}
				if (StringUtils.isNotBlank(entity.getHouseTypePhoto())) {
					sql.append(" AND house_type_photo=?");
					params.add(entity.getHouseTypePhoto());
				}
				if (StringUtils.isNotBlank(entity.getHouseTypeFile())) {
					sql.append(" AND house_type_file=?");
					params.add(entity.getHouseTypeFile());
				}
				if (StringUtils.isNotBlank(entity.getStoriedBuildingNumber())) {
					sql.append(" AND storied_building_number=?");
					params.add(entity.getStoriedBuildingNumber());
				}
				if (StringUtils.isNotBlank(entity.getUnit())) {
					sql.append(" AND unit=?");
					params.add(entity.getUnit());
				}
				if (StringUtils.isNotBlank(entity.getHouseNumber())) {
					sql.append(" AND house_number=?");
					params.add(entity.getHouseNumber());
				}
				if (StringUtils.isNotBlank(entity.getHousesAddress())) {
					sql.append(" AND houses_address=?");
					params.add(entity.getHousesAddress());
				}
				if (StringUtils.isNotBlank(entity.getHousesTypeId())) {
					sql.append(" AND houses_type_id=?");
					params.add(entity.getHousesTypeId());
				}
				if (StringUtils.isNotBlank(entity.getHousesTypeName())) {
					sql.append(" AND houses_type_name=?");
					params.add(entity.getHousesTypeName());
				}
				if (StringUtils.isNotBlank(entity.getStoreLocation())) {
					sql.append(" AND store_location=?");
					params.add(entity.getStoreLocation());
				}
				if (StringUtils.isNotBlank(entity.getProvName())) {
					sql.append(" AND prov_name=?");
					params.add(entity.getProvName());
				}
				if (StringUtils.isNotBlank(entity.getProvCode())) {
					sql.append(" AND prov_code=?");
					params.add(entity.getProvCode());
				}
				if (StringUtils.isNotBlank(entity.getCityName())) {
					sql.append(" AND city_name=?");
					params.add(entity.getCityName());
				}
				if (StringUtils.isNotBlank(entity.getCityCode())) {
					sql.append(" AND city_code=?");
					params.add(entity.getCityCode());
				}
				if (StringUtils.isNotBlank(entity.getAreaName())) {
					sql.append(" AND area_name=?");
					params.add(entity.getAreaName());
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
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<HousesInfoMVO>(HousesInfoMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询HOUSES_INFO错误：{}", e.getMessage());
			throw new SysException("10000", "查询HOUSES_INFO错误", e);
		}
		return resultList;
	}

	@Override
	public HousesInfoMVO queryBean(HousesInfoMVO entity) throws SysException {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT houses_id,houses_status,property_owner_name,property_owner_tel,property_owner_idcard,property_certificates_number,property_certificates_photo,property_certificates_file,community_id,community_name,community_street_id,community_street_name,house_type,house_type_photo,house_type_file,storied_building_number,unit,house_number,houses_address,houses_type_id,houses_type_name,store_location,prov_name,prov_code,city_name,city_code,area_name,area_code,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
		sql.append("FROM  HOUSES_INFO ");
		sql.append("WHERE houses_id=? ");
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				params.add(entity.getHousesId());
			} else {
				sql.append(" AND 1=2");
			}
			logger.info(sql.toString() + "--" + params.toString());
			entity = jdbcTemplate.queryForObject(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<HousesInfoMVO>(HousesInfoMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询HOUSES_INFO错误：{}", e.getMessage());
			throw new SysException("10000", "查询HOUSES_INFO错误", e);
		}
		return entity;
	}

}
