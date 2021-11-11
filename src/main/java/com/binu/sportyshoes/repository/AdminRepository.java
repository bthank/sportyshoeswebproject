package com.binu.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.binu.sportyshoes.dto.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

}
