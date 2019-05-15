package com.fo.up.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fo.up.entity.UpPermission;
import com.fo.up.service.UpPermissionService;

@RestController
@RequestMapping("/permission")
public class UpPermissionController {
    
    @Autowired
    private UpPermissionService upPermissionService;

    @GetMapping( value = "/user/{userId}")
    @RequiresPermissions("up:permission:list:user")
    public List<UpPermission> findAllPermissionByUserId(@PathVariable(value = "userId", required = true) Long userId) {
        List<UpPermission> findPermissionByUserId = this.upPermissionService.findPermissionByUserId(userId);
        return findPermissionByUserId;
    }

    @GetMapping(value = "/{permissionId}")
    @RequiresPermissions("up:permission:find")
    public UpPermission findPermissionById(@PathVariable(value = "permissionId", required = true) Long permissionId) {
        UpPermission findByUpPermission = upPermissionService.findByUpPermission(permissionId);
    	return findByUpPermission;
    }

    @PostMapping
    @RequiresPermissions("up:permission:add")
    public UpPermission addPermission(@RequestBody UpPermission upPermission){
    	return upPermissionService.addPermission(upPermission);
    }
    
    @PutMapping
    @RequiresPermissions("up:permission:update")
    public void updateById(@RequestBody UpPermission upPermission){
    	upPermissionService.updatePermission(upPermission);
    }

    @DeleteMapping(value = "/{permissionId}")
    @RequiresPermissions("up:permission:delete")
    public void deleteById(@PathVariable(value = "permissionId", required = true) Long permissionId){
    	upPermissionService.deletePermissionByPermissionId(permissionId);
    }

    @GetMapping( value = "/page")
    @RequiresPermissions("up:permission:page")
    public Page<UpPermission> findPermissionByPage(
            @RequestParam(value = "search", required = false) String name, 
            @RequestParam( value = "permissionId", required = false) Integer permissionId,
            @RequestParam( value = "page", required = false, defaultValue = "1") Integer page, 
            @RequestParam( value = "pageSize", required = false, defaultValue = "12")Integer pageSize){
        UpPermission upPermission = new UpPermission();
        boolean blank = StringUtils.isBlank(name);
        upPermission.setName(blank? null: name);
        upPermission.setPermissionId(permissionId);
        Sort sort = new Sort(Direction.DESC, "orders");
        Page<UpPermission> findPermissionByPage = this.upPermissionService.findPermissionByPage(upPermission,
                PageRequest.of(page - 1, pageSize, sort));
        return findPermissionByPage;
    }

    @GetMapping(value = "name")
    public List<UpPermission> findPermissionByName(@RequestParam( value = "name", required = true)String name) {
        return this.upPermissionService.findPermissionByName(name);
    }
}
