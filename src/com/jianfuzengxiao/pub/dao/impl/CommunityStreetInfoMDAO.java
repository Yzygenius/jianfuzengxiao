package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.ICommunityStreetInfoMDAO;
import com.jianfuzengxiao.pub.entity.CommunityStreetInfoMVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

@Repository
public class CommunityStreetInfoMDAO extends CommunityStreetInfoSDAO implements ICommunityStreetInfoMDAO {
	private static Logger logger = LoggerFactory.getLogger(CommunityStreetInfoMDAO.class);

	public PageInfo queryPage(CommunityStreetInfoMVO entity, PageInfo pageInfo) throws SysException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select a.community_street_id,a.community_street_name,a.status,a.community_id,a.list_order,date_format(a.create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(a.update_time,'%Y-%m-%d %H:%i:%s')update_time,a.sts,a.gwh_id,a.gwh_name ");
		sql.append(",b.community_name ");
		sql.append("from COMMUNITY_STREET_INFO a ");
		sql.append("left join community_info b on(a.community_id=b.community_id) ");
		sql.append("where 1=1");

		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
					sql.append(" AND a.community_street_id=?");
					params.add(entity.getCommunityStreetId());
				}
				if (StringUtils.isNotBlank(entity.getCommunityStreetName())) {
					sql.append(" AND a.community_street_name like ?");
					params.add("%" + entity.getCommunityStreetName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getStatus())) {
					sql.append(" AND a.status=?");
					params.add(entity.getStatus());
				}
				if (StringUtils.isNotBlank(entity.getCommunityId())) {
					sql.append(" AND a.community_id in("+entity.getCommunityId()+") ");
				}
				if (StringUtils.isNotBlank(entity.getListOrder())) {
					sql.append(" AND a.list_order=?");
					params.add(entity.getListOrder());
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
				if (StringUtils.isNotBlank(entity.getCommunityName())) {
					sql.append(" AND b.community_name like ?");
					params.add("%" + entity.getCommunityName() + "%");
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
			logger.info(sql.toString()+" -- "+params.toString());
			pageInfo = this.pagingQuery(sql.toString(), pageInfo, params,
					new BeanPropertyRowMapper<CommunityStreetInfoMVO>(CommunityStreetInfoMVO.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			logger.error("查询CommunityStreetInfo错误：{}", e.getMessage());
			throw new SysException("查询CommunityStreetInfo错误", "10000", e);
		}
		return pageInfo;
	}
}
