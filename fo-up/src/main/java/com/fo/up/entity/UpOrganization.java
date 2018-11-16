package com.fo.up.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UpOrganization {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long organizationId;//编号
	@Column(nullable = false)
	private Long pid;//所属上级
	
	@Column(nullable = true)
	private String name;//组织名称
	@Column(nullable = true)
	private String description;//组织描述
	@Column(nullable = true)
	private Long ctime;//创建时间'
	
	public Long getOrganizationId() {
        return organizationId;
    }
    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
    public Long getPid() {
        return pid;
    }
    public void setPid(Long pid) {
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
		return ctime;
	}
	public void setcTime(Long ctime) {
		this.ctime = ctime;
	}
	@Override
	public String toString() {
		return "UpOrganization [organizationId=" + organizationId + ", pid=" + pid + ", name=" + name + ", description="
				+ description + ", ctime=" + ctime + "]";
	}
    
	
}
