package com.example.demo.service;

import com.example.demo.entity.DisposalRecord;
import java.util.List;

public interface DisposalRecordService {
    List<DisposalRecord> getAllDisposals();
    DisposalRecord getDisposalById(Long id);
    DisposalRecord createDisposal(DisposalRecord disposal);
}
