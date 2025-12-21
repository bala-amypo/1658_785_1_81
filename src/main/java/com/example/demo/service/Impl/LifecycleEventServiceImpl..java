package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Asset;
import com.example.demo.entity.LifecycleEvent;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.LifecycleEventRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LifecycleEventService;

@Service
public class LifecycleEventServiceImpl implements LifecycleEventService {

    private final LifecycleEventRepository eventRepo;
    private final AssetRepository assetRepo;
    private final UserRepository userRepo;

    public LifecycleEventServiceImpl(LifecycleEventRepository eventRepo,
                                     AssetRepository assetRepo,
                                     UserRepository userRepo) {
        this.eventRepo = eventRepo;
        this.assetRepo = assetRepo;
        this.userRepo = userRepo;
    }

    @Override
    public LifecycleEvent postData(int assetId, int userId, LifecycleEvent event) {

        Asset asset = assetRepo.findById((long) assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));

        event.setAsset(asset);
        event.setPerformedBy(userRepo.findById((long) userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found")));

        return eventRepo.save(event);
    }

    @Override
    public List<LifecycleEvent> getAllByAsset(int assetId) {
        return eventRepo.findByAssetId((long) assetId);
    }
}