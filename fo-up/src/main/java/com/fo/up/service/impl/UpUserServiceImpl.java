package com.fo.up.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fo.up.core.exception.UpException;
import com.fo.up.entity.UpUser;
import com.fo.up.repository.UpUserRepository;
import com.fo.up.service.UpUserService;

@Service
public class UpUserServiceImpl implements UpUserService {

    @Autowired
    private UpUserRepository upUserRepository;

    @Override
    /**
	 * 根据id查找user
	 * @param id
	 * @return
	 */
    public UpUser getUserById(Long id) {
    	if(id == null){
    		throw new UpException("id is not null");
    	}
        return upUserRepository.findById(id).get();
    }

	@Override
	/**
     * 新增用户
     * @return
     */
	public UpUser addUser(UpUser user) {
		if (user.getUsername() == null && "".equals(user.getUsername())){
			throw new UpException("账号不能为空");
		}
		if(user.getPassword() == null && "".equals(user.getPassword())){
			throw new UpException("账密码不能为空");
		}else if (user.getPassword().length() < 6){
			throw new UpException("密码至少六位");
		}
		return upUserRepository.save(user);
	}

	

/*	*//**
     * 更新用户
     *//*
	public void updateUser(String name) {
		upUserRepository.updateUser(name);
	}*/

	
	
	

  
}
