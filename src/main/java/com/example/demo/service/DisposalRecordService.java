package com.example.demo.service;

import com.example.demo.entity.DisposalRecord;
import java.util.List;
public interface DisposalRecordService{
DisposalRecord PostData(Long assetId,DisposalRecord disposal);
List<DisposalRecord>getval();
DisposalRecord getdata(Long id);
}