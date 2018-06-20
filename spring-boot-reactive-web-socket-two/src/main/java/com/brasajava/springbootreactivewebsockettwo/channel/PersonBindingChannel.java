package com.brasajava.springbootreactivewebsockettwo.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

import com.brasajava.springbootreactivewebsockettwo.utils.ChannelBindingsConstant;

public interface PersonBindingChannel {

	@Output(ChannelBindingsConstant.SEND_PERSON_CREATED)
	MessageChannel sendCreatedEvent();

	@Output(ChannelBindingsConstant.SEND_PERSON_UPDATED)
	MessageChannel sendUpdatedEvent();
	
	@Output(ChannelBindingsConstant.SEND_PERSON_DELETED)
	MessageChannel sendDeletedEvent();
	
	
	@Input(ChannelBindingsConstant.LISTEN_PERSON_CREATED)
	SubscribableChannel listenCreatedEvent();
	
	@Input(ChannelBindingsConstant.LISTEN_PERSON_UPDATED)
	SubscribableChannel listenUpdatedEvent();
	
	@Input(ChannelBindingsConstant.LISTEN_PERSON_DELETED)
	SubscribableChannel listenDeleteEvent();
}
