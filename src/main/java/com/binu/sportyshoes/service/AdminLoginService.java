package com.binu.sportyshoes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binu.sportyshoes.dto.Admin;
import com.binu.sportyshoes.repository.AdminRepository;

@Service
public class AdminLoginService {
	
	@Autowired
	AdminRepository adminRepository;

    public boolean validateAdminUser(String username, String password) {
    	System.out.println("In AdminLoginService: validateAdminUser()    username=" + username + "     password=" + password);
    	boolean foundAdmin = false;
    	Optional<Admin> optional_admin = adminRepository.findById(username);
    	System.out.println("In AdminLoginService: validateAdminUser()    username=" + username + "     password=" + password  + "   optional_admin=" + optional_admin);
    	
    	if (optional_admin.isPresent()) {
    		Admin admin = optional_admin.get();
    		if (admin.getAdminUserName().equals(username) && admin.getAdminPassword().equals(password)) {
    			foundAdmin = true;
    		} 
    	}
      		
        return foundAdmin;
    }

}
