package com.MVRGroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MVRGroup.entity.AssignedRawMaterial;

@Repository
public interface AssignedRawmaterialRepo extends JpaRepository<AssignedRawMaterial, Integer> {
	
}
