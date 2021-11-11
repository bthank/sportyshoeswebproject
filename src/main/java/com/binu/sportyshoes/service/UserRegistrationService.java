package com.binu.sportyshoes.service;

import com.binu.sportyshoes.dto.User;

public interface UserRegistrationService {

	boolean doesUserExistInDB(String userid);
	User registerUser(User user);
	
}
