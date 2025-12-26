package com.example.demo.service;
import com.example.demo.entity.TransferRecord;
import java.util.List;

public interface TransferRecordService {
    List<TransferRecord> getTransfersForAsset(Long assetId); // Added to satisfy implementation
}
