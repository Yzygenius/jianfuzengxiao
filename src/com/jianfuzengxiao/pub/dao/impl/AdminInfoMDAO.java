package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IAdminInfoMDAO;
import com.jianfuzengxiao.pub.entity.AdminInfoMVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

@Repository
public class AdminInfoMDAO extends AdminInfoSDAO implements IAdminInfoMDAO {
	private static Logger logger = LoggerFactory.getLogger(AdminInfoMDAO.class);

	public PageInfo queryPage(AdminInfoMVO entity, PageInfo pageInfo) throws SysException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select a.admin_id,a.login_name,a.password,a.satl,a.username,a.gender,date_format(a.birth_date,'%Y-%m-%d %H:%i:%s')birth_date,a.nation_id,a.nation_name,a.telephone,a.role_id,a.role_name,a.is_wx,a.wx_name,a.wx_account_number,a.wx_openid,a.wx_photo,date_format(a.wx_time,'%Y-%m-%d %H:%i:%s')wx_time,a.wx_password,date_format(a.create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(a.update_time,'%Y-%m-%d %H:%i:%s')update_time,a.sts ");
		sql.append(",count(b.id)manage_houses_count ");
		sql.append(",count(c.lgzg_id)manage_community_count,c.gwh_id,c.gwh_name ");
		sql.append("from ADMIN_INFO a ");
		sql.append("left join aduit_distribution b on(a.admin_id=b.admin_id and b.sts='A') ");
		sql.append("left join lgzg c on(a.admin_id=c.admin_id and c.sts='A') ");
		sql.append("where 1=1");

		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getAdminId())) {
					sql.append(" AND a.admin_id=?");
					params.add(entity.getAdminId());
				}
				if (StringUtils.isNotBlank(entity.getLoginName())) {
					sql.append(" AND a.login_name like ?");
					params.add("%" + entity.getLoginName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getPassword())) {
					sql.append(" AND a.password like ?");
					params.add("%" + entity.getPassword() + "%");
				}
				if (StringUtils.isNotBlank(entity.getSatl())) {
					sql.append(" AND a.satl like ?");
					params.add("%" + entity.getSatl() + "%");
				}
				if (StringUtils.isNotBlank(entity.getUsername())) {
					sql.append(" AND a.username like ?");
					params.add("%" + entity.getUsername() + "%");
				}
				if (StringUtils.isNotBlank(entity.getGender())) {
					sql.append(" AND a.gender=?");
					params.add(entity.getGender());
				}
				if (StringUtils.isNotBlank(entity.getBirthDate())) {
					sql.append("  AND a.birth_date=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
					params.add(entity.getBirthDate());
				}
				if (StringUtils.isNotBlank(entity.getNationId())) {
					sql.append(" AND a.nation_id=?");
					params.add(entity.getNationId());
				}
				if (StringUtils.isNotBlank(entity.getNationName())) {
					sql.append(" AND a.nation_name like ?");
					params.add("%" + entity.getNationName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getTelephone())) {
					sql.append(" AND a.telephone like ?");
					params.add("%" + entity.getTelephone() + "%");
				}
				if (StringUtils.isNotBlank(entity.getRoleId())) {
					sql.append(" AND a.role_id=?");
					params.add(entity.getRoleId());
				}
				if (StringUtils.isNotBlank(entity.getRoleName())) {
					sql.append(" AND a.role_name like ?");
					params.add("%" + entity.getRoleName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getIsWx())) {
					sql.append(" AND a.is_wx=?");
					params.add(entity.getIsWx());
				}
				if (StringUtils.isNotBlank(entity.getWxName())) {
					sql.append(" AND a.wx_name like ?");
					params.add("%" + entity.getWxName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getWxAccountNumber())) {
					sql.append(" AND a.wx_account_number like ?");
					params.add("%" + entity.getWxAccountNumber() + "%");
				}
				if (StringUtils.isNotBlank(entity.getWxOpenid())) {
					sql.append(" AND a.wx_openid like ?");
					params.add("%" + entity.getWxOpenid() + "%");
				}
				if (StringUtils.isNotBlank(entity.getWxPhoto())) {
					sql.append(" AND a.wx_photo like ?");
					params.add("%" + entity.getWxPhoto() + "%");
				}
				if (StringUtils.isNotBlank(entity.getWxTime())) {
					sql.append("  AND a.wx_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
					params.add(entity.getWxTime());
				}
				if (StringUtils.isNotBlank(entity.getWxPassword())) {
					sql.append(" AND a.wx_password like ?");
					params.add("%" + entity.getWxPassword() + "%");
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
					sql.append(" AND (a.login_name like ? or a.username like ? or a.telephone like ?) ");
					params.add("%" + entity.getKeyword() + "%");
					params.add("%" + entity.getKeyword() + "%");
					params.add("%" + entity.getKeyword() + "%");
				}
			}
			sql.append(" group by a.admin_id ");
			pageInfo = this.pagingQuery(sql.toString(), pageInfo, params,
					new BeanPropertyRowMapper<AdminInfoMVO>(AdminInfoMVO.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			logger.error("查询AdminInfo错误：{}", e.getMessage());
			throw new SysException("查询AdminInfo错误", "10000", e);
		}
		return pageInfo;
	}
}
