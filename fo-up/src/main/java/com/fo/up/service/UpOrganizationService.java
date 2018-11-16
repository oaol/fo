package com.fo.up.service;

import java.util.List;

import com.fo.up.entity.UpOrganization;

public interface UpOrganizationService {
	
	
    /**
     * 新增组织
     */
    public UpOrganization addOrganization(UpOrganization upOrganization);
    
    /**
     * 删除组织
     */
    public void deleteByOrganizationId(Long organizationId);

    /**
     * 修改组织
     */
    public void updateByOrganization(UpOrganization upOrganization);
    
    /**
     * 查看组织
     */
    public UpOrganization findByOrganizationId(Long organizationId);
    
    /**
	 * 根据userId查组织
	 */
	public List<UpOrganization> findOrganizationByUserId(Long userId);
	
}
