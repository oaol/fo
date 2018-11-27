package com.fo.up.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fo.up.core.constant.UpResult;
import com.fo.up.entity.UpPermission;
import com.fo.up.service.UpPermissionService;

@RestController
@RequestMapping("/permission")
public class UpPermissionController {
    
    @Autowired
    private UpPermissionService upPermissionService;

    @GetMapping( value = "/user/{userId}")
    public UpResult<List<UpPermission>> findAllPermissionByUserId(@PathVariable("userId") Long userId) {
        UpResult<List<UpPermission>> upResult = new UpResult<List<UpPermission>>();
        List<UpPermission> findPermissionByUserId = this.upPermissionService.findPermissionByUserId(userId);
        upResult.setResults(findPermissionByUserId);
        return upResult;
    }
    
    @GetMapping(value = "/{id}")
    public UpResult<UpPermission> findPermissionById(@PathVariable("id") Long upPermissionId){
        UpResult<UpPermission> upResult = new UpResult<>();
        UpPermission findByUpPermission = upPermissionService.findByUpPermission(upPermissionId);
        upResult.setResults(findByUpPermission);
    	return upResult;
    }
    
    @PostMapping
    public UpPermission addPermission(@RequestBody UpPermission upPermission){
    	return upPermissionService.addPermission(upPermission);
    }
    
    @PutMapping
    public void updateById(@RequestBody UpPermission upPermission){
    	upPermissionService.updatePermission(upPermission);
    }

    
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") Long upPermissionId){
    	upPermissionService.deletePermissionByPermissionId(upPermissionId);
    }
    

    @GetMapping( value = "/page")
    public UpResult<Page<UpPermission>> findPermissionByPage(
            @RequestParam(value = "search", required = false) String name, 
            @RequestParam( value = "permissionId", required = false) Long permissionId,
            @RequestParam( value = "page", required = false, defaultValue = "0") Integer page, 
            @RequestParam( value = "pageSize", required = false, defaultValue = "12")Integer pageSize){
        UpPermission upPermission = new UpPermission();
        boolean blank = StringUtils.isBlank(name);
        upPermission.setName(blank? null: name);
        upPermission.setPermissionId(permissionId);
        UpResult<Page<UpPermission>> upResult = new UpResult<Page<UpPermission>>();
        Page<UpPermission> findPermissionByPage = this.upPermissionService.findPermissionByPage(upPermission, PageRequest.of(page - 1, pageSize));
        upResult.setResults(findPermissionByPage);
        return upResult;
    }
}
