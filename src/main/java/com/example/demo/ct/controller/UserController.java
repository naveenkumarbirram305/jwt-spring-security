package com.example.demo.ct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ct.request.AuthRequest;
import com.example.demo.ct.service.UserRegistrationService;

@RestController
@RequestMapping("/api/register")
public class UserController {

	private final UserRegistrationService userRegistrationService;

	@Autowired
	public UserController(UserRegistrationService userRegistrationService) {
		this.userRegistrationService = userRegistrationService;
	}

	@PostMapping
	public String registerUser(@RequestBody AuthRequest request,  @RequestHeader("Authorization") String token) {
	    try {
	        userRegistrationService.registerUser(request.getLoginId(), request.getPassword());
	        return "User registered successfully!";
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception
	        return "Failed to register user.";
	    }
	}

}
