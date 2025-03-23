package com.hrportal.controller;

import com.hrportal.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://127.0.0.1:5501") 

@RestController
@RequestMapping("/hr")
public class HrController {

    @Autowired
    private HrService hrService;

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        boolean isAuthenticated = hrService.login(email, password);
        if (isAuthenticated) {
            return "Login successful!";
        } else {
            return "Invalid email or password!";
        }
    }
    
}
