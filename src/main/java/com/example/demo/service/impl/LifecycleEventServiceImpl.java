package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import java.util.List;

public class LifecycleEventServiceImpl {

    LifecycleEventRepository lifecycleEventRepository;
    AssetRepository assetRepository;
    UserRepository userRepository;

    public LifecycleEvent logEvent(Long assetId, Long userId, LifecycleEvent event) {
        event.setAsset(assetRepository.findById(assetId).get());
        event.setPerformedBy(userRepository.findById(userId).get());
        return lifecycleEventRepository.save(event);
    }

    public List<LifecycleEvent> getEventsForAsset(Long assetId) {
        return lifecycleEventRepository.findByAsset_Id(assetId);
    }
}
