package com.jianfuzengxiao.pub.dao.impl;

import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IContractFileMDAO;
import com.jianfuzengxiao.pub.entity.ContractFileMVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;


@Repository
public class ContractFileMDAO extends ContractFileSDAO implements IContractFileMDAO {
    private static Logger logger = LoggerFactory.getLogger(ContractFileMDAO.class);
    public PageInfo queryPage(ContractFileMVO entity, PageInfo pageInfo) throws SysException {
        StringBuffer sql = new StringBuffer();
        sql.append("select file_id,personnel_id,houses_id,user_id,file_thumb,date_format(create_time,'%Y-%m-%d %H:%i:%s')create_time,date_format(update_time,'%Y-%m-%d %H:%i:%s')update_time,sts ");
        sql.append("from CONTRACT_FILE ");
        sql.append("where 1=1");

        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
            	if (StringUtils.isNotBlank(entity.getFileId())) {
                sql.append(" AND file_id=?");
                params.add(entity.getFileId());
            }
            	if (StringUtils.isNotBlank(entity.getPersonnelId())) {
                sql.append(" AND personnel_id=?");
                params.add(entity.getPersonnelId());
            }
            	if (StringUtils.isNotBlank(entity.getHousesId())) {
                sql.append(" AND houses_id=?");
                params.add(entity.getHousesId());
            }
            	if (StringUtils.isNotBlank(entity.getUserId())) {
                sql.append(" AND user_id like ?");
                params.add("%" + entity.getUserId() + "%");
            }
            	if (StringUtils.isNotBlank(entity.getFileThumb())) {
                sql.append(" AND file_thumb like ?");
                params.add("%" + entity.getFileThumb() + "%");
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
                    new BeanPropertyRowMapper<ContractFileMVO>(ContractFileMVO.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            logger.error("查询ContractFile错误：{}", e.getMessage());
            throw new SysException("查询ContractFile错误", "10000", e);
        }
        return pageInfo;
    }
}
