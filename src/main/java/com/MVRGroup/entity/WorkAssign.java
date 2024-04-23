package com.MVRGroup.entity;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Table(name = "AssignedUserWork")
@Entity
public class WorkAssign {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workid;

    @Column(name = "email") // Assuming email is the column name in the database
    private String email;

    @Column(name = "assigned_work") // Assuming assigned_work is the column name in the database
    private String assignedWork;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", referencedColumnName = "userid") // Assuming userid is the foreign key column in AssignedUserWork table
    private User user;
    @Column
	 private String status;
    @Column
    private Date deadLine;
   
}
