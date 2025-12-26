package com.example.demo.controller;

import com.example.demo.entity.TransferRecord;
import com.example.demo.service.TransferRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class TransferRecordController {

    private final TransferRecordService transferRecordService;

    public TransferRecordController(TransferRecordService transferRecordService) {
        this.transferRecordService = transferRecordService;
    }

    @PostMapping("/asset/{assetId}")
    public ResponseEntity<TransferRecord> createTransfer(
            @PathVariable Long assetId,
            @RequestBody TransferRecord transferRecord) {

        TransferRecord saved =
                transferRecordService.createTransfer(assetId, transferRecord);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/asset/{assetId}")
    public ResponseEntity<List<TransferRecord>> getTransfersForAsset(
            @PathVariable Long assetId) {

        return ResponseEntity.ok(
                transferRecordService.getTransfersForAsset(assetId));
    }
}
