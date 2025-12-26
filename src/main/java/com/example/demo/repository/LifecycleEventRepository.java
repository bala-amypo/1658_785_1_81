package com.example.demo.repository;

import com.example.demo.entity.Asset;
import com.example.demo.entity.LifecycleEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LifecycleEventRepository extends JpaRepository<LifecycleEvent, Long> {

    // Find all events for a specific asset
    List<LifecycleEvent> findByAsset(Asset asset);
}
