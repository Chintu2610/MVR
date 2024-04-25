
package com.MVRGroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MVRGroup.entity.TrainingAssigneeEntity;
import java.util.List;

public interface TrainingAssigneeRepository extends JpaRepository<TrainingAssigneeEntity, Integer> {
    // You can add custom query methods here if needed
    List<TrainingAssigneeEntity> findAll(); // Retrieve all services
    @Query(value ="SELECT * from assigned_user_work where  MONTH(work_assign_date) = MONTH(CURDATE())",nativeQuery = true)
	List<TrainingAssigneeEntity> numberOfTrainingCompletedThisMonth();
}
