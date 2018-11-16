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
    @Query("update UpOrganization o set  "
            + " o.name = CASE WHEN :#{#upOrganization.name} IS NULL THEN o.name ELSE :#{#upOrganization.name} END ,"
            + " o.pid = CASE WHEN :#{#upOrganization.pid} IS NULL THEN o.pid ELSE :#{#upOrganization.pid} END ,"
            + " o.description = CASE WHEN :#{#upOrganization.description} IS NULL THEN o.description ELSE :#{#upOrganization.description} END,"
            + " o.ctime = CASE WHEN :#{#upOrganization.ctime} IS NULL THEN o.ctime ELSE :#{#upOrganization.ctime} END"
            + " where o.organizationId = :#{#upOrganization.organizationId}")
    public void updateByUpOrganization(@Param("upOrganization") UpOrganization upOrganization);
    
   
}
