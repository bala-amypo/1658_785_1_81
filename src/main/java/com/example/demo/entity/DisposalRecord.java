package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "disposal_records")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DisposalRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne @JoinColumn(name = "asset_id")
    private Asset asset; // [cite: 123]
    private String disposalMethod; // RECYCLED, SOLD, etc. [cite: 124]
    private LocalDate disposalDate;
    @ManyToOne @JoinColumn(name = "approved_by_id")
    private User approvedBy;
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() { if (createdAt == null) createdAt = LocalDateTime.now(); } // [cite: 139]
}