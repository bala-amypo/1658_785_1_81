package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.DisposalRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.DisposalRecordRepository;
import com.example.demo.service.DisposalRecordService;

@Service
public class DisposalRecordServiceImpl implements DisposalRecordService {

    private final DisposalRecordRepository disposalRepository;
    private final AssetRepository assetRepository;
    private final UserRepository userRepository;

    public DisposalRecordServiceImpl(
            DisposalRecordRepository disposalRepository,
            AssetRepository assetRepository,
            UserRepository userRepository) {
        this.disposalRepository = disposalRepository;
        this.assetRepository = assetRepository;
        this.userRepository = userRepository;
    }

    public DisposalRecord createDisposal(Long assetId, DisposalRecord record) {

        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));

        User approver = userRepository.findById(record.getApprovedBy().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!"ADMIN".equals(approver.getRole()))
            throw new ValidationException("Approver must be ADMIN");

        if (record.getDisposalDate().isAfter(LocalDate.now()))
            throw new ValidationException("Disposal date cannot be in the future");

        record.setAsset(asset);
        record.setApprovedBy(approver);

        DisposalRecord saved = disposalRepository.save(record);

        asset.setStatus("DISPOSED");
        assetRepository.save(asset);

        return saved;
    }

    public DisposalRecord getDisposal(Long id) {
        return disposalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Disposal record not found"));
    }

    public List<DisposalRecord> getAllDisposals() {
        return disposalRepository.findAll();
    }
}
