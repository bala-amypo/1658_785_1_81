package com.example.demo.service.impl;

import com.example.demo.entity.Asset;
import com.example.demo.entity.TransferRecord;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.TransferRecordRepository;
import com.example.demo.service.TransferRecordService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class TransferRecordServiceImpl implements TransferRecordService {

    private final TransferRecordRepository transferRecordRepository;
    private final AssetRepository assetRepository;

    @Autowired
    public TransferRecordServiceImpl(TransferRecordRepository transferRecordRepository, AssetRepository assetRepository) {
        this.transferRecordRepository = transferRecordRepository;
        this.assetRepository = assetRepository;
    }

    @Override
    public TransferRecord createTransfer(Long assetId, TransferRecord transferRecord) {
        Optional<Asset> assetOpt = assetRepository.findById(assetId);
        if (assetOpt.isPresent()) {
            transferRecord.setAsset(assetOpt.get());
            return transferRecordRepository.save(transferRecord);
        } else {
            throw new RuntimeException("Asset not found");
        }
    }

    @Override
    public List<TransferRecord> getAllTransfers() {
        return transferRecordRepository.findAll();
    }

    @Override
    public TransferRecord getTransfer(Long id) {
        return transferRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transfer not found"));
    }
}
