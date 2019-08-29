package com.jwt.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.example.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String user);
}

