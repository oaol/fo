package com.fo.up.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UpRole {
	@Id
	@GeneratedValue
	private Integer roleId;//编号
	@Column(nullable = true)
	private String name;//角色名称
	@Column(nullable = true)
	private String title;//角色标题
	@Column(nullable = true)
	private String description;//角色描述
	@Column(nullable = false)
	private Long ctime;//创建时间
	@Column(nullable = false)
	private Long orders;//排序
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getCtime() {
		return ctime;
	}
	public void setCtime(Long ctime) {
		this.ctime = ctime;
	}
	public Long getOrders() {
		return orders;
	}
	public void setOrders(Long orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "UpRole [roleId=" + roleId + ", name=" + name + ", title=" + title + ", description=" + description
				+ ", ctime=" + ctime + ", orders=" + orders + "]";
	}
	


}
