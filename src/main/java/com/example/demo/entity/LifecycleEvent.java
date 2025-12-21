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

@Entity
@Data
@Table(name = "lifecycle_events")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LifecycleEvent {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne @JoinColumn(name = "asset_id")
    private Asset asset; // [cite: 80]
    private String eventType; // [cite: 81]
    private String eventDescription;
    private LocalDateTime eventDate;
    @ManyToOne @JoinColumn(name = "user_id")
    private User performedBy; // [cite: 84]

    @PrePersist
    protected void onCreate() { if (eventDate == null) eventDate = LocalDateTime.now(); } // [cite: 94]
}