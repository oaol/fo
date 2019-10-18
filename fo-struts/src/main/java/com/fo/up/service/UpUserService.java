package com.fo.up.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fo.up.entity.UpUser;

public interface UpUserService {

    /**
     * 根据id查找user
     * 
     * @param id
     * @return
     */
    public UpUser getUserById(Long id);

    /**
     * 新增用户
     * 
     * @return
     */
    public UpUser addUser(UpUser upser);

    /**
     * 更新用户
     */
    public void updateUser(UpUser user);

    /**
     * 根据id删除用户
     */
    public void deleteById(Long id);

    /**
     * 分页查询
     * 
     * @param upPermission
     * @param pageable
     * @return
     */
    public Page<UpUser> findUserByPage(UpUser upUser, Pageable pageable);

    /**
     * 跟据 用户名和密码查询
     * 
     * @author bryce
     * @date Nov 22, 2018
     */
    public UpUser findUserByUsernameAndPassword(UpUser upUser);

}
