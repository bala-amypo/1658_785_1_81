package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.example.demo.entity.LifecycleEvent;
import java.util.List;
@Repository
public interface LifecycleEventRepository extends JpaRepository<LifecycleEvent,Long>{
List<LifecycleEvent> findByAssetId(String assetId);
    
}
