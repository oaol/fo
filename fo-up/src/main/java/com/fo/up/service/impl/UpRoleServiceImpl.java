package com.fo.up.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fo.common.core.exception.FoException;
import com.fo.up.entity.UpRole;
import com.fo.up.entity.UpRolePermission;
import com.fo.up.entity.UpUser;
import com.fo.up.repository.UpRolePermissionRepository;
import com.fo.up.repository.UpRoleRepository;
import com.fo.up.repository.UpUserRepository;
import com.fo.up.service.UpRoleService;

@Service
public class UpRoleServiceImpl implements UpRoleService {

    @Autowired
    private UpRoleRepository upRoleRepository;

    @Autowired
    private UpUserRepository upUserRepository;

    @Autowired
    private UpRolePermissionRepository upRolePermissionReporsitory;

    @Override
    public List<UpRole> findRoleByUserId(Long userId) {
        UpUser upUser = this.upUserRepository.findById(userId).get();
        if (null == upUser || upUser.getLocked() == 1) {
            throw new FoException(String.format("不存在的用户 userId: %s", userId));
        }
        List<UpRole> findRoleByUserId = this.upRoleRepository.findRoleByUserId(userId);
        return findRoleByUserId;
    }

    @Override
    public UpRole findRoleById(Long roleId) {
        UpRole upRole = this.upRoleRepository.findById(roleId).get();
        return upRole;
    }

    @Override
    public UpRole addRole(UpRole upRole) {
        return upRoleRepository.save(upRole);
    }

    @Override
    public void deleteByRoleId(Long roleId) {
        if (roleId == null) {
            throw new FoException("roleId不能为空");
        }
        upRoleRepository.deleteById(roleId);
    }

    @Override
    public void updateByRoleId(UpRole upRole) {
        upRoleRepository.updateUpRole(upRole);
    }

    @Override
    public Page<UpRole> findRoleByPage(UpRole upRole, Pageable pageable) {
        Example<UpRole> example = Example.of(upRole);
        return this.upRoleRepository.findAll(example, pageable);
    }

    @Override
    public UpRolePermission saveRolePermission(UpRolePermission upRolePermission) {
        return this.upRolePermissionReporsitory.save(upRolePermission);
    }
}
