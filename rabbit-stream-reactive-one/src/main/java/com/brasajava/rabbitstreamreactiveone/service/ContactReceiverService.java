package com.brasajava.rabbitstreamreactiveone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.brasajava.rabbitstreamreactiveone.channel.ContactReceiverBinding;
import com.brasajava.rabbitstreamreactiveone.domain.ContactEvent;
import com.brasajava.rabbitstreamreactiveone.repository.ContactEventRepository;

import reactor.core.publisher.Flux;

@EnableBinding(ContactReceiverBinding.class)
@EnableAutoConfiguration
public class ContactReceiverService {
	
	@Autowired
	private ContactEventRepository repository;

	@StreamListener
	public void create(@Input(ContactReceiverBinding.LISTEN_CREATED_CONTACT) Flux<ContactEvent> event) {
		System.out.println("CONTACT CREATED EVENT LISTENER CONNECTED");
		event.subscribe(e -> {System.out.println("Receiving CONTACT CREATED event -> " + e); repository.save(e);});
	}
	
	@StreamListener
	public void notSaved(@Input(ContactReceiverBinding.LISTEN_NOT_SAVED_CONTACT) Flux<ContactEvent> event) {
		System.out.println("CONTACT NOT SAVED EVENT LISTENER CONNECTED");
		event.subscribe(e -> {System.out.println("Receiving CONTACT NOT SAVED event -> " + e); repository.save(e);});
	}
	
	@StreamListener
	public void updated(@Input(ContactReceiverBinding.LISTEN_UPDATED_CONTACT) Flux<ContactEvent> event) {
		System.out.println("CONTACT UPDATED EVENT LISTENER CONNECTED");
		event.subscribe(e -> {System.out.println("Receiving CONTACT UPDATED event -> " + e); repository.save(e);});
	}
	
	@StreamListener
	public void delete(@Input(ContactReceiverBinding.LISTEN_DELETED_CONTACT) Flux<ContactEvent> event) {
		System.out.println("CONTACT DELETED EVENT LISTENER CONNECTED");
		event.subscribe(e -> {System.out.println("Receiving CONTACT DELETED event -> " + e); repository.save(e);});
	}
}
