// Copyright © Tomasz Miotk, Crystalen Project TM.
// This code is proprietary and for viewing purposes only.
// Copying, editing, or distributing any part of this code is strictly prohibited without explicit permission from the author.

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