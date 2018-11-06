package com.fo.up.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fo.up.entity.UpUser;

public interface UpUserRepository extends JpaRepository<UpUser, Long>{

}
