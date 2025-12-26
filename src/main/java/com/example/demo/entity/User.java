package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;      // Fixed: Missing getEmail()/setEmail()
    private String fullName;   // Fixed: Missing setFullName()
    private String department; // Fixed: Missing setDepartment()
    private String role;       // Fixed: Missing getRole()
}