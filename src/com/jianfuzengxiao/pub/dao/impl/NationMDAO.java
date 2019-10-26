package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.INationMDAO;
import com.jianfuzengxiao.pub.entity.NationMVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

@Repository
public class NationMDAO extends NationSDAO implements INationMDAO {
	private static Logger logger = LoggerFactory.getLogger(NationMDAO.class);

	public PageInfo queryPage(NationMVO entity, PageInfo pageInfo) throws SysException {
		StringBuffer sql = new StringBuffer();
		sql.append("select nation_id,nation_name ");
		sql.append("from NATION ");
		sql.append("where 1=1");

		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getNationId())) {
					sql.append(" AND nation_id=?");
					params.add(entity.getNationId());
				}
				if (StringUtils.isNotBlank(entity.getNationName())) {
					sql.append(" AND nation_name like ?");
					params.add("%" + entity.getNationName() + "%");
				}
			}
			pageInfo = this.pagingQuery(sql.toString(), pageInfo, params,
					new BeanPropertyRowMapper<NationMVO>(NationMVO.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			logger.error("查询Nation错误：{}", e.getMessage());
			throw new SysException("10000", "查询Nation错误", e);
		}
		return pageInfo;
	}
}
