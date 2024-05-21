package com.example.demo.ct.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.ct.config.JwtTokenProvider;
import com.example.demo.ct.entity.User;
import com.example.demo.ct.repository.UserRepository;
import com.example.demo.ct.request.AuthRequest;
import com.example.demo.ct.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


	@Override
	public String authenticateUser(AuthRequest authRquest) {
		 // Authenticate logic (validate credentials, generate token)
        String loginId = authRquest.getLoginId();
        String password = authRquest.getPassword();
        
        
        try {
            // Encode the entered password using BCryptPasswordEncoder
           // String encodedPassword = passwordEncoder.encode(password);

            // Authenticate the user using Spring Security AuthenticationManager
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginId, password)
            );

            // Set the authenticated user in the SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Generate JWT token
            User user = userRepository.findByLoginId(loginId)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found")); // More specific exception

            return tokenProvider.generateToken(user);
        } catch (AuthenticationException e) {
            // Handle authentication exception (e.g., bad credentials, locked account)
            throw new RuntimeException("Authentication failed", e);
        }

//        // Authenticate the user using Spring Security AuthenticationManager
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginId, password)
//        );
//
//        // Set the authenticated user in the SecurityContext
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        // Generate JWT token
//        User user = userRepository.findByLoginId(loginId)
//                .orElseThrow(() -> new RuntimeException("User not found")); // Handle appropriately
//        return tokenProvider.generateToken(user);
	}
}
