package com.example.demo.controller;

import com.example.demo.entity.TransferRecord;
import com.example.demo.service.TransferRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfers") // Base URL for Transfer APIs
public class TransferRecordController {

    private final TransferRecordService transferService;

    @Autowired
    public TransferRecordController(TransferRecordService transferService) {
        this.transferService = transferService;
    }

    // Create a new transfer record
    @PostMapping
    public TransferRecord createTransfer(@RequestBody TransferRecord transfer) {
        return transferService.createTransfer(transfer);
    }

    // Get all transfer records
    @GetMapping
    public List<TransferRecord> getAllTransfers() {
        return transferService.getAllTransfers();
    }

    // Get a transfer record by ID
    @GetMapping("/{id}")
    public TransferRecord getTransfer(@PathVariable Long id) {
        return transferService.getTransfer(id);
    }

    // Update transfer record
    @PutMapping("/{id}")
    public TransferRecord updateTransfer(@PathVariable Long id, @RequestBody TransferRecord transfer) {
        return transferService.updateTransfer(id, transfer);
    }

    // Delete transfer record
    @DeleteMapping("/{id}")
    public void deleteTransfer(@PathVariable Long id) {
        transferService.deleteTransfer(id);
    }
}
