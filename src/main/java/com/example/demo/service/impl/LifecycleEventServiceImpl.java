package com.example.demo.service.impl;

import com.example.demo.entity.LifecycleEvent;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.LifecycleEventService;
import org.springframework.stereotype.Service;

@Service
public class LifecycleEventServiceImpl implements LifecycleEventService {
    private final LifecycleEventRepository lifecycleEventRepository;
    private final AssetRepository assetRepository;
    private final UserRepository userRepository;

    public LifecycleEventServiceImpl(LifecycleEventRepository ler, AssetRepository ar, UserRepository ur) { // [cite: 23]
        this.lifecycleEventRepository = ler;
        this.assetRepository = ar;
        this.userRepository = ur;
    }

    @Override
    public LifecycleEvent logEvent(Long assetId, Long userId, LifecycleEvent event) {
        event.setAsset(assetRepository.findById(assetId).orElseThrow(() -> new ResourceNotFoundException("Asset not found"))); // [cite: 96, 221]
        event.setPerformedBy(userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"))); // [cite: 96, 221]
        return lifecycleEventRepository.save(event);
    }
}