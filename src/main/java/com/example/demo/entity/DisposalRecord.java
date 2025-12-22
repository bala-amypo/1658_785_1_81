package com.example.demo.entity;
import lombok.Data;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.Getter;
import jakarta.persistence.Setter;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Setter;


@Entity
@Data
@Table(name = "disposal_records")
@Getter
 @Setter
  @NoArgsConstructor
   @AllArgsConstructor
public class DisposalRecord {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne 
    @JoinColumn(name = "asset_id")
    private Asset asset; 
    private String disposalMethod; 
    private LocalDate disposalDate;
    @ManyToOne @JoinColumn(name = "approved_by_id")
    private User approvedBy;
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() { if (createdAt == null) createdAt = LocalDateTime.now(); }
}