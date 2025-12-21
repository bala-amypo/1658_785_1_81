package com.example.demo.controller;

import com.example.demo.entity.DisposalRecord;
import com.example.demo.service.DisposalRecordService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/disposals") // [cite: 328]
@Tag(name = "Disposals")
public class DisposalRecordController {
    private final DisposalRecordService service;
    public DisposalRecordController(DisposalRecordService service) { this.service = service; }

    @PostMapping("/{assetId}") // [cite: 331]
    public DisposalRecord create(@PathVariable Long assetId, @RequestBody DisposalRecord disposal) {
        return service.createDisposal(assetId, disposal);
    }

    @GetMapping // [cite: 335]
    public List<DisposalRecord> getAll() { return service.getAllDisposals(); }
}