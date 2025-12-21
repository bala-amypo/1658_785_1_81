package com.example.demo.controller;

import com.example.demo.entity.LifecycleEvent;
import com.example.demo.service.LifecycleEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lifecycle")
public class LifecycleEventController {

    private final LifecycleEventService lifecycleService;

    public LifecycleEventController(LifecycleEventService lifecycleService) {
        this.lifecycleService = lifecycleService;
    }

    @PostMapping
    public LifecycleEvent save(@RequestBody LifecycleEvent event) {
        return lifecycleService.save(event);
    }

    @GetMapping
    public List<LifecycleEvent> getAll() {
        return lifecycleService.getAll();
    }
}
