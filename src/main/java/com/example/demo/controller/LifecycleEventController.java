package com.example.demo.controller;

import com.example.demo.entity.LifecycleEvent;
import com.example.demo.service.Impl.LifecycleEventServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/lifecycle-events")
public class LifecycleEventController {

  
    @GetMapping
    public List<LifecycleEvent> getAllEvents() {
        return lifecycleService.getAllEvents();
    }

    @PostMapping
    public LifecycleEvent createEvent(@RequestBody LifecycleEvent event) {
        return lifecycleService.createEvent(event);
    }
}
