package com.cptm.backend.login.dto;

public class LoginResponse {

    private String message;
    private String token;
    private String email;
    private long expiration; // timestamp w ms

    public LoginResponse(String message) {
        this.message = message;
    }

    public LoginResponse(String message, String token, String email, long expiration) {
        this.message = message;
        this.token = token;
        this.email = email;
        this.expiration = expiration;
    }

    // Gettery
    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }

    public String getEmail() {
        return email;
    }

    public long getExpiration() {
        return expiration;
    }
}
