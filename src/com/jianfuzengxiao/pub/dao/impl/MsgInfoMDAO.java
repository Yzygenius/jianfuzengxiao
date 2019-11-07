package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IMsgInfoMDAO;
import com.jianfuzengxiao.pub.entity.MsgInfoMVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

@Repository
public class MsgInfoMDAO extends MsgInfoSDAO implements IMsgInfoMDAO {
	private static Logger logger = LoggerFactory.getLogger(MsgInfoMDAO.class);

	public PageInfo queryPage(MsgInfoMVO entity, PageInfo pageInfo) throws SysException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select msg_id,user_id,personnel_id,msg_type_id,msg_type_name,title,content,status,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
		sql.append("from MSG_INFO ");
		sql.append("where 1=1");

		List<Object> params = new ArrayList<Object>();
		try {
			if (entity != null) {
				if (StringUtils.isNotBlank(entity.getMsgId())) {
					sql.append(" AND msg_id=?");
					params.add(entity.getMsgId());
				}
				if (StringUtils.isNotBlank(entity.getPersonnelId())) {
					sql.append(" AND personnel_id=?");
					params.add(entity.getPersonnelId());
				}
				if (StringUtils.isNotBlank(entity.getUserId())) {
					sql.append(" AND user_id like ?");
					params.add("%" + entity.getUserId() + "%");
				}
				if (StringUtils.isNotBlank(entity.getMsgTypeId())) {
					sql.append(" AND msg_type_id=?");
					params.add(entity.getMsgTypeId());
				}
				if (StringUtils.isNotBlank(entity.getMsgTypeName())) {
					sql.append(" AND msg_type_name like ?");
					params.add("%" + entity.getMsgTypeName() + "%");
				}
				if (StringUtils.isNotBlank(entity.getTitle())) {
					sql.append(" AND title like ?");
					params.add("%" + entity.getTitle() + "%");
				}
				if (StringUtils.isNotBlank(entity.getContent())) {
					sql.append(" AND content like ?");
					params.add("%" + entity.getContent() + "%");
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
					new BeanPropertyRowMapper<MsgInfoMVO>(MsgInfoMVO.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			logger.error("查询MsgInfo错误：{}", e.getMessage());
			throw new SysException("查询MsgInfo错误", "10000", e);
		}
		return pageInfo;
	}

	@Override
	public int queryCountNotRead(MsgInfoMVO entity) throws SysException {
		String sql = "SELECT count(*)unread_count from msg_info where sts='A' and status=1 and user_id='" + entity.getUserId() + "'";
		logger.info(sql.toString());
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}
}
