
package com.MVRGroup.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="payment")
public class PaymentEntity {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentid")
    private int paymentid;

    @Column(name = "userid")
    private int userid;
    
    @Column(name = "PaymentAmt")
    private double  PaymentAmt;

    @Column(name = "date")
    private String date;
    
    @Column(name = "status")
    private String status;
   
    @Column(name = "PaymentMethod")
    private String PaymentMethod;

    
    
	public int getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public double getPaymentAmt() {
		return PaymentAmt;
	}

	public void setPaymentAmt(double paymentAmt) {
		PaymentAmt = paymentAmt;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentMethod() {
		return PaymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		PaymentMethod = paymentMethod;
	}
    
   
}
