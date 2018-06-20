package com.brasajava.rabbitstreamreactiveone.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface PersonSenderBinding {
	String CREATED_PERSON = "createdPerson";
	String UPDATED_PERSON = "updatedPerson";
	String NOT_SAVED_PERSON = "notSavedPerson";
	String DELETED_PERSON = "deletedPerson";
	
	
	@Output(CREATED_PERSON)
	public MessageChannel createPerson();
	
	@Output(UPDATED_PERSON)
	public MessageChannel updatedPerson();
	
	@Output(NOT_SAVED_PERSON)
	public MessageChannel notSavedPerson();

	@Output(DELETED_PERSON)
	public MessageChannel deletePerson();
}
