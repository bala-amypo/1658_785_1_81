package com.example.demo.service.impl;

import com.example.demo.entity.Asset;
import com.example.demo.entity.LifecycleEvent;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.LifecycleEventRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LifecycleEventServiceImpl {

    @Autowired
    private LifecycleEventRepository lifecycleEventRepository;

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private UserRepository userRepository;

    public List<LifecycleEvent> getAllEvents() {
        return lifecycleEventRepository.findAll();
    }

    public LifecycleEvent createEvent(LifecycleEvent event) {
        Asset asset = assetRepository.findById(event.getAsset().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));

        User user = userRepository.findById(event.getCreatedBy().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        event.setAsset(asset);
        event.setCreatedBy(user);

        return lifecycleEventRepository.save(event);
    }
}
