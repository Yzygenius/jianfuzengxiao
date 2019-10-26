package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IHousesInfoMDAO;
import com.jianfuzengxiao.pub.entity.HousesInfoMVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

@Repository
public class HousesInfoMDAO extends HousesInfoSDAO implements IHousesInfoMDAO {
	private static Logger logger = LoggerFactory.getLogger(HousesInfoMDAO.class);

	public PageInfo queryPage(HousesInfoMVO entity, PageInfo pageInfo) throws SysException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select houses_id,houses_status,property_owner_name,property_owner_tel,property_owner_idcard,property_certificates_number,property_certificates_photo,property_certificates_file,community_id,community_name,community_street_id,community_street_name,house_type,house_type_photo,house_type_file,storied_building_number,unit,house_number,houses_address,houses_type_id,houses_type_name,store_location,prov_name,prov_code,city_name,city_code,area_name,area_code,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
		sql.append("from HOUSES_INFO ");
		sql.append("where 1=1");

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
					sql.append(" AND property_owner_name like ?");
					params.add("%" + entity.getPropertyOwnerName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getPropertyOwnerTel())) {
					sql.append(" AND property_owner_tel like ?");
					params.add("%" + entity.getPropertyOwnerTel() + "%");
				}
				if (StringUtils.isNotBlank(entity.getPropertyOwnerIdcard())) {
					sql.append(" AND property_owner_idcard like ?");
					params.add("%" + entity.getPropertyOwnerIdcard() + "%");
				}
				if (StringUtils.isNotBlank(entity.getPropertyCertificatesNumber())) {
					sql.append(" AND property_certificates_number like ?");
					params.add("%" + entity.getPropertyCertificatesNumber() + "%");
				}
				if (StringUtils.isNotBlank(entity.getPropertyCertificatesPhoto())) {
					sql.append(" AND property_certificates_photo like ?");
					params.add("%" + entity.getPropertyCertificatesPhoto() + "%");
				}
				if (StringUtils.isNotBlank(entity.getPropertyCertificatesFile())) {
					sql.append(" AND property_certificates_file like ?");
					params.add("%" + entity.getPropertyCertificatesFile() + "%");
				}
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND community_id=?");
					params.add(entity.getCommunityId());
				}
				if (StringUtils.isNotBlank(entity.getCommunityName())) {
					sql.append(" AND community_name like ?");
					params.add("%" + entity.getCommunityName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
					sql.append(" AND community_street_id=?");
					params.add(entity.getCommunityStreetId());
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetName())) {
					sql.append(" AND community_street_name like ?");
					params.add("%" + entity.getCommunityStreetName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getHouseType())) {
					sql.append(" AND house_type like ?");
					params.add("%" + entity.getHouseType() + "%");
				}
				if (StringUtils.isNotBlank(entity.getHouseTypePhoto())) {
					sql.append(" AND house_type_photo like ?");
					params.add("%" + entity.getHouseTypePhoto() + "%");
				}
				if (StringUtils.isNotBlank(entity.getHouseTypeFile())) {
					sql.append(" AND house_type_file like ?");
					params.add("%" + entity.getHouseTypeFile() + "%");
				}
				if (StringUtils.isNotBlank(entity.getStoriedBuildingNumber())) {
					sql.append(" AND storied_building_number like ?");
					params.add("%" + entity.getStoriedBuildingNumber() + "%");
				}
				if (StringUtils.isNotBlank(entity.getUnit())) {
					sql.append(" AND unit like ?");
					params.add("%" + entity.getUnit() + "%");
				}
				if (StringUtils.isNotBlank(entity.getHouseNumber())) {
					sql.append(" AND house_number like ?");
					params.add("%" + entity.getHouseNumber() + "%");
				}
				if (StringUtils.isNotBlank(entity.getHousesAddress())) {
					sql.append(" AND houses_address like ?");
					params.add("%" + entity.getHousesAddress() + "%");
				}
				if (StringUtils.isNotBlank(entity.getHousesTypeId())) {
					sql.append(" AND houses_type_id=?");
					params.add(entity.getHousesTypeId());
				}
				if (StringUtils.isNotBlank(entity.getHousesTypeName())) {
					sql.append(" AND houses_type_name like ?");
					params.add("%" + entity.getHousesTypeName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getStoreLocation())) {
					sql.append(" AND store_location=?");
					params.add(entity.getStoreLocation());
				}
				if (StringUtils.isNotBlank(entity.getProvName())) {
					sql.append(" AND prov_name like ?");
					params.add("%" + entity.getProvName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getProvCode())) {
					sql.append(" AND prov_code like ?");
					params.add("%" + entity.getProvCode() + "%");
				}
				if (StringUtils.isNotBlank(entity.getCityName())) {
					sql.append(" AND city_name like ?");
					params.add("%" + entity.getCityName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getCityCode())) {
					sql.append(" AND city_code like ?");
					params.add("%" + entity.getCityCode() + "%");
				}
				if (StringUtils.isNotBlank(entity.getAreaName())) {
					sql.append(" AND area_name like ?");
					params.add("%" + entity.getAreaName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getAreaCode())) {
					sql.append(" AND area_code like ?");
					params.add("%" + entity.getAreaCode() + "%");
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
					new BeanPropertyRowMapper<HousesInfoMVO>(HousesInfoMVO.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			logger.error("查询HousesInfo错误：{}", e.getMessage());
			throw new SysException("10000", "查询HousesInfo错误", e);
		}
		return pageInfo;
	}
}
