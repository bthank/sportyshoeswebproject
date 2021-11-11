package com.binu.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.binu.sportyshoes.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
	 
	List<User> findByAgeLessThanAndGender(Integer age, String gender);  // Age < 20 AND gender
	List<User> findByAgeLessThan(Integer age);  // Age < 20 AND All genders
	
	List<User> findByAgeBetweenAndGender(Integer age1, Integer age2, String gender); // Age "20-29", "30-39", "40-49", "50-59" AND gender
	List<User> findByAgeBetween(Integer age1, Integer age2); // Age "20-29", "30-39", "40-49", "50-59" AND All genders
		
	List<User> findByAgeGreaterThanAndGender(Integer age, String gender); // Age "> 59"	AND gender
	List<User> findByAgeGreaterThan(Integer age); // Age "> 59" AND all genders
	
	List<User> findByGender(String gender);

}
