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
public class UpRolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rolePermissionId;
    @Column(nullable = false)
    private Integer roleId;
    @Column(nullable = false)
    private Integer permissionId;

}