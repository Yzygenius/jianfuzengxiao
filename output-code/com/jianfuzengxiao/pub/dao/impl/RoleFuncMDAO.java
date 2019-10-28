package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IRoleFuncMDAO;
import com.jianfuzengxiao.pub.entity.RoleFuncMVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;


@Repository
public class RoleFuncMDAO extends RoleFuncSDAO implements IRoleFuncMDAO {
    private static Logger logger = LoggerFactory.getLogger(RoleFuncMDAO.class);
    public PageInfo queryPage(RoleFuncMVO entity, PageInfo pageInfo) throws SysException {
        StringBuffer sql = new StringBuffer();
        sql.append("select role_func_id,role_id,right_code,sts,date_format(sts_time,'%Y-%m-%d %H:%i:%s')sts_time ");
        sql.append("from ROLE_FUNC ");
        sql.append("where 1=1");

        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
            	if (StringUtils.isNotBlank(entity.getRoleFuncId())) {
                sql.append(" AND role_func_id=?");
                params.add(entity.getRoleFuncId());
            }
            	if (StringUtils.isNotBlank(entity.getRoleId())) {
                sql.append(" AND role_id=?");
                params.add(entity.getRoleId());
            }
            	if (StringUtils.isNotBlank(entity.getRightCode())) {
                sql.append(" AND right_code like ?");
                params.add("%" + entity.getRightCode() + "%");
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
                    new BeanPropertyRowMapper<RoleFuncMVO>(RoleFuncMVO.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            logger.error("查询RoleFunc错误：{}", e.getMessage());
            throw new SysException("查询RoleFunc错误", "10000", e);
        }
        return pageInfo;
    }
}
