package com.MVRGroup.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int userid;
	
	
	
	@Column
	private String Name;
	@Column
	private String password;
	@Column
	private String phoneNum;
	@Column(unique = true)
	private String email;
	@Column
	private int roleid;
	@Column
	private String address;
	
	@Column
	private String assignedworkstatus;

	@Column(name = "paid250")
	    private String paid250;
	 
	 public String getPaid250() {
		return paid250;
	}
	public void setPaid250(String paid250) {
		this.paid250 = paid250;
	}

	public String getAssignedworkstatus() {
		return assignedworkstatus;
	}
	public void setAssignedworkstatus(String assignedworkstatus) {
		this.assignedworkstatus = assignedworkstatus;
	}

	@Column(name = "approvestatus")
	    private String approvestatus;
	
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRoleid() {
		return roleid;
	}
	public String getApprovestatus() {
		return approvestatus;
	}
	public void setApprovestatus(String approvestatus) {
		this.approvestatus = approvestatus;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User(int userid, String name, String password, String phoneNum, String email, int roleid, String address) {
		super();
		this.userid = userid;
		Name = name;
		this.password = password;
		this.phoneNum = phoneNum;
		this.email = email;
		this.roleid = roleid;
		this.address = address;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", Name=" + Name + ", password=" + password + ", phoneNum=" + phoneNum
				+ ", email=" + email + ", roleid=" + roleid + ", address=" + address + "]";
	}
	
	
	
	
	
}
