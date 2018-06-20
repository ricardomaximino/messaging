package com.brasajava.rabbitstreamreceiverone.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

import com.brasajava.rabbitstreamreceiverone.util.ContactChannel;

public interface ContactReceiverChannelBinding {
	
	@Input(ContactChannel.CONTACT_CREATED_EVENT)
	SubscribableChannel created();
	
	@Input(ContactChannel.CONTACT_SAVED_EVENT)
	SubscribableChannel saved();
	
	@Input(ContactChannel.CONTACT_NOT_SAVED_EVENT)
	SubscribableChannel notSaved();
	
	@Input(ContactChannel.CONTACT_UPDATED_EVENT)
	SubscribableChannel updated();
	
	@Input(ContactChannel.CONTACT_DELETED_EVENT)
	SubscribableChannel deleted();

}
