package com.jianfuzengxiao.pub.entity;
import com.bamboo.framework.entity.Entity;
public class SysConfig extends Entity {

    
    protected  String  configId;
    
    protected  String  configName;
    
    protected  String  configValue;
    
    protected  String  type;
    
    protected  String  remarks;
    
    protected  String  updateTime;
    
    protected  String  editable;

    public String getConfigId() {
        return configId;
    }
    public void setConfigId(String  configId) {
        this.configId = configId;
    }
    public String getConfigName() {
        return configName;
    }
    public void setConfigName(String  configName) {
        this.configName = configName;
    }
    public String getConfigValue() {
        return configValue;
    }
    public void setConfigValue(String  configValue) {
        this.configValue = configValue;
    }
    public String getType() {
        return type;
    }
    public void setType(String  type) {
        this.type = type;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String  remarks) {
        this.remarks = remarks;
    }
    public String getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(String  updateTime) {
        this.updateTime = updateTime;
    }
    public String getEditable() {
        return editable;
    }
    public void setEditable(String  editable) {
        this.editable = editable;
    }
}
