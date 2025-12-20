package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.example.demo.entity.TransferRecord;
import java.util.List;
@Repository
public interface TransferRecordRepository extends JpaRepository<TransferRecord,Long>{
List<TransferRecord> findByAssetId(Long assetId);
    
}
