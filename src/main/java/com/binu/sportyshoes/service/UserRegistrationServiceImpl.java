package com.binu.sportyshoes.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binu.sportyshoes.dto.Address;
import com.binu.sportyshoes.dto.User;
import com.binu.sportyshoes.repository.AddressRepository;
import com.binu.sportyshoes.repository.UserRepository;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
    public boolean doesUserExistInDB(String userid) {
        boolean doesUserExist = false;
        
        Optional<User> user = userRepository.findById(userid);
        if (user.isPresent()) {
        	doesUserExist = true; 
        }
    	
        return doesUserExist;
    }
    
    @Transactional
    public User registerUser(User user) {
    	Address address = new Address();
    	address.setAddressLine1(user.getHomeAddress().getAddressLine1());
    	address.setAddressLine2(user.getHomeAddress().getAddressLine2());
    	address.setCity(user.getHomeAddress().getCity());
    	address.setState(user.getHomeAddress().getState());
    	address.setZipCode(user.getHomeAddress().getZipCode());
    	address.setCountry(user.getHomeAddress().getCountry());
    	address = addressRepository.save(address);
    	
    	user.getHomeAddress().setId(address.getId());
    	User saved_user = userRepository.save(user);
    	return saved_user;
    }

}
