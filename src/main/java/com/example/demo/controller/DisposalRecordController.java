package com.example.demo.controller;

import com.example.demo.entity.DisposalRecord;
import com.example.demo.service.DisposalRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/disposals")
public class DisposalRecordController {

    private final DisposalRecordService disposalRecordService;

    public DisposalRecordController(DisposalRecordService disposalRecordService) {
        this.disposalRecordService = disposalRecordService;
    }

    @PostMapping("/asset/{assetId}")
    public ResponseEntity<DisposalRecord> createDisposal(
            @PathVariable Long assetId,
            @RequestBody DisposalRecord disposalRecord) {

        DisposalRecord saved =
                disposalRecordService.createDisposal(assetId, disposalRecord);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalRecord> getDisposal(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                disposalRecordService.getDisposal(id));
    }
}
