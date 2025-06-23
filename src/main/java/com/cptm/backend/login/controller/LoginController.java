package com.cptm.backend.login.controller;

import com.cptm.backend.login.dto.LoginRequest;
import com.cptm.backend.login.dto.LoginResponse;
import com.cptm.backend.login.service.LoginService;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        String email = request.getEmail() != null ? request.getEmail().trim().toLowerCase() : "";
        logger.info("Login attempt for email: {}", email);

        if (loginService.isCompanyEmail(email)) {
            return ResponseEntity.ok(new LoginResponse(LoginService.SUCCESS_MESSAGE));
        } else {
            return ResponseEntity
                .status(403)
                .body(new LoginResponse(LoginService.FAILURE_MESSAGE));
        }
    }
}