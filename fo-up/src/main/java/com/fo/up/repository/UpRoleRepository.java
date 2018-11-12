package com.fo.up.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fo.up.entity.UpRole;

public interface UpRoleRepository extends JpaRepository<UpRole, Long>{

    @Query( value = 
            "select ur.roleId, ur.name, ur.title, ur.description, ur.ctime, ur.orders "
            + " from UpRole ur "  
            + " left join UpUserRole uur on ur.roleId = uur.roleId " 
            +  "where uur.userId = :userId")
          
    public List<UpRole> findRoleByUserId(@Param( value = "userId") Integer userId);
}
