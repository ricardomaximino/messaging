package com.brasajava.rabbitstreamreceiverone.service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.brasajava.rabbitstreamreceiverone.channel.ContactReceiverChannelBinding;
import com.brasajava.rabbitstreamreceiverone.domain.ContactEvent;
import com.brasajava.rabbitstreamreceiverone.repository.ContactEventRepository;
import com.brasajava.rabbitstreamreceiverone.util.ContactChannel;

@EnableBinding(ContactReceiverChannelBinding.class)
public class ContactReceiverService {
	
	@Autowired
	private ContactEventRepository repository;
	
	@StreamListener(ContactChannel.CONTACT_CREATED_EVENT)
	public void created(ContactEvent event) {
		event.setReceiveDate(LocalDate.now());
		event.setReceiveTime(LocalTime.now());
		System.out.println("Receiving created contact event -> " + event);
		repository.save(event);
	}
	
	@StreamListener(ContactChannel.CONTACT_SAVED_EVENT)
	public void saved(ContactEvent event) {
		event.setReceiveDate(LocalDate.now());
		event.setReceiveTime(LocalTime.now());
		System.out.println("Receiving saved contact event -> " + event);
		event = repository.save(event);
	}
	
	@StreamListener(ContactChannel.CONTACT_NOT_SAVED_EVENT)
	public void notSaved(ContactEvent event) {
		event.setReceiveDate(LocalDate.now());
		event.setReceiveTime(LocalTime.now());
		System.out.println("Receiving notSaved contact event -> " + event);
		event = repository.save(event);
	}
	
	@StreamListener(value=ContactChannel.CONTACT_UPDATED_EVENT)
	public void updated(ContactEvent event) {
		event.setReceiveDate(LocalDate.now());
		event.setReceiveTime(LocalTime.now());
		System.out.println("Receiving updated contact event -> " + event);
		event = repository.save(event);
	}
	
	@StreamListener(value=ContactChannel.CONTACT_DELETED_EVENT)
	public void deleted(ContactEvent event) {
		event.setReceiveDate(LocalDate.now());
		event.setReceiveTime(LocalTime.now());
		System.out.println("Receiving deleted contact event -> " + event);
		event = repository.save(event);
	}

}
