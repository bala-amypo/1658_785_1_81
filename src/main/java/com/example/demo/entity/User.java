package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String department;
    private String role;
    private String password;
    @OneToMany(mappedBy = "owner")
    private List<Asset> assets;

    public User() {}
    public User(Long id, String name, String email, String department, String role, String password, List<Asset> assets) {
        this.id = id; this.name = name; this.email = email; this.department = department; 
        this.role = role; this.password = password; this.assets = assets;
    }
    // Standard Getters and Setters
}
