package com.example.demo.controller;

import com.example.demo.entity.Asset;
import com.example.demo.service.AssetService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
@Tag(name = "Assets")
public class AssetController {

    private final AssetService service;

    public AssetController(AssetService service) {
        this.service = service;
    }

    @PostMapping
    public Asset create(@RequestBody Asset asset) {
        return service.createAsset(asset);
    }

    @GetMapping
    public List<Asset> all() {
        return service.getAllAssets();
    }

    @GetMapping("/{id}")
    public Asset get(@PathVariable Long id) {
        return service.getAsset(id);
    }

    @PutMapping("/status/{id}")
    public Asset update(@PathVariable Long id,
                        @RequestParam String status) {
        return service.updateStatus(id, status);
    }
}
