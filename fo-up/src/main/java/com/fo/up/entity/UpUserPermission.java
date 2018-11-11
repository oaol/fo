package com.fo.up.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class UpUserPermission {
	@Id
	@GeneratedValue
	private Integer userPermissionId;//编号
	@Column(nullable = false)
	private Integer userId;//用户编号
	@Column(nullable = false)
	private Integer permissionId;//权限编号
	@Column(nullable = false)
	private Integer type;//权限类型(-1:减权限,1:增权限)
	public Integer getUserPermissionId() {
		return userPermissionId;
	}
	public void setUserPermissionId(Integer userPermissionId) {
		this.userPermissionId = userPermissionId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "UpUserPermission [userPermissionId=" + userPermissionId + ", userId=" + userId + ", permissionId="
				+ permissionId + ", type=" + type + "]";
	}
	
}
