package com.jianfuzengxiao.pub.entity;
import com.bamboo.framework.entity.Entity;
public class Lgzg extends Entity {

    
    protected  String  lgzgId;
    
    protected  String  adminId;
    
    protected  String  communityId;
    
    protected  String  status;
    
    protected  String  createTime;
    
    protected  String  updateTime;
    
    protected  String  sts;

    public String getLgzgId() {
        return lgzgId;
    }
    public void setLgzgId(String  lgzgId) {
        this.lgzgId = lgzgId;
    }
    public String getAdminId() {
        return adminId;
    }
    public void setAdminId(String  adminId) {
        this.adminId = adminId;
    }
    public String getCommunityId() {
        return communityId;
    }
    public void setCommunityId(String  communityId) {
        this.communityId = communityId;
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