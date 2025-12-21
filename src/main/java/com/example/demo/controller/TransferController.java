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
@RequestMapping("/api/transfers")
public class TransferRecordController {

    private final TransferRecordService transferService;

    public TransferRecordController(TransferRecordService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/{assetId}")
    public TransferRecord createTransfer(@PathVariable Long assetId,
                                         @RequestBody TransferRecord record) {
        return transferService.createTransfer(assetId, record);
    }

    @GetMapping("/asset/{assetId}")
    public List<TransferRecord> getTransfersForAsset(@PathVariable Long assetId) {
        return transferService.getTransfersForAsset(assetId);
    }

    @GetMapping("/{id}")
    public TransferRecord getTransfer(@PathVariable Long id) {
        return transferService.getTransfer(id);
    }
}