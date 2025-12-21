
package com.example.demo.service.impl;

import com.example.demo.entity.TransferRecord;
import com.example.demo.entity.User;
import com.example.demo.exception.*;
import com.example.demo.repository.*;
import com.example.demo.service.TransferRecordService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class TransferRecordServiceImpl implements TransferRecordService {
    private final TransferRecordRepository transferRecordRepository;
    private final AssetRepository assetRepository;
    private final UserRepository userRepository;

    public TransferRecordServiceImpl(TransferRecordRepository trr, AssetRepository ar, UserRepository ur) { // [cite: 24]
        this.transferRecordRepository = trr;
        this.assetRepository = ar;
        this.userRepository = ur;
    }

    @Override
    public TransferRecord createTransfer(Long assetId, TransferRecord record) {
        if (record.getFromDepartment().equals(record.getToDepartment())) throw new ValidationException("Departments must differ"); // [cite: 114, 237]
        if (record.getTransferDate().isAfter(LocalDate.now())) throw new ValidationException("Transfer date cannot be in the future"); // [cite: 116, 238]
        
        User admin = userRepository.findById(record.getApprovedBy().getId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        if (!"ADMIN".equals(admin.getRole())) throw new ValidationException("Approver must be ADMIN"); // [cite: 115, 236]

        record.setAsset(assetRepository.findById(assetId).orElseThrow(() -> new ResourceNotFoundException("Asset not found")));
        return transferRecordRepository.save(record);
    }
}