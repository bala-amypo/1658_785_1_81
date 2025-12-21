package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "transfer_records")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TransferRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne @JoinColumn(name = "asset_id")
    private Asset asset;
    private String fromDepartment;
    private String toDepartment;
    private LocalDate transferDate;
    @ManyToOne @JoinColumn(name = "approved_by_id")
    private User approvedBy; // [cite: 106]
}