package com.MVRGroup.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MVRGroup.entity.User;
import com.MVRGroup.repository.UserRepository;

@Service
public class ReportsService {
	@Autowired
	UserRepository userRepository;
	public List<User> getnumberOfUsersRegisteredThisMonth() {
		// TODO Auto-generated method stub
		return userRepository.getnumberOfUsersRegisteredThisMonth();
		 
	}
	
}
