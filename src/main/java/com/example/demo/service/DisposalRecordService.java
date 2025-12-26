package com.example.demo.service;

import com.example.demo.entity.DisposalRecord;

import java.util.List;

public interface DisposalRecordService {

    DisposalRecord createDisposalRecord(DisposalRecord disposalRecord);

    List<DisposalRecord> getAllDisposalRecords();

    DisposalRecord getDisposalRecord(Long id);
}
