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

    private final LifecycleEventRepository eventRepository;
    private final AssetRepository assetRepository;
    private final UserRepository userRepository;

    public LifecycleEventServiceImpl(
            LifecycleEventRepository eventRepository,
            AssetRepository assetRepository,
            UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.assetRepository = assetRepository;
        this.userRepository = userRepository;
    }

    public LifecycleEvent logEvent(Long assetId, Long userId, LifecycleEvent event) {

        if (event.getEventType() == null)
            throw new ValidationException("Event type is required");

        if (event.getEventDescription() == null || event.getEventDescription().isEmpty())
            throw new ValidationException("Event description is required");

        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        event.setAsset(asset);
        event.setPerformedBy(user);
        return eventRepository.save(event);
    }

    public List<LifecycleEvent> getEventsForAsset(Long assetId) {
        return eventRepository.findByAssetId(assetId);
    }

    public LifecycleEvent getEvent(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lifecycle event not found"));
    }
}
