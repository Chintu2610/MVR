

package com.MVRGroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.MVRGroup.entity.PaymentEntity;
import java.util.List;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {
    // You can add custom query methods here if needed
    List<PaymentEntity> findAll(); // Retrieve all services
}
