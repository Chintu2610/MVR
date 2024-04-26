
package com.MVRGroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MVRGroup.entity.TrainingScheduleEntity;
import java.util.List;

public interface TrainingScheduleRepository extends JpaRepository<TrainingScheduleEntity, Integer> {

	List<TrainingScheduleEntity> findAll(); 
	
	
	@Query(value ="SELECT ts.*, tr.trainingname AS training_name FROM trainingschedule ts INNER JOIN training tr ON ts.trainingid = tr.trainingid", nativeQuery = true)
	List<TrainingScheduleEntity> findAllByTrainingID(); 
}
