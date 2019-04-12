package com.fo.up.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fo.up.entity.UpOrganization;

/**
 * organization service
 * 
 * @author bryce
 * @Date Apr 11, 2019
 */
public interface UpOrganizationService {

    /**
     * 
     * add organization
     * @param upOrganization
     * @return
     */
    public UpOrganization addOrganization(UpOrganization upOrganization);

    /**
     * 
     * delete organization
     * @param organizationId
     */
    public void deleteByOrganizationId(Long organizationId);

    /**
     * 
     * udpate organizaiton by organization id
     * @param upOrganization
     */
    public void updateByOrganization(UpOrganization upOrganization);

    /**
     * 
     * find organization by organization id
     * @param organizationId
     * return
     */
    public UpOrganization findByOrganizationId(Long organizationId);

    /**
     * 
     * <p>find organizations by user id</p>
     * @param userId
     * @return
     */
    public List<UpOrganization> findOrganizationByUserId(Long userId);

    /**
     * <p>find organizatoin by page</p>
     * 
     * @return
     */
    public Page<UpOrganization> findOrganizationByPage(UpOrganization upOrganization, Pageable pageable);
}
