package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.LifecycleEvent;

public interface LifecycleEventRepository extends JpaRepository<LifecycleEvent, Long> {

    // Original
    List<LifecycleEvent> findByAsset_Id(Long assetId);

    // Alias for service
    List<LifecycleEvent> findByAssetId(Long assetId);
}
