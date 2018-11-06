package com.fo.up.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fo.up.entity.UpUser;
import com.fo.up.repository.UpUserRepository;
import com.fo.up.service.UpUserService;

@Service
public class UpUserServiceImpl implements UpUserService {

    @Autowired
    private UpUserRepository upUserRepository;

    @Override
    public UpUser getUserById(Long id) {
        return upUserRepository.findById(id).get();
    }

    @Override
    public List<UpUser> findUpUserById(Long id) {
//		return upUserRepository.findPerById(id);
        return null;
    }

}
