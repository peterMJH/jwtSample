package com.jwt.example.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.example.config.JwtTokenProvider;
import com.jwt.example.domain.User;
import com.jwt.example.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class LoginController {
	
	@Autowired
	private final JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping(value = "/signin")
	public String logIn(@RequestParam String username, @RequestParam String password) {
		User user = userRepository.findByUsername(username);
		if(!passwordEncoder.matches(password, passwordEncoder.encode(user.getPassword()))) {
			return "login Failure";
		} else {
			return jwtTokenProvider.createToken(user.getUsername(), null);
		}
	}
	
	@PostMapping(value = "/signup")
	public User signUp(@RequestParam String username, @RequestParam String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		userRepository.save(user);
		return user;
	}

}
