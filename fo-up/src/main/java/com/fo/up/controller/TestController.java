package com.fo.up.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fo.up.service.TestService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

//    @Autowired
    private TestService testService;

    @GetMapping("/transactional")
    public void testTransactional() {
        this.testService.testTransaction();
    }
    
    @PostMapping("/test")
    public String test(@RequestParam("count") int count) {
        log.error(count + "");
        return count + "";
    }
}
