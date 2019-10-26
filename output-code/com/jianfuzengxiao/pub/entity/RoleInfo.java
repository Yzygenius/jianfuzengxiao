package com.jianfuzengxiao.pub.entity;
import com.bamboo.framework.entity.Entity;
public class RoleInfo extends Entity {

    
    protected  String  roleId;
    
    protected  String  roleName;
    
    protected  String  roleDesc;
    
    protected  String  sts;
    
    protected  String  stsTime;

    public String getRoleId() {
        return roleId;
    }
    public void setRoleId(String  roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String  roleName) {
        this.roleName = roleName;
    }
    public String getRoleDesc() {
        return roleDesc;
    }
    public void setRoleDesc(String  roleDesc) {
        this.roleDesc = roleDesc;
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
