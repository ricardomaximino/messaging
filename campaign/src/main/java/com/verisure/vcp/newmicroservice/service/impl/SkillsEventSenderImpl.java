package com.verisure.vcp.newmicroservice.service.impl;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.reactive.FluxSender;
import org.springframework.cloud.stream.reactive.StreamEmitter;

import com.verisure.vcp.newmicroservice.common.utils.SkillsChannelsBinding;
import com.verisure.vcp.newmicroservice.domain.entity.Event;
import com.verisure.vcp.newmicroservice.service.SkillsBindingService;
import com.verisure.vcp.newmicroservice.service.SkillsEventSender;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@EnableBinding(SkillsBindingService.class)
public class SkillsEventSenderImpl implements SkillsEventSender{
	
	private FluxSender createdFluxSender;
	private FluxSender updatedFluxSender;
	private FluxSender deletedFluxSender;
	
	@StreamEmitter
	public void setCreatedFluxSender(@Output(SkillsChannelsBinding.SEND_SKILLS_CREATED_EVENT) FluxSender sender) {
		this.createdFluxSender = sender;
	}
	
	@StreamEmitter
	public void setUpdatedFluxSender(@Output(SkillsChannelsBinding.SEND_SKILLS_UPDATED_EVENT) FluxSender sender) {
		this.updatedFluxSender = sender;
	}
	
	@StreamEmitter
	public void setdDeletedFluxSender(@Output(SkillsChannelsBinding.SEND_SKILLS_DELETED_EVENT) FluxSender sender) {
		this.deletedFluxSender = sender;
	}

	@Override
	public void sendCreatedEvent(Event event) {
		LOGGER.debug("SENDING SKILLS CREATED EVENT");
		createdFluxSender.send(Flux.just(event));
	}

	@Override
	public void sendUpdatedEvent(Event event) {
		LOGGER.debug("SENDING SKILLS UPDATED EVENT");
		updatedFluxSender.send(Flux.just(event));
	}

	@Override
	public void sendDeletedEvent(Event event) {
		LOGGER.debug("SENDING SKILLS DELETED EVENT");
		deletedFluxSender.send(Flux.just(event));
	}
}
