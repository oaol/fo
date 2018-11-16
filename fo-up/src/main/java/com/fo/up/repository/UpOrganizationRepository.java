package com.fo.up.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.fo.up.entity.UpOrganization;

public interface UpOrganizationRepository extends JpaRepository<UpOrganization, Long>{
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update up_organization o set  "
            + " o.name = CASE WHEN :#{#upOrganization.name} IS NULL THEN o.name ELSE :#{#upOrganization.name} END ,"
            + " o.pid = CASE WHEN :#{#upOrganization.title} IS NULL THEN o.title ELSE :#{#upOrganization.title} END ,"
            + " o.description = CASE WHEN :#{#upOrganization.description} IS NULL THEN o.description ELSE :#{#upOrganization.description} END,"
            + " o.ctime = CASE WHEN :#{#upOrganization.ctime} IS NULL THEN o.ctime ELSE :#{#upOrganization.ctime} END"
            + " where o.organization_id = :#{#upOrganization.organizationId}", nativeQuery = true)
    public void updateByUpOrganization(@Param("upOrganization")UpOrganization upOrganization);
    
   
}
