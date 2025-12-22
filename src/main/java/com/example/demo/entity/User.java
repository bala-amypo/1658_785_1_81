package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Getter
 @Setter
  @NoArgsConstructor
   @AllArgsConstructor
public class User {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String fullName;
    private String department;
    private String role;
    private String password;
    private LocalDateTime createdAt;
}