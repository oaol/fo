package com.fo.up.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fo.up.entity.UpRolePermission;
import com.fo.up.repository.UpRolePermissionRepository;
import com.fo.up.service.UpRolePermissionService;

@Service
public class UpRolePermissionImpl implements UpRolePermissionService {

    @Autowired
    private UpRolePermissionRepository upRolePermissionRepository;

    @Override
    public Page<UpRolePermission> findRolePermissionByPage(UpRolePermission upRolePermission, Pageable pageable) {
        Example<UpRolePermission> example = Example.of(upRolePermission);
        Page<UpRolePermission> page = upRolePermissionRepository.findAll(example, pageable);
        return page;
    }

}
