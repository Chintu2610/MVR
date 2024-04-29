
	package com.MVRGroup.Service;

	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.MVRGroup.entity.AssignedRawMaterial;
	import com.MVRGroup.repository.AssignedRawmaterialRepo;
	@Service
	public class AssignedRawmaterialService {

		
		@Autowired
		private AssignedRawmaterialRepo repository;
		

	
	
	public List<AssignedRawMaterial> getAllRawMaterialsUser()
	{
			List<AssignedRawMaterial> raw= repository.findAll();					
			
	        return raw;		
	}
	
	
	public List<AssignedRawMaterial> getAllRawMaterialsUserid(Integer userid)
	{
//			List<AssignedRawMaterial> raw= repository.findByUserid(userid);					
			
	        return null;		
	}
}
