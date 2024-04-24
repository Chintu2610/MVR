
package com.MVRGroup.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "trainingschedule")
public class TrainingScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainingscheduleid")
    private int trainingscheduleid;

    @Column(name = "trainingid")
    private int trainingid;
    
    
    @Column(name = "startDate")
    private String startDate;
    
    @Column(name = "endDate")
    private String endDate;
    
    
    @Column(name = "timings")
    private String timings;
    
    
    @Column(name = "description")
    private String description;


	public int getTrainingscheduleid() {
		return trainingscheduleid;
	}


	public void setTrainingscheduleid(int trainingscheduleid) {
		this.trainingscheduleid = trainingscheduleid;
	}


	public int getTrainingid() {
		return trainingid;
	}


	public void setTrainingid(int trainingid) {
		this.trainingid = trainingid;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getTimings() {
		return timings;
	}


	public void setTimings(String timings) {
		this.timings = timings;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
  