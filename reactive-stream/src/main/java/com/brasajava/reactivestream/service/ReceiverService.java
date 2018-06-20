package com.brasajava.reactivestream.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.brasajava.reactivestream.domain.Contact;
import com.brasajava.reactivestream.repository.ContactRepository;

@EnableBinding(Sink.class)
public class ReceiverService{
	
	@Autowired
	private ContactRepository repository;
	
	@StreamListener(Sink.INPUT)
	public void receive(Contact contact) {
		System.out.println("Receives -> " + contact);
		repository.save(contact);
	}
	
}
