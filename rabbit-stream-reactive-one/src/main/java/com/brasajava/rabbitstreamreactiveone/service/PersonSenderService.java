package com.brasajava.rabbitstreamreactiveone.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.reactive.FluxSender;
import org.springframework.cloud.stream.reactive.StreamEmitter;

import com.brasajava.rabbitstreamreactiveone.channel.PersonSenderBinding;
import com.brasajava.rabbitstreamreactiveone.domain.PersonEvent;

import reactor.core.publisher.Flux;

@EnableBinding(PersonSenderBinding.class)
public class PersonSenderService {
	
	private FluxSender createdPersonEventSender;
	private FluxSender notSavedPersonEventSender;
	private FluxSender updatedPersonEventSender;
	private FluxSender deletedPersonEventSender;

	@StreamEmitter
	public void setPersonCreatedEvent(@Output(PersonSenderBinding.CREATED_PERSON) FluxSender sender) {
		this.createdPersonEventSender = sender;
	}

	@StreamEmitter
	public void setPersonNotSavedEvent(@Output(PersonSenderBinding.NOT_SAVED_PERSON) FluxSender sender) {
		this.notSavedPersonEventSender = sender;
	}
	
	@StreamEmitter
	public void setUpdatedEvent(@Output(PersonSenderBinding.UPDATED_PERSON) FluxSender sender) {
		this.updatedPersonEventSender = sender;
	}
	
	@StreamEmitter
	public void setPersonDeleteEvent(@Output(PersonSenderBinding.DELETED_PERSON) FluxSender sender) {
		this.deletedPersonEventSender = sender;
	}

	public void sendPersonCreatedEvent(PersonEvent event) {
		System.out.println("Sending PERSON CREATED event -> " + event);
		createdPersonEventSender.send(Flux.just(event));
	}

	public void sendPersonNotSavedEvent(PersonEvent event) {
		System.out.println("Sending PERSON NOT SAVED event -> " + event);
		notSavedPersonEventSender.send(Flux.just(event));
	}
	
	public void sendPersonUpdatedEvent(PersonEvent event) {
		System.out.println("Sending the PERSON UPDATED event -> " + event);
		updatedPersonEventSender.send(Flux.just(event));
	}
	
	public void sendPersonDeleteEvent(PersonEvent event) {
		System.out.println("Sending PERSON DELETED event -> " + event);
		deletedPersonEventSender.send(Flux.just(event));
	}
}
