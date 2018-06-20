package com.brasajava.reactivestream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brasajava.reactivestream.domain.Contact;
import com.brasajava.reactivestream.service.SenderService;



@RestController
public class SenderController {
	@Autowired
	private SenderService sender;
	
	@PostMapping("/send")
	public ResponseEntity<String> sendContact(@RequestBody Contact contact){
		sender.send(contact);
		return new ResponseEntity<>("Contact was sent successfully", HttpStatus.OK);
	}
}
