package com.example.demo.service.Impl;
import org.springframework.stereotype.Service;
import com.example.demo.service.TransferRecordService;
import com.example.demo.entity.TransferRecord;
import com.example.demo.exception.ResourceNotException;

import com.example.demo.repository.TransferRecordRepository;
import java.util.List;
@Service
public class TransferRecordServiceImp implements TransferRecordService{
private final TransferRecordRepository transferRepo;
private final final AssetRepository assetRepo;
private final final UserRepository userRepo;

public TransferRecordServiceImpl(TransferRecordRepository,transferRepo,AssetRepository assetRepo,UserRepository userRepo){
    this.userRepo=userRepo;
    this.assetRepo=assetRepo;
    this.transferRepo=transferRepo;
}
    @Override
public TransferRecord PostData(int assetId,TransferRecord record){
    Asset asset=assetRepo.findById((long)id).orElseThrow(()->new ResorceNotFoundException("Asset not found")
user admin=userRepo.findById(record.getApprovedBy().getId()).orElseThrow(()->new ResorceNotFoundException("User not found"));
if(!"ADMIN".equals(admin.getRole())){
    throw new ValidatinException("Approver must be ADMIN");
}
if(record.getFromDepartment().equals(record.getToDepartment())){
    throw new ValidatinException("Departments must differ");
    }
    if(record.getTransferDate().isAfter(LocalDate.now())){
    throw new ValidationException("Transfer date cannot be in the future");
    }
record.setAsset(asset);
record.setApprovedBy(admin);
return transferRepo.save(record);
}

@Override
public List<TransferRecord>getValByAsset(int assetId){
return transferRepo.findByAssetId((long)assetId);
}

}