package com.example.demo.controller;

import org.springframework.web.bind.annotation.TransferController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.service.TransferRecordService;
import com.example.demo.entity.TransferRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
@RestController
@RequestMapping("/api/transfers")
public class TransferController{
    private final TransferRecordService transferService;
    public TransferController(TransferRecordService transferService){
    this.transferService=transferService;
    }
@PostMapping("/post/{assetId}")
public TransferRecord sendData(@PathVariable Long assetId,@RequestBody TransferRecord record){
    return transferService.createTransfer(assetId,record);

}
@GetMapping("/get/asset/{assetId}")
public List<TransferRecordt>getval(@PathVariable Long assetId){
    return transferService.getTransfersForAsset(assetId);
}

}