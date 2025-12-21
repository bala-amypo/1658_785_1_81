package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.TransferRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.TransferRecordRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TransferRecordService;
@Service
public class TransferRecordServiceImpl implements TransferRecordService {

    private final TransferRecordRepository transferRepository;
    private final AssetRepository assetRepository;
    private final UserRepository userRepository;

    public TransferRecordServiceImpl(
            TransferRecordRepository transferRepository,
            AssetRepository assetRepository,
            UserRepository userRepository) {
        this.transferRepository = transferRepository;
        this.assetRepository = assetRepository;
        this.userRepository = userRepository;
    }

    public TransferRecord createTransfer(Long assetId, TransferRecord record) {

        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));

        User approver = userRepository.findById(record.getApprovedBy().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!"ADMIN".equals(approver.getRole()))
            throw new ValidationException("Approver must be ADMIN");

        if (record.getFromDepartment().equals(record.getToDepartment()))
            throw new ValidationException("Departments must differ");

        if (record.getTransferDate().isAfter(LocalDate.now()))
            throw new ValidationException("Transfer date cannot be in the future");

        record.setAsset(asset);
        record.setApprovedBy(approver);
        return transferRepository.save(record);
    }

    public List<TransferRecord> getTransfersForAsset(Long assetId) {
        return transferRepository.findByAssetId(assetId);
    }

    public TransferRecord getTransfer(Long id) {
        return transferRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transfer record not found"));
    }
}
