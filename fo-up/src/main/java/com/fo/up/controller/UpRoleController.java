package com.fo.up.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value = "/user")
    public List<UpRole> findRoleByUserId(@RequestParam( value = "userId") Long userId) {
        return this.upRoleService.findRoleByUserId(userId);
    }

    @GetMapping
    public UpRole findRoleById(@RequestParam("roleId") Long roleId) {
        return this.upRoleService.findRoleById(roleId);
    }
    
    @PostMapping
    public UpRole addRole(UpRole upRole){
    	return upRoleService.addRole(upRole);
    }
    
    @DeleteMapping
    public void deleteByRoleId(Long roleId){
    	upRoleService.deleteByRoleId(roleId);
    }

    @PutMapping
    public void updateByUpRole(UpRole upRole){
    	upRoleService.updateByRoleId(upRole);
    }
}
