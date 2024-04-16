package com.MVRGroup.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="subsubservice")
public class SubSubServiceEntity {

	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "subsubserviceId")
	    private int subsubserviceId;
	    
	  	@Column(name = "subserviceId")
	    private int subserviceId;
	  
	    @Column(name = "title")
	    private String title;

	    @Column(name = "url")
	    private String url;

    
		public int getSubsubserviceId() {
			return subsubserviceId;
		}

		public void setSubsubserviceId(int subsubserviceId) {
			this.subsubserviceId = subsubserviceId;
		}

		public int getSubserviceId() {
			return subserviceId;
		}

		public void setSubserviceId(int subserviceId) {
			this.subserviceId = subserviceId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
	
}
