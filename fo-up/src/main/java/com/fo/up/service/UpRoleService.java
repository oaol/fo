package com.fo.up.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fo.up.entity.UpRole;

/**
 * role
 * 
 * @author bryce
 *
 */
public interface UpRoleService {

    /**
     * find all role by user id
     * 
     * @param userId
     * @return
     */
    public List<UpRole> findRoleByUserId(Long userId);

    /**
     * 查看角色
     * 
     * @param roleId
     * @return
     */
    public UpRole findRoleById(Long roleId);

    /**
     * 新增角色
     */
    public UpRole addRole(UpRole upRole);

    /**
     * 删除角色
     */
    public void deleteByRoleId(Long roleId);

    /**
     * 更新角色
     */
    public void updateByRoleId(UpRole upRole);

    /**
     * query role by page
     * 
     * @param upRole
     * @param pageable
     * @return
     */
    public Page<UpRole> findRoleByPage(UpRole upRole, Pageable pageable);
}
