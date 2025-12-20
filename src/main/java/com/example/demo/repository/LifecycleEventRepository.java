package com.example.demo.repository;
public interface LifecycleEventRepository{
    
}
package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.example.demo.entity.Asset;
import java.util.List;
@Repository
public interface LifecycleEventRepository extends JpaRepository<Asset,Long>{
List<Asset> findByStatus(String status);
    
}
