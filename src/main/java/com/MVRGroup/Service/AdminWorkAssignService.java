package com.MVRGroup.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.MVRGroup.dto.WorkAssignDTO;
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
	@Autowired
	RawmaterialRepository rawMaterialRepo;
	public void AssignWork(String email,String work, Map<String, Integer> rawMaterials, String deadLine)
	{
		String status="placed";
		 WorkAssign workAssign = new WorkAssign();
	        workAssign.setEmail(email);
	        workAssign.setAssignedWork(work);
	        workAssign.setStatus(status);
	        
	        Integer workId1 = workAssignRepo.findWorkidByEmailAndAssignedWork(email, work);
	        if(workId1 != null && workId1 > 0) {
	            return;
	        }
		workAssignRepo.assignWork(email,work,email,status, deadLine);
		
		int workId = workAssignRepo.findWorkidByEmailAndAssignedWork(email, work); 

		
		 workAssignRepo.updateAssignedWorkStatus(email);
		
	
		 
	        // Store raw material details along with the retrieved workid
	        for (Map.Entry<String, Integer> entry : rawMaterials.entrySet()) {
	        	
	        	String rawMaterialName = entry.getKey();
	            int assignedQuantity = entry.getValue();

	            // Retrieve the raw material entity from the repository
	            RawmaterialEntity rawMaterial = rawMaterialRepo.findByName(rawMaterialName);
	            
	            if (rawMaterial != null) {
	                // Check if the available quantity is sufficient
	                int availableQuantity = rawMaterial.getQuantityAvailable();
	                

	                // Update the available quantity
	                rawMaterial.setQuantityAvailable(availableQuantity - assignedQuantity);

	                // Save the updated raw material entity
	                rawMaterialRepo.save(rawMaterial);
	            }
	            AssignedRawMaterial rawMaterial1 = new AssignedRawMaterial();
	            rawMaterial1.setName(entry.getKey());
	            rawMaterial1.setQuantity(entry.getValue());
	            rawMaterial1.setWorkId(workId);
	            assignrawmaterialrepo.save(rawMaterial1);
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

	public List<WorkAssignDTO> getWithin2DaysData() {
		// TODO Auto-generated method stub
		List<WorkAssign> works= workAssignRepo.getWithin2DaysData();
		List<WorkAssignDTO> dto=new ArrayList<>();
		for(WorkAssign wo:works)
		{
			WorkAssignDTO dt=new WorkAssignDTO();			
			dt.setAssignedWork(wo.getAssignedWork());
			dt.setDeadline(wo.getDeadLine());
			dt.setWorkAssignDate(wo.getWorkAssignDate());
			dt.setEmail(wo.getEmail());
			dt.setName(wo.getUser().getName());
			dt.setStatus(wo.getStatus());
			dt.setUserId(wo.getUser().getUserid());
			dto.add(dt);
		}
		return dto;
	}
	public List<WorkAssignDTO> getDeliveryDatePassedData() {
		// TODO Auto-generated method stub
		List<WorkAssign> works= workAssignRepo.getDeliveryDatePassedData();
		List<WorkAssignDTO> dto=new ArrayList<>();
		for(WorkAssign wo:works)
		{
			WorkAssignDTO dt=new WorkAssignDTO();			
			dt.setAssignedWork(wo.getAssignedWork());
			dt.setDeadline(wo.getDeadLine());
			dt.setEmail(wo.getEmail());
			dt.setName(wo.getUser().getName());
			dt.setStatus(wo.getStatus());
			dt.setUserId(wo.getUser().getUserid());
			dto.add(dt);
		}
		return dto;
	}
	public List<WorkAssignDTO> getDeliveredProductsData() {
		// TODO Auto-generated method stub
		List<WorkAssign> works= workAssignRepo.getDeliveredProductsData();
		List<WorkAssignDTO> dto=new ArrayList<>();
		for(WorkAssign wo:works)
		{
			WorkAssignDTO dt=new WorkAssignDTO();			
			dt.setAssignedWork(wo.getAssignedWork());
			dt.setDeadline(wo.getDeadLine());
			dt.setEmail(wo.getEmail());
			dt.setName(wo.getUser().getName());
			dt.setStatus(wo.getStatus());
			dt.setUserId(wo.getUser().getUserid());
			dto.add(dt);
		}
		return dto;
	}
	public List<WorkAssignDTO> getDeliveredProductsDatabyUserid(int userid) {
		// TODO Auto-generated method stub
		List<WorkAssign> works= workAssignRepo.getDeliveredProductsDataByUserId(userid);
		List<WorkAssignDTO> dto=new ArrayList<>();
		for(WorkAssign wo:works)
		{
			WorkAssignDTO dt=new WorkAssignDTO();			
			dt.setAssignedWork(wo.getAssignedWork());
			dt.setDeadline(wo.getDeadLine());
			dt.setEmail(wo.getEmail());
			dt.setName(wo.getUser().getName());
			dt.setStatus(wo.getStatus());
			dt.setUserId(wo.getUser().getUserid());
			dto.add(dt);
		}
		return dto;
	}

	
	 public List<WorkAssign> getAllAssignedWorksByUserId(int userid) {
	        return workAssignRepo.findAllByUserId(userid);
	    }
	 
	 
	 public List<WorkAssignDTO> getWithin2DaysDataByuserid(int userid) {
			// TODO Auto-generated method stub
			List<WorkAssign> works= workAssignRepo.getWithin2DaysDataByuserid(userid);
			List<WorkAssignDTO> dto=new ArrayList<>();
			for(WorkAssign wo:works)
			{
				WorkAssignDTO dt=new WorkAssignDTO();			
				dt.setAssignedWork(wo.getAssignedWork());
				dt.setDeadline(wo.getDeadLine());
				dt.setWorkAssignDate(wo.getWorkAssignDate());
				dt.setEmail(wo.getEmail());
				dt.setName(wo.getUser().getName());
				dt.setStatus(wo.getStatus());
				dt.setUserId(wo.getUser().getUserid());
				dto.add(dt);
			}
			return dto;
		}
	 
	 
	 public List<WorkAssignDTO> getDeliveryDatePassedDataByUserid(int userid) {
			// TODO Auto-generated method stub
			List<WorkAssign> works= workAssignRepo.getDeliveryDatePassedDataByuserid(userid);
			List<WorkAssignDTO> dto=new ArrayList<>();
			for(WorkAssign wo:works)
			{
				WorkAssignDTO dt=new WorkAssignDTO();			
				dt.setAssignedWork(wo.getAssignedWork());
				dt.setDeadline(wo.getDeadLine());
				dt.setEmail(wo.getEmail());
				dt.setName(wo.getUser().getName());
				dt.setStatus(wo.getStatus());
				dt.setUserId(wo.getUser().getUserid());
				dto.add(dt);
			}
			return dto;
		}
	public void updateUserWork(int workid) {
		// TODO Auto-generated method stub
		workAssignRepo.updateUserWork(workid);
		
	}
}
