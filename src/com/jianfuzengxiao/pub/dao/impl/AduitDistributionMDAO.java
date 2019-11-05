package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IAduitDistributionMDAO;
import com.jianfuzengxiao.pub.entity.AduitDistributionMVO;
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
public class AduitDistributionMDAO extends AduitDistributionSDAO implements IAduitDistributionMDAO {
	private static Logger logger = LoggerFactory.getLogger(AduitDistributionMDAO.class);

	public PageInfo queryPage(AduitDistributionMVO entity, PageInfo pageInfo) throws SysException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select id,admin_id,houses_id,status,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
		sql.append("from ADUIT_DISTRIBUTION ");
		sql.append("where 1=1");

		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getId())) {
					sql.append(" AND id=?");
					params.add(entity.getId());
				}
				if (StringUtils.isNotBlank(entity.getAdminId())) {
					sql.append(" AND admin_id=?");
					params.add(entity.getAdminId());
				}
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND houses_id=?");
					params.add(entity.getHousesId());
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
					sql.append(" AND sts like ?");
					params.add("%" + entity.getSts() + "%");
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			pageInfo = this.pagingQuery(sql.toString(), pageInfo, params,
					new BeanPropertyRowMapper<AduitDistributionMVO>(AduitDistributionMVO.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			logger.error("查询AduitDistribution错误：{}", e.getMessage());
			throw new SysException("查询AduitDistribution错误", "10000", e);
		}
		return pageInfo;
	}

	@Override
	public PageInfo queryHousesPage(AduitDistributionMVO entity, PageInfo pageInfo) throws SysException {
		StringBuffer sql = new StringBuffer();
		sql.append("select a.id,a.admin_id,a.houses_id,a.status,date_format(a.create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(a.update_time,'%Y-%m-%d %H:%i:%s')update_time,a.sts ");
		sql.append(",b.houses_status,b.property_owner_name,b.property_owner_tel,b.property_owner_idcard,b.community_id,b.community_name,b.community_street_id,b.community_street_name ");
		sql.append(",b.storied_building_number,b.unit,b.house_number,b.houses_address,b.property_certificates_number,b.house_type,b.houses_type_name,b.store_location ");
		sql.append(",b.prov_code,b.city_code,b.area_code ");
		sql.append("from ADUIT_DISTRIBUTION a ");
		sql.append("left join houses_info b on(a.houses_id=b.houses_id) ");
		sql.append("where 1=1 ");

		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getId())) {
					sql.append(" AND a.id=?");
					params.add(entity.getId());
				}
				if (StringUtils.isNotBlank(entity.getAdminId())) {
					sql.append(" AND a.admin_id=?");
					params.add(entity.getAdminId());
				}
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND a.houses_id=?");
					params.add(entity.getHousesId());
				}
				if (StringUtils.isNotBlank(entity.getSts())) {
					sql.append(" AND a.sts = ?");
					params.add(entity.getSts());
				}
				if (StringUtils.isNotBlank(entity.getKeyword())) {
					sql.append(" AND (b.property_owner_name like ? or b.property_owner_tel like ? ) ");
					params.add("%"+entity.getKeyword()+"%");
					params.add("%"+entity.getKeyword()+"%");
				}
				if (StringUtils.isNotBlank(entity.getStoriedBuildingNumber())) {
					sql.append(" AND b.storied_building_number like ?");
					params.add("%" + entity.getStoriedBuildingNumber() + "%");
				}
				if (StringUtils.isNotBlank(entity.getUnit())) {
					sql.append(" AND b.unit like ?");
					params.add("%" + entity.getUnit() + "%");
				}
				if (StringUtils.isNotBlank(entity.getHouseNumber())) {
					sql.append(" AND b.house_number like ?");
					params.add("%" + entity.getHouseNumber() + "%");
				}
				if (StringUtils.isNotBlank(entity.getProvCode())) {
					sql.append(" AND b.prov_code like ?");
					params.add("%" + entity.getProvCode() + "%");
				}
				if (StringUtils.isNotBlank(entity.getCityCode())) {
					sql.append(" AND b.city_code like ?");
					params.add("%" + entity.getCityCode() + "%");
				}
				if (StringUtils.isNotBlank(entity.getAreaCode())) {
					sql.append(" AND b.area_code like ?");
					params.add("%" + entity.getAreaCode() + "%");
				}
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND b.community_id=?");
					params.add(entity.getCommunityId());
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
					sql.append(" AND b.community_street_id=?");
					params.add(entity.getCommunityStreetId());
				}
				/*if (StringUtils.isNotBlank(entity.getPropertyOwnerName())) {
					sql.append(" AND b.property_owner_name like ?");
					params.add("%"+entity.getPropertyOwnerName()+"%");
				}
				if (StringUtils.isNotBlank(entity.getPropertyOwnerTel())) {
					sql.append(" AND b.property_owner_tel like ?");
					params.add("%"+entity.getPropertyOwnerTel()+"%");
				}*/
			}
			logger.info(sql.toString() + "--" + params.toString());
			pageInfo = this.pagingQuery(sql.toString(), pageInfo, params,
					new BeanPropertyRowMapper<AduitDistributionMVO>(AduitDistributionMVO.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			logger.error("查询AduitDistribution错误：{}", e.getMessage());
			throw new SysException("查询AduitDistribution错误", "10000", e);
		}
		return pageInfo;
	}

	@Override
	public List<AduitDistributionMVO> queryHousesList(AduitDistributionMVO entity) throws SysException {
		StringBuffer sql = new StringBuffer();
		sql.append("select a.id,a.admin_id,a.houses_id,a.status,date_format(a.create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(a.update_time,'%Y-%m-%d %H:%i:%s')update_time,a.sts ");
		sql.append(",b.houses_status,b.property_owner_name,b.property_owner_tel,b.property_owner_idcard,b.community_name,b.community_street_name ");
		sql.append(",b.storied_building_number,b.unit,b.house_number,b.houses_address ");
		sql.append("from ADUIT_DISTRIBUTION a ");
		sql.append("left join houses_info b on(a.houses_id=b.houses_id) ");
		sql.append("where 1=1 ");
		List<AduitDistributionMVO> resultList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getId())) {
					sql.append(" AND a.id=?");
					params.add(entity.getId());
				}
				if (StringUtils.isNotBlank(entity.getAdminId())) {
					sql.append(" AND a.admin_id=?");
					params.add(entity.getAdminId());
				}
				if (StringUtils.isNotBlank(entity.getHousesId())) {
					sql.append(" AND a.houses_id=?");
					params.add(entity.getHousesId());
				}
				if (StringUtils.isNotBlank(entity.getSts())) {
					sql.append(" AND a.sts = ?");
					params.add(entity.getSts());
				}
				if (StringUtils.isNotBlank(entity.getPropertyOwnerName())) {
					sql.append(" AND b.property_owner_name like ?");
					params.add("%"+entity.getPropertyOwnerName()+"%");
				}
				if (StringUtils.isNotBlank(entity.getPropertyOwnerTel())) {
					sql.append(" AND b.property_owner_tel like ?");
					params.add("%"+entity.getPropertyOwnerTel()+"%");
				}
			}
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(), params.toArray(),
					new BeanPropertyRowMapper<AduitDistributionMVO>(AduitDistributionMVO.class));
		} catch (DataAccessException e) {
			logger.error("查询ADUIT_DISTRIBUTION错误：{}", e.getMessage());
			throw new SysException("查询ADUIT_DISTRIBUTION错误", "10000", e);
		}
		return resultList;
	}

	@Override
	public PageInfo queryPageNotAdminHouses(HousesInfoMVO entity, PageInfo pageInfo) throws SysException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select a.houses_id,a.admin_id,a.user_id,a.houses_status,a.property_owner_name,a.property_owner_tel,a.property_owner_idcard,a.property_certificates_number,a.property_certificates_photo,a.property_certificates_file,a.community_id,a.community_name,a.community_street_id,a.community_street_name,a.house_type,a.house_type_photo,a.house_type_file,a.storied_building_number,a.unit,a.house_number,a.houses_address,a.houses_type_id,a.houses_type_name,a.store_location,a.prov_name,a.prov_code,a.city_name,a.city_code,a.area_name,a.area_code,date_format(a.create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(a.update_time,'%Y-%m-%d %H:%i:%s')update_time,a.sts ");
		sql.append(",b.username,b.telephone admin_telephone ");
		sql.append("from HOUSES_INFO a ");
		sql.append("left join admin_info b on(a.admin_id=b.admin_id) ");
		sql.append("where a.houses_id not in(select houses_id from aduit_distribution where sts='A' group by houses_id) ");

		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getAdminId())) {
					sql.append(" AND a.admin_id=?");
					params.add(entity.getAdminId());
				}
				if (StringUtils.isNotBlank(entity.getUserId())) {
					sql.append(" AND a.user_id like ?");
					params.add("%" + entity.getUserId() + "%");
				}
				if (StringUtils.isNotBlank(entity.getHousesStatus())) {
					sql.append(" AND a.houses_status=?");
					params.add(entity.getHousesStatus());
				}
				if (StringUtils.isNotBlank(entity.getPropertyOwnerName())) {
					sql.append(" AND a.property_owner_name like ?");
					params.add("%" + entity.getPropertyOwnerName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getPropertyOwnerTel())) {
					sql.append(" AND a.property_owner_tel like ?");
					params.add("%" + entity.getPropertyOwnerTel() + "%");
				}
				if (StringUtils.isNotBlank(entity.getPropertyOwnerIdcard())) {
					sql.append(" AND a.property_owner_idcard like ?");
					params.add("%" + entity.getPropertyOwnerIdcard() + "%");
				}
				if (StringUtils.isNotBlank(entity.getPropertyCertificatesNumber())) {
					sql.append(" AND a.property_certificates_number like ?");
					params.add("%" + entity.getPropertyCertificatesNumber() + "%");
				}
				if (StringUtils.isNotBlank(entity.getPropertyCertificatesPhoto())) {
					sql.append(" AND a.property_certificates_photo like ?");
					params.add("%" + entity.getPropertyCertificatesPhoto() + "%");
				}
				if (StringUtils.isNotBlank(entity.getPropertyCertificatesFile())) {
					sql.append(" AND a.property_certificates_file like ?");
					params.add("%" + entity.getPropertyCertificatesFile() + "%");
				}
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND a.community_id=?");
					params.add(entity.getCommunityId());
				}
				if (StringUtils.isNotBlank(entity.getCommunityName())) {
					sql.append(" AND a.community_name like ?");
					params.add("%" + entity.getCommunityName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
					sql.append(" AND a.community_street_id=?");
					params.add(entity.getCommunityStreetId());
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetName())) {
					sql.append(" AND a.community_street_name like ?");
					params.add("%" + entity.getCommunityStreetName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getHouseType())) {
					sql.append(" AND a.house_type like ?");
					params.add("%" + entity.getHouseType() + "%");
				}
				if (StringUtils.isNotBlank(entity.getHouseTypePhoto())) {
					sql.append(" AND a.house_type_photo like ?");
					params.add("%" + entity.getHouseTypePhoto() + "%");
				}
				if (StringUtils.isNotBlank(entity.getHouseTypeFile())) {
					sql.append(" AND a.house_type_file like ?");
					params.add("%" + entity.getHouseTypeFile() + "%");
				}
				if (StringUtils.isNotBlank(entity.getStoriedBuildingNumber())) {
					sql.append(" AND a.storied_building_number like ?");
					params.add("%" + entity.getStoriedBuildingNumber() + "%");
				}
				if (StringUtils.isNotBlank(entity.getUnit())) {
					sql.append(" AND a.unit like ?");
					params.add("%" + entity.getUnit() + "%");
				}
				if (StringUtils.isNotBlank(entity.getHouseNumber())) {
					sql.append(" AND a.house_number like ?");
					params.add("%" + entity.getHouseNumber() + "%");
				}
				if (StringUtils.isNotBlank(entity.getHousesAddress())) {
					sql.append(" AND a.houses_address like ?");
					params.add("%" + entity.getHousesAddress() + "%");
				}
				if (StringUtils.isNotBlank(entity.getHousesTypeId())) {
					sql.append(" AND a.houses_type_id=?");
					params.add(entity.getHousesTypeId());
				}
				if (StringUtils.isNotBlank(entity.getHousesTypeName())) {
					sql.append(" AND a.houses_type_name like ?");
					params.add("%" + entity.getHousesTypeName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getStoreLocation())) {
					sql.append(" AND a.store_location=?");
					params.add(entity.getStoreLocation());
				}
				if (StringUtils.isNotBlank(entity.getProvName())) {
					sql.append(" AND a.prov_name like ?");
					params.add("%" + entity.getProvName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getProvCode())) {
					sql.append(" AND a.prov_code like ?");
					params.add("%" + entity.getProvCode() + "%");
				}
				if (StringUtils.isNotBlank(entity.getCityName())) {
					sql.append(" AND a.city_name like ?");
					params.add("%" + entity.getCityName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getCityCode())) {
					sql.append(" AND a.city_code like ?");
					params.add("%" + entity.getCityCode() + "%");
				}
				if (StringUtils.isNotBlank(entity.getAreaName())) {
					sql.append(" AND a.area_name like ?");
					params.add("%" + entity.getAreaName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getAreaCode())) {
					sql.append(" AND a.area_code like ?");
					params.add("%" + entity.getAreaCode() + "%");
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
				
				if (StringUtils.isNotBlank(entity.getKeyword())) {
					sql.append(" AND (a.property_owner_name like ? or a.property_owner_tel like ? or a.property_owner_idcard like ? ) ");
					params.add("%" + entity.getKeyword() + "%");
					params.add("%" + entity.getKeyword() + "%");
					params.add("%" + entity.getKeyword() + "%");
				}
			}
			sql.append(" group by a.houses_id ");
			logger.info(sql.toString() + "--" + params.toString());
			pageInfo = this.pagingQuery(sql.toString(), pageInfo, params,
					new BeanPropertyRowMapper<HousesInfoMVO>(HousesInfoMVO.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			logger.error("查询HousesInfo错误：{}", e.getMessage());
			throw new SysException("查询HousesInfo错误", "10000", e);
		}
		return pageInfo;
	}
}
