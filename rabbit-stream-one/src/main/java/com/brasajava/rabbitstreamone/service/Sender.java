package com.brasajava.rabbitstreamone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import com.brasajava.rabbitstreamone.domain.Contact;

@Service
@EnableBinding(Source.class)
public class Sender {

	@Autowired
	private Source source;
	

	public void send(Contact contact) {
		source.output().send(new GenericMessage<>((contact)));
		System.out.println("Sended -> " + contact);
	}
}
