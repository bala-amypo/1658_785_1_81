package com.example.demo.controller;

import com.example.demo.entity.TransferRecord;
import com.example.demo.service.TransferRecordService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transfers") 
@Tag(name = "Transfers")
public class TransferRecordController {
    private final TransferRecordService service;
    public TransferRecordController(TransferRecordService service) { this.service = service; }

    @PostMapping("/{assetId}") 
    public TransferRecord create(@PathVariable Long assetId, @RequestBody TransferRecord record) {
        return service.createTransfer(assetId, record);
    }
    
    }

  