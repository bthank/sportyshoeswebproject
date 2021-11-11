package com.binu.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binu.sportyshoes.dto.User;
import com.binu.sportyshoes.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;	
	
	@Override
	public List<User> getAllUsers() {
		List<User> listOfAllUsers = userRepository.findAll();
		return listOfAllUsers;
	}

	@Override
	public List<User> findByAgeLessThanAndGender(Integer age, String gender) {
		List<User> listOfAllUsers = userRepository.findByAgeLessThanAndGender(age, gender);
		return listOfAllUsers;
	}

	@Override
	public List<User> findByAgeLessThan(Integer age) {
		List<User> listOfAllUsers = userRepository.findByAgeLessThan(age);
		return listOfAllUsers;
	}

	@Override
	public List<User> findByAgeBetweenAndGender(Integer age1, Integer age2, String gender) {
		List<User> listOfAllUsers = userRepository.findByAgeBetweenAndGender(age1, age2, gender);
		return listOfAllUsers;
	}

	@Override
	public List<User> findByAgeBetween(Integer age1, Integer age2) {
		List<User> listOfAllUsers = userRepository.findByAgeBetween(age1, age2);
		return listOfAllUsers;
	}

	@Override
	public List<User> findByAgeGreaterThanAndGender(Integer age, String gender) {
		List<User> listOfAllUsers = userRepository.findByAgeGreaterThanAndGender(age, gender);
		return listOfAllUsers;
	}

	@Override
	public List<User> findByAgeGreaterThan(Integer age) {
		List<User> listOfAllUsers = userRepository.findByAgeGreaterThan(age);
		return listOfAllUsers;
	}

	@Override
	public List<User> findByGender(String gender) {
		List<User> listOfAllUsers = userRepository.findByGender(gender);
		return listOfAllUsers;
	}

}
