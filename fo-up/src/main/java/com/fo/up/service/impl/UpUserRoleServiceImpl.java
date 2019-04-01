package com.fo.up.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.fo.up.entity.UpUserRole;
import com.fo.up.repository.UpUserRoleRepository;
import com.fo.up.service.UpUserRoleService;

@Service
public class UpUserRoleServiceImpl implements UpUserRoleService {

    @Autowired
    private UpUserRoleRepository upUserRoleRepository;

    @Override
    @Cacheable(value = "aaa", key = "#userId", condition = "#userId>0")
    public void addUserRole(Long userId, Long roleId) {
        UpUserRole upUserRole = new UpUserRole();
        upUserRole.setUserId(userId);
        upUserRole.setRoleId(roleId);
        this.upUserRoleRepository.save(upUserRole);
    }

}
