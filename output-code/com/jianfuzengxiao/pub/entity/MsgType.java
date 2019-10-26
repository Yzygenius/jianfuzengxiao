package com.jianfuzengxiao.pub.entity;
import com.bamboo.framework.entity.Entity;
public class MsgType extends Entity {

    
    protected  String  msgTypeId;
    
    protected  String  msgTypeName;
    
    protected  String  listOrder;
    
    protected  String  createTime;
    
    protected  String  updateTime;
    
    protected  String  sts;

    public String getMsgTypeId() {
        return msgTypeId;
    }
    public void setMsgTypeId(String  msgTypeId) {
        this.msgTypeId = msgTypeId;
    }
    public String getMsgTypeName() {
        return msgTypeName;
    }
    public void setMsgTypeName(String  msgTypeName) {
        this.msgTypeName = msgTypeName;
    }
    public String getListOrder() {
        return listOrder;
    }
    public void setListOrder(String  listOrder) {
        this.listOrder = listOrder;
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
