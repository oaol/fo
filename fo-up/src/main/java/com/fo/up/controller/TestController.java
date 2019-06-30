package com.fo.up.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fo.up.service.TestService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {

//    @Autowired
    private TestService testService;

    @GetMapping("/transactional")
    public void testTransactional() {
        this.testService.testTransaction();
    }
}
