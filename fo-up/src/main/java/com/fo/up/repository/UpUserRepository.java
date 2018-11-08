package com.fo.up.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.fo.up.entity.UpUser;

public interface UpUserRepository extends JpaRepository<UpUser, Long>{
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update UpUser u set u.password = :pass where u.username = :name ")
	public   void updateUser(@Param(value = "pass") String pass,@Param(value = "name") String name);
	


}
