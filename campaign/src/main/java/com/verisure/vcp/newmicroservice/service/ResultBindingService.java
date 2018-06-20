package com.verisure.vcp.newmicroservice.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

import com.verisure.vcp.newmicroservice.common.utils.ResultChannelsBinding;

public interface ResultBindingService {

	@Output(ResultChannelsBinding.SEND_RESULT_CREATED_EVENT)
	MessageChannel sendCreatedEvent();
	
	@Output(ResultChannelsBinding.SEND_RESULT_UPDATED_EVENT)
	MessageChannel sendUpdatedEvent();
	
	@Output(ResultChannelsBinding.SEND_RESULT_DELETED_EVENT)
	MessageChannel sendDeletedEvent();
}
