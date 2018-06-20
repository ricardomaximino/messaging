package com.brasajava.rabbitstreamsenderone.service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

import com.brasajava.rabbitstreamsenderone.channel.ContactSenderChannelBinding;
import com.brasajava.rabbitstreamsenderone.domain.Contact;
import com.brasajava.rabbitstreamsenderone.domain.ContactEvent;

@EnableBinding(ContactSenderChannelBinding.class)
public class ContactEventSenderService {

	@Autowired
	private ContactSenderChannelBinding sender;

	public void created(Contact contact) {
		System.out.println("Sendign created event");
		sender.created().send(MessageBuilder.withPayload(new ContactEvent("01", contact.getId(), contact, LocalDate.now(), LocalTime.now())).build());
	}

	public void saved(Contact contact) {
		System.out.println("Sendign created event");
		sender.saved().send(MessageBuilder.withPayload(new ContactEvent("02", contact.getId(), contact, LocalDate.now(), LocalTime.now())).build());
	}

	public void notSaved(Contact contact) {
		System.out.println("Sendign created event");
		sender.notSaved().send(MessageBuilder.withPayload(new ContactEvent("03", contact.getId(), contact, LocalDate.now(), LocalTime.now())).build());
	}

	public void updated(Contact contact) {
		System.out.println("Sendign created event");
		sender.updated().send(MessageBuilder.withPayload(new ContactEvent("04", contact.getId(), contact, LocalDate.now(), LocalTime.now())).build());
	}

	public void deleted(Contact contact) {
		System.out.println("Sendign created event");
		sender.deleted().send(MessageBuilder.withPayload(new ContactEvent("05", contact.getId(), contact, LocalDate.now(), LocalTime.now())).build());
	}
}
