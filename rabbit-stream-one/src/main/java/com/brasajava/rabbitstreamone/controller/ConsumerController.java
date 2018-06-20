package com.brasajava.rabbitstreamone.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brasajava.rabbitstreamone.domain.Contact;
import com.brasajava.rabbitstreamone.repository.ContactRepository;


@RestController
public class ConsumerController {
	
	@Autowired
	private ContactRepository repository;

	@GetMapping(value = "/receive")
	public List<Contact> consum(){
		List<Contact> list = new ArrayList<>();
		repository.findAll().toStream().forEach(list::add);
		return list;
	}
}
