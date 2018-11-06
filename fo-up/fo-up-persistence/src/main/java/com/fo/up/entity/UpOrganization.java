package com.fo.up.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class UpOrganization {
	@Id
	@GeneratedValue
	private int organizationId;//编号
	@Column(nullable = false)
	private int pid;//所属上级
	@Column(nullable = true)
	private String name;//组织名称
	@Column(nullable = true)
	private String description;//组织描述
	@Column(nullable = true)
	private long cTime;//创建时间'
	public int getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
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
	public long getcTime() {
		return cTime;
	}
	public void setcTime(long cTime) {
		this.cTime = cTime;
	}
	@Override
	public String toString() {
		return "UpOrganization [organizationId=" + organizationId + ", pid=" + pid + ", name=" + name + ", description="
				+ description + ", cTime=" + cTime + "]";
	}
    
	
}
