package com.fo.up.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fo.up.entity.UpPermission;

public interface UpPermissionRepository extends JpaRepository<UpPermission, Long>{

    /**
     * find all perssions by user id
     * @param userId
     * @return
     */
    @Query( value = "SELECT " 
            + "permission_id, " + 
            "       system_id, " + 
            "       pid, " + 
            "       name, " + 
            "       TYPE, " + 
            "       permission_value, " + 
            "       uri, " + 
            "       icon, " + 
            "       status, " + 
            "       ctime, " + 
            "       orders " + 
            "FROM up_permission up " + 
            "WHERE up.status=1 " + 
            "  AND up.permission_id IN " + 
            "    ( SELECT permission_id " + 
            "     FROM up_role_permission urp " + 
            "     WHERE urp.role_id IN " + 
            "         ( SELECT uur.role_id role_id " + 
            "          FROM up_user_role uur " + 
            "          WHERE uur.user_id= :userId ) " + 
            "     UNION SELECT permission_id " + 
            "     FROM up_user_permission uup1 " + 
            "     WHERE uup1.user_id= :userId  " + 
            "       AND uup1.type=1 )  " + 
            "  AND up.permission_id NOT IN  " + 
            "    ( SELECT permission_id " + 
            "     FROM up_user_permission uup2  " + 
            "     WHERE uup2.user_id= :userId  " + 
            "       AND uup2.type=-1 )  " + 
            "ORDER BY up.orders ASC", nativeQuery = true)
    public List<UpPermission> findPermissionByUserId(@Param("userId") Long userId);
}
