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
import com.fo.up.entity.UpLog1;
import com.fo.up.entity.UpUser;
import com.fo.up.service.UpLog1Service;
import com.fo.up.service.UpUserService;

@RestController
@RequestMapping(value="/log1")
public class UpLog1Controller {
    @Autowired
    private UpLog1Service upLog1Service;
    
    @GetMapping
    public UpResult<Page<UpLog1>> findLog1ByPage(@RequestParam(value = "execStart", required = false) String execStart, 
            @RequestParam( value = "execEnd", required = false) String execEnd,
            @RequestParam( value = "page", required = false, defaultValue = "0") Integer page, 
            @RequestParam( value = "pageSize", required = false, defaultValue = "12")Integer pageSize){
    	UpLog1 upLog1 = new UpLog1();
    	upLog1.setExecStart(execStart);
    	upLog1.setExecEnd(execEnd);
        UpResult<Page<UpLog1>> upResult = new UpResult<Page<UpLog1>>();
        Page<UpLog1> findLog1ByPage = upLog1Service.findLog1ByPage(upLog1, PageRequest.of(page - 1, pageSize));
        upResult.setResults(findLog1ByPage);
        return upResult;
    }
}
