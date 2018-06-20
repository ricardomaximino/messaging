package com.verisure.vcp.newmicroservice.service.impl;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.reactive.FluxSender;
import org.springframework.cloud.stream.reactive.StreamEmitter;

import com.verisure.vcp.newmicroservice.common.utils.ProfileChannelsBinding;
import com.verisure.vcp.newmicroservice.domain.entity.Event;
import com.verisure.vcp.newmicroservice.service.ProfileBindingService;
import com.verisure.vcp.newmicroservice.service.ProfileEventSender;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@EnableBinding(ProfileBindingService.class)
@EnableAutoConfiguration
public class ProfileEventSenderImpl implements ProfileEventSender{
	
	private FluxSender createdFluxSender;
	private FluxSender updatedFluxSender;
	private FluxSender deletedFluxSender;
	
	@StreamEmitter
	public void setCreatedFluxSender(@Output(ProfileChannelsBinding.SEND_PROFILE_CREATED_EVENT) FluxSender sender) {
		this.createdFluxSender = sender;
	}
	
	@StreamEmitter
	public void setUpdatedFluxSender(@Output(ProfileChannelsBinding.SEND_PROFILE_UPDATED_EVENT) FluxSender sender) {
		this.updatedFluxSender = sender;
	}
	
	@StreamEmitter
	public void setdDeletedFluxSender(@Output(ProfileChannelsBinding.SEND_PROFILE_DELETED_EVENT) FluxSender sender) {
		this.deletedFluxSender = sender;
	}

	@Override
	public void sendCreatedEvent(Event event) {
		LOGGER.debug("SENDING PROFILE CREATED EVENT");
		createdFluxSender.send(Flux.just(event));
	}

	@Override
	public void sendUpdatedEvent(Event event) {
		LOGGER.debug("SENDING PROFILE UPDATED EVENT");
		updatedFluxSender.send(Flux.just(event));
	}

	@Override
	public void sendDeletedEvent(Event event) {
		LOGGER.debug("SENDING PROFILE DELETED EVENT");
		deletedFluxSender.send(Flux.just(event));
	}

}
