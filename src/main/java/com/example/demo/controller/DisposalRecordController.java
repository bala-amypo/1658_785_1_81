package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.service.DisposalRecordService;
import com.example.demo.entity.DisposalRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/disposals")
public class DisposalRecordController {

    private final DisposalRecordService disposalService;

    public DisposalRecordController(DisposalRecordService disposalService) {
        this.disposalService = disposalService;
    }

    @PostMapping("/{assetId}")
    public DisposalRecord createDisposal(@PathVariable Long assetId,
                                         @RequestBody DisposalRecord record) {
        return disposalService.createDisposal(assetId, record);
    }

    @GetMapping
    public List<DisposalRecord> getAllDisposals() {
        return disposalService.getAllDisposals();
    }

    @GetMapping("/{id}")
    public DisposalRecord getDisposal(@PathVariable Long id) {
        return disposalService.getDisposal(id);
    }
}
