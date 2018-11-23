package com.fo.up.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sso")
public class SSOController {

    @GetMapping("/login")
    public String login() {
        Subject currentUser = SecurityUtils.getSubject();
        if ( !currentUser.isAuthenticated() ) {
            //collect user principals and credentials in a gui specific manner
            //such as username/password html form, X509 certificate, OpenID, etc.
            //We'll use the username/password example here since it is the most common.
            UsernamePasswordToken token = new UsernamePasswordToken("admin", "3038D9CB63B3152A79B8153FB06C02F7");

            //this is all you have to do to support 'remember me' (no config - built in!):
            token.setRememberMe(true);

            currentUser.login(token);
            if ( currentUser.isPermitted( "cms:article:read" ) ) {
                System.out.println(1);
                return "1";
            } else {
                System.out.println(2);
                return "2";
            }
        }
            return "3";
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
