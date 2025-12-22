package com.example.demo.controller;

import com.example.demo.dto.RegisterRequest; // [cite: 143]
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth") 
@Tag(name = "Authentication")
public class AuthController {
    private final UserService userService;
    public AuthController(UserService userService) { this.userService = userService; }

    @PostMapping("/register") 
    public User register(@RequestBody RegisterRequest req) {
        User user = new User();
        user.setEmail(req.getEmail());
        user.setFullName(req.getFullName());
        user.setDepartment(req.getDepartment());
        user.setPassword(req.getPassword());
        return userService.registerUser(user);
    }
}