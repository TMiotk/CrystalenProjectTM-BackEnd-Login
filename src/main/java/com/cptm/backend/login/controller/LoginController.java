package com.cptm.backend.login.controller;

import com.cptm.backend.login.dto.LoginRequest;
import com.cptm.backend.login.dto.LoginResponse;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        String email = request.getEmail();
        if (email.toLowerCase().endsWith("@crystalenproject.com")) {
            return ResponseEntity.ok(new LoginResponse("Firma Crystalen Project TM pozdrawia !"));
        } else {
            return ResponseEntity
                .status(401)
                .body(new LoginResponse("You are not registered in company database"));
        }
    }
}