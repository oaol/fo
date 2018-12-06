package com.fo.up.service.impl;

import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fo.common.core.util.MD5Util;
import com.fo.up.core.exception.UpException;
import com.fo.up.entity.UpLog1;
import com.fo.up.entity.UpUser;
import com.fo.up.repository.UpLog1Repository;
import com.fo.up.repository.UpUserRepository;
import com.fo.up.repository.UpUserRoleRepository;
import com.fo.up.service.UpLog1Service;
import com.fo.up.service.UpUserService;

@Service
public class UpLog1ServiceImpl implements UpLog1Service {

    @Autowired
    private UpLog1Repository upLog1Repository;

    /**
     * 分页查询
     */
    @Override
    public Page<UpLog1> findLog1ByPage(UpLog1 log1, Pageable pageable) {
        Example<UpLog1> example = Example.of(log1);
        return upLog1Repository.findAll(example, pageable);
    }

}
