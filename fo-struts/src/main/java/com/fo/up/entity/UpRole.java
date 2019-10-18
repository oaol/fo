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
public class UpRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;// 编号
    @Column(nullable = true)
    private String name;// 角色名称
    @Column(nullable = true)
    private String title;// 角色标题
    @Column(nullable = true)
    private String description;// 角色描述
    @Column(nullable = false)
    private Long ctime;// 创建时间
    @Column(nullable = false)
    private Long orders;// 排序
}
