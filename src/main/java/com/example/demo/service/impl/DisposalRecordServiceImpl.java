package com.example.demo.service.impl;

import com.example.demo.entity.DisposalRecord;
import com.example.demo.repository.DisposalRecordRepository;
import com.example.demo.service.DisposalRecordService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DisposalRecordServiceImpl implements DisposalRecordService {
    private final DisposalRecordRepository disposalRecordRepository;

    public DisposalRecordServiceImpl(DisposalRecordRepository disposalRecordRepository) {
        this.disposalRecordRepository = disposalRecordRepository;
    }

    @Override
    public List<DisposalRecord> getAllDisposals() {
        return disposalRecordRepository.findAll();
    }

    @Override
    public DisposalRecord createDisposal(Long assetId, DisposalRecord disposal) {
        // ... your existing create logic ...
        return disposalRecordRepository.save(disposal);
    }
}