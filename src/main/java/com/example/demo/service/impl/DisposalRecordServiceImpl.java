package com.example.demo.service.impl;

import com.example.demo.entity.DisposalRecord;
import com.example.demo.exception.ResourceNotFoundException;
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
    public DisposalRecord createDisposalRecord(DisposalRecord disposalRecord) {
        return disposalRecordRepository.save(disposalRecord);
    }

    @Override
    public List<DisposalRecord> getAllDisposalRecords() {
        return disposalRecordRepository.findAll();
    }

    @Override
    public DisposalRecord getDisposalRecord(Long id) {
        return disposalRecordRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Disposal record not found"));
    }
}
