package com.MVRGroup.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.boot.registry.classloading.spi.ClassLoaderService.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.MVRGroup.entity.AssignedRawMaterial;
import com.MVRGroup.entity.RawmaterialEntity;
import com.MVRGroup.entity.WorkAssign;
import com.MVRGroup.entity.Works;
import com.MVRGroup.repository.AssignedRawmaterialRepo;
import com.MVRGroup.repository.RawmaterialRepository;
import com.MVRGroup.repository.WorkAssignRepo;
import com.MVRGroup.repository.WorksRepo;

@Service
public class AdminWorkAssignService {
	@Autowired
	WorkAssignRepo workAssignRepo;
	@Autowired
	WorksRepo worksrepo;
	@Autowired
	AssignedRawmaterialRepo assignrawmaterialrepo;
	public void AssignWork(String email,String work, Map<String, Integer> rawMaterials)
	{
		 WorkAssign workAssign = new WorkAssign();
	        workAssign.setEmail(email);
	        workAssign.setAssignedWork(work);
		workAssignRepo.assignWork(email,work,email);
		/*
		 * Long workId = workAssignRepo.findWorkidByEmailAndAssignedWork(email, work);
		 */
		 
	        // Store raw material details along with the retrieved workid
	        for (Map.Entry<String, Integer> entry : rawMaterials.entrySet()) {
	            AssignedRawMaterial rawMaterial = new AssignedRawMaterial();
	            rawMaterial.setName(entry.getKey());
	            rawMaterial.setQuantity(entry.getValue());
	            rawMaterial.setWorkAssign(workAssign);
	            assignrawmaterialrepo.save(rawMaterial);
	        }
	}
	public List<Works> getAvailableWorks() {
		// TODO Auto-generated method stub
		 return worksrepo.findAll();
	}
	public void AddWork(String work) {
		// TODO Auto-generated method stub
		Works wo=new Works();
		wo.setWorkName(work);
		worksrepo.save(wo);
	}
	public ResponseEntity<String> EditWork(String workname, int workid) {
		// TODO Auto-generated method stub
		Optional<Works> work = worksrepo.findById(workid);
		if (work.isPresent()) {
		    work.get().setWorkName(workname);
		    worksrepo.save(work.get());
		    return ResponseEntity.ok("Work updated successfully");
		}

		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Work with ID " + workid + " not found");
		   
	}
	public String DeleteWork( int workid) {
		// TODO Auto-generated method stub
		Optional<Works> work = worksrepo.findById(workid);
		if (work.isPresent()) {
		    
		    worksrepo.delete(work.get());
		    return "Work deleted successfully";
		}

		 return "Work with ID " + workid + " not found";
		   
	}
	public List<WorkAssign> getAllAssignedWorks() {
		// TODO Auto-generated method stub
		return  workAssignRepo.findAll();
		
	}
}
