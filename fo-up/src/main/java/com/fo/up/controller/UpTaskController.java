package com.fo.up.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fo.up.entity.UpTask;
import com.fo.up.service.UpTaskService;

@RestController
@RequestMapping(value = "/task")
public class UpTaskController {
    @Autowired
    private UpTaskService upTaskService;

    @GetMapping
    public UpTask getTask() {
        UpTask task = upTaskService.getTask();
        return task;
    }

    @PutMapping
    public void updateTask(@RequestBody UpTask task) {
        upTaskService.updateTask(task);
    }

}
