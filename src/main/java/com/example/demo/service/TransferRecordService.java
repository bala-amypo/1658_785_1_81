package com.example.demo.service;

import com.example.demo.entity.TransferRecord;
import java.util.List;

public interface TransferRecordService {
    List<TransferRecord> getAllTransfers();
    TransferRecord getTransferById(Long id);
    TransferRecord createTransfer(TransferRecord transfer);
}
