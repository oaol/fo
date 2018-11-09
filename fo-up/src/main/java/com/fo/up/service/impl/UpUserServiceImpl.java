package com.fo.up.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

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
		}else if(upUserRepository.findUsername().contains(user.getUsername())){
			throw new UpException("用户名不能重复");
		}
		if(user.getPassword() == null && "".equals(user.getPassword())){
			throw new UpException("账密码不能为空");
		}else if (user.getPassword().length() < 6){
			throw new UpException("密码至少六位");
		}
		return upUserRepository.save(user);
	}

	@Override
	/**
     * 更新用户
     * @return
     */
	public UpUser addUser1(UpUser user) {
		if(user.getUserId() == null && "".equals(user.getUserId())){
			throw new UpException("传入user_id不能为空");
		}
		boolean contains = upUserRepository.findUsername().contains(user.getUsername());
		if(contains){
			throw new UpException("用户名不能重复");
		}
		if (user.getPassword().length() < 6){
			throw new UpException("密码至少六位");
		}
		return upUserRepository.save(user);
	}

	/**
     * 更新用户
     */
	public void updateUser(String pass,String salt,String realname,String avatar,String phone,String email,int sex,int locked, Long ctime,Long userId) {
		upUserRepository.updateUser(pass,salt, realname, avatar, phone, email, sex, locked, ctime, userId);
	}
	
	
	/**
	 * 根据id删除用户
	 */
	public void deleteById(Long id){
		if(id == null){
			throw new UpException("删除时id不能为空");
		}
		upUserRepository.deleteById(id);
	}
	
	/**
	 * 分页查询
	 */
	@Override
    public Page<UpUser> findUserByPage(UpUser upUser, Pageable pageable) {
        Example<UpUser> example = Example.of(upUser);
        return upUserRepository.findAll(example, pageable);
    }
	
	
	

  
}
