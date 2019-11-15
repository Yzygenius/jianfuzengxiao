package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.ICommunityStreetInfoMDAO;
import com.jianfuzengxiao.pub.entity.CommunityStreetInfoMVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;


@Repository
public class CommunityStreetInfoMDAO extends CommunityStreetInfoSDAO implements ICommunityStreetInfoMDAO {
    private static Logger logger = LoggerFactory.getLogger(CommunityStreetInfoMDAO.class);
    public PageInfo queryPage(CommunityStreetInfoMVO entity, PageInfo pageInfo) throws SysException {
        StringBuffer sql = new StringBuffer();
        sql.append("select community_street_id,community_street_name,status,community_id,list_order,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts,gwh_id,gwh_name ");
        sql.append("from COMMUNITY_STREET_INFO ");
        sql.append("where 1=1");

        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
            	if (StringUtils.isNotBlank(entity.getCommunityStreetId())) {
                sql.append(" AND community_street_id=?");
                params.add(entity.getCommunityStreetId());
            }
            	if (StringUtils.isNotBlank(entity.getCommunityStreetName())) {
                sql.append(" AND community_street_name like ?");
                params.add("%" + entity.getCommunityStreetName() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getStatus())) {
                sql.append(" AND status=?");
                params.add(entity.getStatus());
            }
            	if (StringUtils.isNotBlank(entity.getCommunityId())) {
                sql.append(" AND community_id=?");
                params.add(entity.getCommunityId());
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
                    new BeanPropertyRowMapper<CommunityStreetInfoMVO>(CommunityStreetInfoMVO.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            logger.error("查询CommunityStreetInfo错误：{}", e.getMessage());
            throw new SysException("查询CommunityStreetInfo错误", "10000", e);
        }
        return pageInfo;
    }
}
