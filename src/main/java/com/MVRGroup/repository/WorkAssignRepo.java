package com.MVRGroup.repository;

import java.util.List;

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
    @Query(value = "INSERT INTO assigned_user_work (userid, assigned_work, email,status,dead_line) " +
            "VALUES ((SELECT userid FROM user WHERE email = ?1), ?2, ?3,?4,?5)",
    nativeQuery = true)
    void assignWork(String email, String work, String userEmail, String status,String deadline);
    @Transactional
    @Modifying
    @Query(value = "UPDATE user SET assignedworkstatus = 'Not Available' WHERE email = ?1",
        nativeQuery = true)
    void updateAssignedWorkStatus(String email);
    @Query(value = "SELECT wa.workid FROM WorkAssign wa WHERE wa.email = ?1 AND wa.assignedWork = ?2")
    Integer findWorkidByEmailAndAssignedWork(String email, String assignedWork);
    @Query(value = "SELECT * FROM assigned_user_work w " +
            "WHERE w.dead_line <= CURDATE() + INTERVAL 2 DAY " +
            "AND w.dead_line > CURDATE()", nativeQuery = true)
	List<WorkAssign> getWithin2DaysData();
    @Query(value = "SELECT * \r\n"
    		+ "FROM mvrgroup.assigned_user_work \r\n"
    		+ "WHERE dead_line <CURDATE()  " 
            , nativeQuery = true)
	List<WorkAssign> getDeliveryDatePassedData();
    @Query(value = "SELECT * \r\n"
    		+ "FROM mvrgroup.assigned_user_work \r\n"
    		+ "WHERE status=\"delivered\" " 
            , nativeQuery = true)
	List<WorkAssign> getDeliveredProductsData();
    
    @Query(value = "select * from assigned_user_work where userid=?1",nativeQuery = true)
    List<WorkAssign> findAllByUserId(int userid);
    
    
    
    @Query(value = "SELECT * FROM assigned_user_work w " +
            "WHERE w.dead_line <= CURDATE() + INTERVAL 2 DAY " +
            "AND w.dead_line > CURDATE()  AND userid=?1 ", nativeQuery = true)
	List<WorkAssign> getWithin2DaysDataByuserid(int userid);
    
    
    
    @Query(value = "SELECT * \r\n"
    		+ "FROM mvrgroup.assigned_user_work \r\n"
    		+ "WHERE dead_line <CURDATE()  AND userid=?1 " 
            , nativeQuery = true)
	List<WorkAssign> getDeliveryDatePassedDataByuserid(int userid);
    
    
    @Query(value = "SELECT * \r\n"
    		+ "FROM mvrgroup.assigned_user_work \r\n"
    		+ "WHERE status=\"delivered\"  AND userid=?1" 
            , nativeQuery = true)
	List<WorkAssign> getDeliveredProductsDataByUserId(int userid);
    
}
