package com.jianfuzengxiao.pub.entity;
import com.bamboo.framework.entity.Entity;
public class UserHousesInfo extends Entity {

    
    protected  String  uHId;
    
    protected  String  userid;
    
    protected  String  housesId;
    
    protected  String  createTime;
    
    protected  String  updateTime;
    
    protected  String  sts;

    public String getUHId() {
        return uHId;
    }
    public void setUHId(String  uHId) {
        this.uHId = uHId;
    }
    public String getUserid() {
        return userid;
    }
    public void setUserid(String  userid) {
        this.userid = userid;
    }
    public String getHousesId() {
        return housesId;
    }
    public void setHousesId(String  housesId) {
        this.housesId = housesId;
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
