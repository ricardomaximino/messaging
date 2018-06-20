 package com.brasajava.rabbitstreamone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brasajava.rabbitstreamone.domain.Contact;
import com.brasajava.rabbitstreamone.service.Sender;

@RestController
public class SenderController {
	@Autowired
	private Sender sender;

	
	@PostMapping("/send")
	public ResponseEntity<String> send(@RequestBody Contact contact){
		String message = "Enviado correctament para: " + contact.getName();
		sender.send(contact);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
