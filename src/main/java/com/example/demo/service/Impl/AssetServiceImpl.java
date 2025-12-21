package com.example.demo.service.Impl;

import com.example.demo.entity.Asset;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImpl {

    @Autowired
    private AssetRepository assetRepository;

    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    public Asset createAsset(Asset asset) {
        asset.setStatus("Available");
        return assetRepository.save(asset);
    }

    public Asset updateAsset(Long id, Asset updatedAsset) {
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found with id: " + id));
        asset.setAssetName(updatedAsset.getAssetName());
        asset.setAssetCode(updatedAsset.getAssetCode());
        asset.setStatus(updatedAsset.getStatus());
        return assetRepository.save(asset);
    }

    public Asset getAssetByCode(String assetCode) {
        return assetRepository.findByAssetCode(assetCode)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found with code: " + assetCode));
    }
}
