package com.brasajava.springbootreactivewebsockettwo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.brasajava.springbootreactivewebsockettwo.channel.PersonBindingChannel;
import com.brasajava.springbootreactivewebsockettwo.domain.Event;
import com.brasajava.springbootreactivewebsockettwo.utils.ChannelBindingsConstant;

@EnableBinding(PersonBindingChannel.class)
@EnableAutoConfiguration
public class PersonReceiverService {
private static final Logger log = LoggerFactory.getLogger(PersonReceiverService.class);
	
	@StreamListener(ChannelBindingsConstant.LISTEN_PERSON_CREATED)
	public void listenCreatedEvent(Event event) {
		log.info("Receive PERSON CREATED event. PERSON ID => ");
	}
	
	@StreamListener(ChannelBindingsConstant.LISTEN_PERSON_UPDATED)
	public void listenUpdatedEvent(Event event) {
		log.info("Receive PERSON UPDATED event. PERSON ID => ");
	}
	
	@StreamListener(ChannelBindingsConstant.LISTEN_PERSON_DELETED)
	public void listenDeletedEvent(Event event) {
		log.info("Receive PERSON DELETED event. PERSON ID => ");
	}
}
