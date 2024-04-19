
package com.MVRGroup.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="job")
public class JobEntity {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jobid")
    private int jobid;

    @Column(name = "assignedjob")
    private String assignedjob;

    @Column(name = "userid")
    private int userid;

    
    
	public int getJobid() {
		return jobid;
	}

	public void setJobid(int jobid) {
		this.jobid = jobid;
	}

	public String getAssignedjob() {
		return assignedjob;
	}

	public void setAssignedjob(String assignedjob) {
		this.assignedjob = assignedjob;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

   
	
	
   
}
