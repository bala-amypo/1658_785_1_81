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

    private final DisposalRecordRepository disposalRepo;
    private final AssetRepository assetRepo;

    public DisposalRecordServiceImpl(DisposalRecordRepository disposalRepo,
        AssetRepository assetRepo) {
        this.disposalRepo = disposalRepo;
        this.assetRepo = assetRepo;
    }

    @Override
    public DisposalRecord postData(int assetId, DisposalRecord record) {

        if (record.getDisposalDate().isAfter(LocalDate.now())) {
            throw new RuntimeException("Disposal date cannot be in the future");
        }

        record.setAsset(
                assetRepo.findById((long) assetId)
                        .orElseThrow(() -> new ResourceNotFoundException("Asset not found"))
        );

        return disposalRepo.save(record);
    }

    @Override
    public List<DisposalRecord> getAllByAsset(int assetId) {
        return disposalRepo.findByAssetId((long) assetId);
    }
}