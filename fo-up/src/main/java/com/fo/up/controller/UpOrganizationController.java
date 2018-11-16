package com.fo.up.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fo.up.entity.UpOrganization;
import com.fo.up.service.UpOrganizationService;

@RestController
@RequestMapping("/organization")
public class UpOrganizationController {
	@Autowired
	private UpOrganizationService upOrganizationService;
	
    @GetMapping
    public UpOrganization findByOrganizationId(Long organizationId){
    	return upOrganizationService.findByOrganizationId(organizationId);
    }
    
    @PostMapping
    public UpOrganization addOrganization(UpOrganization upOrganization){
    	return upOrganizationService.addOrganization(upOrganization);
    }
    
    @PutMapping
    public void updateByOrganization(UpOrganization upOrganization){
    	upOrganizationService.updateByOrganization(upOrganization);
    }
	
    @DeleteMapping
    public void deleteByOrganizationId(Long organizationId){
    	upOrganizationService.deleteByOrganizationId(organizationId);
    }
  

	

}
