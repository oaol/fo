package com.fo.up.service;


import com.fo.up.entity.UpUser;

public interface UpUserService {
	/**
	 * 根据id查找user
	 * @param id
	 * @return
	 */
    public UpUser getUserById(Long id);
    
    /**
     * 新增用户
     * @return
     */
    public UpUser addUser(UpUser upser);
    
    
    /**
     * 更新用户
     */
    public void updateUser(String pass,String name);


}
