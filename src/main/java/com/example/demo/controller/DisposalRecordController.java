package com.example.demo.controller;

import org.springframework.web.bind.annotation.DisposalRecordController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.service.DisposalRecordService;
import com.example.demo.entity.DisposalRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
@RestController
@RequestMapping("/api/disposals")
public class DisposalRecordController{
    private final DisposalRecordService disposalService;
    public UsController(DisposalRecordService disposalService){
    this.disposalService=disposalService;
    }
@PostMapping("/post/{assetId}")
public DisposalRecord sendData(@PathVariable Long assetId,@RequestBody DisposalRecord disposal ){
    return disposalService.createDisposal(assetId,disposal);
}
@GetMapping("/get")
public List<DisposalRecord>getval(){
    return DisposalRecordService.getAllDisposals();
}

@GetMapping("/getid/{id}")
public DisposalRecord getdata(@PathVariable Long id){
    return disposalService.getdisposal(id);
}
}