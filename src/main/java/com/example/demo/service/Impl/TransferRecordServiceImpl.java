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

    private final TransferRecordRepository transferRepo;
    private final AssetRepository assetRepo;
    private final UserRepository userRepo;

    public TransferRecordServiceImpl(TransferRecordRepository transferRepo,
                                     AssetRepository assetRepo,
                                     UserRepository userRepo) {
        this.transferRepo = transferRepo;
        this.assetRepo = assetRepo;
        this.userRepo = userRepo;
    }

    @Override
    public TransferRecord postData(int assetId, TransferRecord record) {

        if (record.getTransferDate().isAfter(LocalDate.now())) {
            throw new RuntimeException("Transfer date cannot be in the future");
        }

        record.setAsset(assetRepo.findById((long) assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found")));

        return transferRepo.save(record);
    }

    @Override
    public List<TransferRecord> getAllByAsset(int assetId) {
        return transferRepo.findByAssetId((long) assetId);
    }
}