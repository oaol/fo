package com.fo.up.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fo.common.core.exception.UpException;
import com.fo.up.entity.UpPermission;
import com.fo.up.entity.UpUser;
import com.fo.up.repository.UpPermissionRepository;
import com.fo.up.repository.UpUserRepository;
import com.fo.up.service.UpPermissionService;

@Service
public class UpPermissionServiceImpl implements UpPermissionService{

    @Autowired
    private UpPermissionRepository upPermissionRepository;

    @Autowired
    private UpUserRepository upUserRepository;

    @Override
    public List<UpPermission> findPermissionByUserId(Long userId) {
        UpUser upUser = upUserRepository.findById(userId).get();
        if (null == upUser || upUser.getLocked() == 1) {
            throw new UpException(String.format("不存在的用户 userId: %s", userId)) ;
        }
        return this.upPermissionRepository.findPermissionByUserId(userId);
    }

    @Override
    public void createPermission(UpPermission upPermission) {
        this.upPermissionRepository.save(upPermission);
    }

    @Override
    public void alterPermission(UpPermission upPermission) {
    }

    @Override
    public void deletePermissionByPermissionId(Long permissionId) {
        this.upPermissionRepository.deleteById(permissionId);
    }

    @Override
    public Page<UpPermission> findPermissionByPage(UpPermission upPermission, Pageable pageable) {
        Example<UpPermission> example = Example.of(upPermission);
        return this.upPermissionRepository.findAll(example, pageable);
    }

}
