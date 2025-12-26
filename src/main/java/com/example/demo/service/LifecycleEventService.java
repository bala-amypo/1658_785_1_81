package com.example.demo.service;

import com.example.demo.entity.LifecycleEvent;

import java.util.List;

public interface LifecycleEventService {

    LifecycleEvent createLifecycleEvent(Long assetId, LifecycleEvent lifecycleEvent);

    List<LifecycleEvent> getAllLifecycleEvents();

    LifecycleEvent getLifecycleEvent(Long id);
}
