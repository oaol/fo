package com.fo.up.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fo.up.entity.UpPermission;

public interface UpPermissionService {

    /**
     * <p>根据 user id 获取所有权限</p>
     * <p>user permission and role permission</p>
     * 
     * @param userId
     * @return
     */
    public List<UpPermission> findPermissionByUserId(Long userId);

    /**
     * 查看权限
     * @param upPermissionId
     * @return
     */
    public UpPermission findByUpPermission(Long upPermissionId);

    /**
     * 新增权限
     * 
     * @param upPermission
     */
    public UpPermission addPermission(UpPermission upPermission);

    /**
     * 修改权限
     * 
     * @param upPermission
     */
    public void updatePermission(UpPermission upPermission);

    /**
     * 根据 id 删除 permission
     * 
     * @param permissionId
     */
    public void deletePermissionByPermissionId(Long permissionId);

    /**
     * 颁查询
     * 
     * @param upPermission
     * @param pageable
     */
    public Page<UpPermission> findPermissionByPage(UpPermission upPermission, Pageable pageable);
}
