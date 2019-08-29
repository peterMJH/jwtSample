package com.jwt.example.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.example.domain.User;
import com.jwt.example.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value = "/userList")
	public List<User> list() {
		return userRepository.findAll();
	}
}
