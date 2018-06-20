package com.verisure.vcp.newmicroservice.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

import com.verisure.vcp.newmicroservice.common.utils.ContactChannelsBinding;

public interface ContactBindingService {

	@Output(ContactChannelsBinding.SEND_CONTACT_CREATED_EVENT)
	MessageChannel sendCreatedEvent();
	
	@Output(ContactChannelsBinding.SEND_CONTACT_UPDATED_EVENT)
	MessageChannel sendUpdatedEvent();
	
	@Output(ContactChannelsBinding.SEND_CONTACT_DELETED_EVENT)
	MessageChannel sendDeletedEvent();
}
