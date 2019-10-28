package com.jianfuzengxiao.pub.dao.impl;
import com.bamboo.framework.base.impl.BaseDAO;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.pub.dao.IFuncListSDAO;
import com.jianfuzengxiao.pub.entity.FuncListMVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.lang.StringUtils;
import java.util.List;
import java.util.ArrayList;
public class FuncListSDAO extends BaseDAO<FuncListMVO> implements IFuncListSDAO {
private static Logger logger = LoggerFactory.getLogger(FuncListSDAO.class);

@Override
    public FuncListMVO insert(final FuncListMVO entity) throws SysException { 
        final StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO FUNC_LIST (func_id,parent_id,menu_title,menu_desc,menu_icon,menu_url,menu_level,list_order,right_code,remark,sts) ");
        sql.append("VALUES (?,?,?,?,?,?,?,?,?,?,?)");
        try {
            logger.info(sql.toString());
            jdbcTemplate.update(
                new PreparedStatementCreator(){
                public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException{
                	int i = 0;
                	java.sql.PreparedStatement ps = conn.prepareStatement(sql.toString()); 
                	ps.setString(++i, StringUtils.trimToNull(entity.getFuncId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getParentId()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getMenuTitle()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getMenuDesc()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getMenuIcon()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getMenuUrl()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getMenuLevel()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getListOrder()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getRightCode()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getRemark()));
                	ps.setString(++i, StringUtils.trimToNull(entity.getSts()));
                	return ps;
              }
            });
          } catch (DataAccessException e) {
          	logger.error("增加FUNC_LIST 错误：{}", e.getMessage());
          	throw new SysException("增加FUNC_LIST错误", "10000", e);
          }
          return entity;
       }
    @Override
    public int update(FuncListMVO entity) throws SysException {
        int rowsAffected;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE  FUNC_LIST  SET ");
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity.getParentId() != null) {
                sql.append("parent_id=?,");
                params.add(entity.getParentId());
            }
            if (entity.getMenuTitle() != null) {
                sql.append("menu_title=?,");
                params.add(entity.getMenuTitle());
            }
            if (entity.getMenuDesc() != null) {
                sql.append("menu_desc=?,");
                params.add(entity.getMenuDesc());
            }
            if (entity.getMenuIcon() != null) {
                sql.append("menu_icon=?,");
                params.add(entity.getMenuIcon());
            }
            if (entity.getMenuUrl() != null) {
                sql.append("menu_url=?,");
                params.add(entity.getMenuUrl());
            }
            if (entity.getMenuLevel() != null) {
                sql.append("menu_level=?,");
                params.add(entity.getMenuLevel());
            }
            if (entity.getListOrder() != null) {
                sql.append("list_order=?,");
                params.add(entity.getListOrder());
            }
            if (entity.getRightCode() != null) {
                sql.append("right_code=?,");
                params.add(entity.getRightCode());
            }
            if (entity.getRemark() != null) {
                sql.append("remark=?,");
                params.add(entity.getRemark());
            }
            if (entity.getSts() != null) {
                sql.append("sts=?,");
                params.add(entity.getSts());
            }
            sql.deleteCharAt(sql.length() - 1);
            sql.append(" WHERE func_id=?");
            params.add(entity.getFuncId());
            logger.info(sql.toString() + "--" + params.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());
         } catch (DataAccessException e) {
            logger.error("更新FUNC_LIST错误：{}", e.getMessage());
            throw new SysException("更新FUNC_LIST错误", "10000", e);
         }
        return rowsAffected;
    }
    @Override
    public int delete(FuncListMVO entity) throws SysException {
    	   int rowsAffected;
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM FUNC_LIST WHERE func_id=?");
        try {
        	   logger.info(sql.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(),
                           entity.getFuncId());
        } catch (DataAccessException e) {
            logger.error("删除FUNC_LIST错误：{}", e.getMessage());
            throw new SysException("删除FUNC_LIST错误", "10000", e);
        }
        return rowsAffected;
    }
    @Override
    public List<FuncListMVO> queryList(FuncListMVO entity) throws SysException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT func_id,parent_id,menu_title,menu_desc,menu_icon,menu_url,menu_level,list_order,right_code,remark,sts ");
        sql.append("FROM  FUNC_LIST ");
        sql.append("WHERE 1=1 ");
        List<FuncListMVO> resultList = null;
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
            	if (StringUtils.isNotBlank(entity.getFuncId())) {
                sql.append(" AND func_id=?");
                params.add(entity.getFuncId());
            }
            	if (StringUtils.isNotBlank(entity.getParentId())) {
                sql.append(" AND parent_id=?");
                params.add(entity.getParentId());
            }
            	if (StringUtils.isNotBlank(entity.getMenuTitle())) {
                sql.append(" AND menu_title=?");
                params.add(entity.getMenuTitle());
            }
            	if (StringUtils.isNotBlank(entity.getMenuDesc())) {
                sql.append(" AND menu_desc=?");
                params.add(entity.getMenuDesc());
            }
            	if (StringUtils.isNotBlank(entity.getMenuIcon())) {
                sql.append(" AND menu_icon=?");
                params.add(entity.getMenuIcon());
            }
            	if (StringUtils.isNotBlank(entity.getMenuUrl())) {
                sql.append(" AND menu_url=?");
                params.add(entity.getMenuUrl());
            }
            	if (StringUtils.isNotBlank(entity.getMenuLevel())) {
                sql.append(" AND menu_level=?");
                params.add(entity.getMenuLevel());
            }
            	if (StringUtils.isNotBlank(entity.getListOrder())) {
                sql.append(" AND list_order=?");
                params.add(entity.getListOrder());
            }
            	if (StringUtils.isNotBlank(entity.getRightCode())) {
                sql.append(" AND right_code=?");
                params.add(entity.getRightCode());
            }
            	if (StringUtils.isNotBlank(entity.getRemark())) {
                sql.append(" AND remark=?");
                params.add(entity.getRemark());
            }
            	if (StringUtils.isNotBlank(entity.getSts())) {
                sql.append(" AND sts=?");
                params.add(entity.getSts());
            }
        	   }
			logger.info(sql.toString() + "--" + params.toString());
			resultList = jdbcTemplate.query(sql.toString(),
			params.toArray(),
			new BeanPropertyRowMapper<FuncListMVO>(FuncListMVO.class));
        } catch (DataAccessException e) {
            logger.error("查询FUNC_LIST错误：{}", e.getMessage());
            throw new SysException("查询FUNC_LIST错误", "10000", e);
        }
        return resultList;
    }
    @Override
    public FuncListMVO queryBean(FuncListMVO entity) throws SysException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT func_id,parent_id,menu_title,menu_desc,menu_icon,menu_url,menu_level,list_order,right_code,remark,sts ");
        sql.append("FROM  FUNC_LIST ");
        sql.append("WHERE func_id=? ");
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
        	   		params.add(entity.getFuncId());
        	   } else {
        	   		sql.append(" AND 1=2");
        	   }
			logger.info(sql.toString() + "--" + params.toString());
			 entity = jdbcTemplate.queryForObject(sql.toString(),
			params.toArray(),
			new BeanPropertyRowMapper<FuncListMVO>(FuncListMVO.class));
        } catch (DataAccessException e) {
            logger.error("查询FUNC_LIST错误：{}", e.getMessage());
            throw new SysException("查询FUNC_LIST错误", "10000", e);
        }
        return entity;
    }


}
