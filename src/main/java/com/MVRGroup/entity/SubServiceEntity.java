
package com.MVRGroup.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="subservice")
public class SubServiceEntity {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subserviceId")
    private int subserviceId;
    
    
    @Column(name = "serviceId")
    private int serviceId;

    @Column(name = "subserviceName")
    private String subserviceName;

    @Column(name = "imageUrl")
    private String imageUrl;

	public int getSubserviceId() {
		return subserviceId;
	}

	public void setSubserviceId(int subserviceId) {
		this.subserviceId = subserviceId;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getSubserviceName() {
		return subserviceName;
	}

	public void setSubserviceName(String subserviceName) {
		this.subserviceName = subserviceName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	
   
}
