package com.bluespire.citizensmq.controller;

import java.io.IOException;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluespire.citizensmq.model.AccountDetails;
import com.bluespire.citizensmq.model.SavingsAccount;
import com.bluespire.citizensmq.service.Converstions;
import com.bluespire.citizensmq.service.MessageReceiver;
//import com.bluespire.citizensmq.service.MessageSender;
import com.bluespire.citizensmq.service.MessageSender;
import com.bluespire.citizensmq.service.RequestRespondHandler;

import jakarta.jms.JMSException;

import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@RequestMapping("/")
public class MessageController {
	
	@Autowired
	private MessageSender sender;
	
	
	@Autowired
	private RequestRespondHandler requestResponseHandler;
	
	

	
	@PostMapping("details")
	public Object getAccountDetails(@RequestBody SavingsAccount savingsAccount ) throws IOException, javax.jms.JMSException {
		System.out.println("Request Received : "+   savingsAccount + "\n");
		Object response = requestResponseHandler.callMq(savingsAccount);
//		System.out.println(response.toString());
		
		return response;
		
	}
	
}