package com.fo.up.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fo.up.entity.UpRole;
import com.fo.up.service.UpRoleService;

@RestController
@RequestMapping("role/")
public class UpRoleController {

    @Autowired
    private UpRoleService upRoleService;

    @GetMapping(value = "user/{userId}")
    public List<UpRole> findRoleByUserId(@PathVariable( value = "userId") Long userId) {
        return this.upRoleService.findRoleByUserId(userId);
    }

}
