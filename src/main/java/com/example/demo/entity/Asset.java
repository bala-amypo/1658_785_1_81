package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "assets")
@Getter @Setter @NoArgsConstructor
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String assetTag;

    private String assetType; // LAPTOP, DESKTOP, etc.
    private String model;
    private LocalDate purchaseDate;
    private String status; // AVAILABLE, ASSIGNED, etc.

    @ManyToOne
    @JoinColumn(name = "current_holder_id")
    private User currentHolder;

    private LocalDateTime createdAt;

    public Asset(Long id, String assetTag, String assetType, String model, LocalDate purchaseDate, String status, User currentHolder, LocalDateTime createdAt) {
        this.id = id;
        this.assetTag = assetTag;
        this.assetType = assetType;
        this.model = model;
        this.purchaseDate = purchaseDate;
        this.status = status;
        this.currentHolder = currentHolder;
        this.createdAt = createdAt;
    }

    @PrePersist
    protected void onCreate() {
        if (this.status == null) this.status = "AVAILABLE"; [cite: 50]
        if (this.createdAt == null) this.createdAt = LocalDateTime.now(); [cite: 50]
    }
}