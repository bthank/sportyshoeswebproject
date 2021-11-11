package com.binu.sportyshoes.service;

import com.binu.sportyshoes.dto.Admin;

public interface AdminService {
	
	Admin updateAdminPassword(String adminUsername,String adminPassword);

}
