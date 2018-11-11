package com.fo.up.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class UpUerOrganization {
	@Id
	@GeneratedValue
	private Integer userOrganizationId;//编号
	@Column(nullable = false)
	private Integer userId;//用户编号
	@Column(nullable = false)
	private Integer organizationId;//组织编号
	public Integer getUserOrganizationId() {
		return userOrganizationId;
	}
	public void setUserOrganizationId(Integer userOrganizationId) {
		this.userOrganizationId = userOrganizationId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
	@Override
	public String toString() {
		return "UpUerOrganization [userOrganizationId=" + userOrganizationId + ", userId=" + userId
				+ ", organizationId=" + organizationId + "]";
	}
	
	
	
}
