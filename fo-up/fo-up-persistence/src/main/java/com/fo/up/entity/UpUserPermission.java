package com.fo.up.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class UpUserPermission {
	@Id
	@GeneratedValue
	private int userPermissionId;//编号
	@Column(nullable = false)
	private int userId;//用户编号
	@Column(nullable = false)
	private int permissionId;//权限编号
	@Column(nullable = false)
	private int type;//权限类型(-1:减权限,1:增权限)
	public int getUserPermissionId() {
		return userPermissionId;
	}
	public void setUserPermissionId(int userPermissionId) {
		this.userPermissionId = userPermissionId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "UpUserPermission [userPermissionId=" + userPermissionId + ", userId=" + userId + ", permissionId="
				+ permissionId + ", type=" + type + "]";
	}
	
}
