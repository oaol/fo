package com.fo.up.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@ToString
@EqualsAndHashCode
public class UpPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer permissionId;// 编号
    @Column(nullable = false)
    private Integer systemId;// 所属系统
    @Column(nullable = true)
    private Integer pid;// 所属上级
    @Column(nullable = true)
    private String name;// 名称
    @Column(nullable = true)
    private Integer type;// 类型(1:目录,2:菜单,3:按钮)'
    @Column(nullable = true)
    private String permissionValue;// 权限值
    @Column(nullable = true)
    private String uri;// 路径
    @Column(nullable = true)
    private String icon;// 图标
    @Column(nullable = true)
    private Integer status;// 状态(0:禁止,1:正常)
    @Column(nullable = true)
    private Long ctime;// 创建时间
    @Column(nullable = true)
    private Long orders;// 排序
}
