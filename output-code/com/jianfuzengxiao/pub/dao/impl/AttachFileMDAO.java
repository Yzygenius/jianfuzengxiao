package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IAttachFileMDAO;
import com.jianfuzengxiao.pub.entity.AttachFileMVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;


@Repository
public class AttachFileMDAO extends AttachFileSDAO implements IAttachFileMDAO {
    private static Logger logger = LoggerFactory.getLogger(AttachFileMDAO.class);
    public PageInfo queryPage(AttachFileMVO entity, PageInfo pageInfo) throws SysException {
        StringBuffer sql = new StringBuffer();
        sql.append("select file_id,file_type,file_name,save_name,state,sts,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time ");
        sql.append("from ATTACH_FILE ");
        sql.append("where 1=1");

        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
            	if (StringUtils.isNotBlank(entity.getFileId())) {
                sql.append(" AND file_id like ?");
                params.add("%" + entity.getFileId() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getFileType())) {
                sql.append(" AND file_type like ?");
                params.add("%" + entity.getFileType() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getFileName())) {
                sql.append(" AND file_name like ?");
                params.add("%" + entity.getFileName() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getSaveName())) {
                sql.append(" AND save_name like ?");
                params.add("%" + entity.getSaveName() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getState())) {
                sql.append(" AND state like ?");
                params.add("%" + entity.getState() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getSts())) {
                sql.append(" AND sts like ?");
                params.add("%" + entity.getSts() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getCreateTime())) {
                sql.append("  AND create_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
                params.add(entity.getCreateTime());
            }
            	if (StringUtils.isNotBlank(entity.getUpdateTime())) {
                sql.append("  AND update_time=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
                params.add(entity.getUpdateTime());
            }
            }
            pageInfo = this.pagingQuery(sql.toString(), pageInfo, params, 
                    new BeanPropertyRowMapper<AttachFileMVO>(AttachFileMVO.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            logger.error("查询AttachFile错误：{}", e.getMessage());
            throw new SysException("查询AttachFile错误", "10000", e);
        }
        return pageInfo;
    }
}
