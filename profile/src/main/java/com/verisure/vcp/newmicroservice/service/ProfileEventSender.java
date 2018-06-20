package com.verisure.vcp.newmicroservice.service;

import com.verisure.vcp.newmicroservice.domain.entity.Event;


/**
 * The Interface ProfileEventSender.
 */
public interface ProfileEventSender {

	/**
	 * Send created event.
	 *
	 * @param event the event
	 */
	public void sendCreatedEvent(Event event);
	
	/**
	 * Send updated event.
	 *
	 * @param event the event
	 */
	public void sendUpdatedEvent(Event event);
	
	/**
	 * Send deleted event.
	 *
	 * @param event the event
	 */
	public void sendDeletedEvent(Event event);
}
