package com.fo.up.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.fo.up.entity.UpUser;

public interface UpUserRepository extends JpaRepository<UpUser, Long>{
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update UpUser u set u.password = :pass , u.salt = :salt,u.realname = :realname,u.avatar = :avatar,"
			+ "u.phone = :phone,u.email = :email,u.sex = :sex,u.locked = :locked,u.ctime = :ctime where u.userId = :userId")
	public void updateUser(@Param(value = "pass") String pass,@Param(value = "salt") String salt,@Param(value = "realname") String realname,
			@Param(value = "avatar") String avatar,@Param(value = "phone") String phone,@Param(value = "email") String email,
			@Param(value = "sex") int sex,@Param(value = "locked") int locked,@Param(value = "ctime") Long ctime,
			@Param(value = "userId") Long userId);
	
	
	
@Query("select u.username from UpUser u where u.username = :username")
public String findUsername(@Param(value = "username") String username);
		
		
	


}
