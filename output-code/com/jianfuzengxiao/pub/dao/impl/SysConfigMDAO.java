package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.ISysConfigMDAO;
import com.jianfuzengxiao.pub.entity.SysConfigMVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;


@Repository
public class SysConfigMDAO extends SysConfigSDAO implements ISysConfigMDAO {
    private static Logger logger = LoggerFactory.getLogger(SysConfigMDAO.class);
    public PageInfo queryPage(SysConfigMVO entity, PageInfo pageInfo) throws SysException {
        StringBuffer sql = new StringBuffer();
        sql.append("select config_id,config_name,config_value,type,remarks,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,editable ");
        sql.append("from SYS_CONFIG ");
        sql.append("where 1=1");

        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
            	if (StringUtils.isNotBlank(entity.getConfigId())) {
                sql.append(" AND config_id like ?");
                params.add("%" + entity.getConfigId() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getConfigName())) {
                sql.append(" AND config_name like ?");
                params.add("%" + entity.getConfigName() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getConfigValue())) {
                sql.append(" AND config_value like ?");
                params.add("%" + entity.getConfigValue() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getType())) {
                sql.append(" AND type=?");
                params.add(entity.getType());
            }
            	if (StringUtils.isNotBlank(entity.getRemarks())) {
                sql.append(" AND remarks like ?");
                params.add("%" + entity.getRemarks() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getUpdateTime())) {
                sql.append("  AND update_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
                params.add(entity.getUpdateTime());
            }
            	if (StringUtils.isNotBlank(entity.getEditable())) {
                sql.append(" AND editable=?");
                params.add(entity.getEditable());
            }
            }
            pageInfo = this.pagingQuery(sql.toString(), pageInfo, params, 
                    new BeanPropertyRowMapper<SysConfigMVO>(SysConfigMVO.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            logger.error("查询SysConfig错误：{}", e.getMessage());
            throw new SysException("10000", "查询SysConfig错误", e);
        }
        return pageInfo;
    }
}
