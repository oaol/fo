package com.fo.up.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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
    
    /**
     * 更新权限
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value= "UPDATE up_permission p SET "
    		+ " p.system_id = CASE WHEN :#{#upPermission.systemId} IS NULL THEN p.system_id ELSE :#{#upPermission.systemId} END ,"
    		+ " p.pid = CASE WHEN :#{#upPermission.pid} IS NULL THEN p.pid ELSE :#{#upPermission.pid} END,"
    		+ " p.name = CASE WHEN :#{#upPermission.name} IS NULL THEN p.name ELSE :#{#upPermission.name} END,"
    		+ " p.type= CASE WHEN :#{#upPermission.type} IS NULL THEN p.type ELSE :#{#upPermission.type} END,"
    		+ " p.permission_value=CASE WHEN :#{#upPermission.permissionValue} IS NULL THEN p.permission_value ELSE :#{#upPermission.permissionValue} END,"
    		+ " p.uri=CASE WHEN :#{#upPermission.uri} IS NULL THEN p.uri ELSE :#{#upPermission.uri} END,"
    		+ " p.icon=CASE WHEN :#{#upPermission.icon} IS NULL THEN p.icon ELSE :#{#upPermission.icon} END,"
    		+ " p.status=CASE WHEN :#{#upPermission.status} IS NULL THEN p.status ELSE :#{#upPermission.status} END,"
    		+ " p.ctime=CASE WHEN :#{#upPermission.ctime} IS NULL THEN p.ctime ELSE :#{#upPermission.ctime} END,"
    		+ " p.orders= CASE WHEN :#{#upPermission.orders} IS NULL THEN p.orders ELSE :#{#upPermission.orders} END"
    		+ " WHERE p.permission_id = :#{#upPermission.permissionId}" ,nativeQuery = true)
    public void updateByUpPermissionId(@Param("upPermission")UpPermission upPermission);
    
   
}
