package com.MVRGroup.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MVRGroup.entity.User;
import com.MVRGroup.repository.UserRepository;



@Service
public class Userservice {
	@Autowired
	private UserRepository repository;
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
}
