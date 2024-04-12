package com.MVRGroup.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.MVRGroup.entity.RawmaterialEntity;
import com.MVRGroup.entity.User;
import com.MVRGroup.entity.Works;
import com.MVRGroup.repository.RawmaterialRepository;
@Service
public class RawmaterialService {

	
	@Autowired
	private RawmaterialRepository repository;
	public RawmaterialEntity saveRawMaterial(RawmaterialEntity entity)
	{
		  return repository.save(entity);


}
	
	
	
	public List<RawmaterialEntity> getAllRawMaterials()
	{
			List<RawmaterialEntity> raw= repository.findAll();					
			
	        return raw;		
	}
	
	
	
	/*
	 * public ResponseEntity<String> EditRawmaterial(String name, int rawMaterialID)
	 * { // TODO Auto-generated method stub Optional<RawmaterialEntity> work =
	 * repository.findById(rawMaterialID); if (work.isPresent()) {
	 * work.get().setName(name); repository.save(work.get()); return
	 * ResponseEntity.ok("Work updated successfully"); }
	 * 
	 * return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Work with ID " +
	 * rawMaterialID + " not found");
	 * 
	 * }
	 */
	
	
	
	
	public ResponseEntity<String> EditRawmaterial(RawmaterialEntity rawmaterial) {
	    // Check if the raw material exists in the repository
	    Optional<RawmaterialEntity> existingRawmaterialOptional = repository.findById(rawmaterial.getRawMaterialID());
	    
	    if (existingRawmaterialOptional.isPresent()) {
	        // Update the existing raw material with the new data
	        RawmaterialEntity existingRawmaterial = existingRawmaterialOptional.get();
	        existingRawmaterial.setName(rawmaterial.getName());
	        existingRawmaterial.setDescription(rawmaterial.getDescription());
	        existingRawmaterial.setSupplierName(rawmaterial.getSupplierName());
	        existingRawmaterial.setUnitPrice(rawmaterial.getUnitPrice());
	        existingRawmaterial.setQuantityAvailable(rawmaterial.getQuantityAvailable());
	        existingRawmaterial.setStorageConditions(rawmaterial.getStorageConditions());
	        existingRawmaterial.setExpiryDate(rawmaterial.getExpiryDate());
	        existingRawmaterial.setDateAdded(rawmaterial.getDateAdded());
	        
	        // Save the updated raw material
	        repository.save(existingRawmaterial);
	        
	        return ResponseEntity.ok("Raw material updated successfully");
	    } else {
	        // Raw material not found in the repository
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Raw material with ID " + rawmaterial.getRawMaterialID() + " not found");
	    }
	}

	
	
	
	
	
	
	
	
	
	
	public String DeleteRawmaterial(int rawMaterialID) {
		// TODO Auto-generated method stub
		Optional<RawmaterialEntity> work = repository.findById(rawMaterialID);
		if (work.isPresent()) {
		    
			repository.delete(work.get());
		    return "Work deleted successfully";
		}

		 return "Work with ID " + rawMaterialID + " not found";
		   
	}
}

	   