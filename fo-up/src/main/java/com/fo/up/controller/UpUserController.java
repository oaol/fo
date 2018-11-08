package com.fo.up.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return upUserService.addUser(user);
    }
    
    @PutMapping(value="/update")
    public void updateUser(String pass,String name){
    	upUserService.updateUser(pass,name);
    }
    
}
