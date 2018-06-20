package com.brasajava.springbootreactivewebsockettwo.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

import com.brasajava.springbootreactivewebsockettwo.utils.ChannelBindingsConstant;

public interface ContactBindingChannel {
	
	@Output(ChannelBindingsConstant.SEND_CONTACT_CREATED)
	MessageChannel sendCreatedEvent();

	@Output(ChannelBindingsConstant.SEND_CONTACT_UPDATED)
	MessageChannel sendUpdatedEvent();
	
	@Output(ChannelBindingsConstant.SEND_CONTACT_DELETED)
	MessageChannel sendDeletedEvent();
	
	
	@Input(ChannelBindingsConstant.LISTEN_CONTACT_CREATED)
	SubscribableChannel listenCreatedEvent();
	
	@Input(ChannelBindingsConstant.LISTEN_CONTACT_UPDATED)
	SubscribableChannel listenUpdatedEvent();
	
	@Input(ChannelBindingsConstant.LISTEN_CONTACT_DELETED)
	SubscribableChannel listenDeleteEvent();

}
