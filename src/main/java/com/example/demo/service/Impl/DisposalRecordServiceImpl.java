package com.example.demo.service.Impl;

import com.example.demo.entity.Asset;
import com.example.demo.entity.DisposalRecord;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.DisposalRecordRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisposalRecordServiceImpl {

    @Autowired
    private DisposalRecordRepository disposalRecordRepository;

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private UserRepository userRepository;

    public List<DisposalRecord> getAllDisposals() {
        return disposalRecordRepository.findAll();
    }

    public DisposalRecord createDisposal(DisposalRecord record) {
        Asset asset = assetRepository.findById(record.getAsset().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));

        User approver = userRepository.findById(record.getApprovedBy().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        record.setAsset(asset);
        record.setApprovedBy(approver);

        return disposalRecordRepository.save(record);
    }
}
