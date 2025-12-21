package com.example.demo.service.Impl;

import com.example.demo.entity.DisposalRecord;
import com.example.demo.repository.DisposalRecordRepository;
import com.example.demo.service.DisposalRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisposalRecordServiceImpl implements DisposalRecordService {

    private final DisposalRecordRepository repository;

    public DisposalRecordServiceImpl(DisposalRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public DisposalRecord createDisposal(DisposalRecord disposal) {
        return repository.save(disposal);
    }

    @Override
    public List<DisposalRecord> getAllDisposals() {
        return repository.findAll();
    }

    @Override
    public DisposalRecord getDisposalById(Long id) {
        return repository.findById(id).orElse(null);
    }

   
@Override
public DisposalRecord updateDisposal(Long id, DisposalRecord disposal) {
    return repository.save(disposal);
}

    @Override
    public void deleteDisposal(Long id) {
        repository.deleteById(id);
    }
}
