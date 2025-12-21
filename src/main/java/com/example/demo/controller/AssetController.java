package com.example.demo.controller;

import com.example.demo.entity.Asset;
import com.example.demo.service.Impl.AssetServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {

   
    @GetMapping
    public List<Asset> getAllAssets() {
        return assetService.getAllAssets();
    }

    @PostMapping
    public Asset createAsset(@RequestBody Asset asset) {
        return assetService.createAsset(asset);
    }

    @PutMapping("/{id}")
    public Asset updateAsset(@PathVariable Long id, @RequestBody Asset asset) {
        return assetService.updateAsset(id, asset);
    }

    @GetMapping("/search")
    public Asset getAssetByCode(@RequestParam String assetCode) {
        return assetService.getAssetByCode(assetCode);
    }
}
