package com.fo.up.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fo.up.entity.UpLog1;

public interface UpLog1Repository extends JpaRepository<UpLog1, Long> {
    Page<UpLog1> findAll(Specification<UpLog1> spec, Pageable pageable);

   
}
