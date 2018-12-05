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
import com.fo.up.entity.UpTask;
import com.fo.up.entity.UpUser;
import com.fo.up.repository.UpTaskRepository;
import com.fo.up.repository.UpUserRepository;
import com.fo.up.repository.UpUserRoleRepository;
import com.fo.up.service.UpTaskService;
import com.fo.up.service.UpUserService;

@Service
public class UpTaskServiceImpl implements UpTaskService {

    @Autowired
    private UpTaskRepository upTaskRepository;

    /**
     * 根据id查找user
     * 
     * @param id
     * @return
     */
    @Override
    public UpTask getTask() {
        return upTaskRepository.findAll().get(0);
    }

    /**
     * 更新用户
     */
    @Override
    public void updateTask(UpTask task) {
    	upTaskRepository.updateTask(task);
    }

    
   

}
