package com.example.demo.controller;

import com.example.demo.entity.TransferRecord;
import com.example.demo.service.TransferRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class TransferRecordController {

    private final TransferRecordService service;

    @Autowired
    public TransferRecordController(TransferRecordService service) {
        this.service = service;
    }

    @PostMapping("/{assetId}")
    public TransferRecord createTransfer(@PathVariable Long assetId, @RequestBody TransferRecord transferRecord) {
        return service.createTransfer(assetId, transferRecord);
    }

    @GetMapping
    public List<TransferRecord> getAllTransfers() {
        return service.getAllTransfers();
    }

    @GetMapping("/{id}")
    public TransferRecord getTransfer(@PathVariable Long id) {
        return service.getTransfer(id);
    }

    @GetMapping("/asset/{assetId}")
    public List<TransferRecord> getTransfersForAsset(@PathVariable Long assetId) {
        return service.getTransfersForAsset(assetId);
    }
}
