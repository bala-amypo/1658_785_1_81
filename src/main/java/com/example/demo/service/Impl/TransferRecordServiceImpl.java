package com.example.demo.service.Impl;

import com.example.demo.entity.Asset;
import com.example.demo.entity.TransferRecord;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.TransferRecordRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferRecordServiceImpl {

    @Autowired
    private TransferRecordRepository transferRecordRepository;

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private UserRepository userRepository;

    public List<TransferRecord> getAllTransfers() {
        return transferRecordRepository.findAll();
    }

    public TransferRecord createTransfer(TransferRecord transfer) {
        Asset asset = assetRepository.findById(transfer.getAsset().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));
        User fromUser = userRepository.findById(transfer.getTransferredBy().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        User toUser = userRepository.findById(transfer.getTransferredTo().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        transfer.setAsset(asset);
        transfer.setTransferredBy(fromUser);
        transfer.setTransferredTo(toUser);
        return transferRecordRepository.save(transfer);
    }
}
