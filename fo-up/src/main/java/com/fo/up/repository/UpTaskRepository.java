package com.fo.up.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.fo.up.entity.UpTask;

public interface UpTaskRepository extends JpaRepository<UpTask, String> {
    // update或者delete时需要加modifying
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update UpTask t set t.flag = CASE WHEN :#{#task.flag} IS NULL THEN t.flag ELSE :#{#task.flag} END ,"
            + "t.startTime = CASE WHEN :#{#task.startTime} IS NULL THEN t.startTime ELSE :#{#task.startTime} END ,"
            + "t.endTime = CASE WHEN :#{#task.endTime} IS NULL THEN t.endTime ELSE :#{#task.endTime} END ,"
            + "t.period = CASE WHEN :#{#task.period} IS NULL THEN t.period ELSE :#{#task.period} END" 
            + " where t.taskId = :#{#task.taskId}")
    public void updateTask(@Param("task") UpTask task);


}
