package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data; // If using Lombok

@Entity
@Table(name = "users")
@Data // This automatically generates getUsername()
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    // IF YOU ARE NOT USING LOMBOK, UNCOMMENT THIS CODE:
    /*
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    */
}