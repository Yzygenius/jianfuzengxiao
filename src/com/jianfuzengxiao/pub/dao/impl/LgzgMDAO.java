package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.ILgzgMDAO;
import com.jianfuzengxiao.pub.entity.CommunityInfoMVO;
import com.jianfuzengxiao.pub.entity.HousesInfoMVO;
import com.jianfuzengxiao.pub.entity.LgzgMVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

@Repository
public class LgzgMDAO extends LgzgSDAO implements ILgzgMDAO {
	private static Logger logger = LoggerFactory.getLogger(LgzgMDAO.class);

	public PageInfo queryPage(LgzgMVO entity, PageInfo pageInfo) throws SysException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select lgzg_id,admin_id,community_id,status,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts,gwh_id,gwh_name ");
		sql.append("from LGZG ");
		sql.append("where 1=1");

		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getLgzgId())) {
					sql.append(" AND lgzg_id=?");
					params.add(entity.getLgzgId());
				}
				if (StringUtils.isNotBlank(entity.getAdminId())) {
					sql.append(" AND admin_id=?");
					params.add(entity.getAdminId());
				}
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND community_id=?");
					params.add(entity.getCommunityId());
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
				if (StringUtils.isNotBlank(entity.getGwhId())) {
					sql.append(" AND gwh_id=?");
					params.add(entity.getGwhId());
				}
				if (StringUtils.isNotBlank(entity.getGwhName())) {
					sql.append(" AND gwh_name like ?");
					params.add("%" + entity.getGwhName() + "%");
				}
			}
			pageInfo = this.pagingQuery(sql.toString(), pageInfo, params,
					new BeanPropertyRowMapper<LgzgMVO>(LgzgMVO.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			logger.error("查询Lgzg错误：{}", e.getMessage());
			throw new SysException("查询Lgzg错误", "10000", e);
		}
		return pageInfo;
	}

	@Override
	public PageInfo queryManageCommunityPage(LgzgMVO entity, PageInfo pageInfo) throws SysException {
		StringBuffer sql = new StringBuffer();
		sql.append("select a.lgzg_id,a.admin_id,a.community_id,a.status,date_format(a.create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(a.update_time,'%Y-%m-%d %H:%i:%s')update_time,a.sts,a.gwh_id,a.gwh_name ");
		sql.append(",b.community_name,b.prov_name,b.city_name,b.area_name ");
		sql.append("from LGZG a ");
		sql.append("left join community_info b on(a.community_id=b.community_id) ");
		sql.append("where 1=1");

		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getLgzgId())) {
					sql.append(" AND a.lgzg_id=?");
					params.add(entity.getLgzgId());
				}
				if (StringUtils.isNotBlank(entity.getAdminId())) {
					sql.append(" AND a.admin_id=?");
					params.add(entity.getAdminId());
				}
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND a.community_id ("+entity.getCommunityId()+") ");
				}
				if (StringUtils.isNotBlank(entity.getStatus())) {
					sql.append(" AND a.status=?");
					params.add(entity.getStatus());
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
				if (StringUtils.isNotBlank(entity.getGwhId())) {
					sql.append(" AND a.gwh_id=?");
					params.add(entity.getGwhId());
				}
				if (StringUtils.isNotBlank(entity.getGwhName())) {
					sql.append(" AND a.gwh_name like ?");
					params.add("%" + entity.getGwhName() + "%");
				}
			}
			pageInfo = this.pagingQuery(sql.toString(), pageInfo, params,
					new BeanPropertyRowMapper<LgzgMVO>(LgzgMVO.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			logger.error("查询Lgzg错误：{}", e.getMessage());
			throw new SysException("查询Lgzg错误", "10000", e);
		}
		return pageInfo;
	}

	@Override
	public PageInfo queryPageNotAdminCommuntiy(CommunityInfoMVO entity, PageInfo pageInfo) throws SysException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select a.community_id,a.community_name,a.list_order,date_format(a.create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(a.update_time,'%Y-%m-%d %H:%i:%s')update_time,a.sts,a.prov_code,a.prov_name,a.city_code,a.city_name,a.area_code,a.area_name,a.gwh_id,a.gwh_name ");
		//sql.append(",b.username,b.telephone admin_telephone ");
		sql.append("from COMMUNITY_INFO a ");
	//	sql.append("left join admin_info b on(a.admin_id=b.admin_id) ");
		sql.append("where a.community_id not in(select community_id from lgzg where sts='A' group by community_id) ");

		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				
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
				if (StringUtils.isNotBlank(entity.getSts())) {
					sql.append(" AND a.sts like ?");
					params.add("%" + entity.getSts() + "%");
				}
				
			}
			sql.append(" group by a.community_id ");
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
