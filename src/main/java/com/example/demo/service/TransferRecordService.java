package com.example.demo.service;

import com.example.demo.entity.TransferRecord;
import java.util.List;

public interface TransferRecordService {
    TransferRecord save(TransferRecord transfer);
    List<TransferRecord> getAll();
    void delete(Long id);
}
