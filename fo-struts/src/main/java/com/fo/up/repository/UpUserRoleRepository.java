package com.fo.up.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.fo.up.entity.UpUserRole;

public interface UpUserRoleRepository extends JpaRepository<UpUserRole, Long>{
    
    @Transactional
    public void deleteByUserId(Long userId);

}
