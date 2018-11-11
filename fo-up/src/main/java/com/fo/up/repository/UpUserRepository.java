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
	@Query("update UpUser u set  "
	        + "u.salt = CASE WHEN :#{#user.salt} IS NULL THEN u.salt ELSE :#{#user.salt} END ,"
	        + "u.realname = CASE WHEN :#{#user.realname} IS NULL THEN u.realname ELSE :#{#user.realname} END,"
	        + "u.avatar = CASE WHEN :#{#user.avatar} IS NULL THEN u.avatar ELSE :#{#user.avatar} END,"
			+ "u.phone = CASE WHEN :#{#user.phone} IS NULL THEN u.phone ELSE :#{#user.phone} END,"
			+ "u.email = CASE WHEN :#{#user.email} IS NULL THEN u.email ELSE :#{#user.email} END,"
			+ "u.sex = CASE WHEN :#{#user.sex} IS NULL THEN u.sex ELSE :#{#user.sex} END "
			+ "where u.userId = :#{#user.userId}")
	public void updateUser(@Param("user") UpUser user);
	
	
	
@Query("select u.username from UpUser u where u.username = :username")
public String findUsername(@Param(value = "username") String username);
		
		
	


}
