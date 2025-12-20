package com.example.demo.service;

import com.example.demo.entity.TransferRecord;
import java.util.List;
public interface TransferRecordService{
TransferRecord PostData(Long assetId,TransferRecord record);
List<TransferRecord>getval(Long assetId);
TransferRecord getdata(Long id);
}