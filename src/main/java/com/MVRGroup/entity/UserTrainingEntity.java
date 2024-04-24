

package com.MVRGroup.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usertraining")
public class UserTrainingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usertrainingid")
    private int usertrainingid;

    @Column(name = "userid")
    private int userid;
    
    @Column(name = "trainingid")
    private int trainingid;
    
    @Column(name = "trainingscheduleid")
    private int trainingscheduleid;

	public int getUsertrainingid() {
		return usertrainingid;
	}

	public void setUsertrainingid(int usertrainingid) {
		this.usertrainingid = usertrainingid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getTrainingid() {
		return trainingid;
	}

	public void setTrainingid(int trainingid) {
		this.trainingid = trainingid;
	}

	public int getTrainingscheduleid() {
		return trainingscheduleid;
	}

	public void setTrainingscheduleid(int trainingscheduleid) {
		this.trainingscheduleid = trainingscheduleid;
	}

}