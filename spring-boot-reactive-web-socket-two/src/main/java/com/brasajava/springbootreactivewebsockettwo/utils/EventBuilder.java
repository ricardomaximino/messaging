package com.brasajava.springbootreactivewebsockettwo.utils;

import java.time.LocalDate;
import java.time.LocalTime;

import com.brasajava.springbootreactivewebsockettwo.domain.Contact;
import com.brasajava.springbootreactivewebsockettwo.domain.Event;
import com.brasajava.springbootreactivewebsockettwo.domain.Person;

public class EventBuilder {
	
	// CONTACT
	public static Event contactCreatedEvent(Contact contact) {
		return new Event("CREATED", contact.getId(), contact, contact.getCreateDate(), contact.getCreateTime());
	}
	
	public static Event contactUpdatedEvent(Contact contact) {
		return new Event("UPDATED", contact.getId(), contact, contact.getUpdateDate(), contact.getUpdateTime());
	}
	
	public static Event contactDeletedEvent(Contact contact) {
		return new Event("DELETED", contact.getId(), contact, LocalDate.now(), LocalTime.now());
	}
	
	// PERSON
	public static Event personCreatedEvent(Person person) {
		return new Event("CREATED", person.getId(), person, person.getCreateDate(), person.getCreateTime());
	}
	
	public static Event personUpdatedEvent(Person person) {
		return new Event("UPDATED", person.getId(), person, person.getUpdateDate(), person.getUpdateTime());
	}
	
	public static Event personDeletedEvent(Person person) {
		return new Event("DELETED", person.getId(), person, LocalDate.now(), LocalTime.now());
	}

}
