package com.example.demo.repository;

import com.example.demo.entity.TransferRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRecordRepository extends JpaRepository<TransferRecord, Long> {
}
