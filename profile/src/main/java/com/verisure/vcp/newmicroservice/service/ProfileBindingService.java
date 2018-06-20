package com.verisure.vcp.newmicroservice.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

import com.verisure.vcp.newmicroservice.common.utils.ProfileChannelsBinding;

public interface ProfileBindingService {

	@Output(ProfileChannelsBinding.SEND_PROFILE_CREATED_EVENT)
	MessageChannel sendCreatedEvent();
	
	@Output(ProfileChannelsBinding.SEND_PROFILE_UPDATED_EVENT)
	MessageChannel sendUpdatedEvent();
	
	@Output(ProfileChannelsBinding.SEND_PROFILE_DELETED_EVENT)
	MessageChannel sendDeletedEvent();
}
