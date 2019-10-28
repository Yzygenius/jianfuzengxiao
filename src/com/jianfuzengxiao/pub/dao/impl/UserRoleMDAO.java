package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IUserRoleMDAO;
import com.jianfuzengxiao.pub.entity.UserRoleMVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

@Repository
public class UserRoleMDAO extends UserRoleSDAO implements IUserRoleMDAO {
	private static Logger logger = LoggerFactory.getLogger(UserRoleMDAO.class);

	public PageInfo queryPage(UserRoleMVO entity, PageInfo pageInfo) throws SysException {
		StringBuffer sql = new StringBuffer();
		sql.append("select user_role_id,user_id,role_id,sts,date_format(sts_time,'%Y-%m-%d %H:%i:%s')sts_time ");
		sql.append("from USER_ROLE ");
		sql.append("where 1=1");

		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getUserRoleId())) {
					sql.append(" AND user_role_id=?");
					params.add(entity.getUserRoleId());
				}
				if (StringUtils.isNotBlank(entity.getUserId())) {
					sql.append(" AND user_id=?");
					params.add(entity.getUserId());
				}
				if (StringUtils.isNotBlank(entity.getRoleId())) {
					sql.append(" AND role_id=?");
					params.add(entity.getRoleId());
				}
				if (StringUtils.isNotBlank(entity.getSts())) {
					sql.append(" AND sts like ?");
					params.add("%" + entity.getSts() + "%");
				}
				if (StringUtils.isNotBlank(entity.getStsTime())) {
					sql.append("  AND sts_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
					params.add(entity.getStsTime());
				}
			}
			pageInfo = this.pagingQuery(sql.toString(), pageInfo, params,
					new BeanPropertyRowMapper<UserRoleMVO>(UserRoleMVO.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			logger.error("查询UserRole错误：{}", e.getMessage());
			throw new SysException("查询UserRole错误", "10000", e);
		}
		return pageInfo;
	}
}
