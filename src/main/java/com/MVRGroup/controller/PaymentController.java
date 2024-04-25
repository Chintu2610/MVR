

package com.MVRGroup.controller;

import com.MVRGroup.Service.PaymentService;
import com.MVRGroup.entity.PaymentEntity;
import com.MVRGroup.entity.TrainingEntity;
import com.MVRGroup.entity.User;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PaymentController {

	
	private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    
    @GetMapping("/PaymentDetails")
    public ResponseEntity<List<PaymentEntity>> viewAllPayment() {
        List<PaymentEntity> services = paymentService.getAllPayment();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

	@GetMapping("/payment")
	public String viewTrainingAssigneePage() {
	    return "payment";
	}
	
	@PostMapping("/paymentadd")
	public String addTraining(@RequestParam("userid") Integer userid,
	                          @RequestParam("paid250") String paid250) {

		String date = LocalDate.now().toString(); 
	    Double amt = 250.0;
	    String paymentmethod = "online";
	    
	    PaymentEntity entity = new PaymentEntity();
	    
	    entity.setStatus(paid250); 
	    entity.setUserid(userid); 
	    entity.setDate(date); 
	    entity.setPaymentAmt(amt); 
	    entity.setPaymentMethod(paymentmethod); 

	    return "Success"; 
	}

	
}