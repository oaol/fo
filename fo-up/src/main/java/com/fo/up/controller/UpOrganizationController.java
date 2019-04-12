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

import com.fo.up.entity.UpOrganization;
import com.fo.up.service.UpOrganizationService;

@RestController
@RequestMapping("/organization")
public class UpOrganizationController {
    @Autowired
    private UpOrganizationService upOrganizationService;

    @GetMapping("/{organizationId}")
    @RequiresPermissions("up:organization:find")
    public UpOrganization findByOrganizationId(@PathVariable(value = "organizationId", required = true) Long organizationId) {
        return upOrganizationService.findByOrganizationId(organizationId);
    }

    @PostMapping
    @RequiresPermissions("up:organization:add")
    public UpOrganization addOrganization(UpOrganization upOrganization) {
        return upOrganizationService.addOrganization(upOrganization);
    }

    @PutMapping
    @RequiresPermissions("up:organization:update")
    public void updateByOrganization(UpOrganization upOrganization) {
        upOrganizationService.updateByOrganization(upOrganization);
    }

    @DeleteMapping("/{organizationId}")
    @RequiresPermissions("up:organization:delete")
    public void deleteByOrganizationId(@PathVariable(value = "organizationId", required = true) Long organizationId) {
        upOrganizationService.deleteByOrganizationId(organizationId);
    }

    @GetMapping("/page")
    @RequiresPermissions("up:organization:page")
    public Page<UpOrganization> findOrganizationByPage(
            @RequestParam( value = "name", required = false) String name,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "12") Integer pageSize) {
        UpOrganization upOrganization = new UpOrganization();
        upOrganization.setName(name);
        return this.upOrganizationService.findOrganizationByPage(upOrganization, PageRequest.of(page - 1, pageSize));
    }

    @GetMapping("/user/{userId}")
    @RequiresPermissions("up:organization:find:user")
    public List<UpOrganization> findOrganizationByUserId(@PathVariable(required = true) Long userId) {
        return upOrganizationService.findOrganizationByUserId(userId);
    }

}
