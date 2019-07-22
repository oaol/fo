package com.fo.up.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.fo.up.entity.UpRole;

public interface UpRoleRepository extends JpaRepository<UpRole, Long>{
    /**
     * 根据userId查找所有的角色
     * @param userId
     * @return
     */
    @Query( value = 
            "select ur.role_id, ur.name, ur.title, ur.description, ur.ctime, ur.orders "
            + " from up_role ur "
            + " left join up_user_role uur on ur.role_id = uur.role_id " 
            +  "where uur.user_id = :userId", nativeQuery = true)
    public List<UpRole> findRoleByUserId(@Param( value = "userId") Long userId);

    /**
     * 更新角色
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update UpRole r set  "
	        + " r.name = CASE WHEN :#{#upRole.name} IS NULL THEN r.name ELSE :#{#upRole.name} END ,"
	        + " r.title = CASE WHEN :#{#upRole.title} IS NULL THEN r.title ELSE :#{#upRole.title} END ,"
	        + " r.description = CASE WHEN :#{#upRole.description} IS NULL THEN r.description ELSE :#{#upRole.description} END,"
	        + " r.ctime = CASE WHEN :#{#upRole.ctime} IS NULL THEN r.ctime ELSE :#{#upRole.ctime} END,"
			+ " r.orders = CASE WHEN :#{#upRole.orders} IS NULL THEN r.orders ELSE :#{#upRole.orders} END"
			+ " where r.roleId = :#{#upRole.roleId}")
    public void updateUpRole(@Param( value= "upRole") UpRole upRole);
}
