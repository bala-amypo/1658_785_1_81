package com.example.demo.service.Impl;
import org.springframework.stereotype.Service;
import com.example.demo.service.DisposalRecordService;
import com.example.demo.entity.DisposalRecord;
import com.example.demo.exception.ResourceNotException;

import com.example.demo.repository.DisposalRecordRepository;
import java.util.List;
@Service
public class DisposalRecordServiceImp implements DisposalRecordService{
private final DisposalRecordRepository disposalRepo;
private final AssetRepository assetRepo;
private final UserRepository userRepo;

public DisposalRecordServiceImpl(DisposalRecordRepository disposalRepo,AssetRepository assetRepo,UserRepository userRepo){
    this.userRepo=userRepo;
    this.assetRepo=assetRepo;
    this.disposalRepo=disposalRepo;
}
    @Override
public  DisposalRecord PostData(int assetId, DisposalRecord record){
    Asset asset=assetRepo.findById((long)id).orElseThrow(()->new ResorceNotFoundException("Asset not found")
user admin=userRepo.findById(record.getApprovedBy().getId()).orElseThrow(()->new ResorceNotFoundException("User not found"));
if(!"ADMIN".equals(admin.getRole())){
    throw new ValidatinException("Approver must be ADMIN");
}
if(record.getDisposalDate().isAfter(LocalDate.now())){
    throw new ValidatinException("Disposal date cannot be in the future");
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