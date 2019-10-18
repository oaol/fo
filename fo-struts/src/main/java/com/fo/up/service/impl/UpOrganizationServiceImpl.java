package com.fo.up.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fo.up.entity.UpOrganization;
import com.fo.up.repository.UpOrganizationRepository;
import com.fo.up.service.UpOrganizationService;

@Service
public class UpOrganizationServiceImpl implements UpOrganizationService {

    @Autowired
    private UpOrganizationRepository upOrganizationRepository;

    @Override
    public UpOrganization addOrganization(UpOrganization upOrganization) {
        return upOrganizationRepository.save(upOrganization);
    }

    @Override
    public void deleteByOrganizationId(Long organizationId) {
        upOrganizationRepository.deleteById(organizationId);
    }

    @Override
    public void updateByOrganization(UpOrganization upOrganization) {
        upOrganizationRepository.updateByUpOrganization(upOrganization);
    }

    @Override
    public UpOrganization findByOrganizationId(Long organizationId) {
        return upOrganizationRepository.findById(organizationId).get();
    }

    @Override
    public List<UpOrganization> findOrganizationByUserId(Long userId) {
        return upOrganizationRepository.findOrganizationByUserId(userId);
    }

    @Override
    public Page<UpOrganization> findOrganizationByPage(UpOrganization upOrganization, Pageable pageable) {
        Example<UpOrganization> example = Example.of(upOrganization);
        return this.upOrganizationRepository.findAll(example, pageable);
    }

}
