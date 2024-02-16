package com.bluespire.citizensmq.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bluespire.citizensmq.model.AccountDetails;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.core.JmsTemplate;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.ibm.jms.JMSBytesMessage;
import com.ibm.msg.client.jakarta.jms.JmsMessage;

import java.io.UnsupportedEncodingException;

import jakarta.jms.BytesMessage;
import jakarta.jms.JMSException;
import jakarta.jms.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MessageReceiver {

	@Autowired
	private Converstions convertions;

	@Autowired
	ObjectMapper objectMapper;

	private final JmsTemplate jmsTemplate;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public MessageReceiver(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public Object receiveMessageByCorrelationId(String correlationId)
			throws jakarta.jms.JMSException, IOException, javax.jms.JMSException {
		jmsTemplate.setReceiveTimeout(20000);

		// Receive the message
		BytesMessage receivedMessage = (BytesMessage) jmsTemplate.receiveSelected("DEV.QUEUE.2",
				"JMSCorrelationID='" + correlationId + "'");
		if (receivedMessage != null) {
//			logger.info("MessageReceiver    message received    corrId : {}", receivedMessage.getJMSCorrelationID());
		}

		if (receivedMessage != null) {

//			

			byte[] bytes = new byte[(int) receivedMessage.getBodyLength()];
			receivedMessage.readBytes(bytes);
//			System.out.println(bytes);
//			for (byte b : bytes)
//				System.out.println(b);
			String str = convertions.ebcdicToJson(bytes);
			AccountDetails accountDetails = objectMapper.readValue(str, AccountDetails.class);
			System.out.println("Received response from Mainframe : "+accountDetails.toString()+"\n");
			return accountDetails;
			

		} else
			return null;
	}


}
