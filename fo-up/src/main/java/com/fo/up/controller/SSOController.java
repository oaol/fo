package com.fo.up.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.fo.up.entity.UpUser;


@RestController
@RequestMapping("/sso")
public class SSOController {

    @PostMapping("/login")
    public JSONObject login(@Valid @RequestBody UpUser upUser) {
        return loginByUsernamePasswordToken(upUser.getUsername(), upUser.getPassword());
    }

    @GetMapping("/login")
    public JSONObject login(@RequestParam(name = "username", required = true) String username,
             @RequestParam(name = "password", required = true) String password) {
        return loginByUsernamePasswordToken(username, password);
    }

    private JSONObject loginByUsernamePasswordToken(String username, String password) {
        Subject currentUser = SecurityUtils.getSubject();
        if ( currentUser.isAuthenticated() ) {
            return null;
        }
        //collect user principals and credentials in a gui specific manner
        //such as username/password html form, X509 certificate, OpenID, etc.
        //We'll use the username/password example here since it is the most common.
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        
        //this is all you have to do to support 'remember me' (no config - built in!):
        token.setRememberMe(true);
        currentUser.login(token);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token","admin-token");
        return  jsonObject;
    }

    @GetMapping("/role")
    public void role() {
        Subject currentUser = SecurityUtils.getSubject();
        System.out.println(currentUser.getPrincipal());
        if ( currentUser.isPermitted( "winnebago:drive:eagle5" ) ) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }
        return;
    }
    
//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
//
//
//    @GetMapping("/redis")
//    public String testRedis() {
//        Boolean hasKey = redisTemplate.hasKey("up");
//        return String.valueOf(hasKey);
//    }
//    
}
