package com.brasajava.springbootreactivewebsockettwo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.brasajava.springbootreactivewebsockettwo.channel.ContactBindingChannel;
import com.brasajava.springbootreactivewebsockettwo.domain.Event;
import com.brasajava.springbootreactivewebsockettwo.utils.ChannelBindingsConstant;

@EnableBinding(ContactBindingChannel.class)
@EnableAutoConfiguration
public class ContactReceiverService {
	private static final Logger log = LoggerFactory.getLogger(ContactReceiverService.class);
	
	@StreamListener(ChannelBindingsConstant.LISTEN_CONTACT_CREATED)
	public void listenCreatedEvent(Event event) {
		log.info("Receive CONTACT CREATED event. CONTACT ID => ");
	}
	
	@StreamListener(ChannelBindingsConstant.LISTEN_CONTACT_UPDATED)
	public void listenUpdatedEvent(Event event) {
		log.info("Receive CONTACT UPDATED event. CONTACT ID => ");
	}
	
	@StreamListener(ChannelBindingsConstant.LISTEN_CONTACT_DELETED)
	public void listenDeletedEvent(Event event) {
		log.info("Receive CONTACT DELETED event. CONTACT ID => ");
	}

}
