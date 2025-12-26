package com.example.demo.service.impl;

import com.example.demo.entity.TransferRecord;
import com.example.demo.entity.User;
import com.example.demo.repository.TransferRecordRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TransferRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferRecordServiceImpl implements TransferRecordService {

    private final TransferRecordRepository transferRecordRepository;
    private final UserRepository userRepository;

    @Override
    public TransferRecord createTransfer(Long userId, TransferRecord transferRecord) {
        User user = userRepository.findById(userId).orElseThrow();
        transferRecord.setUser(user);
        return transferRecordRepository.save(transferRecord);
    }

    @Override
    public List<TransferRecord> getAllTransfers() {
        return transferRecordRepository.findAll();
    }

    @Override
    public TransferRecord getTransfer(Long id) {
        return transferRecordRepository.findById(id).orElseThrow();
    }
}
