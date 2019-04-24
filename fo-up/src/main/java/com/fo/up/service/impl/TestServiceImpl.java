package com.fo.up.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fo.up.core.TransactionHelper;
import com.fo.up.entity.UpUser;
import com.fo.up.service.TestService;
import com.fo.up.service.UpUserService;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private UpUserService UpUserService;
    
    @Autowired
    private TransactionHelper helper;
    
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void testTransaction() {

        UpUser upUser = new UpUser();
        upUser.setUsername("111");
        upUser.setPassword("123456");
        UpUserService.addUser(upUser);

        UpUser upUser2 = new UpUser();
        upUser2.setUsername("1112");
        upUser2.setPassword("123456");
        helper.withoutTransaction(() -> UpUserService.addUser(upUser2));

    }

}
