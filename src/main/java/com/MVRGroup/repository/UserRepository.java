package com.MVRGroup.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MVRGroup.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	List<User> findByEmailAndPassword(String email,String password);
	@Query("SELECT u FROM User u WHERE u.Name = :username")
	List<User> findByUsername3(@Param("username") String username);
	@Query("SELECT u FROM User u WHERE u.email = :username")
    User findByUsername(@Param("username") String username);	
	Optional<User> findById(int id);
	Optional<User> findByEmail(String email);
	@Query(value ="SELECT * from user where roleid>=1",nativeQuery = true)
	List<User> findAllUsers();
	//User findByUserId(Integer userId);
}
