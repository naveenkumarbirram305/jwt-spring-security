package com.example.demo.ct.service.impl;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.ct.entity.User;
import com.example.demo.ct.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByLoginId(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

		return new org.springframework.security.core.userdetails.User(user.getLoginId(), user.getPassword(),
				// Add any additional roles or authorities here if needed
				// For simplicity, assuming all users have a single role "USER"
				AuthorityUtils.createAuthorityList("ROLE_USER"));
	}

}
