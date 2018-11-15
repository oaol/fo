package com.fo.up.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UpPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionId;// 编号
    @Column(nullable = false)
    private Integer systemId;// 所属系统
    @Column(nullable = true)
    private Long pid;// 所属上级
    @Column(nullable = true)
    private String name;// 名称
    @Column(nullable = true)
    private String type;// 类型(1:目录,2:菜单,3:按钮)'
    @Column(nullable = true)
    private String permissionValue;// 权限值
    @Column(nullable = true)
    private String uri;// 路径
    @Column(nullable = true)
    private String icon;// 图标
    @Column(nullable = true)
    private String status;// 状态(0:禁止,1:正常)
    @Column(nullable = true)
    private String ctime;// 创建时间
    @Column(nullable = true)
    private String orders;// 排序
    public Long getPermissionId() {
        return permissionId;
    }
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
    public Integer getSystemId() {
        return systemId;
    }
    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
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
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getPermissionValue() {
        return permissionValue;
    }
    public void setPermissionValue(String permissionValue) {
        this.permissionValue = permissionValue;
    }
    public String getUri() {
        return uri;
    }
    public void setUri(String uri) {
        this.uri = uri;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getCtime() {
        return ctime;
    }
    public void setCtime(String ctime) {
        this.ctime = ctime;
    }
    public String getOrders() {
        return orders;
    }
    public void setOrders(String orders) {
        this.orders = orders;
    }
}
