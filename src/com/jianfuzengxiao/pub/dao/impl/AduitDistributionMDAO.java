package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IAduitDistributionMDAO;
import com.jianfuzengxiao.pub.entity.AduitDistributionMVO;

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
		sql.append(",b.houses_status,b.property_owner_name,b.property_owner_tel,b.property_owner_idcard,b.community_name,b.community_street_name ");
		sql.append(",b.storied_building_number,b.unit,b.house_number,b.houses_address ");
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
				if (StringUtils.isNotBlank(entity.getPropertyOwnerName())) {
					sql.append(" AND b.property_owner_name like ?");
					params.add("%"+entity.getPropertyOwnerName()+"%");
				}
				if (StringUtils.isNotBlank(entity.getPropertyOwnerTel())) {
					sql.append(" AND b.property_owner_tel like ?");
					params.add("%"+entity.getPropertyOwnerTel()+"%");
				}
			}
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
}
