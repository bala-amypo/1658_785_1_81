package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.*;
import com.example.demo.repository.*;
import com.example.demo.service.DisposalRecordService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class DisposalRecordServiceImpl implements DisposalRecordService {
    private final DisposalRecordRepository disposalRecordRepository;
    private final AssetRepository assetRepository;
    private final UserRepository userRepository;

    public DisposalRecordServiceImpl(DisposalRecordRepository drr, AssetRepository ar, UserRepository ur) { // [cite: 25]
        this.disposalRecordRepository = drr;
        this.assetRepository = ar;
        this.userRepository = ur;
    }

    @Override
    public DisposalRecord createDisposal(Long assetId, DisposalRecord disposal) {
        Asset asset = assetRepository.findById(assetId).orElseThrow(() -> new ResourceNotFoundException("Asset not found")); // [cite: 250]
        if (disposal.getDisposalDate().isAfter(LocalDate.now())) throw new ValidationException("Future disposal date"); // [cite: 136, 253]

        asset.setStatus("DISPOSED"); // [cite: 138, 255]
        assetRepository.save(asset);

        disposal.setAsset(asset);
        return disposalRecordRepository.save(disposal);
    }
}