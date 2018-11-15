package com.fo.up.service;

import java.util.List;

import com.fo.up.entity.UpRole;

/**
 * role
 * @author bryce
 *
 */
public interface UpRoleService {

    /**
     * find all role by user id
     * @param userId
     * @return
     */
    public List<UpRole> findRoleByUserId(Long userId);
    
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
}
