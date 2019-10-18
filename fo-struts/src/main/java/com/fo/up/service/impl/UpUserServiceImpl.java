package com.fo.up.service.impl;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fo.up.core.ExceptionExpectUtils;
import com.fo.up.core.exception.UpException;
import com.fo.up.entity.UpUser;
import com.fo.up.repository.UpUserRepository;
import com.fo.up.repository.UpUserRoleRepository;
import com.fo.up.service.UpUserService;

@Service
public class UpUserServiceImpl implements UpUserService {

    @Autowired
    private UpUserRepository upUserRepository;

    @Autowired
    private UpUserRoleRepository upUserRoleRepository;

    @Cacheable(value = "up", key = "'user-' + #id")
    @Override
    public UpUser getUserById(Long id) {
        return upUserRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UpUser addUser(UpUser user) {
        ExceptionExpectUtils.expectTrue(StringUtils.isNotBlank(user.getUsername()), new UpException("用户名不能为空"));
        ExceptionExpectUtils.expectTrue(upUserRepository.findUsername(user.getUsername()) == null,
                new UpException("用户名不能重复"));
        ExceptionExpectUtils.expectTrue(StringUtils.isNotBlank(user.getPassword()), new UpException("密码不能为空"));
        ExceptionExpectUtils.expectTrue(user.getPassword().length() >= 6, new UpException("密码至少六位"));

        long time = System.currentTimeMillis();
        String salt = UUID.randomUUID().toString().replaceAll("-", "");
        user.setSalt(salt);
//        user.setPassword(MD5Util.md5(user.getPassword() + user.getSalt()));
        user.setCtime(time);
        UpUser save = upUserRepository.save(user);
        return save;
    }

    @Override
    public void updateUser(UpUser user) {
        upUserRepository.updateUser(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        upUserRepository.deleteById(id);
        // delete role by user id
        this.upUserRoleRepository.deleteByUserId(id);
    }

    @Override
    public Page<UpUser> findUserByPage(UpUser upUser, Pageable pageable) {
        Example<UpUser> example = Example.of(upUser);
        return upUserRepository.findAll(example, pageable);
    }

    @Override
    public UpUser findUserByUsernameAndPassword(UpUser upUser) {
        UpUser user = this.upUserRepository.findUpUserByUsername(upUser.getUsername()).orElse(null);
        return user;
    }

}
