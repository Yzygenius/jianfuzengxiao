package com.jianfuzengxiao.pub.entity;
import com.bamboo.framework.entity.Entity;
public class RoleFunc extends Entity {

    
    protected  String  roleFuncId;
    
    protected  String  roleId;
    
    protected  String  rightCode;
    
    protected  String  sts;
    
    protected  String  stsTime;

    public String getRoleFuncId() {
        return roleFuncId;
    }
    public void setRoleFuncId(String  roleFuncId) {
        this.roleFuncId = roleFuncId;
    }
    public String getRoleId() {
        return roleId;
    }
    public void setRoleId(String  roleId) {
        this.roleId = roleId;
    }
    public String getRightCode() {
        return rightCode;
    }
    public void setRightCode(String  rightCode) {
        this.rightCode = rightCode;
    }
    public String getSts() {
        return sts;
    }
    public void setSts(String  sts) {
        this.sts = sts;
    }
    public String getStsTime() {
        return stsTime;
    }
    public void setStsTime(String  stsTime) {
        this.stsTime = stsTime;
    }
}
