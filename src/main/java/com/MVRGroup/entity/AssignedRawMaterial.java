package com.MVRGroup.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class AssignedRawMaterial {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column
	    private String name;

	    @Column
	    private int quantity;

		/*
		 * @ManyToOne
		 * 
		 * @JoinColumn(name = "workid", referencedColumnName = "workid") private
		 * WorkAssign workAssign;
		 */
	    @Column(name = "workid")
	    private Long workId;

}
