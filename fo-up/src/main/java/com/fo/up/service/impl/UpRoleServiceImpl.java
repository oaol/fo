package com.fo.up.service.impl;

import java.util.List;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fo.common.core.exception.UpException;
import com.fo.up.entity.UpRole;
import com.fo.up.entity.UpUser;
import com.fo.up.repository.UpRoleRepository;
import com.fo.up.repository.UpUserRepository;
import com.fo.up.service.UpRoleService;

@Service
public class UpRoleServiceImpl implements UpRoleService {

    @Autowired
    private UpRoleRepository upRoleRepository;

    @Autowired
    private UpUserRepository upUserRepository;
    
    /**
     * 根据userId查找所有的角色
     * @param userId
     * @return
     */
    @Override
    public List<UpRole> findRoleByUserId(Long userId) {
        UpUser upUser = this.upUserRepository.findById(userId).get();
        if (null == upUser || upUser.getLocked() == 1) {
            throw new UpException(String.format("不存在的用户 userId: %s", userId)) ;
        }
        List<UpRole> findRoleByUserId = this.upRoleRepository.findRoleByUserId(userId);
        return findRoleByUserId;
    }
    
    
    
    
    /**
     * 根据roleId查找所有的角色
     */
    @Override
    public UpRole findRoleById(Long roleId) {
        UpRole upRole = this.upRoleRepository.findById(roleId).get();
        return upRole;
    }



    /**
     * 新增角色
     */
	@Override
	public UpRole addRole(UpRole upRole) {
		return upRoleRepository.save(upRole);
	}

	/**
	 * 删除角色
	 */
	public void deleteByRoleId(Long roleId){
		if(roleId == null){
			throw new UpException("roleId不能为空");
		}
		 upRoleRepository.deleteById(roleId);
	}


	/**
	 * 更新角色
	 */
	@Override
	public void updateByRoleId(UpRole upRole) {
		upRoleRepository.updateUpRole(upRole);
	}
    
	
	
}
