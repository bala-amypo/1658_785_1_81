package com.example.demo.service.impl;

import com.example.demo.entity.TransferRecord;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.*;
import java.time.LocalDate;
import java.util.List;

public class TransferRecordServiceImpl {

    TransferRecordRepository transferRecordRepository;
    AssetRepository assetRepository;
    UserRepository userRepository;

    public TransferRecord createTransfer(Long assetId, TransferRecord transfer) {
        if (transfer.getTransferDate().isAfter(LocalDate.now()))
            throw new ValidationException("Transfer date cannot be in the future");

        transfer.setAsset(assetRepository.findById(assetId).get());
        return transferRecordRepository.save(transfer);
    }

    public List<TransferRecord> getTransfersForAsset(Long assetId) {
        return transferRecordRepository.findByAsset_Id(assetId);
    }
}
