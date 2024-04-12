package com.MVRGroup.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table
public class Works {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	int workid;
	@Column
	String workName;	
}
