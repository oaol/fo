package com.fo.up.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
}
