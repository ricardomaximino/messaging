package com.brasajava.reactivestream.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

import com.brasajava.reactivestream.domain.Contact;

@EnableBinding(Source.class)
public class SenderService {
	@Autowired
	Source source;
	
	  public void send(Contact contact) {
		source.output().send(MessageBuilder.withPayload(contact).build());
	  }
	
}
