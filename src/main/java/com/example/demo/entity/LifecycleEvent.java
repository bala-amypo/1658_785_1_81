package com.example.demo.entity;
import lombok.Data;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.PrePersist;
@Entity
@Data
@Table(name = "lifecycle_events")
@Getter
 @Setter
  @NoArgsConstructor
   @AllArgsConstructor
public class LifecycleEvent {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
     @JoinColumn(name = "asset_id")
    private Asset asset; 
    private String eventType; 
    private String eventDescription;
    private LocalDateTime eventDate;
    @ManyToOne
     @JoinColumn(name = "user_id")
    private User performedBy;

    @PrePersist
    protected void onCreate() { if (eventDate == null) eventDate = LocalDateTime.now(); } 
}