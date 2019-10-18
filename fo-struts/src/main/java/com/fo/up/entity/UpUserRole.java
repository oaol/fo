package com.fo.up.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UpUserRole {
    @Id
    @GeneratedValue
    private Long userRoleId;// 编号
    @Column(nullable = false)
    private Long userId;// 用户编号
    @Column(nullable = true)
    private Long roleId;// 角色编号

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}
