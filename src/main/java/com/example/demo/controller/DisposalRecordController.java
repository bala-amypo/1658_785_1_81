package com.example.demo.controller;

import com.example.demo.entity.DisposalRecord;
import com.example.demo.service.DisposalRecordService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disposals")
@Tag(name = "Disposals")
public class DisposalRecordController {

    private final DisposalRecordService service;

    public DisposalRecordController(DisposalRecordService service) {
        this.service = service;
    }

    @PostMapping("/{assetId}")
    public DisposalRecord create(@PathVariable Long assetId,
                                 @RequestBody DisposalRecord record) {
        return service.createDisposal(assetId, record);
    }

    @Ge
