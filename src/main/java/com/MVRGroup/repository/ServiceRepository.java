package com.MVRGroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.MVRGroup.entity.ServiceEntity;
import java.util.List;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Integer> {
    // You can add custom query methods here if needed
    List<ServiceEntity> findAll(); // Retrieve all services
}
