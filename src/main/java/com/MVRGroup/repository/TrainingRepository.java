

package com.MVRGroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MVRGroup.entity.TrainingEntity;
import java.util.List;

public interface TrainingRepository extends JpaRepository<TrainingEntity, Integer> {
    // You can add custom query methods here if needed
    List<TrainingEntity> findAll(); // Retrieve all services
    @Query(value = "select trainingname from training where trainingid=?1",
            nativeQuery = true)
	String findTrainingNameByTrainingid(int trainingid);
}
