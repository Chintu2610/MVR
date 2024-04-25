

package com.MVRGroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.MVRGroup.entity.JobEntity;
import java.util.List;

public interface JobRepository extends JpaRepository<JobEntity, Integer> {
    List<JobEntity> findAll(); // Retrieve all services
    
    List<JobEntity> findByUserid(Integer userid);
    
}
