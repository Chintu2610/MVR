package com.MVRGroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MVRGroup.entity.Works;
@Repository
public interface WorksRepo extends JpaRepository<Works,Integer>{
 
    
    
	

}
