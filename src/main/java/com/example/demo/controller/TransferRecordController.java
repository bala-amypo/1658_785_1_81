package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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