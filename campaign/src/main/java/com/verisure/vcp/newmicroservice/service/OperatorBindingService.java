package com.verisure.vcp.newmicroservice.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

import com.verisure.vcp.newmicroservice.common.utils.OperatorChannelsBinding;

public interface OperatorBindingService {

	@Output(OperatorChannelsBinding.SEND_OPERATOR_CREATED_EVENT)
	MessageChannel sendCreatedEvent();
	
	@Output(OperatorChannelsBinding.SEND_OPERATOR_UPDATED_EVENT)
	MessageChannel sendUpdatedEvent();
	
	@Output(OperatorChannelsBinding.SEND_OPERATOR_DELETED_EVENT)
	MessageChannel sendDeletedEvent();
}
