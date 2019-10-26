package com.jianfuzengxiao.pub.entity;
import com.bamboo.framework.entity.Entity;
public class Nation extends Entity {

    
    protected  String  nationId;
    
    protected  String  nationName;

    public String getNationId() {
        return nationId;
    }
    public void setNationId(String  nationId) {
        this.nationId = nationId;
    }
    public String getNationName() {
        return nationName;
    }
    public void setNationName(String  nationName) {
        this.nationName = nationName;
    }
}
