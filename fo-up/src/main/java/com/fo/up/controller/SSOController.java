package com.fo.up.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sso")
public class SSOController {

    @PostMapping("/login")
    public void login() {
        // 鉴权
        // 是否登录
            // 否
            // 创建 session
            // 
            // 是
            return;
    }
}
