package com.cptm.backend.login.dto;


public class LoginResponse {
    private String message;

    public LoginResponse(String message) {
        this.message = message;
    }

    // Getter
    public String getMessage() { return message; }
}