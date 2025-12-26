package com.example.demo.service.impl;

import com.example.demo.entity.Asset;
import com.example.demo.entity.LifecycleEvent;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.LifecycleEventRepository;
import com.example.demo.service.LifecycleEventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LifecycleEventServiceImpl implements LifecycleEventService {

    private final LifecycleEventRepository lifecycleEventRepository;
    private final AssetRepository assetRepository;

    public LifecycleEventServiceImpl(
            LifecycleEventRepository lifecycleEventRepository,
            AssetRepository assetRepository) {
        this.lifecycleEventRepository = lifecycleEventRepository;
        this.assetRepository = assetRepository;
    }

    @Override
    public LifecycleEvent createLifecycleEvent(Long assetId, LifecycleEvent lifecycleEvent) {

        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Asset not found"));

        lifecycleEvent.setAsset(asset);
        return lifecycleEventRepository.save(lifecycleEvent);
    }

    @Override
    public List<LifecycleEvent> getAllLifecycleEvents() {
        return lifecycleEventRepository.findAll();
    }

    @Override
    public LifecycleEvent getLifecycleEvent(Long id) {
        return lifecycleEventRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Lifecycle event not found"));
    }
}
