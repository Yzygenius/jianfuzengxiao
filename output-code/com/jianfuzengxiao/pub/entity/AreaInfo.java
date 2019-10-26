package com.jianfuzengxiao.pub.entity;
import com.bamboo.framework.entity.Entity;
public class AreaInfo extends Entity {

    
    protected  String  areaCode;
    
    protected  String  parentCode;
    
    protected  String  areaName;
    
    protected  String  areaLevel;

    public String getAreaCode() {
        return areaCode;
    }
    public void setAreaCode(String  areaCode) {
        this.areaCode = areaCode;
    }
    public String getParentCode() {
        return parentCode;
    }
    public void setParentCode(String  parentCode) {
        this.parentCode = parentCode;
    }
    public String getAreaName() {
        return areaName;
    }
    public void setAreaName(String  areaName) {
        this.areaName = areaName;
    }
    public String getAreaLevel() {
        return areaLevel;
    }
    public void setAreaLevel(String  areaLevel) {
        this.areaLevel = areaLevel;
    }
}
