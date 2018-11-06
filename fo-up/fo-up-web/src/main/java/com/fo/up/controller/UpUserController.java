package com.fo.up.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fo.up.entity.UpUser;
import com.fo.up.service.UpUserService;

@RestController
@RequestMapping(value="/up/user")
public class UpUserController {

    @Autowired
    private UpUserService upUserService;
    
    @GetMapping
    public UpUser getUserById(Long id) {
        return this.upUserService.getUserById(id);
    }
    
    @GetMapping("/list")
    public List<UpUser> findUpUserById(Long id) {
        return this.upUserService.findUpUserById(id);
    }
}
