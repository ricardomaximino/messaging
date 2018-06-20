package com.brasajava.rabbitstreamone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.brasajava.rabbitstreamone.domain.Contact;
import com.brasajava.rabbitstreamone.repository.ContactRepository;

@EnableBinding(Sink.class)
public class Consumer {

	@Autowired
	private ContactRepository repository;

	@StreamListener(Sink.INPUT)
	public void receive(Contact contact) {
		System.out.println("Receive -> :" + contact.getName());
		repository.save(contact).subscribe();
	}
}
