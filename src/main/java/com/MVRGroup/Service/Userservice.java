package com.MVRGroup.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.MVRGroup.entity.TrainingEntity;
import com.MVRGroup.entity.User;
import com.MVRGroup.repository.TrainingRepository;
import com.MVRGroup.repository.UserRepository;



@Service
public class Userservice {
	@Autowired
	private UserRepository userrepository;
	public User UserRegistration(User entity)
	{
		Optional<User> obj=repository.findByEmail(entity.getEmail());
		if(obj.isPresent())
		{
			return entity;
		}	
		if(entity.getEmail().equals("admin@gmail.com"))
		{
			entity.setRoleid(1);
		}else
		{
			entity.setRoleid(2);
		}
		repository.save(entity);
		return entity;
	}
	public User ValidateUser(String email,String password)
	{
		List<User> obj=repository.findByEmailAndPassword(email, password);
		if(obj.size()==0)
		{
			return null;
		}else
		{
			return obj.get(0);
			
		}
	}
	public User GetUserDetails(String userName)
	{
			Optional<User> user= repository.findByEmail(userName);					
			if (user.isPresent()) {									
			return user.get();
			}
	        return null;		
	}
	
	public List<User> getAllUsers()
	{
			List<User> users= repository.findAll();					
			
	        return users;		
	}
	
	
	public String LogOut(String email) {
	    // TODO Auto-generated method stub
	    Optional<User> validAdminOrCustomer = repository.findByEmail(email);
	    if (validAdminOrCustomer.isPresent()) {
	        repository.delete(validAdminOrCustomer.get());
	        return "User Logged Out Successfully";
	    } else {
	        return "User Not Logged In with this Credentials";
	    }
	}

	
	

	public String UpdateUser(User dto)
	{
		
		Optional<User> user= repository.findByEmail(dto.getEmail());	
		if (user.isPresent())
		{
			if(user.get().getEmail().equals("admin@gmail.com"))
			{
				dto.setRoleid(1);
			}else
			{
				dto.setRoleid(2);
			}
			dto.setUserid(user.get().getUserid());
			repository.save(dto);
			return "user updated successfull";
		}
		return "cant update user";		
	}
	
	
	@Autowired
	private UserRepository repository;
	public User saveUser(User entity)
	{
		  return repository.save(entity);
}
	
	
	
	 public User getUserById(Integer userId) {
	        return repository.findById(userId).orElse(null);
	    }
	
	
	 
	 public String DeleteUser(int userId) {
			Optional<User> work = repository.findById(userId);
			if (work.isPresent()) {
			    
				repository.delete(work.get());
			    return "Work deleted successfully";
			}

			 return " ID " + userId + " not found";
			   
		}	
	 
	 
	 
	 
	 public ResponseEntity<String> EditUser(User service) {
		    Optional<User> existingServiceOptional = repository.findById(service.getUserid());
		    
		    if (existingServiceOptional.isPresent()) {
		    	User existingsss = existingServiceOptional.get();

		    	
		    	existingsss.setName(service.getName());
		    	existingsss.setAddress(service.getAddress());
		    	existingsss.setEmail(service.getEmail());
		    	existingsss.setPassword(service.getPassword());
		    	existingsss.setPhoneNum(service.getPhoneNum());
		    	existingsss.setRoleid(service.getRoleid());
		    	    existingsss.setPaid250(service.getPaid250());
		    	    existingsss.setApprovestatus(service.getApprovestatus());

		        repository.save(existingsss);
		        
		        return ResponseEntity.ok("  updated successfully");
		    } else {
		        // Raw material not found in the repository
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Raw material with ID " + service.getUserid() + " not found");
		    }
		}
	 
	 public String getUsernameById(Integer userId) {
	        // Retrieve user by ID from the repository
	        User user = getUserById(userId);
	        if (user != null) {
	            return user.getName();
	        } else {
	            return "Unknown"; // Or handle the case when the user ID doesn't exist
	        }
	    }
}
