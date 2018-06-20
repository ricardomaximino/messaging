package com.verisure.vcp.newmicroservice.service.impl;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.reactive.FluxSender;
import org.springframework.cloud.stream.reactive.StreamEmitter;

import com.verisure.vcp.newmicroservice.common.utils.ContactChannelsBinding;
import com.verisure.vcp.newmicroservice.domain.entity.Event;
import com.verisure.vcp.newmicroservice.service.ContactBindingService;
import com.verisure.vcp.newmicroservice.service.ContactEventSender;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@EnableBinding(ContactBindingService.class)
public class ContactEventSenderImpl implements ContactEventSender{

	private FluxSender createdFluxSender;
	private FluxSender updatedFluxSender;
	private FluxSender deletedFluxSender;
	
	@StreamEmitter
	public void setCreatedFluxSender(@Output(ContactChannelsBinding.SEND_CONTACT_CREATED_EVENT) FluxSender sender) {
		this.createdFluxSender = sender;
	}
	
	@StreamEmitter
	public void setUpdatedFluxSender(@Output(ContactChannelsBinding.SEND_CONTACT_UPDATED_EVENT) FluxSender sender) {
		this.updatedFluxSender = sender;
	}
	
	@StreamEmitter
	public void setdDeletedFluxSender(@Output(ContactChannelsBinding.SEND_CONTACT_DELETED_EVENT) FluxSender sender) {
		this.deletedFluxSender = sender;
	}

	@Override
	public void sendCreatedEvent(Event event) {
		LOGGER.debug("SENDING CONTACT CREATED EVENT");
		createdFluxSender.send(Flux.just(event));
	}

	@Override
	public void sendUpdatedEvent(Event event) {
		LOGGER.debug("SENDING CONTACT UPDATED EVENT");
		updatedFluxSender.send(Flux.just(event));
	}

	@Override
	public void sendDeletedEvent(Event event) {
		LOGGER.debug("SENDING CONTACT DELETED EVENT");
		deletedFluxSender.send(Flux.just(event));
	}
}
