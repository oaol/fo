package com.fo.up.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class UpOrganization {
	@Id
	@GeneratedValue
	private Integer organizationId;//编号
	@Column(nullable = false)
	private Integer pid;//所属上级
	
	@Column(nullable = true)
	private String name;//组织名称
	@Column(nullable = true)
	private String description;//组织描述
	@Column(nullable = true)
	private Long cTime;//创建时间'
	public Integer getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getcTime() {
		return cTime;
	}
	public void setcTime(Long cTime) {
		this.cTime = cTime;
	}
	@Override
	public String toString() {
		return "UpOrganization [organizationId=" + organizationId + ", pid=" + pid + ", name=" + name + ", description="
				+ description + ", cTime=" + cTime + "]";
	}
    
	
}
