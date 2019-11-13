package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.ILzzgMDAO;
import com.jianfuzengxiao.pub.entity.LzzgMVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;


@Repository
public class LzzgMDAO extends LzzgSDAO implements ILzzgMDAO {
    private static Logger logger = LoggerFactory.getLogger(LzzgMDAO.class);
    public PageInfo queryPage(LzzgMVO entity, PageInfo pageInfo) throws SysException {
        StringBuffer sql = new StringBuffer();
        sql.append("select lzzg_id,admin_id,community_id,status,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
        sql.append("from LZZG ");
        sql.append("where 1=1");

        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
            	if (StringUtils.isNotBlank(entity.getLzzgId())) {
                sql.append(" AND lzzg_id=?");
                params.add(entity.getLzzgId());
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
            }
            pageInfo = this.pagingQuery(sql.toString(), pageInfo, params, 
                    new BeanPropertyRowMapper<LzzgMVO>(LzzgMVO.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            logger.error("查询Lzzg错误：{}", e.getMessage());
            throw new SysException("查询Lzzg错误", "10000", e);
        }
        return pageInfo;
    }
}
