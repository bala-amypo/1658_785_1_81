package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.TransferRecord;

public interface TransferRecordRepository extends JpaRepository<TransferRecord, Long> {

    // Original JPA method
    List<TransferRecord> findByAsset_Id(Long assetId);

    // Alias used in services/tests
    List<TransferRecord> findByAssetId(Long assetId);
}
