package com.example.demo.ct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ct.request.AuthRequest;
import com.example.demo.ct.service.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authService;

    @PostMapping
    public ResponseEntity<String> authenticate(@RequestBody AuthRequest request) {
        String token = authService.authenticateUser(request);
        return ResponseEntity.ok(token);
    }

}
