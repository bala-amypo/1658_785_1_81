package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;

public class DisposalRecordServiceImpl {

    DisposalRecordRepository disposalRecordRepository;
    AssetRepository assetRepository;
    UserRepository userRepository;

    public DisposalRecord createDisposal(Long assetId, DisposalRecord disposal) {
        Asset asset = assetRepository.findById(assetId).get();
        asset.setStatus("DISPOSED");
        assetRepository.save(asset);
        disposal.setAsset(asset);
        return disposalRecordRepository.save(disposal);
    }

    public DisposalRecord getDisposal(Long id) {
        return disposalRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Disposal record not found"));
    }
}
