package com.fo.up.controller;


import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fo.up.core.constant.UpResult;
import com.fo.up.entity.UpUser;
import com.fo.up.service.UpUserService;

@RestController
@RequestMapping(value="/user")
public class UpUserController {
    @Autowired
    private UpUserService upUserService;
    
    @GetMapping(value = "/{id}")
    @RequiresPermissions("haha")
    public UpUser getUserById(@PathVariable("id") Long id) {
    	return this.upUserService.getUserById(id);
    }
    
    @PostMapping
    public UpUser addUser(@RequestBody UpUser user){
    	return upUserService.addUser(user);
    }

    
  /*  @PutMapping
    public UpUser updateUserById(UpUser user){
        return upUserService.addUser1(user);
    }*/
    
    @PutMapping
    public void updateUser(@RequestBody UpUser user){
    	upUserService.updateUser(user);
    }
    
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") Long id){
    	upUserService.deleteById(id);
    }
    
    @GetMapping( value = "/page")
    @RequiresPermissions(value = {"cms:article:create"})
    public UpResult<Page<UpUser>> findUserByPage(@RequestParam(value = "username", required = false) String username, 
            @RequestParam( value = "userId", required = false) Long userId,
            @RequestParam( value = "page", required = false, defaultValue = "0") Integer page, 
            @RequestParam( value = "pageSize", required = false, defaultValue = "12")Integer pageSize){
    	UpUser upUser = new UpUser();
    	upUser.setUserId(userId);
    	upUser.setUsername(username);
        UpResult<Page<UpUser>> upResult = new UpResult<Page<UpUser>>();
        Page<UpUser> findUserByPage = upUserService.findUserByPage(upUser, PageRequest.of(page - 1, pageSize));
        upResult.setResults(findUserByPage);
        return upResult;
    }
}
