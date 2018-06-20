package com.verisure.vcp.newmicroservice.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

import com.verisure.vcp.newmicroservice.common.utils.ActivityChannelsBinding;

public interface ActivityBindingService {
	
	@Output(ActivityChannelsBinding.SEND_ACTIVITY_CREATED_EVENT)
	MessageChannel sendCreatedEvent();
	
	@Output(ActivityChannelsBinding.SEND_ACTIVITY_UPDATED_EVENT)
	MessageChannel sendUpdatedEvent();
	
	@Output(ActivityChannelsBinding.SEND_ACTIVITY_DELETED_EVENT)
	MessageChannel sendDeletedEvent();

}
