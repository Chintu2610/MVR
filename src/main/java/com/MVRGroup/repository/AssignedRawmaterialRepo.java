package com.MVRGroup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MVRGroup.entity.AssignedRawMaterial;
import com.MVRGroup.entity.JobEntity;

@Repository
public interface AssignedRawmaterialRepo extends JpaRepository<AssignedRawMaterial, Integer> {
	
	 List<AssignedRawMaterial> findByUserid(Integer userid);
	
	
}
