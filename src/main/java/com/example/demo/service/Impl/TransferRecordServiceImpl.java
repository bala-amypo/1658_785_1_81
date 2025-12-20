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

public TransferRecordServiceImpl(TransferRecordRepository,eventRepo,AssetRepository assetRepo,UserRepository userRepo){
    this.userRepo=userRepo;
    this.assetRepo=assetRepo;
    this.eventRepo=eventRepo;
}
    @Override
public LifecycleEven PostData(int assetId,int userId,LifecycleEven event){
    Asset asset=assetRepo.findById((long)id).orElseThrow(()->new ResorceNotFoundException("Asset not found")

if(event).getEventType()==null){
    throw new ValidatinException("Event details is required");
}
event.setAsset(asset);
event.setPerformedBy(user);
return eventRepo.save(event);
}

@Override
public List<LifecycleEvent>getValByAsset(int assetId){
return eventRepo.findByAssetId((long)assetId);
}

}