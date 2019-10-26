package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IHousesTypeMDAO;
import com.jianfuzengxiao.pub.entity.HousesTypeMVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

@Repository
public class HousesTypeMDAO extends HousesTypeSDAO implements IHousesTypeMDAO {
	private static Logger logger = LoggerFactory.getLogger(HousesTypeMDAO.class);

	public PageInfo queryPage(HousesTypeMVO entity, PageInfo pageInfo) throws SysException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select houses_type_id,houses_type_name,list_order,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
		sql.append("from HOUSES_TYPE ");
		sql.append("where 1=1");

		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getHousesTypeId())) {
					sql.append(" AND houses_type_id=?");
					params.add(entity.getHousesTypeId());
				}
				if (StringUtils.isNotBlank(entity.getHousesTypeName())) {
					sql.append(" AND houses_type_name like ?");
					params.add("%" + entity.getHousesTypeName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getListOrder())) {
					sql.append(" AND list_order=?");
					params.add(entity.getListOrder());
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
					new BeanPropertyRowMapper<HousesTypeMVO>(HousesTypeMVO.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			logger.error("查询HousesType错误：{}", e.getMessage());
			throw new SysException("10000", "查询HousesType错误", e);
		}
		return pageInfo;
	}
}
