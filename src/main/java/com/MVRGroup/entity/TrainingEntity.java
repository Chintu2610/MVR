

package com.MVRGroup.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="training")
public class TrainingEntity {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainingid")
    private int trainingid;

    @Column(name = "trainingname")
    private String trainingname;

	public int getTrainingid() {
		return trainingid;
	}

	public void setTrainingid(int trainingid) {
		this.trainingid = trainingid;
	}

	public String getTrainingname() {
		return trainingname;
	}

	public void setTrainingname(String trainingname) {
		this.trainingname = trainingname;
	}

   
   
}
