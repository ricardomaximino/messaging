package com.brasajava.rabbitstreamreactiveone.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface PersonReceiverBinding {
	String LISTEN_CREATED_PERSON = "listenCreatedPerson";
	String LISTEN_NOT_SAVED_PERSON = "listenNotSavedPerson";
	String LISTEN_UPDATED_PERSON = "listenUpdatedPerson";
	String LISTEN_DELETED_PERSON = "listenDeletedPerson";
	
	
	@Input(LISTEN_CREATED_PERSON)
	public SubscribableChannel createPerson();
	
	@Input(LISTEN_NOT_SAVED_PERSON)
	public SubscribableChannel notSavedPerson();
	
	@Input(LISTEN_UPDATED_PERSON)
	public SubscribableChannel updatedPerson();

	@Input(LISTEN_DELETED_PERSON)
	public SubscribableChannel deletePerson();
}
