
package com.MVRGroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.MVRGroup.entity.UserTrainingEntity;
import java.util.List;

public interface UserTrainingRepository extends JpaRepository<UserTrainingEntity, Integer> {

	List<UserTrainingEntity> findAll(); 
}
