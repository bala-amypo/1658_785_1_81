package com.example.demo.controller;

import com.example.demo.entity.Asset;
import com.example.demo.service.AssetService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/assets") // [cite: 278]
@Tag(name = "Assets") // [cite: 379]
public class AssetController {
    private final AssetService assetService;
    public AssetController(AssetService assetService) { this.assetService = assetService; }

    @PostMapping
    public Asset create(@RequestBody Asset asset) { return assetService.createAsset(asset); }

    @GetMapping
    public List<Asset> getAll() { return assetService.getAllAssets(); }

    @GetMapping("/{id}")
    public Asset getById(@PathVariable Long id) { return assetService.getAsset(id); }
}