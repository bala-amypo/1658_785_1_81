package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String fullName;
    private String department;
    private String role; // ADMIN or USER
    private String password;
    private LocalDateTime createdAt;

    public User(Long id, String fullName, String email, String department, String role, String password, LocalDateTime createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.department = department;
        this.role = role;
        this.password = password;
        this.createdAt = createdAt;
    }

    @PrePersist
    protected void onCreate() {
        if (this.role == null) this.role = "USER"; [cite: 69]
        if (this.createdAt == null) this.createdAt = LocalDateTime.now(); [cite: 69]
    }
}