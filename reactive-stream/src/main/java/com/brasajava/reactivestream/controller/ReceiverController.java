package com.brasajava.reactivestream.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brasajava.reactivestream.domain.Contact;
import com.brasajava.reactivestream.repository.ContactRepository;

@RestController
public class ReceiverController {
	@Autowired
	private ContactRepository repository;
	
	@GetMapping("/receive")
	public ResponseEntity<List<Contact>> getContacts(){
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}
}
