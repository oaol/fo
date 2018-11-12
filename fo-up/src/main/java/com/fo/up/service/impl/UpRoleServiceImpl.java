package com.fo.up.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fo.up.entity.UpRole;
import com.fo.up.repository.UpRoleRepository;
import com.fo.up.service.UpRoleService;

@Service
public class UpRoleServiceImpl implements UpRoleService {

    @Autowired
    private UpRoleRepository upRoleRepository;

    @Override
    public List<UpRole> findRoleByUserId(Integer userId) {
        return this.upRoleRepository.findRoleByUserId(userId);
    }

}
