package com.example.demo.controller;

import com.example.demo.entity.TransferRecord;
import com.example.demo.service.TransferRecordService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/transfers")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @PostMapping("/{assetId}")
    public ResponseEntity<TransferRecord> transferAsset(
            @PathVariable Long assetId,
            @RequestBody TransferRecord transferRecord
    ) {
        TransferRecord saved = transferService.transfer(assetId, transferRecord);
        return ResponseEntity.ok(saved);
    }
}

  