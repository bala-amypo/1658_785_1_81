package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String department;
    private String role;
    private String password;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (this.role == null) this.role = "USER";
        this.createdAt = LocalDateTime.now();
    }
}