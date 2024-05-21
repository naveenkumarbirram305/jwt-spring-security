package com.example.demo.ct.service.impl;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.ct.entity.User;
import com.example.demo.ct.repository.UserRepository;
import com.example.demo.ct.service.UserRegistrationService;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService{
	
	private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder; // Inject BCryptPasswordEncoder here

	public UserRegistrationServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Transactional
	public void registerUser(String loginId, String password) {
		// Check if the username is already taken
		if (userRepository.findByLoginId(loginId).isPresent()) {
			throw new RuntimeException("Username is already taken");
		}

		// Encode the password using BCryptPasswordEncoder
		String encodedPassword = passwordEncoder.encode(password);

		// Create a new user
		User user = new User();
		user.setLoginId(loginId);
		user.setPassword(encodedPassword);

		// Save the user in the database
		userRepository.save(user);
	}

}
