package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String assetTag;
    private String category;
    private String manufacturer;
    private LocalDate purchaseDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User currentHolder;
    
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (this.status == null) this.status = "AVAILABLE";
        this.createdAt = LocalDateTime.now();
    }
}