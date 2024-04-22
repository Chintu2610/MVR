

package com.MVRGroup.controller;

import com.MVRGroup.Service.PaymentService;
import com.MVRGroup.entity.PaymentEntity;
import com.MVRGroup.entity.User;

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
	
}