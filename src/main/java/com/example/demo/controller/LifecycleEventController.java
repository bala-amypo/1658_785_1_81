package com.example.demo.controller;

import org.springframework.web.bind.annotation.LifecycleEventController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.service.LifecycleEventService;
import com.example.demo.entity.LifecycleEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
@RestController
@RequestMapping("/api/events")
public class LifecycleEventController{
    private final LifecycleEventService eventService;
    public LifecycleEventController(LifecycleEventService eventService){
    this.eventService=eventService;
    }
@PostMapping("/post/{assetId}/{userId}")
public LifecycleEvent sendData(@PathVariable Long userId,@RequestBody LifecycleEvent event){
    return eventService.logEvent(assetId,userId,event);

}
@GetMapping("/get/asset/{assetId}")
public List<LifecycleEvent>getval(@PathVariable Long assetId){
    return eventService.getEventsForAsset(assetId);
}

}