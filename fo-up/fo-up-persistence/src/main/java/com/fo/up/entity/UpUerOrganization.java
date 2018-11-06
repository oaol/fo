package com.fo.up.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class UpUerOrganization {
	@Id
	@GeneratedValue
	private int userOrganizationId;//编号
	@Column(nullable = false)
	private int userId;//用户编号
	@Column(nullable = false)
	private int organizationId;//组织编号
	public int getUserOrganizationId() {
		return userOrganizationId;
	}
	public void setUserOrganizationId(int userOrganizationId) {
		this.userOrganizationId = userOrganizationId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	@Override
	public String toString() {
		return "UpUerOrganization [userOrganizationId=" + userOrganizationId + ", userId=" + userId
				+ ", organizationId=" + organizationId + "]";
	}
	
	
	
}
