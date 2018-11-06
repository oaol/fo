package com.fo.up.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class UpUserRole {
	@Id
	@GeneratedValue
	private int userRoleId;//编号
	@Column(nullable = false)
	private int userId;//用户编号
	@Column(nullable = true)
	private int roleId;//角色编号
	public int getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "UpUserRole [userRoleId=" + userRoleId + ", userId=" + userId + ", roleId=" + roleId + "]";
	}
	
	
}
