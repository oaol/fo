package com.fo.up.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fo.up.entity.UpRole;
import com.fo.up.service.UpRoleService;

@RestController
@RequestMapping(value = "/role")
public class UpRoleController {

    @Autowired
    private UpRoleService upRoleService;

    @GetMapping(value = "/user/{userId}")
//    @RequiresPermissions("up:role:find")
    public List<UpRole> findRoleByUserId(@PathVariable(value = "userId", required = true) Long userId) {
        return this.upRoleService.findRoleByUserId(userId);
    }

    @GetMapping(value = "/{roleId}")
    @RequiresPermissions("up:role:find")
    public UpRole findRoleById(@PathVariable(value = "roleId", required = true) Long roleId) {
        return this.upRoleService.findRoleById(roleId);
    }

    @PostMapping
    @RequiresPermissions("up:role:add")
    public UpRole addRole(UpRole upRole) {
        return upRoleService.addRole(upRole);
    }

    @DeleteMapping("/{roleId}")
    @RequiresPermissions("up:role:delete")
    public void deleteByRoleId(@PathVariable(value = "roleId", required = true)Long roleId) {
        upRoleService.deleteByRoleId(roleId);
    }

    @PutMapping
    @RequiresPermissions("up:role:update")
    public void updateByUpRole(UpRole upRole) {
        upRoleService.updateByRoleId(upRole);
    }

    @GetMapping("/page")
    @RequiresPermissions("up:role:page")
    public Page<UpRole> findUpRoleByPage(@RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "12") Integer pageSize) {
        UpRole upRole = new UpRole();
        upRole.setName(name);
        Page<UpRole> findRoleByPage = this.upRoleService.findRoleByPage(upRole, PageRequest.of(page, pageSize));
        return findRoleByPage;
    }
}
