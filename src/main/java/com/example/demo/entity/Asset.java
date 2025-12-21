package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "assets")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String assetTag; //
    private String assetType; // LAPTOP, DESKTOP, etc.
    private String model;
    private LocalDate purchaseDate;
    private String status; //

    @ManyToOne
    @JoinColumn(name = "current_holder_id")
    private User currentHolder; //
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        if (this.status == null) this.status = "AVAILABLE"; //
        if (this.createdAt == null) this.createdAt = LocalDateTime.now(); //
    }
}