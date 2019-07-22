package com.fo.up.dto;

import lombok.Data;

@Data
public class UpRolePermissionDTO {

    private Integer roleId;
    private Integer permissionId;
    private String roleName;
    private String permissionName;

}
