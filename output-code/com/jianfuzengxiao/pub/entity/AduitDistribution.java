package com.jianfuzengxiao.pub.entity;
import com.bamboo.framework.entity.Entity;
public class AduitDistribution extends Entity {

    
    protected  String  id;
    
    protected  String  adminId;
    
    protected  String  housesId;
    
    protected  String  status;
    
    protected  String  createTime;
    
    protected  String  updateTime;
    
    protected  String  sts;

    public String getId() {
        return id;
    }
    public void setId(String  id) {
        this.id = id;
    }
    public String getAdminId() {
        return adminId;
    }
    public void setAdminId(String  adminId) {
        this.adminId = adminId;
    }
    public String getHousesId() {
        return housesId;
    }
    public void setHousesId(String  housesId) {
        this.housesId = housesId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String  status) {
        this.status = status;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String  createTime) {
        this.createTime = createTime;
    }
    public String getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(String  updateTime) {
        this.updateTime = updateTime;
    }
    public String getSts() {
        return sts;
    }
    public void setSts(String  sts) {
        this.sts = sts;
    }
}
