package com.brasajava.rabbitstreamreactiveone.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ContactSenderBinding {
	String CREATED_CONTACT = "createdContact";
	String NOT_SAVED_CONTACT = "notSavedContact";
	String UPDATED_CONTACT = "updatedContact";
	String DELETED_CONTACT = "deletedContact";
	
	@Output(DELETED_CONTACT)
	public MessageChannel deleteContact();
	
	@Output(CREATED_CONTACT)
	public MessageChannel createContact();
	
	@Output(UPDATED_CONTACT)
	public MessageChannel updateContact();

	@Output(NOT_SAVED_CONTACT)
	public MessageChannel notSavedContact();
}
