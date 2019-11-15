package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.ILgzgMDAO;
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
        sql.append("select lgzg_id,admin_id,community_id,status,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts,gwh_id,gwh_name ");
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
}
