package com.fo.up.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.fo.up.entity.UpOrganization;

public interface UpOrganizationRepository extends JpaRepository<UpOrganization, Long> {
    /**
     * 更新组织
     * 
     * @param upOrganization
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update up_organization o set  "
            + " o.name = CASE WHEN :#{#upOrganization.name} IS NULL THEN o.name ELSE :#{#upOrganization.name} END ,"
            + " o.pid = CASE WHEN :#{#upOrganization.pid} IS NULL THEN o.pid ELSE :#{#upOrganization.pid} END ,"
            + " o.description = CASE WHEN :#{#upOrganization.description} IS NULL THEN o.description ELSE :#{#upOrganization.description} END,"
            + " o.ctime = CASE WHEN :#{#upOrganization.ctime} IS NULL THEN o.ctime ELSE :#{#upOrganization.ctime} END"
            + " where o.organization_id = :#{#upOrganization.organizationId}", nativeQuery = true)
    public void updateByUpOrganization(@Param("upOrganization") UpOrganization upOrganization);

    /**
     * 根据userId查组织
     */
    @Transactional
    @Query(value = "SELECT o.organization_id,o.pid,o.name,o.description,o.ctime FROM up_organization o "
            + "  JOIN up_user_organization uo ON o.organization_id = uo.organization_id "
            + " WHERE uo.user_id=:userId", nativeQuery = true)
    public List<UpOrganization> findOrganizationByUserId(@Param("userId") Long userId);
}
