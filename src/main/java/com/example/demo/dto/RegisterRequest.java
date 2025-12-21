package com.example.demo.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String fullName;
    private String department;
    private String password;
}