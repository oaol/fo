package com.fo.up.service.impl;

import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fo.common.core.util.ExceptionExpectUtils;
import com.fo.common.core.util.MD5Util;
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

    /**
     * 根据id查找user
     * 
     * @param id
     * @return
     */
    @Cacheable(value = "aaa", key = "#id + 1", condition = "#id>0")
    @Override
    public UpUser getUserById(Long id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return upUserRepository.findById(id).get();
    }
    /**
     * 
     * 新增用户
     * 
     * @return
     */
    @Override
    public UpUser addUser(UpUser user) {
        ExceptionExpectUtils.expectTrue(StringUtils.isBlank(user.getUsername()), new UpException("用户名不能为空"));
        ExceptionExpectUtils.expectTrue(upUserRepository.findUsername(user.getUsername()) != null,
                new UpException("用户名不能重复"));
        ExceptionExpectUtils.expectTrue(StringUtils.isBlank(user.getPassword()), new UpException("密码不能为空"));
        ExceptionExpectUtils.expectTrue(user.getPassword().length() < 6, new UpException("密码至少六位"));

        long time = System.currentTimeMillis();
        String salt = UUID.randomUUID().toString().replaceAll("-", "");
        user.setSalt(salt);
        user.setPassword(MD5Util.md5(user.getPassword() + user.getSalt()));
        user.setCtime(time);
        return upUserRepository.save(user);
    }

    /*
     * @Override
     *//**
        * 更新用户
        * 
        * @return
        *//*
           * public UpUser addUser1(UpUser user) { if(user.getUserId() == null){ throw new
           * UpException("传入user_id不能为空"); } boolean contains =
           * upUserRepository.findUsername(user.getUsername()).contains(user.getUsername()
           * ); if(contains){ throw new UpException("用户名不能重复"); } if
           * (user.getPassword().length() < 6){ throw new UpException("密码至少六位"); } return
           * upUserRepository.save(user); }
           */

    /**
     * 更新用户
     */
    @Override
    public void updateUser(UpUser user) {
        upUserRepository.updateUser(user);
    }

    /**
     * 根据id删除用户
     */
    @Override
    @Transactional
    public void deleteById(Long id) {
        if (id == null) {
            throw new UpException("删除时id不能为空");
        }

        upUserRepository.deleteById(id);
        // delete role by user id
        this.upUserRoleRepository.deleteByUserId(id);
    }

    /**
     * 分页查询
     */
    @Override
    public Page<UpUser> findUserByPage(UpUser upUser, Pageable pageable) {
        Example<UpUser> example = Example.of(upUser);
        return upUserRepository.findAll(example, pageable);
    }

    @Override
    public UpUser findUserByUsernameAndPassword(UpUser upUser) {
        UpUser user = this.upUserRepository.findUpUserByUsername(upUser.getUsername());
        return user;
    }

}
