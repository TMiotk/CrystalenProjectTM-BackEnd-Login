package com.cptm.backend.login.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public static final String COMPANY_DOMAIN = "@crystalenproject.com";
    public static final String SUCCESS_MESSAGE = "Firma Crystalen Project TM pozdrawia !";
    public static final String FAILURE_MESSAGE = "You are not registered in company database";

    public boolean isCompanyEmail(String email) {
        return email != null && email.endsWith(COMPANY_DOMAIN);
    }
}