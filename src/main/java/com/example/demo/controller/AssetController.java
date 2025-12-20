package com.example.demo.controller;

import org.springframework.web.bind.annotation.AssetController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.service.AssetService;
import com.example.demo.entity.Asset;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;


import java.util.List;
@RestController
@RequestMapping("/api/assests")
public class AssetController{
    private final AssetService assetService;
    public AssetController(AssetService assetService){
    this.assetService=assetService;
@PostMapping("/post")
public Asset sendData(@RequestBody Asset asset){
    return assetService.CreateAsset(asset);
}
@GetMapping("/get")
public List<Asset>getval(){
    return assetService.getAllAsset();
}

@GetMapping("/getid/{id}")
public StudentEntity getdata(@PathVariable int id){
    return ser.getData(id);
}
@PutMapping("/putid/{id}")
public StudentEntity putval(@PathVariable int id,@RequestBody StudentEntity entity){
    return ser.updateData(id,entity);
}
}