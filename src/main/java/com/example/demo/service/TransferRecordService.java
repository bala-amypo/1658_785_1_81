package com.example.demo.service;

import com.example.demo.entity.TransferRecord;
import java.util.List;
public interface TransferRecordService{
TransferRecord PostData(Long assetId,Long userId,LiecycleEvent event);
List<TransferRecord>getval(Long assetId);
TransferRecord getdata(Long id);
}