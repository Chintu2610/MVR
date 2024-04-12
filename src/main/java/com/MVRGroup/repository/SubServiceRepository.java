
package com.MVRGroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.MVRGroup.entity.SubServiceEntity;
import java.util.List;

public interface SubServiceRepository extends JpaRepository<SubServiceEntity, Integer> {
    List<SubServiceEntity> findAll(); 
}
