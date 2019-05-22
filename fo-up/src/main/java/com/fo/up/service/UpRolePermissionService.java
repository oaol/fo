package com.fo.up.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alibaba.fastjson.JSONObject;
import com.fo.up.entity.UpRolePermission;

/**
 * role permission
 * 
 * @author bryce
 *
 */
public interface UpRolePermissionService {


    /**
     * query role permission by page
     * TODO 关联表查询  permission name and role name
     * @param upRole
     * @param pageable
     * @return
     */
    public Page<JSONObject> findRolePermissionByPage(UpRolePermission upRolePermission, Pageable pageable);
}
