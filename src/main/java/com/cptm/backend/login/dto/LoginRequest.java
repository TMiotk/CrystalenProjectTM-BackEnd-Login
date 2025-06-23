package com.cptm.backend.login.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
  
	@NotBlank
	@Email
    private String email;

    // Getter and Setter
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}