package com.verisure.vcp.newmicroservice.common.utils;

import java.time.LocalDate;
import java.time.LocalTime;

import com.verisure.vcp.newmicroservice.domain.entity.Event;


public class EventBuilder {
	
	public static Event createdEvent(EventMessage object) {
		return new Event(null, "CREATE", object.getId(), object.getOperator(), LocalDate.now(), LocalTime.now());
	}
	
	
	public static Event updatedEvent(EventMessage object) {
		return new Event(null, "UPDATE", object.getId(), object.getOperator(), LocalDate.now(), LocalTime.now());
	}
	
	
	public static Event deletedEvent(EventMessage object) {
		return new Event(null, "DELETE", object.getId(), object.getOperator(), LocalDate.now(), LocalTime.now());
	}

}
