package com.fo.up.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fo.up.entity.UpOrganization;
import com.fo.up.repository.UpOrganizationRepository;
import com.fo.up.service.UpOrganizationService;

@Service
public class UpOrganizationServiceImpl implements UpOrganizationService{

    @Autowired
    private UpOrganizationRepository upOrganizationRepository;
    

    /**
     * 新增组织
     */
    @Override
    public UpOrganization addOrganization(UpOrganization upOrganization) {
        return upOrganizationRepository.save(upOrganization);
    }

    /**
     * 删除组织
     */
    @Override
    public void deleteByOrganizationId(Long organizationId) {
        upOrganizationRepository.deleteById(organizationId);
    }

    /**
     * 修改组织
     */
    @Override
    public void updateByOrganization(UpOrganization upOrganization) {
         upOrganizationRepository.updateByUpOrganization(upOrganization);
    }

    /**
     * 查看组织
     */
    @Override
    public UpOrganization findByOrganizationId(Long organizationId) {
        return upOrganizationRepository.findById(organizationId).get();
    }

    /**
     * 根据userId查组织
     */
	@Override
	public List<UpOrganization> findOrganizationByUserId(Long userId) {
		return upOrganizationRepository.findOrganizationByUserId(userId);
	} 
    
}
