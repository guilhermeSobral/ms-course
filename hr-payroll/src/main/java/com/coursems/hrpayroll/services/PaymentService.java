package com.coursems.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursems.hrpayroll.clients.WorkerFeignClient;
import com.coursems.hrpayroll.entities.Payment;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient client;

	public Payment getPayment(Long workerId, Integer days) {
		var worker = client.findWorker(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), 10);
	}
}
