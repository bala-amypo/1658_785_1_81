package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.LifecycleEvent;

public interface LifecycleEventRepository extends JpaRepository<LifecycleEvent, Long> {

    // Original JPA method
    List<LifecycleEvent> findByAsset_Id(Long assetId);

    // Alias used in services/tests
    List<LifecycleEvent> findByAssetId(Long assetId);
}
