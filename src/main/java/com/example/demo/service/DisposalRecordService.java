package com.example.demo.service;

import com.example.demo.entity.DisposalRecord;
import java.util.List;

public interface DisposalRecordService {
    DisposalRecord createDisposal(DisposalRecord disposal);
    List<DisposalRecord> getAllDisposals();
    DisposalRecord getDisposalById(Long id);
    DisposalRecord updateDisposal(Long id, DisposalRecord disposal); // must exist
    void deleteDisposal(Long id); // must exist
}
