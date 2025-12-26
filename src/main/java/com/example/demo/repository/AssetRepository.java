package com.example.demo.repository;

import com.example.demo.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface AssetRepository extends JpaRepository<Asset, Long> {
    Optional<Asset> findByAssetTag(String assetTag);
    List<Asset> findByStatus(String status);
    boolean existsByAssetTag(String assetTag);
}
