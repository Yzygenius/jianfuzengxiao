package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.ILiveTypeMDAO;
import com.jianfuzengxiao.pub.entity.LiveTypeMVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

@Repository
public class LiveTypeMDAO extends LiveTypeSDAO implements ILiveTypeMDAO {
	private static Logger logger = LoggerFactory.getLogger(LiveTypeMDAO.class);

	public PageInfo queryPage(LiveTypeMVO entity, PageInfo pageInfo) throws SysException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select live_type_id,live_type_name,list_order,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
		sql.append("from LIVE_TYPE ");
		sql.append("where 1=1");

		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getLiveTypeId())) {
					sql.append(" AND live_type_id=?");
					params.add(entity.getLiveTypeId());
				}
				if (StringUtils.isNotBlank(entity.getLiveTypeName())) {
					sql.append(" AND live_type_name like ?");
					params.add("%" + entity.getLiveTypeName() + "%");
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
					new BeanPropertyRowMapper<LiveTypeMVO>(LiveTypeMVO.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			logger.error("查询LiveType错误：{}", e.getMessage());
			throw new SysException("10000", "查询LiveType错误", e);
		}
		return pageInfo;
	}
}
