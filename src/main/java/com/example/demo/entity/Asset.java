


package com.example.demo.entity;
import lombok.Data;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "assets")
@Getter
@Setter
 @NoArgsConstructor
 @AllArgsConstructor
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String assetTag; 
    private String assetType; 
    private String model;
    private LocalDate purchaseDate;
    private String status; 

    @ManyToOne
    @JoinColumn(name = "current_holder_id")
    private User currentHolder; 
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        if (this.status == null) 
        this.status = "AVAILABLE"; 
        if (this.createdAt == null) 
        this.createdAt = LocalDateTime.now(); 
    }
}