package com.kk.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring Security JWT OAuth2 Learning Project";
    }

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello! JWT authentication successful.";
    }

    @GetMapping("/api/admin")
    public String admin() {
        return "Hello Admin";
    }
}
