package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.*;
import com.example.demo.repository.*;
import com.example.demo.service.TransferRecordService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class TransferRecordServiceImpl implements TransferRecordService {
    private final TransferRecordRepository transferRecordRepository;
    private final AssetRepository assetRepository;
    private final UserRepository userRepository;

    public TransferRecordServiceImpl(TransferRecordRepository transferRecordRepository, 
                                     AssetRepository assetRepository, 
                                     UserRepository userRepository) {
        this.transferRecordRepository = transferRecordRepository;
        this.assetRepository = assetRepository;
        this.userRepository = userRepository;
    }

    public TransferRecord executeTransfer(Long assetId, Long adminId, String fromDep, String toDep, LocalDate date) {
        if (fromDep.equals(toDep)) throw new ValidationException("Departments must differ");
        if (date.isAfter(LocalDate.now())) throw new ValidationException("Transfer date cannot be in the future");
        
        Asset asset = assetRepository.findById(assetId)
            .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));
        User admin = userRepository.findById(adminId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        if (!"ADMIN".equals(admin.getRole())) throw new ValidationException("Approver must be admin");

        return transferRecordRepository.save(new TransferRecord(null, asset, fromDep, toDep, date, admin));
    }
}
