package com.example.demo.service.Impl;
import org.springframework.stereotype.Service;
import com.example.demo.service.LifecycleEventService;
import com.example.demo.entity.LifecycleEvent;
import com.example.demo.exception.ResourceNotException;

import com.example.demo.repository.UserRepository;
import java.util.List;
@Service
public class LifecycleEventServiceImp implements LifecycleEventService{
private final LifecycleEventRepository eventRepo;
private final final AssetRepository assetRepo;
private final final UserRepository userRepo;

public LifecycleEventServiceImpl(LifecycleEventRepository,eventRepo,AssetRepository assetRepo,UserRepository userRepo){
    this.userRepo=userRepo;
    this.assetRepo=assetRepo;
    this.eventRepo=eventRepo;
}
    @Override
public LifecycleEvent PostData(int assetId,int userId,LifecycleEvent event){
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