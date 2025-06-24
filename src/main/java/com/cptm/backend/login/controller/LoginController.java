// Copyright © Tomasz Miotk, Crystalen Project TM.
// This code is proprietary and for viewing purposes only.
// Copying, editing, or distributing any part of this code is strictly prohibited without explicit permission from the author.

package com.cptm.backend.login.controller;

import com.cptm.backend.login.dto.LoginRequest;
import com.cptm.backend.login.dto.LoginResponse;
import com.cptm.backend.login.service.LoginService;
import com.cptm.backend.security.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public LoginController(LoginService loginService,
                           AuthenticationManager authenticationManager,
                           JwtUtil jwtUtil) {
      
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        try {
            Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(auth);

            String token = jwtUtil.generateToken(request.getEmail());
            long expirationTime = System.currentTimeMillis() + 3600_000; // 1h w ms
            return ResponseEntity.ok(new LoginResponse("Login successful", token, request.getEmail(), expirationTime));

        } catch (Exception e) {
            return ResponseEntity.status(401).body(new LoginResponse("Invalid credentials"));
        }
    }
}
