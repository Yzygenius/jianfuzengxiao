package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IFuncListMDAO;
import com.jianfuzengxiao.pub.entity.FuncListMVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

@Repository
public class FuncListMDAO extends FuncListSDAO implements IFuncListMDAO {
	private static Logger logger = LoggerFactory.getLogger(FuncListMDAO.class);

	public PageInfo queryPage(FuncListMVO entity, PageInfo pageInfo) throws SysException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select func_id,parent_id,menu_title,menu_desc,menu_icon,menu_url,menu_level,list_order,right_code,remark,sts ");
		sql.append("from FUNC_LIST ");
		sql.append("where 1=1");

		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getFuncId())) {
					sql.append(" AND func_id=?");
					params.add(entity.getFuncId());
				}
				if (StringUtils.isNotBlank(entity.getParentId())) {
					sql.append(" AND parent_id=?");
					params.add(entity.getParentId());
				}
				if (StringUtils.isNotBlank(entity.getMenuTitle())) {
					sql.append(" AND menu_title like ?");
					params.add("%" + entity.getMenuTitle() + "%");
				}
				if (StringUtils.isNotBlank(entity.getMenuDesc())) {
					sql.append(" AND menu_desc like ?");
					params.add("%" + entity.getMenuDesc() + "%");
				}
				if (StringUtils.isNotBlank(entity.getMenuIcon())) {
					sql.append(" AND menu_icon like ?");
					params.add("%" + entity.getMenuIcon() + "%");
				}
				if (StringUtils.isNotBlank(entity.getMenuUrl())) {
					sql.append(" AND menu_url like ?");
					params.add("%" + entity.getMenuUrl() + "%");
				}
				if (StringUtils.isNotBlank(entity.getMenuLevel())) {
					sql.append(" AND menu_level=?");
					params.add(entity.getMenuLevel());
				}
				if (StringUtils.isNotBlank(entity.getListOrder())) {
					sql.append(" AND list_order=?");
					params.add(entity.getListOrder());
				}
				if (StringUtils.isNotBlank(entity.getRightCode())) {
					sql.append(" AND right_code like ?");
					params.add("%" + entity.getRightCode() + "%");
				}
				if (StringUtils.isNotBlank(entity.getRemark())) {
					sql.append(" AND remark like ?");
					params.add("%" + entity.getRemark() + "%");
				}
				if (StringUtils.isNotBlank(entity.getSts())) {
					sql.append(" AND sts like ?");
					params.add("%" + entity.getSts() + "%");
				}
			}
			pageInfo = this.pagingQuery(sql.toString(), pageInfo, params,
					new BeanPropertyRowMapper<FuncListMVO>(FuncListMVO.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			logger.error("查询FuncList错误：{}", e.getMessage());
			throw new SysException("10000", "查询FuncList错误", e);
		}
		return pageInfo;
	}
}
