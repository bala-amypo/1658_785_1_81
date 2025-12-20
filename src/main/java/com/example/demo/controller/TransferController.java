package com.example.demo.controller;

import org.springframework.web.bind.annotation.TransferController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.service.TransferRecordService;
import com.example.demo.entity.TransferRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
@RestController
@RequestMapping("/api/events")
public class TransferController{
    private final TransferRecordService eventService;
    public TransferRecordController(TransferRecordService eventService){
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