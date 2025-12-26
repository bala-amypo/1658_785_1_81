package com.example.demo.service.impl;

import com.example.demo.entity.Asset;
import com.example.demo.entity.TransferRecord;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.TransferRecordRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TransferRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransferRecordServiceImpl implements TransferRecordService {

    private final TransferRecordRepository transferRecordRepository;
    private final AssetRepository assetRepository;
    private final UserRepository userRepository;

    // Strict constructor order for TestNG injection
    public TransferRecordServiceImpl(TransferRecordRepository transferRecordRepository, 
                                     AssetRepository assetRepository, 
                                     UserRepository userRepository) {
        this.transferRecordRepository = transferRecordRepository;
        this.assetRepository = assetRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public TransferRecord createTransfer(Long assetId, Long approvedById, String fromDep, String toDep, LocalDate date) {
        if (fromDep.equals(toDep)) {
            throw new ValidationException("Source and target departments must differ");
        }
        if (date != null && date.isAfter(LocalDate.now())) {
            throw new ValidationException("Transfer date cannot be in the future");
        }

        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));
        User admin = userRepository.findById(approvedById)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!"ADMIN".equals(admin.getRole())) {
            throw new ValidationException("Approver must be admin");
        }

        TransferRecord record = new TransferRecord(null, asset, fromDep, toDep, date, admin);
        
        // Update asset status as per lifecycle rules
        asset.setStatus("TRANSFERRED");
        assetRepository.save(asset);

        return transferRecordRepository.save(record);
    }

    @Override
    public List<TransferRecord> getTransfersForAsset(Long assetId) {
        return transferRecordRepository.findByAssetId(assetId);
    }
}
