package com.fo.up.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fo.up.entity.UpLog1;
import com.fo.up.entity.UpUser;

public interface UpLog1Service {
 
    /**
     * 分页查询
     * 
     * @param upPermission
     * @param pageable
     * @return
     */
    public Page<UpLog1> findLog1ByPage(UpLog1 log1, Pageable pageable);
}
