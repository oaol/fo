package com.fo.up.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fo.up.entity.UpUser;

@RestController
@RequestMapping("/sso")
public class SSOController {

    @PostMapping("/login")
    public String login(@RequestBody UpUser upUser) {
        Subject currentUser = SecurityUtils.getSubject();
        if ( !currentUser.isAuthenticated() ) {
            //collect user principals and credentials in a gui specific manner
            //such as username/password html form, X509 certificate, OpenID, etc.
            //We'll use the username/password example here since it is the most common.
            UsernamePasswordToken token = new UsernamePasswordToken(upUser.getUsername(), upUser.getPassword());

            //this is all you have to do to support 'remember me' (no config - built in!):
            token.setRememberMe(true);
            currentUser.login(token);
            return  "login sucess";
        }
        return "already login";
    }

    @GetMapping("/login")
    public String login(@Validated @NotEmpty String username,@Valid  @NotEmpty String password) {
        Subject currentUser = SecurityUtils.getSubject();
        if ( !currentUser.isAuthenticated() ) {
            //collect user principals and credentials in a gui specific manner
            //such as username/password html form, X509 certificate, OpenID, etc.
            //We'll use the username/password example here since it is the most common.
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            
            //this is all you have to do to support 'remember me' (no config - built in!):
            token.setRememberMe(true);
            currentUser.login(token);
            return  "login sucess";
        }
        return "already login";
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
    
}
