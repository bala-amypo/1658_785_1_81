package com.example.demo.controller;

import org.springframework.web.bind.annotation.LifecycleEventController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.service.LifecycleEventService;
import com.example.demo.entity.LifecycleEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


import java.util.List;
@RestController
@RequestMapping("/api/events")
public class LifecycleEventController{
    private final LifecycleEventService eventService;
    public LifecycleEventController(LifecycleEventService eventService){
    this.eventService=eventService;
@PostMapping("/post/{assetId}/{userId}")
public LifecycleEvent sendData(@PathVariable Long userId,@RequestBody LifecycleEvent event){
    return eventService.logEvent(assetId,userId,event);
}

@GetMapping("/getid/{id}")
public Asset getdata(@PathVariable Long id){
    return assetService.getAsset(id);
}
@PutMapping("/putid/{id}")
public Asset putval(@PathVariable Long id,@RequestBody String status){
    return assetService.updateStatus(id,status);
}
}