package com.fo.up.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fo.up.core.constant.UpResult;
import com.fo.up.entity.UpPermission;
import com.fo.up.service.UpPermissionService;

@RestController
@RequestMapping("permission/")
public class UpPermissionController {
    
    @Autowired
    private UpPermissionService upPermissionService;

    @GetMapping( value = "user/{userId}")
    public UpResult<List<UpPermission>> findAllPermissionByUserId(@PathVariable("userId") Long userId) {
        UpResult<List<UpPermission>> upResult = new UpResult<List<UpPermission>>();
        List<UpPermission> findPermissionByUserId = this.upPermissionService.findPermissionByUserId(userId);
        upResult.setData(findPermissionByUserId);
        return upResult;
    }

    @GetMapping( value = "page")
    public UpResult<Page<UpPermission>> findPermissionByPage(
            @RequestParam(value = "name", required = false) String name, 
            @RequestParam( value = "permissionId", required = false) Long permissionId){
        UpPermission upPermission = new UpPermission();
        upPermission.setName(name);
        upPermission.setPermissionId(permissionId);
        UpResult<Page<UpPermission>> upResult = new UpResult<Page<UpPermission>>();
        Page<UpPermission> findPermissionByPage = this.upPermissionService.findPermissionByPage(upPermission, PageRequest.of(0, 2));
        upResult.setData(findPermissionByPage);
        return upResult;
    }
}
