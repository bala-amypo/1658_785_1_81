package com.example.demo.service.impl;

import com.example.demo.entity.LifecycleEvent;
import com.example.demo.repository.LifecycleEventRepository;
import com.example.demo.service.LifecycleEventService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LifecycleEventServiceImpl implements LifecycleEventService {
    private final LifecycleEventRepository lifecycleEventRepository;

    public LifecycleEventServiceImpl(LifecycleEventRepository lifecycleEventRepository) {
        this.lifecycleEventRepository = lifecycleEventRepository;
    }

    @Override
    public List<LifecycleEvent> getEventsForAsset(Long assetId) {
        return lifecycleEventRepository.findByAssetId(assetId);
    }

    @Override
    public LifecycleEvent logEvent(Long assetId, Long userId, LifecycleEvent event) {
        // ... your existing log logic ...
        return lifecycleEventRepository.save(event);
    }
}