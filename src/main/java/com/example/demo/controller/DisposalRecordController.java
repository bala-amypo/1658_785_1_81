package com.example.demo.controller;

import com.example.demo.entity.DisposalRecord;
import com.example.demo.service.DisposalRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disposals")
public class DisposalRecordController {

    private final DisposalRecordService disposalService;

    public DisposalRecordController(DisposalRecordService disposalService) {
        this.disposalService = disposalService;
    }

    @PostMapping
    public DisposalRecord createDisposal(@RequestBody DisposalRecord disposal) {
        return disposalService.createDisposal(disposal);
    }

    @GetMapping
    public List<DisposalRecord> getAllDisposals() {
        return disposalService.getAllDisposals();
    }

    @GetMapping("/{id}")
    public DisposalRecord getDisposal(@PathVariable Long id) {
        return disposalService.getDisposalById(id);
    }

    @PutMapping("/{id}")
    public DisposalRecord updateDisposal(@PathVariable Long id, @RequestBody DisposalRecord disposal) {
        return disposalService.updateDisposal(id, disposal);
    }

    @DeleteMapping("/{id}")
    public void deleteDisposal(@PathVariable Long id) {
        disposalService.deleteDisposal(id);
    }
}
