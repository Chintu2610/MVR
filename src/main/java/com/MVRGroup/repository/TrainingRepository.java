

package com.MVRGroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.MVRGroup.entity.TrainingEntity;
import java.util.List;

public interface TrainingRepository extends JpaRepository<TrainingEntity, Integer> {
    // You can add custom query methods here if needed
    List<TrainingEntity> findAll(); // Retrieve all services
}
