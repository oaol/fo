package com.fo.up.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class UpUserPermission {
	@Id
	@GeneratedValue
	private Long userPermissionId;//编号
	@Column(nullable = false)
	private Long userId;//用户编号
	@Column(nullable = false)
	private Long permissionId;//权限编号
	@Column(nullable = false)
	private Integer type;//权限类型(-1:减权限,1:增权限)
    public Long getUserPermissionId() {
        return userPermissionId;
    }
    public void setUserPermissionId(Long userPermissionId) {
        this.userPermissionId = userPermissionId;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getPermissionId() {
        return permissionId;
    }
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
	
	
}
