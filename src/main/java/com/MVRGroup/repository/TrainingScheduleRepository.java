
package com.MVRGroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.MVRGroup.entity.TrainingScheduleEntity;
import java.util.List;

public interface TrainingScheduleRepository extends JpaRepository<TrainingScheduleEntity, Integer> {

	List<TrainingScheduleEntity> findAll(); 
}
