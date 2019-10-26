package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IAreaInfoMDAO;
import com.jianfuzengxiao.pub.entity.AreaInfoMVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

@Repository
public class AreaInfoMDAO extends AreaInfoSDAO implements IAreaInfoMDAO {
	private static Logger logger = LoggerFactory.getLogger(AreaInfoMDAO.class);

	public PageInfo queryPage(AreaInfoMVO entity, PageInfo pageInfo) throws SysException {
		StringBuffer sql = new StringBuffer();
		sql.append("select area_code,parent_code,area_name,area_level ");
		sql.append("from AREA_INFO ");
		sql.append("where 1=1");

		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getAreaCode())) {
					sql.append(" AND area_code like ?");
					params.add("%" + entity.getAreaCode() + "%");
				}
				if (StringUtils.isNotBlank(entity.getParentCode())) {
					sql.append(" AND parent_code like ?");
					params.add("%" + entity.getParentCode() + "%");
				}
				if (StringUtils.isNotBlank(entity.getAreaName())) {
					sql.append(" AND area_name like ?");
					params.add("%" + entity.getAreaName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getAreaLevel())) {
					sql.append(" AND area_level=?");
					params.add(entity.getAreaLevel());
				}
			}
			pageInfo = this.pagingQuery(sql.toString(), pageInfo, params,
					new BeanPropertyRowMapper<AreaInfoMVO>(AreaInfoMVO.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			logger.error("查询AreaInfo错误：{}", e.getMessage());
			throw new SysException("10000", "查询AreaInfo错误", e);
		}
		return pageInfo;
	}
}
