package com.example.demo.service.impl;

import com.example.demo.entity.Asset;
import com.example.demo.entity.DisposalRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.DisposalRecordRepository;
import com.example.demo.service.DisposalRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisposalRecordServiceImpl implements DisposalRecordService {

    private final DisposalRecordRepository disposalRecordRepository;
    private final AssetRepository assetRepository;

    public DisposalRecordServiceImpl(
            DisposalRecordRepository disposalRecordRepository,
            AssetRepository assetRepository) {
        this.disposalRecordRepository = disposalRecordRepository;
        this.assetRepository = assetRepository;
    }

    @Override
    public DisposalRecord createDisposal(Long assetId, DisposalRecord disposalRecord) {

        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Asset not found"));

        disposalRecord.setAsset(asset);
        return disposalRecordRepository.save(disposalRecord);
    }

    @Override
    public List<DisposalRecord> getAllDisposals() {
        return disposalRecordRepository.findAll();
    }

    @Override
    public DisposalRecord getDisposal(Long id) {
        return disposalRecordRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Disposal record not found"));
    }
}

