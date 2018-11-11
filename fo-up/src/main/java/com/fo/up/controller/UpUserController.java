package com.fo.up.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fo.up.core.constant.UpResult;
import com.fo.up.entity.UpUser;
import com.fo.up.service.UpUserService;

@RestController
@RequestMapping(value="/user")
public class UpUserController {
    @Autowired
    private UpUserService upUserService;
    
    @GetMapping
    public UpUser getUserById(Long id) {
    	return this.upUserService.getUserById(id);
    }
    
    @PostMapping
    public UpUser addUser(UpUser user){
    	return upUserService.addUser(user);
    }

    
    @PutMapping
    public UpUser updateUserById(UpUser user){
        return upUserService.addUser1(user);
    }
    
    @PutMapping(value="/update")
    public void updateUser(UpUser user){
    	upUserService.updateUser(user.getPassword(), 
    	        user.getSalt(), user.getRealname(), user.getAvatar(), 
    	        user.getPhone(), user.getEmail(), user.getSex(), user.getLocked(), user.getCtime(), user.getUserId());
    }
    
    @DeleteMapping
    public void deleteById(Long id){
    	upUserService.deleteById(id);
    }
    
    
    @GetMapping( value = "/page")
    public UpResult<Page<UpUser>> findUserByPage(@RequestParam(value = "username", required = false) String username, 
            @RequestParam( value = "userId", required = false) Long userId,
            @RequestParam( value = "page", required = false, defaultValue = "0") Integer page, 
            @RequestParam( value = "pageSize", required = false, defaultValue = "12")Integer pageSize){
    	UpUser upUser = new UpUser();
    	upUser.setUserId(userId);
    	upUser.setUsername(username);
        UpResult<Page<UpUser>> upResult = new UpResult<Page<UpUser>>();
        Page<UpUser> findUserByPage = upUserService.findUserByPage(upUser, PageRequest.of(page, pageSize));
        upResult.setData(findUserByPage);
        return upResult;
    }
}
