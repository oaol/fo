package com.fo.up.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alibaba.fastjson.JSONObject;
import com.fo.up.entity.UpRolePermission;


public interface UpRolePermissionRepository extends JpaRepository<UpRolePermission, Long>{

    @Query( value = "select urp.role_id as roleId, urp.permission_id as permissionId ,ur.name as roleName, up.name as permissionName from up_role_permission as urp " + 
            "left join up_role as ur on urp.role_id = ur.role_id " + 
            "left join up_permission as up on urp.permission_id = up.permission_id " + 
            "where urp.role_id = :roleId", nativeQuery = true)
    public Page<JSONObject> findRolePermissionByPage(@Param(value = "roleId") Integer roleId, Pageable pageable);
}
