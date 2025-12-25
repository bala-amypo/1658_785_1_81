package com.example.demo.repository;

import com.example.demo.entity.LifecycleEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LifecycleEventRepository extends JpaRepository<LifecycleEvent, Long> {
    Optional<LifecycleEvent> findByAsset_Id(Long assetId);
}
