package com.example.demo.service.impl;

import com.example.demo.entity.TransferRecord;
import com.example.demo.repository.TransferRecordRepository;
import com.example.demo.service.TransferRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferRecordServiceImpl implements TransferRecordService {

    private final TransferRecordRepository transferRecordRepository;

    @Override
    public TransferRecord createTransfer(Long assetId, TransferRecord record) {
        // You can link assetId to record here if needed
        return transferRecordRepository.save(record);
    }

    @Override
    public List<TransferRecord> getAllTransfers() {
        return transferRecordRepository.findAll();
    }

    @Override
    public TransferRecord getTransfer(Long id) {
        return transferRecordRepository.findById(id).orElse(null);
    }

    @Override
    public List<TransferRecord> getTransfersForAsset(Long assetId) {
        return transferRecordRepository.findByAssetId(assetId);
    }
}
