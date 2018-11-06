package com.fo.up.service;

import java.util.List;

import com.fo.up.entity.UpUser;

public interface UpUserService {
    public UpUser getUserById(Long id);

    public List<UpUser> findUpUserById(Long id);
}
