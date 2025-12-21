package com.example.demo.controller;

import com.example.demo.entity.LifecycleEvent;
import com.example.demo.service.impl.LifecycleEventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lifecycle-events")
public class LifecycleEventController {

    @Autowired
    private LifecycleEventServiceImpl lifecycleService;

    @GetMapping
    public List<LifecycleEvent> getAllEvents() {
        return lifecycleService.getAllEvents();
    }

    @PostMapping
    public LifecycleEvent createEvent(@RequestBody LifecycleEvent event) {
        return lifecycleService.createEvent(event);
    }
}
