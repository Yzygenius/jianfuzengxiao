package com.jianfuzengxiao.pub.entity;
import com.bamboo.framework.entity.Entity;
public class ContractFile extends Entity {

    
    protected  String  fileId;
    
    protected  String  personnelId;
    
    protected  String  housesId;
    
    protected  String  userId;
    
    protected  String  fileThumb;
    
    protected  String  createTime;
    
    protected  String  updateTime;
    
    protected  String  sts;

    public String getFileId() {
        return fileId;
    }
    public void setFileId(String  fileId) {
        this.fileId = fileId;
    }
    public String getPersonnelId() {
        return personnelId;
    }
    public void setPersonnelId(String  personnelId) {
        this.personnelId = personnelId;
    }
    public String getHousesId() {
        return housesId;
    }
    public void setHousesId(String  housesId) {
        this.housesId = housesId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String  userId) {
        this.userId = userId;
    }
    public String getFileThumb() {
        return fileThumb;
    }
    public void setFileThumb(String  fileThumb) {
        this.fileThumb = fileThumb;
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
