package com.fo.up.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.fo.up.service.ShiroTestService;

@Service
public class ShiroTestServiceImpl implements ShiroTestService{

   
    public static void main(String[] args) {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        if(!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
            //this is all you have to do to support 'remember me' (no config - built in!):
            token.setRememberMe(true);
            currentUser.login(token);
        }
    }
}
