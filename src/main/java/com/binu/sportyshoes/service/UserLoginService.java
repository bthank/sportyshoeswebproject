package com.binu.sportyshoes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binu.sportyshoes.dto.User;
import com.binu.sportyshoes.repository.UserRepository;

@Service
public class UserLoginService {
	
	@Autowired
	UserRepository userRepository;

    public boolean validateUser(String username, String password) {
         
       	System.out.println("In UserLoginService: validateUser()    username=" + username + "     password=" + password);
    	boolean foundUser = false;
    	Optional<User> optional_user = userRepository.findById(username);
    	System.out.println("In UserLoginService: validateUser()    username=" + username + "     password=" + password  + "   optional_user=" + optional_user);
    	
    	if (optional_user.isPresent()) {
    		User user = optional_user.get();
    		if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
    			foundUser = true;
    		} 
    	}
      		
        return foundUser;
    }

}
