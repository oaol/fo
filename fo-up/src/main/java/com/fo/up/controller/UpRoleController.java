package com.fo.up.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fo.up.entity.UpRole;
import com.fo.up.service.UpRoleService;

@RestController
@RequestMapping(value = "/role")
public class UpRoleController {

    @Autowired
    private UpRoleService upRoleService;

    @GetMapping(value = "/user")
    public List<UpRole> findRoleByUserId(@Param( value = "userId") Long userId) {
        return this.upRoleService.findRoleByUserId(userId);
    }

}
