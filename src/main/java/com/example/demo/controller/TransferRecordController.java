package com.example.demo.controller;

import com.example.demo.entity.TransferRecord;
import com.example.demo.service.TransferRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfers")
public class TransferRecordController {

    private final TransferRecordService transferService;

    public TransferRecordController(TransferRecordService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public TransferRecord save(@RequestBody TransferRecord transfer) {
        return transferService.save(transfer);
    }

    @GetMapping
    public List<TransferRecord> getAll() {
        return transferService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        transferService.delete(id);
    }
}
