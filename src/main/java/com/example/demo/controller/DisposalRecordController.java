package com.example.demo.controller;

import com.example.demo.entity.DisposalRecord;
import com.example.demo.service.DisposalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disposals") // Base URL for Disposal APIs
public class DisposalRecordController {

    private final DisposalRecordService disposalService;

    @Autowired
    public DisposalRecordController(DisposalRecordService disposalService) {
        this.disposalService = disposalService;
    }

    // Create a new disposal record
    @PostMapping
    public DisposalRecord createDisposal(@RequestBody DisposalRecord disposal) {
        return disposalService.createDisposal(disposal);
    }

    // Get all disposal records
    @GetMapping
    public List<DisposalRecord> getAllDisposals() {
        return disposalService.getAllDisposals();
    }

    // Get a disposal record by ID
    @GetMapping("/{id}")
    public DisposalRecord getDisposal(@PathVariable Long id) {
        return disposalService.getDisposal(id);
    }

    // Update disposal record
    @PutMapping("/{id}")
    public DisposalRecord updateDisposal(@PathVariable Long id, @RequestBody DisposalRecord disposal) {
        return disposalService.updateDisposal(id, disposal);
    }

    // Delete disposal record
    @DeleteMapping("/{id}")
    public void deleteDisposal(@PathVariable Long id) {
        disposalService.deleteDisposal(id);
    }
}
