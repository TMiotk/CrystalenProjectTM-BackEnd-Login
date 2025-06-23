package com.cptm.backend.login.controller;


import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {

 @PostMapping("/login")
 public Map<String, String> login(@RequestBody Map<String, String> body) {
     String email = body.get("email");
     if (email != null && email.toLowerCase().endsWith("@crystalenproject.com")) {
         return Map.of("message", "Firma Crystalen Project TM pozdrawia !");
     } else {
         return Map.of("message", "You are not registered in company database");
     }
 }
}
