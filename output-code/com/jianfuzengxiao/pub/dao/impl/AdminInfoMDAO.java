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
        sql.append("select admin_id,login_name,password,satl,username,gender,date_format(birth_date,'%Y-%m-%d %H:%i:%s')birth_date,nation_id,nation_name,telephone,role_id,role_name,is_wx,wx_openid,wx_photo,date_format(wx_time,'%Y-%m-%d %H:%i:%s')wx_time,wx_password,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
        sql.append("from ADMIN_INFO ");
        sql.append("where 1=1");

        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
            	if (StringUtils.isNotBlank(entity.getAdminId())) {
                sql.append(" AND admin_id=?");
                params.add(entity.getAdminId());
            }
            	if (StringUtils.isNotBlank(entity.getLoginName())) {
                sql.append(" AND login_name like ?");
                params.add("%" + entity.getLoginName() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getPassword())) {
                sql.append(" AND password like ?");
                params.add("%" + entity.getPassword() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getSatl())) {
                sql.append(" AND satl like ?");
                params.add("%" + entity.getSatl() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getUsername())) {
                sql.append(" AND username like ?");
                params.add("%" + entity.getUsername() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getGender())) {
                sql.append(" AND gender=?");
                params.add(entity.getGender());
            }
            	if (StringUtils.isNotBlank(entity.getBirthDate())) {
                sql.append("  AND birth_date=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
                params.add(entity.getBirthDate());
            }
            	if (StringUtils.isNotBlank(entity.getNationId())) {
                sql.append(" AND nation_id=?");
                params.add(entity.getNationId());
            }
            	if (StringUtils.isNotBlank(entity.getNationName())) {
                sql.append(" AND nation_name like ?");
                params.add("%" + entity.getNationName() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getTelephone())) {
                sql.append(" AND telephone like ?");
                params.add("%" + entity.getTelephone() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getRoleId())) {
                sql.append(" AND role_id=?");
                params.add(entity.getRoleId());
            }
            	if (StringUtils.isNotBlank(entity.getRoleName())) {
                sql.append(" AND role_name like ?");
                params.add("%" + entity.getRoleName() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getIsWx())) {
                sql.append(" AND is_wx=?");
                params.add(entity.getIsWx());
            }
            	if (StringUtils.isNotBlank(entity.getWxOpenid())) {
                sql.append(" AND wx_openid like ?");
                params.add("%" + entity.getWxOpenid() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getWxPhoto())) {
                sql.append(" AND wx_photo like ?");
                params.add("%" + entity.getWxPhoto() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getWxTime())) {
                sql.append("  AND wx_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
                params.add(entity.getWxTime());
            }
            	if (StringUtils.isNotBlank(entity.getWxPassword())) {
                sql.append(" AND wx_password like ?");
                params.add("%" + entity.getWxPassword() + "%");
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
                    new BeanPropertyRowMapper<AdminInfoMVO>(AdminInfoMVO.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            logger.error("查询AdminInfo错误：{}", e.getMessage());
            throw new SysException("10000", "查询AdminInfo错误", e);
        }
        return pageInfo;
    }
}
