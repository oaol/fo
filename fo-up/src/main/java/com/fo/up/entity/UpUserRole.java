package com.fo.up.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class UpUserRole {
	@Id
	@GeneratedValue
	private Integer userRoleId;//编号
	@Column(nullable = false)
	private Integer userId;//用户编号
	@Column(nullable = true)
	private Integer roleId;//角色编号
	public Integer getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "UpUserRole [userRoleId=" + userRoleId + ", userId=" + userId + ", roleId=" + roleId + "]";
	}
	
	
}
