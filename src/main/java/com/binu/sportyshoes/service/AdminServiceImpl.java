package com.binu.sportyshoes.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binu.sportyshoes.dto.Admin;
import com.binu.sportyshoes.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	@Override
	@Transactional
	public Admin updateAdminPassword(String adminUsername, String adminPassword) {
		
		Admin admin = adminRepository.findById(adminUsername).get();
		
		if (admin != null) {
			admin.setAdminPassword(adminPassword);
		    admin = adminRepository.save(admin);		
		}
		return admin;
		
	}

}
