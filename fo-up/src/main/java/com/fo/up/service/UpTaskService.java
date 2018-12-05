package com.fo.up.service;


import org.springframework.data.domain.Page;

import com.fo.up.entity.UpTask;

public interface UpTaskService {
    /**
     * 根据id查找user
     * 
     * @param id
     * @return
     */
    public UpTask getTask();

    /**
     * 更新用户
     */
    public void updateTask(UpTask task);

}
