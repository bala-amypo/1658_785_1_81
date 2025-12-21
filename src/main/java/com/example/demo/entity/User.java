package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email; // [cite: 57]
    private String fullName;
    private String department;
    private String role; // ADMIN or USER [cite: 59]
    private String password;
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        if (this.role == null) this.role = "USER"; // [cite: 69]
        if (this.createdAt == null) this.createdAt = LocalDateTime.now(); // [cite: 69]
    }
}