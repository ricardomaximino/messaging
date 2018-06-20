package com.verisure.vcp.newmicroservice.common.utils;

import java.time.LocalDate;
import java.time.LocalTime;

import com.verisure.vcp.newmicroservice.api.dto.ProfileDTO;
import com.verisure.vcp.newmicroservice.domain.entity.Event;
import com.verisure.vcp.newmicroservice.domain.entity.Profile;


/**
 * The Class EventBuilder.
 */
public class EventBuilder {
	
	/**
	 * Created event.
	 *
	 * @param profile the profile
	 * @return the event
	 */
	public static Event createdEvent(ProfileDTO profile) {
		return new Event(null, "CREATE", profile.getId(), profile.getOperator(), LocalDate.now(), LocalTime.now());
	}
	
	/**
	 * Updated event.
	 *
	 * @param profile the profile
	 * @return the event
	 */
	public static Event updatedEvent(ProfileDTO profile) {
		return new Event(null, "UPDATE", profile.getId(), profile.getOperator(), LocalDate.now(), LocalTime.now());
	}
	
	/**
	 * Deleted event.
	 *
	 * @param profile the profile
	 * @return the event
	 */
	public static Event deletedEvent(Profile profile, String operator) {
		return new Event(null, "DELETE", profile.getId(), operator, LocalDate.now(), LocalTime.now());
	}

}
