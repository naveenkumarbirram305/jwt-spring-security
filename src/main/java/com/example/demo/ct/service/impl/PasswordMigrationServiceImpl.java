package com.example.demo.ct.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.ct.entity.User;
import com.example.demo.ct.repository.UserRepository;

@Service
public class PasswordMigrationServiceImpl {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Transactional
	public void migratePasswords() {
		List<User> users = userRepository.findAll();

		for (User user : users) {
			String oldPassword = user.getPassword();

			// Check if the password is not already BCrypt-encoded
			if (!passwordEncoder.matches("", oldPassword)) {
				String newPassword = passwordEncoder.encode(oldPassword);
				user.setPassword(newPassword);
			}
		}

		userRepository.saveAll(users);
	}
}
