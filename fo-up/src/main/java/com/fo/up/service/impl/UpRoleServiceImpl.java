package com.fo.up.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fo.common.core.exception.UpException;
import com.fo.up.entity.UpRole;
import com.fo.up.entity.UpUser;
import com.fo.up.repository.UpRoleRepository;
import com.fo.up.repository.UpUserRepository;
import com.fo.up.service.UpRoleService;

@Service
public class UpRoleServiceImpl implements UpRoleService {

    @Autowired
    private UpRoleRepository upRoleRepository;

    @Autowired
    private UpUserRepository upUserRepository;

    @Override
    public List<UpRole> findRoleByUserId(Long userId) {
        UpUser upUser = this.upUserRepository.findById(userId).get();
        if (null == upUser || upUser.getLocked() == 1) {
            throw new UpException(String.format("不存在的用户 userId: %s", userId)) ;
        }
        return this.upRoleRepository.findRoleByUserId(userId);
    }

}
