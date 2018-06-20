package com.verisure.vcp.newmicroservice.common.utils;

public class ContactChannelsBinding {

	public static final String SEND_CONTACT_CREATED_EVENT = "sendContactCreatedEvent";
	public static final String SEND_CONTACT_UPDATED_EVENT = "sendContactUpdatedEvent";
	public static final String SEND_CONTACT_DELETED_EVENT = "sendContactDeletedEvent";
	
	private ContactChannelsBinding() throws IllegalAccessException {
		throw new IllegalAccessException("This class should not be initialized");
	}
}
