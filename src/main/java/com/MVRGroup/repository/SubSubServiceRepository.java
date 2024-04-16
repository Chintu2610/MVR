
package com.MVRGroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.MVRGroup.entity.SubSubServiceEntity;
import java.util.List;



    public interface SubSubServiceRepository extends JpaRepository<SubSubServiceEntity, Integer> {
      
    	List<SubSubServiceEntity> findAll();
    	List<SubSubServiceEntity> findBySubserviceId(Integer subserviceId);
    }



