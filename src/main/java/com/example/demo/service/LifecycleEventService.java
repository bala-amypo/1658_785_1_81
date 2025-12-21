package com.example.demo.service;

import com.example.demo.entity.LifecycleEvent;
import java.util.List;

public interface LifecycleEventService {
    List<LifecycleEvent> getAllEvents();
    LifecycleEvent getEventById(Long id);
    LifecycleEvent createEvent(LifecycleEvent event);
}
