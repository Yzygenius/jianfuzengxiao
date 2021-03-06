package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IGwhInfoMDAO;
import com.jianfuzengxiao.pub.entity.GwhInfoMVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;


@Repository
public class GwhInfoMDAO extends GwhInfoSDAO implements IGwhInfoMDAO {
    private static Logger logger = LoggerFactory.getLogger(GwhInfoMDAO.class);
    public PageInfo queryPage(GwhInfoMVO entity, PageInfo pageInfo) throws SysException {
        StringBuffer sql = new StringBuffer();
        sql.append("select gwh_id,gwh_name,list_order,prov_code,city_code,area_code,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
        sql.append("from GWH_INFO ");
        sql.append("where 1=1");

        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
            	if (StringUtils.isNotBlank(entity.getGwhId())) {
                sql.append(" AND gwh_id=?");
                params.add(entity.getGwhId());
            }
            	if (StringUtils.isNotBlank(entity.getGwhName())) {
                sql.append(" AND gwh_name like ?");
                params.add("%" + entity.getGwhName() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getListOrder())) {
                sql.append(" AND list_order=?");
                params.add(entity.getListOrder());
            }
            	if (StringUtils.isNotBlank(entity.getProvCode())) {
                sql.append(" AND prov_code like ?");
                params.add("%" + entity.getProvCode() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getCityCode())) {
                sql.append(" AND city_code like ?");
                params.add("%" + entity.getCityCode() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getAreaCode())) {
                sql.append(" AND area_code like ?");
                params.add("%" + entity.getAreaCode() + "%");
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
                    new BeanPropertyRowMapper<GwhInfoMVO>(GwhInfoMVO.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            logger.error("查询GwhInfo错误：{}", e.getMessage());
            throw new SysException("查询GwhInfo错误", "10000", e);
        }
        return pageInfo;
    }
}
