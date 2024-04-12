package com.MVRGroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.MVRGroup.entity.WorkAssign;

import jakarta.transaction.Transactional;
@Repository
public interface WorkAssignRepo extends JpaRepository<WorkAssign,Integer>{
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO assigned_user_work (userid, assigned_work, email) " +
            "VALUES ((SELECT userid FROM user WHERE email = ?1), ?2, ?3)",
    nativeQuery = true)
    void assignWork(String email, String work, String userEmail);
    

}
