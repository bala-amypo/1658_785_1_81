package com.example.demo.controller;

import com.example.demo.entity.LifecycleEvent;
import com.example.demo.service.LifecycleEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lifecycle")
public class LifecycleEventController {

    private final LifecycleEventService service;

    public LifecycleEventController(LifecycleEventService service) {
        this.service = service;
    }

    // 1️⃣ Log a new lifecycle event
    @PostMapping("/asset/{assetId}/user/{userId}")
    public ResponseEntity<LifecycleEvent> logEvent(
            @PathVariable Long assetId,
            @PathVariable Long userId,
            @RequestBody LifecycleEvent lifecycleEvent) {

        LifecycleEvent savedEvent = service.logEvent(assetId, userId, lifecycleEvent);
        return ResponseEntity.ok(savedEvent);
    }

    // 2️⃣ Get all events for a specific asset
    @GetMapping("/asset/{assetId}")
    public ResponseEntity<List<LifecycleEvent>> getEventsForAsset(@PathVariable Long assetId) {
        List<LifecycleEvent> events = service.getEventsForAsset(assetId);
        return ResponseEntity.ok(events);
    }

    // 3️⃣ Get a specific lifecycle event by its ID
    @GetMapping("/{id}")
    public ResponseEntity<LifecycleEvent> getEvent(@PathVariable Long id) {
        LifecycleEvent event = service.getEvent(id);
        return ResponseEntity.ok(event);
    }
}
