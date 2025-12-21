package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Asset;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssetRepository;
import com.example.demo.service.AssetService;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepo;

    public AssetServiceImpl(AssetRepository assetRepo) {
        this.assetRepo = assetRepo;
    }

    @Override
    public Asset postData(Asset asset) {
        return assetRepo.save(asset);
    }

    @Override
    public List<Asset> getAllData() {
        return assetRepo.findAll();
    }

    @Override
    public Asset getData(int id) {
        return assetRepo.findById((long) id)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));
    }

    @Override
    public Asset updateStatus(int id, String status) {
        Asset asset = getData(id);
        asset.setStatus(status);
        return assetRepo.save(asset);
    }
}