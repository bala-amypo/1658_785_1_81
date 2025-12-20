package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.example.demo.entity.DisposalRecord;
@Repository
public interface DisposalRecordRepository extends JpaRepository< DisposalRecord,Long>{
    
}
