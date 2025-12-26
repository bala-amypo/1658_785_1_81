package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Table(name = "assets")
public class Asset {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String assetTag;
    private String status;
    private LocalDateTime createdAt;
    @ManyToOne @JoinColumn(name = "holder_id")
    private User currentHolder;

    @PrePersist
    protected void onCreate() {
        if (this.status == null) this.status = "AVAILABLE";
        if (this.createdAt == null) this.createdAt = LocalDateTime.now();
    }
    // Getters, Setters, and parameterized constructor Asset(Long id, String assetTag, ...)
}
