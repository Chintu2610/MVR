package com.MVRGroup.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "trainingassigne")
public class TrainingAssigneeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainingassigneid")
    private int trainingassigneid;

    @Column(name = "trainingassignestatus")
    private String trainingassignestatus;
    
    
    @Column(name = "userid")
    private int userid;
    
    
    @Column(name = "trainingid")
    private int trainingid;
  

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "userid") private User userid;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "trainingid") private TrainingEntity trainingid;
	 */

    // Getter and setter methods

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

	public int getTrainingassigneid() {
        return trainingassigneid;
    }

    public void setTrainingassigneid(int trainingassigneid) {
        this.trainingassigneid = trainingassigneid;
    }

    public String getTrainingassignestatus() {
        return trainingassignestatus;
    }

    public void setTrainingassignestatus(String trainingassignestatus) {
        this.trainingassignestatus = trainingassignestatus;
    }

	/*
	 * public User getUserid() { return userid; }
	 * 
	 * public void setUserid(User userid) { this.userid = userid; }
	 * 
	 * public TrainingEntity getTrainingid() { return trainingid; }
	 * 
	 * public void setTrainingid(TrainingEntity trainingid) { this.trainingid =
	 * trainingid; }
	 * 
	 * // Getter methods for username and trainingname
	 * 
	 * public String getUsername() { return userid != null ? userid.getName() :
	 * null; }
	 * 
	 * public String getTrainingname() { return trainingid != null ?
	 * trainingid.getTrainingname() : null; }
	 */
    
}
