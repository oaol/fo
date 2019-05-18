package com.fo.up.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fo.up.entity.UpRolePermission;
import com.fo.up.service.UpRolePermissionService;

@RestController
@RequestMapping(value = "/role/permission")
public class UpRolePermissionController {

    @Autowired
    private UpRolePermissionService upRolePermissionService;

    @GetMapping("/page")
    @RequiresPermissions("up:role:permission:page")
    public Page<UpRolePermission> findUpRoleByPage(@RequestParam(value = "roleId", required = false) Integer roleId,
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "12") Integer pageSize) {
        UpRolePermission upRolePermission = new UpRolePermission();
        upRolePermission.setRoleId(roleId);
        Page<UpRolePermission> findRolePermissionByPage = this.upRolePermissionService
                .findRolePermissionByPage(upRolePermission, PageRequest.of(page - 1, pageSize));
        return findRolePermissionByPage;
    }

}
