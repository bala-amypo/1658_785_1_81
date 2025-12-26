package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Asset {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String assetTag;
    private String type;
    private String brand;
    private LocalDate purchaseDate;
    private String status;
    @ManyToOne
    private User owner;
    private LocalDateTime createdAt;

    public Asset() {}
    public Asset(Long id, String tag, String type, String brand, LocalDate date, String status, User owner, LocalDateTime created) {
        this.id = id; this.assetTag = tag; this.type = type; this.brand = brand;
        this.purchaseDate = date; this.status = status; this.owner = owner; this.createdAt = created;
    }
    // Standard Getters and Setters
}
