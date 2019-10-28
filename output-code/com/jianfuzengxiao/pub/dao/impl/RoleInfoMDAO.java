package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IRoleInfoMDAO;
import com.jianfuzengxiao.pub.entity.RoleInfoMVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;


@Repository
public class RoleInfoMDAO extends RoleInfoSDAO implements IRoleInfoMDAO {
    private static Logger logger = LoggerFactory.getLogger(RoleInfoMDAO.class);
    public PageInfo queryPage(RoleInfoMVO entity, PageInfo pageInfo) throws SysException {
        StringBuffer sql = new StringBuffer();
        sql.append("select role_id,role_name,role_desc,sts,date_format(sts_time,'%Y-%m-%d %H:%i:%s')sts_time ");
        sql.append("from ROLE_INFO ");
        sql.append("where 1=1");

        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
            	if (StringUtils.isNotBlank(entity.getRoleId())) {
                sql.append(" AND role_id=?");
                params.add(entity.getRoleId());
            }
            	if (StringUtils.isNotBlank(entity.getRoleName())) {
                sql.append(" AND role_name like ?");
                params.add("%" + entity.getRoleName() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getRoleDesc())) {
                sql.append(" AND role_desc like ?");
                params.add("%" + entity.getRoleDesc() + "%");
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
                    new BeanPropertyRowMapper<RoleInfoMVO>(RoleInfoMVO.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            logger.error("查询RoleInfo错误：{}", e.getMessage());
            throw new SysException("查询RoleInfo错误", "10000", e);
        }
        return pageInfo;
    }
}
