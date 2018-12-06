package com.fo.up.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.fo.up.entity.UpLog1;
import com.fo.up.entity.UpUser;

public interface UpLog1Repository extends JpaRepository<UpLog1, Long> {
   
}
